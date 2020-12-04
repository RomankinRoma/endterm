import facade.ClientFacade;
import medCenter.ASAP;
import medCenter.SNAKE;
import builder.OrderFactory;
import observable.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ClientFacade clientFacade =new ClientFacade();
        OrderFactory orderFactory = new OrderFactory();
        Integer chose=-1;
        User user=new User(1,"Asdsd ada","12.12.12",new ArrayList<>(),new ArrayList<>());
        clientFacade.getUserList().add(user);
        clientFacade.getMedCenters().add(new ASAP());
        clientFacade.getMedCenters().add(new SNAKE());

        Integer userID=1;

        while (chose!=0){
            System.out.println("");
            System.out.println("1.Register");
            System.out.println("2.Make order");
            System.out.println("3.Delete order");
            System.out.println("4.Get orders");
            System.out.println("5.Get results");
            System.out.println("6.Check current account");
            System.out.println("7.Change account");
            System.out.println("8.Subscribe");
            System.out.println("9.Payment");
            System.out.println("0.Exit");
            chose=in.nextInt();
            switch (chose){
                case 1:
                    clientFacade.register();
                    break;
                case 2:
                    clientFacade.makeOrder(userID);
                    break;
                case 3:
                    clientFacade.deleteOrder(userID);
                    break;
                case 4:
                    clientFacade.getOrders(userID);
                    break;
                case 5:
                    clientFacade.getResults(userID);
                    break;
                case 6:
                    clientFacade.checkAcc(userID);
                    break;
                case 7:
                    clientFacade.getUsers();
                    System.out.println("Choose your id:");
                    userID=in.nextInt();
                    break;
                case 8:
                    clientFacade.subscribe(userID);
                    break;
                case 9:
                    clientFacade.payment(userID);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choise!");
                    break;

            }
        }
   }
}
