package src.game.ables;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Represents an item that can be bought
 * Created by:
 * @author Henry Ma Yee Lik
 * Modified by:
 * @author Tong Zhi Hao
 *
 */

public interface Buyable {
    /**
     * Executes the action where the actor buys an item
     *
     * @param actor the actor performing the action
     * @param roll the random number generated
     * @return a description of the action after it is processed
     */
    String buy(Actor actor, int roll);

    /**
     * Returns the price of the item
     *
     * @return the price of the item
     */
    int getPrice();

}
