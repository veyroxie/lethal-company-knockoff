package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ables.Consumable;
import game.ables.Usable;

/**
 * Represents an action where actor uses an item
 *
 * @author Elyesa Tee Way Yien
 */
public class UseAction extends Action {
    Usable usable;
    public UseAction(Usable usable) {

        this.usable = usable;
    }

    /**
     * Applies the action and does not remove item from inventory
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return Success message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        this.usable.effect(actor);
        return actor + " used " + this.usable;
    }

    /**
     * Returns menu description
     *
     * @param actor The actor performing the action.
     * @return Menu description
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses " + this.usable.toString();
    }

}
