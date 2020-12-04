package strategyPayment;

import paymentModels.PayPalUser;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayPal implements PaymentSystem {
    Scanner in = new Scanner(System.in);
    static Map<String, PayPalUser> userHashMap= new HashMap<>();
    static PayPalUser payPalUser =new PayPalUser("Aaa","Aaa","aaa@aaa",6000);
    static PayPalUser payPalUser2 =new PayPalUser("Bbb","Aaa","bbb@aaa",2000);
    static PayPalUser payPalUser3 =new PayPalUser("Ccc","Aaa","ccc@aaa",2000);


    static {
        userHashMap.put("1qwe", payPalUser);
        userHashMap.put("12qwe", payPalUser2);
        userHashMap.put("123qwe", payPalUser3);
    }
    @Override
    public String details(int amount) {
        System.out.println("Enter email:");
        String email = in.next();
        System.out.println("Enter password:");
        String password = in.next();
        try {
            if (email.equals(userHashMap.get(password).getEmail()) ) {
                PayPalUser tempPayPalUser = userHashMap.get(password);
                if (amount < userHashMap.get(password).getAmount()){
                tempPayPalUser.setAmount(tempPayPalUser.getAmount() - amount);
                userHashMap.replace(password, tempPayPalUser);
                }else {
                    return "Not enough money";
                }
                return "Successful!";
            }
        } catch (Exception e) {
            return "Wrong password or email";
        }
        return "email";
    }

    public PayPal() {
    }

    public PayPal(Map<String, PayPalUser> userHashMap) {
        this.userHashMap = userHashMap;
    }

    public Map<String, PayPalUser> getUserHashMap() {
        return userHashMap;
    }

    public void setUserHashMap(Map<String, PayPalUser> userHashMap) {
        this.userHashMap = userHashMap;
    }
}
