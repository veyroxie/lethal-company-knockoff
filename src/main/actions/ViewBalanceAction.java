package main.actions;


import main.User;

/**
 * Shows user's current balance in the system
 */
public class ViewBalanceAction implements Action {

    /**
     * Displays user balance
     * @param user user that wants to check balance
     * @return amount balance
     */
    @Override
    public String execute(User user) {
        return String.format("You have a balance of $%s", user.balance);
    }

    /**
     * @see Action
     */
    @Override
    public String menuDescription() {
        return "View balance. ";
    }
}
