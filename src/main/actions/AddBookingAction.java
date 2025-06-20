package main.actions;

import main.Booking;
import main.User;

/**
 * Allows booking to be added to system
 *
 */

public class AddBookingAction implements Action {
    /**
     * The booking being added to a user's booking list
     */
    public Booking booking;

    /**
     * Default constructor
     * @param booking booking to be added
     */

    public AddBookingAction(Booking booking) {
        this.booking = booking;
    }

    /**
     * Implementation of Action which adds specific booking to a user's booking list.
     * @param user
     * @return String representing the details of the Vehicle in the booking
     */
    @Override
    public String execute(User user) {
        user.addBookings(booking);
        return "Vehicle: " + booking + " is successfully added to the Booking System!";

    }

    /**
     * @see Action
     */
    @Override
    public String menuDescription() {
        return "Add the following vehicle to the Booking System: " + booking.toString();

    }


}
