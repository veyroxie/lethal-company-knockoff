package main.actions;

import main.Booking;
import main.User;

/**
 * removes a specific booking from the user's booking list.
 */
public class RemoveBookingAction implements Action{
    /**
     * booking to be removed
     */
    private Booking remove;

    /**
     * Default constructor
     * @param booking booking to be removed
     */
    public RemoveBookingAction(Booking booking){
        remove = booking;
    }

    /**
     * Removes booking from user booking list
     * @param user user under which booking is to be removed
     * @return which booking is to be removed
     */
    public String execute(User user) {
        user.removeBookings(remove);
        return "Booking detail: " +  remove.toString() + " removed.";
    }

    /**
     * @see Action
     */
    public String menuDescription() {
        return "Remove the following vehicle from the Booking System: " + remove.toString();
    }

}