package game.terrain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ables.Consumable;
import game.actions.ConsumeAction;

/**
 * Represents a puddle<br>
 * @author Adrian Kristanto
 * Modified by:
 * @author Elyesa Tee Way Yien
 */
public class Puddle extends Ground implements Consumable {
    private static final int ADD_HP = 1;
    /**
     * Constructor.
     */
    public Puddle() {
        super('~');
    }


    /**
     * Returns an ActionList having ConsumeAction as possible action
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return list of actions allowed
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (location.getActor() == actor){
            actions.add(consume());
        }
        return actions;
    }

    /**
     * Increases Maximum HP of the consumer by 1 point
     *
     * @param user actor using the consumable
     */
    @Override
    public void effect(Actor user) {
            user.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, ADD_HP);
        }


    /**
     * Returns a ConsumeAction with Puddle as argument
     *
     * @return ConsumeAction with Puddle as argument
     */
    @Override
    public ConsumeAction consume() {
            return new ConsumeAction(this);
    }


    /**
     * Returns nothing, since does not need to be in actor inventory to be consumed
     * @return null
     */
    @Override
    public Item returnItem() {
        return null;
    }

    /**
     * toString to show up in menu description
     *
     * @return String of name
     */
    @Override
    public String toString() {
        return "Puddle of Water";
    }
}
