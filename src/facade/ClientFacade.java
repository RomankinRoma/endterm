package facade;

import medCenter.MedCenter;
import observable.MedCenterPublisher;
import observable.Publisher;
import observable.User;
import builder.*;
import paymentModels.PaymentContext;
import strategyPayment.CreditCard;
import strategyPayment.PayPal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientFacade {
    private List<User> userList=new ArrayList<>();
    private List<MedCenter> medCenters=new ArrayList<MedCenter>();
    private PaymentContext context=new PaymentContext();
    private Publisher medCenter = new MedCenterPublisher();
    OrderFactory orderFactory=new OrderFactory();
    Scanner in = new Scanner(System.in);

    public ClientFacade() {
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUserToList(User user) {
        this.userList.add(user);
    }

    public void delUserFromList(User user) {
        this.userList.remove(user);
    }

    public void register(){
        System.out.println("Input id:");
        Integer id=in.nextInt();
        System.out.print("Input name:");
        String name=in.next();
        System.out.print("Input second name:");
        String secName=in.next();
        String fullname=name+" "+secName;
        System.out.println("Input date of birth:");
        String dateOfBirth=in.nextLine();
        User user = new User(id,fullname,dateOfBirth,new ArrayList<>(),new ArrayList<>());
        userList.add(user);
        System.out.println("User added to base.");
    }

    public void makeOrder(Integer userId){
        System.out.println("Input id:");
        Integer id=in.nextInt();
        System.out.println("Input address:");
        String address=in.nextLine();
        System.out.println("Input date:");
        String date=in.nextLine();
        System.out.println("Choose id of medical center:");
        MedCenter medicalCenter=null;
        for (MedCenter medCenter: medCenters){
            System.out.println("ID:"+medCenter.getId()+"     Name:"+medCenter.getName()+"    Address:"+medCenter.getAddress());
        }
        Integer medID=in.nextInt();
        for (MedCenter medCenter: medCenters){
            if (medCenter.getId()==medID)
                medicalCenter=medCenter;
        }
        System.out.println("Addons\n1.Food\n2.Medicine\n3.Food and medicine\n4.Dont need");
        Integer chose=in.nextInt();
        User user=getUser(userId);
        if (chose==1){
            Order order=orderFactory.createOrderWithFood(id,address,date,medicalCenter,true);
            user.addOrder(order);
        }else if(chose==2){
            Order order=orderFactory.createOrderWithMedicine(id,address,date,medicalCenter,true);
            user.addOrder(order);
        }else if(chose==3){
            Order order=orderFactory.createOrderWithFoodAndMedicine(id,address,date,medicalCenter,true,true);
            user.addOrder(order);
        }else if(chose==4){
            Order order=orderFactory.createSimpleOrder(id,address,date,medicalCenter);
            user.addOrder(order);
        }
        System.out.println("Order added!");
    }

    public void deleteOrder(Integer id){
        for (Order order:getUser(id).getOrders()){
            System.out.println(order.toString());
        }
        System.out.println("Input id of order:");
        Integer orderID=in.nextInt();
        Order orderDel=null;
        for (Order order:getUser(id).getOrders()){
           if (order.getId() == orderID)
            orderDel=order;
        }
        getUser(id).delOrder(orderDel);
    }

    public User getUser(Integer id){
        for (User usr:userList){
            if (usr.getId()==id)
                return usr;
        }
        return null;
    }

    public void checkAcc(Integer id){
        User user=getUser(id);
        System.out.println("You authorized as "+user.getFullname());
    }
    public void changeAcc(Integer currentID){
        System.out.println("Choose your id:");
        for (User user:userList)
            System.out.println(user.getId()+"."+user.getFullname());
        Integer newID=in.nextInt();
        currentID= newID;
    }
    public void getOrders(Integer id){
        User user=getUser(id);
        if (user.getOrders().isEmpty())
            System.out.println("Empty");
        else
            for (Order order:user.getOrders()){
                System.out.println(order.toString());
            }
    }
    public void getResults(Integer id){
        if (getUser(id).getResults().isEmpty())
            System.out.println("Empty");
            for (Result result:getUser(id).getResults()){
                System.out.println(result.toString());
            }
    }

    public void subscribe(Integer id){
        medCenter.addSubscriber(getUser(id));
        System.out.println("Successful!");
    }

    public List<MedCenter> getMedCenters() {
        return medCenters;
    }

    public void getUsers(){
        for (User user:userList)
            System.out.println(user.getId()+"."+user.getFullname());
    }
    public void payment(Integer id){
        System.out.println("Choose payment system:\n1.PayPal\n2.Credit card");
    Integer chose=in.nextInt();
    if (chose==1){
        System.out.println("Choose order for pay:");
        User user=getUser(id);
        if (user.getOrders().isEmpty())
            System.out.println("Empty");
        else
            for (Order order:user.getOrders()){
                System.out.println(order.toString());
            }
        Integer amount=in.nextInt();
        for (Order order:user.getOrders()){
            if (amount==order.getId())
                amount=order.getAmount();
        }
        context.setPaymentSystem(new PayPal());
        System.out.println(context.payment(amount));
    }else if (chose==2){
        System.out.println("Choose order for pay:");
        User user=getUser(id);
        if (user.getOrders().isEmpty())
            System.out.println("Empty");
        else
            for (Order order:user.getOrders()){
                System.out.println(order.toString());
            }
        Integer amount=in.nextInt();
        for (Order order:user.getOrders()){
            if (amount==order.getId())
                amount=order.getAmount();
        }
        context.setPaymentSystem(new CreditCard());
        System.out.println(context.payment(amount));
    }else{
        System.out.println("Incorrect input!");
    }

    }
}
