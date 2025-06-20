package main.vehicles;

import main.Booking;
import main.actions.Action;
import main.actions.ActionCapable;
import main.actions.AddBookingAction;

import java.util.ArrayList;
import java.util.List;

/**
 * template for default vehicle, contains attributes any vehicle would ahve
 */
public abstract class Vehicle implements ActionCapable {
    /**
     * brand of vehicle
     */
    private String brand;
    /**
     * year of production of vehicle
     */
    private int year;
    /**
     * price of vehicle
     */
    private float price;
    /**
     * ID of vehicle
     */
    public String ID;


    /**
     * default constructor
     * @param brand brand of Vehicle
     * @param year year of production
     * @param price price of vehicle
     */
    public Vehicle(String brand, int year, float price){
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    /**
     * method to choose which actions Vehicle class can use
     * @return list of actions being used by vehicle in the system
     */
    @Override
    public List<Action> allowableActions() {
        List<Action> actions = new ArrayList<>();
        Booking booking = new Booking(this);
        actions.add(new AddBookingAction(booking));
        return actions;
    }

    /**
     * displays Vehicle details
     * @return details of Vehicle in String form
     */
    @Override
    public String toString() {
        return String.format("Booking detail: Brand: %s | Year: %d | Price: $%.2f | ID: %s ",
                this.getBrand(), this.getYear(), this.getPrice(), this.getID());
    }


    /**
     * setter for brand
     * @param brand string representing brand of vehicle
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * setter for price
     * @param price float representing price of vehicle
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * setter for year of production
     * @param year integer representing year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * getter for year
     * @return year of production for specific vehicle (int)
     */
    public int getYear() {
        return year;
    }

    /**
     * getter for price of vehicle
     * @return price(int)
     */
    public double getPrice() {
        return price;
    }

    /**
     * getter for brand of vehicle
     * @return brand (String)
     */
    public String getBrand() {
        return brand;
    }

    /**
     * abstract method to be implemented in all subclasses to generate ID within the specified ranges
     * - different for each subclass
     */
    public abstract void setID();

    /**
     * getter for ID
     * @return ID of vehicle (String)
     */
    public String getID() {
        return this.ID;
    }
}
