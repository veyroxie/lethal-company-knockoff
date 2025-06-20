package main.actions;

import main.User;

/**
 *    Parent / template for all actions in Booking System
 *    <p>
 *        Action interface contains 2 methods:
 *        - execute: main function of action
 *        - menuDescription: tells user a short description of what that action does
 *    </p>
 *
 * @author Elyesa Tee Way Yien
 * @version 1.0.0
 */

public interface Action {

    /**
     * Execute method to be implemented by subclasses
     * @param user user doing the action
     * @return a string showing result of action
     */
    public String execute(User user);


    /**
     * menuDescription method to be implemented by subclasses
     * @return a string indicating type of action in consoleMenu
     */
    public String menuDescription();
}
