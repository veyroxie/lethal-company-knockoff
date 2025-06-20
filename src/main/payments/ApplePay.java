package main.payments;
import java.util.Scanner;
import main.User;
import main.actions.AddBalanceAction;

/**
 * implements a type of payment with a maximum amount of 1000.00 as an AddBalanceAction
 */
public class ApplePay implements Payment, AddBalanceAction {

    /**
     * maximum amount addable
     */
    public final float maxApplePay = 1000.00f;

    /**
     * user whose balance is being added to
     */
    public User user;
    private String added;

    /**
     * default constructor
     * @param user user whose balance is being added to
     */
    public ApplePay(User user) {
        this.user = user;
    }

    /**
     * Accepts an input from user and checks if not above maximum amount.
     * if yes: amount added to balance
     * if no: inform user about failure to add
     * @param user user whose balance is being added to
     * @return string that shows balance added
     */
    @Override
    public String execute(User user) {
        // add money to balance

        System.out.println("Enter a number to add to your current balance: ");
        try (Scanner scanner = new Scanner(System.in)) {
            float add = scanner.nextFloat();
            if (add <= maxApplePay) {
                added = processPayment(add) + "\n" + String.format("%.2f is added to the user balance!", add);
            } else {
                added = String.format("Limit exceeded for payment of %.2f", add) + "\nFailed to add to user balance";
            }
        }
        return added;
    }

    /**
     * @see main.actions.Action
     */
    @Override
    public String menuDescription() {
        return "Add Balance with Apple Pay.";
    }

    /**
     * @see Payment
     */
    @Override
    public String processPayment(float amount) {
        user.balance = user.balance + amount;
        return "Payment processed by Apple Pay: " + amount;
    }

}
