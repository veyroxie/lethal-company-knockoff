package game.ables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;

/**
 * Represents a consumable<br>
 * Created by:
 * @author Tong Zhi Hao
 * Modified by:
 * @author Elyesa Tee Way Yien
 *
 */
public interface Consumable {

    /**
     * Applies effect to the actor
     *
     * @param user actor using the consumable
     */
    void effect(Actor user);

    /**
     * Returns a ConsumeAction with the Consumable as argument
     *
     * @return the ConsumeAction
     */
    ConsumeAction consume();

    /**
     * Returns the Item if it is an item
     * @return The Item
     */
    Item returnItem();

}
