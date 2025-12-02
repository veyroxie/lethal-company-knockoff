package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.ables.Sellable;
import game.actions.SellAction;

/**
 * Represents a large bolt<br>
 * @author Tong Zhi Hao
 * Modified by:Timothy Yeng Kai Ze
 *
 */
public class LargeBolt extends Item implements Sellable {
    /** The price at which the large bolt can be sold. */
    private int sellPrice;
    /***
     * Constructor.
     * Initializes a large bolt with a name, display character, and availability.
     * Sets the sell price to 25.
     */
    public LargeBolt() {
        super("Large Bolt",'+',true);
        this.sellPrice = 25;
    }
    /**
     * Sells the large bolt to the specified actor.
     * Adds the sell price to the actor's balance.
     *
     * @param actor the actor who is selling the large bolt
     * @param roll a value that may influence the sale
     * @param map the current game map
     * @return a description of the result of the sell action
     */

    @Override
    public String sell(Actor actor, int roll, GameMap map) {
        actor.addBalance(this.getSellPrice());
        return actor + " has sold " + this;
    }
    /**
     * Returns a SellAction instance for selling the large bolt.
     *
     * @return a SellAction object
     */

    @Override
    public SellAction selling() {
        return new SellAction(this);
    }
    /**
     * Returns the price at which the large bolt can be sold.
     *
     * @return the price of the large bolt
     */

    @Override
    public int getSellPrice() {
        return sellPrice;
    }
    /**
     * Returns the large bolt itself as an item.
     *
     * @return the large bolt as an item
     */

    @Override
    public Item returnItem() {
        return this;
    }
}
