package main.actions;

import main.User;

/**
 * Shows all the bookings currently in the user's list
 */
public class DisplayBookingAction implements Action {

    /**
     * Shows a user's pending booking list
     * @param user user checking booking list
     * @return unconfirmed booked vehicle list
     */
    @Override
    public String execute(User user) {
        return user.getBList().toString();

    }

    /**
     * @see Action
     */
    @Override
    public String menuDescription() {
        return "Display Booking. ";
    }
}
