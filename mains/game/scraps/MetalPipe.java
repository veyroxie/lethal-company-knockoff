package game.scraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ables.Sellable;
import game.actions.SellAction;

/**
 * Represents a metal pipe<br>
 * @author Tong Zhi Hao
 * Modified by:Timothy Yeng Kai Ze
 *
 */
public class MetalPipe extends ScrapWeapon implements Sellable {
    /** The price at which the metal pipe can be sold. */
    private int sellPrice;
    /**
     * Constructor.
     * Initializes a metal pipe with a name, display character, verb, base damage, and availability.
     * Sets the sell price to 35.
     */
    public MetalPipe() {
        super("Metal Pipe",'!',1,"whacks",20);
        this.sellPrice = 35;
    }
    /**
     * Sells the metal pipe to the specified actor.
     * Adds the sell price to the actor's balance.
     *
     * @param actor the actor who is selling the metal pipe
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
     * Returns a SellAction instance for selling the metal pipe.
     *
     * @return a SellAction object
     */

    @Override
    public SellAction selling() {
        return new SellAction(this);
    }
    /**
     * Returns the price at which the metal pipe can be sold.
     *
     * @return the price of the metal pipe
     */

    @Override
    public int getSellPrice() {
        return sellPrice;
    }
    /**
     * Returns the metal pipe itself as an item.
     *
     * @return the metal pipe as an item
     */

    @Override
    public Item returnItem() {
        return this;
    }
}
