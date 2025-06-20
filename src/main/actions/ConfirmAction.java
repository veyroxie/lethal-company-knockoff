package main.actions;

import main.Booking;
import main.User;

import java.util.ArrayList;

/**

 * Finalises the list of bookings for the user
 */

public class ConfirmAction implements Action{

    /**
     * Implementation of execute that loops through a list of the user's selected bookings,
     * and subtracts the total amount owed by user for all bookings from user balance.
     * @param user user confirming booking
     * @return String indicating total deducted and residual balance of user.
     */
    @Override
    public String execute(User user) {
        float price = 0.00f;
        ArrayList<Booking> temp = new ArrayList<>(user.getBList()); // Create a copy of the list

        for (Booking booked : temp) {
            price += (float) booked.getVehicle().getPrice();
        }

            float finalBalance = user.getBalance() - price;
            user.setBalance(finalBalance);
            user.clearBookingList();

        return "$" + price + " deducted! User balance set to $" + user.getBalance();

    }

    /**
     * @see Action
     */
    @Override
    public String menuDescription() {
        return "Confirm booking?";
    }
}
