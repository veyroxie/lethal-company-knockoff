package main.actions;
import main.User;

/**
 * closes the Booking System.
 */
public class ExitAction implements Action{

    /**
     * closes the BookingSystem console and ends the user interaction
     * @param user user leaving system
     * @return a closing string addressing the user
     */
    @Override
    public String execute(User user) {
        user.setUserDone(true);
        return "Thank you for visiting FIT2099 Vehicle Booking System!";
    }

    /**
     * @see Action
     */
    @Override
    public String menuDescription() {
        return "Exit Console. ";
    }
}
