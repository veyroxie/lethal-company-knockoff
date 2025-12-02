package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.characters.Status;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents hostile behaviour<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public class HostileBehaviour implements Behaviour {
    /**
     * Random object to be used
     */
    private final Random random = new Random();
    private boolean kill;

    public HostileBehaviour(boolean kill){
        this.kill = kill;
    }

    /**
     * If there are attack-able actors around it, randomly selects one and returns the AttackAction for it. null otherwise
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return AttackAction or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<>();

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();
                if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    AttackAction attackAction =  new AttackAction(target, exit.getName());

                    if (kill) {
                        attackAction.setKill(true);
                    }

                    actions.add(attackAction);
                }
            }
        }

        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        }
        else {
            return null;
        }
    }
}
