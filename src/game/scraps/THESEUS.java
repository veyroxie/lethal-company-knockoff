package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.ables.Buyable;
import game.actions.TeleportAction;

/**
 * A class that represents the item THESEUS.
 * @author Henry Ma Yee Lik
 * Modified by:
 *
 *
 */
public class THESEUS extends Item implements Buyable {
    /**
     * The price of the item
     *
     */
    private static final int PRICE = 100;

    /**
     * Constructor.
     */
    public THESEUS() {
        super("THESEUS", '^', true);
    }

    /**
     * Executes the action where the actor buys an item
     *
     * @param actor the actor performing the action
     * @param roll the random number generated
     * @return a description of the action after it is processed
     */
    @Override
    public String buy(Actor actor , int roll) {
        if (actor.getBalance() < this.getPrice()) {
            return actor + " does not have enough credits to buy " + this;
        }

        actor.deductBalance(this.getPrice());
        actor.addItemToInventory(this);
        return actor + " bought " + this + " for " + this.getPrice() + " credits";

    }

    /**
     * Returns the price of the item
     *
     * @return the price of the item
     */
    @Override
    public int getPrice() {
        return THESEUS.PRICE;
    }

    /**
     * Returns the allowable actions for the actor
     *
     * @param location the actor performing the action
     * @return a list of allowable actions
     */
    @Override
    public ActionList allowableActions(Location location) {
        ActionList actions = new ActionList();
        actions.add(new TeleportAction(location.getActor()));
        return actions;
    }
}
