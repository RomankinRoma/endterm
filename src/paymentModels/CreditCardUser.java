package paymentModels;

public class CreditCardUser {
    private String name;
    private String lName;
    private String number;
    private String date;
    private int cvv;
    private Integer amount=1000;

    public CreditCardUser(String number, String date, int cvv,Integer amount) {
        this.number = number;
        this.amount = amount;
        this.date = date;
        this.cvv = cvv;
    }

    public CreditCardUser(String name, String lName, String number, String date, int cvv) {
        this.name = name;
        this.lName = lName;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
