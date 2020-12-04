package strategyPayment;

import paymentModels.CreditCardUser;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreditCard implements PaymentSystem {
    Scanner in = new Scanner(System.in);
    static Map<Integer, CreditCardUser> cardsHashMap= new HashMap<>();
    static CreditCardUser creditCardUser =new CreditCardUser("1111 1111 1111 1111","10/22",455,6000);
    static CreditCardUser creditCardUser2 =new CreditCardUser("2222 2222 2222 2222","10/23",456,6000);
    static CreditCardUser creditCardUser3 =new CreditCardUser("3333 3333 3333 3333","10/24",457,6000);



    static {
        cardsHashMap.put(creditCardUser.getCvv(), creditCardUser);
        cardsHashMap.put(creditCardUser2.getCvv(), creditCardUser2);
        cardsHashMap.put(creditCardUser3.getCvv(), creditCardUser3);
    }

    @Override
    public String details(int amount) {
        System.out.println("Enter card number(with spaces):");
        String cardNumber=in.nextLine();
        System.out.println("Enter date:");
        String date=in.nextLine();
        System.out.println("Enter cvv:");
        Integer cvv=in.nextInt();
        try {
        if (cardNumber.equals(cardsHashMap.get(cvv).getNumber()) && date.equals(cardsHashMap.get(cvv).getDate()) && amount<cardsHashMap.get(cvv).getAmount()) {
            return "Successful!";
        }else if(cardNumber.equals(cardsHashMap.get(cvv).getNumber()) && date.equals(cardsHashMap.get(cvv).getDate()) && amount>cardsHashMap.get(cvv).getAmount()) {
            return "Not enough money.";
        }
            } catch (Exception e) {
            return "Incorrect information!";
        }
        return "Invalid information!";
    }
}
