package src.game.ables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.actions.UseAction;

/**
 * Represents any item that is usable
 *
 * @author Elyesa Tee Way Yien
 */
public interface Usable {
    /**
     * Applies effect
     * @param user
     */
    void effect(Actor user);

    /**
     * Returns a UseAction with the item as argument
     *
     * @return the UseAction
     */
    UseAction use();



}
