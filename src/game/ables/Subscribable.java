package game.ables;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Represents any instance that has a subscription.
 *
 * @author Elyesa Tee Way Yien
 *
 * Modified by:
 */
public interface Subscribable {

    /**
     * Checks if the subscription is active for the given actor
     *
     * @param user the actor whose subscription status is being checked
     * @return true if the subscription is active, false otherwise
     */
    boolean checkActive(Actor user);

    /**
     * Deducts the subscription fee from the actor's balance if they have enough credits.
     *
     * @param user the actor who is paying the subscription fee
     * @return true if the subscription fee was successfully deducted, false otherwise
     */
    boolean paySubscription(Actor user);
}
