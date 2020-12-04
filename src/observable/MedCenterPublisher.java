package observable;

import java.util.ArrayList;
import java.util.List;

public class MedCenterPublisher implements Publisher{

    private List<Subscriber> subscriberList;
    private Boolean discountChange=false;
    private Integer discount=10;
    private Integer lDiscount=10;
    private Integer pay=5000;
    private Integer lPay=5000;
    private String news="COVID-19 live updates: Total number of cases passes 36 million";

    public void addSubscriber(Subscriber b) {
        if (subscriberList==null)
            subscriberList=new ArrayList<>();
        subscriberList.add(b);
    }

    @Override
    public void removeSubscriber(Subscriber b) {
        subscriberList.remove(b);
    }

    @Override
    public void notifySubscriber() {
        for (Subscriber s:subscriberList             ) {
            s.update(this);
        }
    }

    public List<Subscriber> getSubscriberList() {
        return subscriberList;
    }

    public void setSubscriberList(List<Subscriber> subscriberList) {
        this.subscriberList = subscriberList;
    }

    public Boolean getDiscountChange() {
        return discountChange;
    }

    public void setDiscountChange(Boolean discountChange) {
        this.discountChange = discountChange;
        notifySubscriber();
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.lDiscount=this.discount;
        this.discount = discount;
        notifySubscriber();
    }

    public Integer getPay() {
        return pay;
    }

    public Integer getlDiscount() {
        return lDiscount;
    }

    public void setlDiscount(Integer lDiscount) {
        this.lDiscount = lDiscount;
    }

    public Integer getlPay() {
        return lPay;
    }

    public void setlPay(Integer lPay) {
        this.lPay = lPay;
    }

    public void setPay(Integer pay) {
        this.lPay = this.pay;
        this.pay = pay;
        notifySubscriber();
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
        notifySubscriber();
    }
}
