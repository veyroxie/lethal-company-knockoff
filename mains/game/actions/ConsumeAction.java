package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ables.Consumable;

/**
 * Represent an action to consume <br>
 * @author Tong Zhi Hao
 * Modified by:
 * @author Elyesa Tee Way Yien
 *
 */
public class ConsumeAction extends Action {

    /**
     * Consumable to be consumed
     */
    Consumable consumable;

    /**
     * Constructor
     *
     * @param consumable
     */
    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable;
    }

    /**
     * Applies the action and checks if actor is conscious after consuming item.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return Success message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        this.consumable.effect(actor);
        actor.removeItemFromInventory(this.consumable.returnItem());

        if(!actor.isConscious()){
            actor.unconscious(map);
            System.out.println(actor.unconscious(map));
        }
        return actor + " consumed " + this.consumable.toString() + "!";
    }

    /**
     * Returns menu description
     *
     * @param actor The actor performing the action.
     * @return Menu description
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + this.consumable.toString();
    }

}
