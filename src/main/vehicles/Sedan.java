package main.vehicles;

/**
 * Subclass of Vehicle, with additional attributes: range, engType
 */
public class Sedan extends Vehicle{
    /**
     * range of car
     */
    private final int range;
    /**
     * what type of engine it uses
     */
    private EngineType engType;

    /**
     * default constructor
     * @see Vehicle
     * @param range range of Sedan
     * @param engType engine type of Sedan
     */
    public Sedan(String brand, int year, float price, int range, EngineType engType) {
        super(brand, year, price);
        this.range = range;
        this.engType = engType;
    }

    /**
     * displays Vehicle details
     * @return details of Vehicle in String form
     */
    @Override
    public String toString() {
        return super.toString()+
                String.format(""" 
                        | Range: %d km | Fuel Type: %s""", range, engType);
    }

    /**
     * setter for ID between 10000 and 99999
     */
    @Override
    public void setID() {
        this.ID = "Sedan" + Utility.generateRandomInt(10000, 99999);
    }


    /**
     * setter for EngType
     * @param engType type of engine
     */
    public void setEngType(EngineType engType) {
        this.engType = engType;
    }

    /**
     * getter for EngType
     * @return type of engine used
     */

    public EngineType getEngType() {
        return engType;
    }

    /**
     * getter for range
     * @return possible range for this particular car
     */
    public int getRange() {
        return range;
    }


}

