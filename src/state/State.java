package state;

import builder.Order;

public abstract class State {
    Order order;
    String state;
    public State(Order order) {
        this.state="Created";
        this.order = order;
    }

    public abstract String inProcess();
    public abstract String done();
    public abstract String rejected();
}
