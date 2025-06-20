package main;

import java.util.ArrayList;
import java.util.List;
import main.actions.*;
import main.vehicles.Vehicle;

/**
 * Creates a booking instance for a vehicle
 */
public class Booking implements ActionCapable{
    /**
     * vehicle that can be booked
     */
    Vehicle vehicle;
    /**
     * user that vehicle is booked under
     */
    @SuppressWarnings("unused")
    private User user;
    /**
     * user's pending booking list
     */
    ArrayList<Booking> bList = new ArrayList<>();

    /**
     * default constructor
     * @param vehicle Vehicle object in booking
     */
    public Booking(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    /**
     * displays vehicle details in this specific booking
     * @return String representation of vehicle details
     */
    @Override
    public String toString() {
        return vehicle.toString();
    }


    /**
     * getter for vehicle object in booking
     * @return Vehicle object in booking
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * method to select actions that Booking class can use
     * @return list of actions being used by vehicle in the system
     */
    @Override
    public List<Action> allowableActions() {
        List<Action> actions = new ArrayList<>();
        actions.add(new RemoveBookingAction(this));
        return actions;
    }

}
