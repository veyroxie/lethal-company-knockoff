package game.flora;

import edu.monash.fit2099.engine.items.Item;

/**
 * Represents a droppable item<br>
 * Created by:
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public abstract class DroppableItem extends Item {
    /**
     * The item's drop chance
     */
    private int dropChance;


    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     */
    public DroppableItem(String name, char displayChar, int dropChance) {
        super(name, displayChar, true);
        this.dropChance = dropChance;
    }

    /**
     * Gets the drop chance
     * @return drop chance
     */
    public int getDropChance() {
        return dropChance;
    }
}
