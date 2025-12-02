package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ables.Consumable;
import game.ables.Sellable;
import game.actions.ConsumeAction;
import game.actions.SellAction;

/**
 * Represents a Pot of Gold<br>
 *
 * @author Elyesa Tee Way Yien
 * Modified by:Timothy Yeng Kai Ze
 */
public class PotOfGold extends Item implements Consumable,Sellable {
    private static final int CREDIT_AMOUNT = 10;
    /** The price at which the Pot of Gold can be sold. */
    private int sellPrice;
    /** The chance of cheating when selling the Pot of Gold. */
    private int chance;
    /**
     * Constructor.
     * Initializes a Pot of Gold with a name, display character, and availability.
     * Sets the sell price to 500 and the chance to 25.
     */
    public PotOfGold() {
        super("Pot of Gold", '$', true);
        this.sellPrice = 500;
        this.chance = 25;
    }


    /**
     * Adds 10 credits to the User's balance
     *
     * @param owner actor using the pot of gold
     */
    @Override
    public void effect(Actor owner) {
        owner.addBalance(CREDIT_AMOUNT);
        System.out.println("You got "+ CREDIT_AMOUNT +" credits!");
    }

    /**
     * Returns a ConsumeAction with PotOfGold as argument
     *
     * @return new ConsumeAction with PotOfGold as argument
     */
    @Override
    public ConsumeAction consume() {
        return new ConsumeAction(this);
    }
    /**
     * Sells the Pot of Gold to the specified actor.
     * Adds the sell price to the actor's balance. There's a chance to cheat the actor by setting the sell price to 0.
     *
     * @param actor the actor who is selling the Pot of Gold
     * @param roll a value that may influence the sale
     * @param map the current game map
     * @return a description of the result of the sell action
     */

    @Override
    public String sell(Actor actor, int roll, GameMap map) {
        if (roll < this.getChance()){
            this.setSellPrice(0);
            actor.addBalance(this.getSellPrice());
            return actor+ " has been cheated out of " + this;

        }else{
            actor.addBalance(this.getSellPrice());
            return actor + " has sold " + this;
        }
    }
    /**
     * Returns a SellAction instance for selling the Pot of Gold.
     *
     * @return a SellAction object
     */
    @Override
    public SellAction selling() {
        return new SellAction(this);
    }
    /**
     * Returns the price at which the Pot of Gold can be sold.
     *
     * @return the price of the Pot of Gold
     */

    @Override
    public int getSellPrice() {
        return sellPrice;
    }
    /**
     * Returns the chance of cheating when selling the Pot of Gold.
     *
     * @return the chance of cheating
     */

    public int getChance() {
        return chance;
    }
    /**
     * Sets the sell price of the Pot of Gold.
     *
     * @param sellPrice the price at which the Pot of Gold can be sold
     */

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * Returns itself
     *
     * @return Pot Of Gold
     */
    @Override
    public Item returnItem() {
        return this;
    }

    /**
     * Returns a list of actions containing only ConsumeAction
     *
     * @param owner the actor that owns the item
     * @return the list of actions
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(consume());
        return actions;
    }
}
