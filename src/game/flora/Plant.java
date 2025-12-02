package game.flora;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;

/**
 * Represents a plant<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public abstract class Plant extends Ground {

    /**
     * Name of the plant
     */
    private final String name;

    /**
     * The growth handler
     */
    private GrowthHandler growthHandler;

    /**
     * The constructor of the Actor class.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Plant(String name, char displayChar) {
        super(displayChar);
        this.name = name;
        this.growthHandler = new GrowthHandler();
    }

    /**
     * Increments age every tick.
     * If the current growth stage changed, modify the display character accordingly
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (!this.growthHandler.singleStage()) {
            boolean changedStage = this.growthHandler.grow();
            if (changedStage) {
                this.setDisplayChar(this.growthHandler.getDisplayChar());
            }
        }
    }

    /**
     * Gets the name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to add another growth stage
     * @param duration number of ticks needed to get past this stage
     * @param display_char display character for this stage
     */
    public void addGrowthStage(int duration, char display_char) {
            this.growthHandler.addGrowthStage(duration, display_char);
    }

    /**
     * Getting the growth handler
     * @return the growth handler
     */
    public GrowthHandler getGrowthHandler() {
        return growthHandler;
    }
}
