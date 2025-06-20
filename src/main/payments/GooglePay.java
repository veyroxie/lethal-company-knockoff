package main.payments;
import main.User;
import main.actions.AddBalanceAction;

import java.util.Scanner;

/**
 * implements a type of payment as an AddBalanceAction
 */
public class GooglePay implements Payment, AddBalanceAction {
    /**
     * amount to be added to user balance
     */
    private float amount;
    /**
     * user whose balance is being added to
     */
    public User user;

    /**
     * default constructor
     * @param user user whose balance is being added to
     */
    public GooglePay(User user) {
        this.user = user;
    }

    /**
     * Accepts an input from user and adds that number to user balance
     * @param user user whose balance is being added to
     * @return balance added
     */
    @Override
    public String execute(User user){
        // add money to balance
        System.out.println("Enter a number to add to your current balance: ");
        Scanner scanner = new Scanner(System.in);
        float add = scanner.nextFloat();
        String added = String.format(processPayment(add) +"\n" +
                "%.2f is added to the user balance!", add);
        return added;
    }

    /**
     * @see main.actions.Action
     */
    @Override
    public String menuDescription() {
        return "Add Balance with Google Pay.";
    }

    /**
     * @see Payment
     */
    @Override
    public String processPayment(float amount) {
        user.balance += amount;
        return "Payment processed by Google Pay: " + amount;
    }

}
