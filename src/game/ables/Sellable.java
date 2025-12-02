package src.game.ables;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SellAction;

import java.util.List;

/**
 * Represents an item that can be sold
 * Created by:
 * @author Timothy Yeng Kai Ze
 *
 */
public interface Sellable {
    /**
     * Sells the item to the specified actor, given a roll value and the current game map.
     *
     * @param actor the actor who is selling the item
     * @param roll a value that may influence the sale
     * @param map the current game map
     * @return a string describing the result of the sell action
     */
    String sell(Actor actor , int roll, GameMap map);
    /**
     * Returns a SellAction instance for selling the item.
     *
     * @return a SellAction object
     */
    SellAction selling();
    /**
     * Returns the price of the item.
     *
     * @return the price of the item
     */
    int getSellPrice();
    /**
     * Returns the item that is being sold.
     *
     * @return the item being sold
     */
    Item returnItem();
}
