package observable;

import builder.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Subscriber {
    private Integer id;
    private String fullname;
    private String dateofBirth;
    private List<Order> orders;
    private List<Result> results;

    public User(Integer id, String fullname, String dateofBirth, List<Order> orders, List<Result> results) {
        this.id = id;
        this.fullname = fullname;
        this.dateofBirth = dateofBirth;
        this.orders = orders;
        this.results = results;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public List<Order> getOrders() {
        if (orders==null)
            orders=new ArrayList<>();
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void delOrder(Order order) {
        this.orders.remove(order);
    }

    public List<Result> getResults() {
        return results;
    }

    public void addResult(Result result) {
        this.results.add(result);
    }

    public void delResult(Result result) {
        this.results.remove(result);
    }

    @Override
    public void update(Publisher p) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        if (!((MedCenterPublisher) p).getDiscount().equals(((MedCenterPublisher) p).getlDiscount())){
            System.out.println("Discount changed from "+(((MedCenterPublisher) p).getlDiscount()+" to "+(((MedCenterPublisher) p).getDiscount())));
        }
        if (!((MedCenterPublisher) p).getPay().equals(((MedCenterPublisher) p).getlPay())){
            System.out.println("Pay changed from "+(((MedCenterPublisher) p).getlPay()+" to "+(((MedCenterPublisher) p).getPay())));
        }
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
