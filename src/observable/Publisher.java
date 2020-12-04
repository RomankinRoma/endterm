package observable;

public interface Publisher {
    void addSubscriber(Subscriber b);
    void removeSubscriber(Subscriber b);
    void notifySubscriber();
}
