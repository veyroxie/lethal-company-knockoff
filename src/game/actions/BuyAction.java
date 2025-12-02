package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utility;
import game.ables.Buyable;

/**
 * Represents an action where the actor buys an item
 */
public class BuyAction extends Action {
    /**
     * The item to be bought
     */
    private Buyable item;
    /**
     * The price of the item
     */
    private int price;
    /**
     * The chance of a special event happening
     */
    private double chance;

    /**
     * Constructor.
     *
     * @param item the item to be bought

     */
    public BuyAction(Buyable item) {
        this.item = item;
    }

    /**
     * Executes the action where the actor buys an item
     *
     * @param actor the actor performing the action
     * @param map the map the actor is on
     * @return a description of the action after it is processed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int randomValue = Utility.generateNumber(0,100);
        String printedString = this.item.buy(actor, randomValue);
        return printedString;
    }

    /**
     * Returns a string description of the action
     *
     * @param actor the actor performing the action
     * @return a string description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + item + " for " + item.getPrice() + " credits";
    }
}