package game.creatures;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.HostileBehaviour;
import game.characters.Status;

/**
 * Represents a hostile Mob<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public abstract class HostileCreature extends Creature {
    /**
     * Attack accuracy
     */
    private int attackAccuracy;

    /**
     * Verb for attacks
     */
    private String attackVerb;

    /**
     * Damage
     */
    private int attackDamage;

    /**
     * The constructor of the HostileCreature class.
     *
     * @param name        the name of the Creature
     * @param displayChar the character that will represent the Mob in the display
     * @param hitPoints   the Creature's starting hit points
     * @param kill boolean to check if the HostileCreatures attacks are fatal to targets
     */
    public HostileCreature(String name, char displayChar, int hitPoints, int attackDamage, String attackVerb, int attackAccuracy, boolean kill) {
        super(name, displayChar, hitPoints);
        this.attackAccuracy = attackAccuracy;
        this.attackVerb = attackVerb;
        this.attackDamage = attackDamage;
        this.addBehaviours("ATTACK",new HostileBehaviour(kill));
        this.addPriorityKey("ATTACK");
        this.addCapability(Status.HOSTILE_TO_PLAYER);
    }

    /**
     * Gets new intrinsic weapon with attributes as arguments
     *
     * @return New intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(attackDamage, attackVerb,attackAccuracy);
    }


    /**
     * Hostile mob can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return List of allowable actions for the mob
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }


}
