package game.ables;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Represents any entity that can monologue within the game <br>
 * @author Elyesa Tee Way Yien
 * Modified by:
 *
 */
public interface Monologuable {

    /**
     * Gets a monologue based on the state of the given actor.
     *
     * @param user the actor for whom the monologue is generated
     * @return a string representing the monologue
     */
    String getMonologue(Actor user);

}
