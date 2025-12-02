package game.behaviours;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Behaviour;
import game.characters.Status;

/**
 * A class that figures out a MoveAction that will move the actor one step
 * closer to a target Actor.
 * @see edu.monash.fit2099.demo.mars.Application
 *
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Henry Ma Yee Lik
 * @author Tong Zhi Hao
 *
 */
public class FollowBehaviour implements Behaviour {

    /**
     * The target.
     * Target will be null until it encounters a player
     */
    private Actor target;

    /**
     * Targeted status of actor to follow
     */
    private final Status targetedStatus;


    /**
     * Constructor.
     *
     */
    public FollowBehaviour(Status targetedStatus) {
        this.target = null;
        this.targetedStatus = targetedStatus;
    }


    /**
     * If the target is null, try to find a player around the actor.
     * Move closer to the target according to the Manhattan distance
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return null or MoveActorAction
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);

        if (this.target == null){
            for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();
                if (destination.containsAnActor() && destination.getActor().hasCapability(this.targetedStatus)) {
                    this.target = destination.getActor();
                    break;
                }
            }
        }

        //If target is still null after the initial loop means that no player is in its proximity
        if(this.target == null || !map.contains(target) || !map.contains(actor))
            return null;

        Location there = map.locationOf(target);

        int currentDistance = distance(here, there);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                int newDistance = distance(destination, there);
                if (newDistance < currentDistance) {
                    return new MoveActorAction(destination, exit.getName());
                }
            }
        }

        return null;
    }

    /**
     * Compute the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the first location
     * @return the number of steps between a and b if you only move in the four cardinal directions.
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
