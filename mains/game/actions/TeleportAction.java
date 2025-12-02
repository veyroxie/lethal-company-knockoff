package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;

/**
 * A class that represents the action of teleporting to a random location.
 * @author Henry Ma Yee Lik
 * Modified by:
 *
 *
 */
public class TeleportAction extends Action {
    /**
     * The actor that is teleporting
     */
    private Actor actor;

    /**
     * Constructor.
     *
     * @param actor the actor that is teleporting
     */
    public TeleportAction(Actor actor) {
        this.actor = actor;
    }

    /**
     * Teleports the actor to a random location.
     *
     * @param actor the actor that is teleporting
     * @param map the map that the actor is on
     * @return a string that describes the result of the teleportation
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int x = Utility.generateNumber(0, map.getXRange().max());
        int y = Utility.generateNumber(0, map.getYRange().max());
        Location newLocation = map.at(x, y);
        if (newLocation.canActorEnter(actor)) {
            map.moveActor(actor, newLocation);
            return actor + " is teleported to a new location.";
        } else {
            return actor + " tried to teleport, but the teleportation failed.";
        }
    }

    /**
     * Returns a string that describes the action.
     *
     * @param actor the actor that is teleporting
     * @return a string that describes the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleports to a random location.";
    }
}