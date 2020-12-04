import strategyPayment.PaymentSystem;

public class PaymentContext {
    private PaymentSystem paymentSystem;

    public PaymentContext() {
    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public String payment(int i){
         return paymentSystem.details(i);
    }
}
