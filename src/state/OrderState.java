package state;

import builder.Order;

public class OrderState extends State {
    public OrderState(Order order) {
        super(order);
    }

    @Override
    public String inProcess() {
        state="Order in process";
        return state;
    }

    @Override
    public String done() {
        state="Order closed";
        return state;
    }

    @Override
    public String rejected() {
        state="Order rejected";
        return state;
    }
}
