package main.vehicles;

/**
 * Subclass of Vehicle, with additional attributes: loading
 */
public class Truck extends Vehicle{
    /**
     * maximum weight able to be carried by truck
     */
    private double loading;

    /**
     * default constructor
     * @see Vehicle
     * @param loading maximum weight carryable
     */

    public Truck(String brand, int year, float price, double loading){
        super(brand, year, price);
        this.loading = loading;


    }

    /**
     * displays Vehicle details
     * @return details of Vehicle in String form
     */
    @Override
    public String toString() {
        return super.toString() +
                String.format(" | Loading: %s", loading);
    }

    /**
     * setter for ID between 100 and 999
     */
    @Override
    public void setID() {
        this.ID = "Truck" + Utility.generateRandomInt(100, 999);
    }

    /**
     * setter for loading
     * @param loading maximum weight carryable
     */
    public void setLoading(double loading) {
        this.loading = loading;
    }


    /**
     * getter for loading
     * @return how much truck can carry
     */
    public double getLoading() {
        return loading;
    }
}
