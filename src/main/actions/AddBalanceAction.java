package main.actions;

import main.User;

/**
 * template for different types of payments that will add to user balance
 */
public interface AddBalanceAction extends Action {


    /**
     * @see Action
     */
    String execute(User user);

    /**
     * @see main.actions.Action
     */
    String menuDescription();
}


