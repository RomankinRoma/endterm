package builder;
import state.OrderState;
import state.State;
import medCenter.MedCenter;

public class Order {
    Integer id;
    String address;
    String date;
    MedCenter medCenter;
    Integer amount;
    Boolean medicine;
    Boolean food;
    State state;

    public Order(OrderBuilder orderBuilder) {
        this.state=new OrderState(this);
        this.id = orderBuilder.id;
        this.address = orderBuilder.address;
        this.date = orderBuilder.date;
        this.amount = orderBuilder.amount;
        this.medCenter = orderBuilder.medCenter;
        this.medicine = orderBuilder.medicine;
        this.food = orderBuilder.food;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MedCenter getMedCenter() {
        return medCenter;
    }

    public void setMedCenter(MedCenter medCenter) {
        this.medCenter = medCenter;
    }

    public Boolean getMedicine() {
        return medicine;
    }

    public void setMedicine(Boolean medicine) {
        this.medicine = medicine;
    }

    public Boolean getFood() {
        return food;
    }

    public void setFood(Boolean food) {
        this.food = food;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        if (food!=null || medicine!=null)
            return getId()+"."+getAddress()+" toPay:"+getAmount()+" with addons";
        else
            return getId()+"."+getAddress()+" without addons";
    }
    public static class OrderBuilder {
        Integer id;
        String address;
        String date;
        Integer amount;
        MedCenter medCenter;
        Boolean medicine;
        Boolean food;

        public OrderBuilder(Integer id, String address,String date, MedCenter medCenter,Integer amount) {
            this.id = id;
            this.amount = amount;
            this.address = address;
            this.date = date;
            this.medCenter = medCenter;
        }

        public OrderBuilder withMedicine(Boolean medicine){
            this.medicine=medicine;
            this.amount+=1000;
            return this;
        }

        public OrderBuilder withFood(Boolean food){
            this.food=food;
            this.amount+=1000;
            return this;
        }

        public Order createOrder(){
            return new Order(this);
        }

    }
}
