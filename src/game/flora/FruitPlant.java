package game.flora;

import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.terrain.Spawnpoint;

/**
 * Represents a fruiting plant<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public abstract class FruitPlant extends Plant implements Spawnpoint {
    /**
     * Fruit the plant produces at this stage if any
     */
    private DroppableItem fruit;


    /**
     * The constructor of the Actor class.
     *
     * @param name
     * @param displayChar character to display for this type of terrain
     */
    public FruitPlant(String name, char displayChar, DroppableItem fruit) {
        super(name, displayChar);
        this.fruit = fruit;
    }

    /**
     * Increments age every tick.
     * If the current growth stage changed, modify the display character and fruit accordingly
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (!this.getGrowthHandler().singleStage()) {
            boolean changedStage = this.getGrowthHandler().grow();
            if (changedStage) {
                this.setDisplayChar(this.getGrowthHandler().getDisplayChar());
                this.setFruit(this.getGrowthHandler().getFruit());
            }
        }

        spawnObject(location);
    }

    /**
     * Tries to spawn fruit every tick if fruit is not null
     * @param location the location of the spawnpoint
     */
    public void spawnObject(Location location){
        if (this.fruit != null) {

            Location selected = getSpawnLocation(location);
            int roll = Utility.generateNumber(0, 100);
            if (roll < this.fruit.getDropChance()) {
                selected.addItem(this.fruit);

            }
        }
    }

    /**
     * Returns the fruit
     * @return Fruit
     */
    public DroppableItem getFruit() {
        return this.getGrowthHandler().getFruit();
    }

    /**
     * Sets the fruit produced to a specified type
     * @param fruit The fruit
     */
    public void setFruit(DroppableItem fruit) {
        this.fruit = fruit;
    }



    /**
     * Overloaded method to add another growth stage
     * @param duration number of ticks needed to get past this stage
     * @param display_char display character for this stage
     * @param fruit Fruit the plant produces at this stage if any
     */
    public void addGrowthStage(int duration, char display_char, DroppableItem fruit) {
        this.getGrowthHandler().addGrowthStage(duration, display_char, fruit);
    }
}
