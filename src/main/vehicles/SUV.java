package main.vehicles;
/**
 * Subclass of Vehicle, with additional attributes: seats, engType
 */
public class SUV extends Vehicle{

    /**
     * number of seats available
     */
    private int seats;
    /**
     * type of engine used
     */
    private EngineType engType;

    /**
     * default constructor
     * @param seats number of seats
     * @param engType engine type
     * @see Vehicle
     */
    public SUV(String brand, int year, float price, int seats, EngineType engType){
        super(brand, year, price);
        this.seats = seats;
        this.engType = engType;
    }

    /**
     * displays Vehicle details
     * @return details of Vehicle in String form
     */
    @Override
    public String toString() {
        return super.toString() +
                String.format("| Number of Seats: %s | Engine Type: %s", seats, engType);
    }


    /**
     * setter for ID between 1000 and 9999
     */
    @Override
    public void setID() {
        this.ID = "SUV" + Utility.generateRandomInt(1000, 9999);
    }


    /**
     * setter for EngType
     * @param engType engine type
     */
    public void setEngType(EngineType engType) {
        this.engType = engType;
    }

    /**
     * setter for number of seats
     * @param seats number of seats
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * getter for EngType
     * @return type of engine used
     */
    public EngineType getEngType() {
        return engType;
    }

    /**
     * getter for seats
     * @return integer representing number of seats
     */
    public int getSeats() {
        return seats;
    }
}
