package game.terrain;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.characters.Status;

/**
 * A class that represents the floor inside a building.<br>
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Tong Zhi Hao
 */
public class Floor extends Ground {
    public Floor() {
        super('_');
    }

    /**
     * Returns false if the actor is hostile to the player
     *
     * @param actor the Actor to check
     * @return Boolean
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Status.HOSTILE_TO_PLAYER)){
            return false;
        }

        return true;
    }
}
