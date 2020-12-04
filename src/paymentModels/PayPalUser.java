package paymentModels;

public class PayPalUser {
    private String name;
    private String surname;
    private String email;
    private float amount;

    public PayPalUser(String name, String surname, String email, float amount) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.amount = amount;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
