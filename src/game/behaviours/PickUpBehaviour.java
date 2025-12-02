package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utility;

import java.util.ArrayList;

/**
 * A class that figures out a MoveAction that will move the actor one step
 * closer to a target Actor.
 *
 * @author Henry Ma Yee Lik
 * Modified by:
 * @author Tong Zhi Hao
 */
public class PickUpBehaviour implements Behaviour {

    /**
     * Returns a PickUpAction that picks up an item on the ground.
     *
     * @param actor The actor that will pick up the item
     * @param map The map that the actor is on
     * @return A PickUpAction that picks up an item on the ground
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Item> items = new ArrayList<>();
        for (Item item : map.locationOf(actor).getItems()) {
            if (item.getPickUpAction(actor) != null) {
                items.add(item);
            }
        }

        if (!items.isEmpty()) {
            return new PickUpAction(items.get(Utility.generateNumber(0,items.size())));
        }

        return null;
    }
}
