package main;

import main.actions.*;
import main.payments.*;

import java.util.ArrayList;
import java.util.List;

/**
 * user that is able to select what to do within the booking system
 */
public class User implements ActionCapable {

    // attributes
    private ArrayList<Booking> bList = new ArrayList<>();
    /**
     * balance of user
     */
    public float balance;
    /**
     * checks if user wants to exit the program
     * if isUserDone = false; then program continues to ask user for input
     * if isUserDone = true; then program halts
     */
    private boolean isUserDone = false;


    /**
     * display all vehicles in user's pending booking list
     */
    // methods
    public void displayVehicles(){
        for (Booking booking : bList) {
            System.out.println(booking.toString() + "\n");
        }
    }

    /**
     * used to add booking to booking list
     * @param booking booking to be added
     */
    public void addBookings(Booking booking){
        bList.add(booking);
    }

    /**
     * used to remove booking from booking list
     * @param booking booking to be removed
     */
    public void removeBookings(Booking booking){
        bList.remove(booking);
    }

    /**
     * empties the booking list
     */
    public void clearBookingList(){
        bList.clear();
    }

    /**
     * method to select actions that User class can use
     * @return list of actions usable by User in the system
     */
    @Override
    public List<Action> allowableActions() {
        List<Action> actions = new ArrayList<>();
        AddBalanceAction ab = new GooglePay(this);
        AddBalanceAction ab2 = new ApplePay(this);

        DisplayBookingAction db = new DisplayBookingAction();
        ConfirmAction ca = new ConfirmAction();
        ExitAction ea = new ExitAction();
        ViewBalanceAction vb = new ViewBalanceAction();

        // add actions
        actions.add(ab);
        actions.add(ab2);
        actions.add(db);
        actions.add(ca);
        actions.add(ea);
        actions.add(vb);
        for (Booking booking : this.getBList()) {
            actions.add(new RemoveBookingAction(booking));
        }
        return actions;
    }


    /**
     * getter for user booking list
     * @return list of bookings of vehicles
     */
    // getters and setters
    public ArrayList<Booking> getBList() {
        return bList;
    }

    /**
     * getter for user's balance
     * @return balance in user account(float)
     */
    public float getBalance() {
        return balance;
    }

    /**
     * checks if user is done booking
     * @return user status in boolean
     */
    public boolean getIsUserDone() {

        return isUserDone;
    }

    /**
     * setter for user's booking list
     * @param bList list of user bookings
     */
    public void setBList(ArrayList<Booking> bList) {
        this.bList = bList;
    }

    /**
     * setter for user balance
     * @param balance user balance
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * setter for isUserDone status
     * @param userDone status of user in system
     */
    public void setUserDone(boolean userDone) {
        isUserDone = userDone;
    }


}
