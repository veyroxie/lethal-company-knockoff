package game.flora;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ables.Consumable;
import game.ables.Sellable;
import game.actions.ConsumeAction;
import game.actions.SellAction;

/**
 * Represents a large fruit<br>
 * @author Tong Zhi Hao
 * Modified by: Timothy Yeng Kai Ze
 *
 */
public class LargeFruit extends DroppableItem implements Consumable, Sellable {
    /**
     * The selling price of the item
     */
    private int sellPrice;
    /***
     * Constructor.
     * Initializes a large fruit with a name, display character, and hit points.
     * Sets the sell price to 30.
     */
    public LargeFruit() {
        super("Large Fruit", 'O',20);
        this.sellPrice = 30;
    }

    /**
     * Heals the player for 2 points
     *
     * @param owner Owner of the consumable
     */
    @Override
    public void effect(Actor owner) {
        owner.heal(2);
    }

    /**
     * Returns a ConsumeAction with the fruit as argument
     *
     * @return ConsumeAction with the fruit as argument
     */
    @Override
    public ConsumeAction consume() {
        return new ConsumeAction(this);
    }
    /**
     * Sells the large fruit to the specified actor.
     * Adds the sell price to the actor's balance.
     *
     * @param actor the actor who is selling the large fruit
     * @param roll a value that may influence the sale
     * @param map the current game map
     * @return a string describing the result of the sell action
     */

    @Override
    public String sell(Actor actor, int roll, GameMap map) {
        actor.addBalance(this.getSellPrice());
        return actor + " has sold " + this;
    }
    /**
     * Returns a SellAction instance for selling the large fruit.
     *
     * @return a SellAction object
     */

    @Override
    public SellAction selling() {
        return new SellAction(this);
    }
    /**
     * Returns the price at which the large fruit can be sold.
     *
     * @return the price of the large fruit
     */

    @Override
    public int getSellPrice() {
        return sellPrice;
    }

    /**
     * Returns itself
     *
     * @return The fruit
     */
    @Override
    public Item returnItem() {
        return this;
    }

    /**
     * Returns an ActionList with only a ConsumeAction with the fruit as argument
     *
     * @param owner the actor that owns the item
     * @return ActionList with a ConsumeAction
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(consume());
        return actions;
    }
}
