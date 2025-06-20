package main.vehicles;


/**
 * creation of ID for Vehicles
 */
public class Utility {
    /**
     * method that generates random integers, so they can be used as Vehicle ID
     * @param lower minimum of range
     * @param upper maximum of range
     * @return random integer to be used as ID
     */
    public static int generateRandomInt(int lower, int upper) {
        return (int) ((Math.random() * (upper - lower))//);
                + lower);
    }
}