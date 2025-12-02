package game.scraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ables.Sellable;
import game.actions.SellAction;

/**
 * Represents a metal sheet<br>
 * @author Tong Zhi Hao
 * Modified by:Timothy Yeng Kai Ze
 *
 */
public class MetalSheet extends Item implements Sellable {
    /** The chance of selling the metal sheet at half price. */
    private int chance;
    /** The price at which the metal sheet can be sold. */
    private int sellPrice;
    /**
     * Constructor.
     * Initializes a metal sheet with a name, display character, and availability.
     * Sets the sell price to 20 and the chance to 60.
     */
    public MetalSheet() {
        super("Metal Sheet",'%',true);
        this.sellPrice = 20;
        this.chance = 60;
    }
    /**
     * Sells the metal sheet to the specified actor.
     * Adds the sell price to the actor's balance. There's a chance to sell it at half price.
     *
     * @param actor the actor who is selling the metal sheet
     * @param roll a value that may influence the sale
     * @param map the current game map
     * @return a description of the result of the sell action
     */

    @Override
    public String sell(Actor actor, int roll, GameMap map) {
        if (roll < this.getChance()){
            this.setSellPrice(this.getSellPrice()/2);
            actor.addBalance(this.getSellPrice());
            return actor + " has sold " + this +" at half price";

        }else{
            actor.addBalance(this.getSellPrice());
            return actor + " has sold " + this;
        }
    }
    /**
     * Returns a SellAction instance for selling the metal sheet.
     *
     * @return a SellAction object
     */

    @Override
    public SellAction selling() {
        return new SellAction(this);
    }
    /**
     * Returns the price at which the metal sheet can be sold.
     *
     * @return the price of the metal sheet
     */
    @Override
    public int getSellPrice() {
        return sellPrice;
    }
    /**
     * Returns the chance of selling the metal sheet at half price.
     *
     * @return the chance of selling at half price
     */
    public int getChance() {
        return chance;
    }
    /**
     * Sets the sell price of the metal sheet.
     *
     * @param sellPrice the price at which the metal sheet can be sold
     */
    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
    /**
     * Returns the metal sheet itself as an item.
     *
     * @return the metal sheet as an item
     */

    @Override
    public Item returnItem() {
        return this;
    }
}
