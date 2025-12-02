package game.creatures;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utility;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.behaviours.PickUpBehaviour;
import game.characters.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Alien Bug<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public class AlienBug extends Creature {


    /**
     * Constructor.
     * Alien bug is name "Feature-" along with 3 random numbers
     */
    public AlienBug() {
        super("Feature-" + Utility.generateMultipleNumberString(0,10,3), 'a', 2);
        this.addBehaviours("FOLLOW", new FollowBehaviour(Status.HOSTILE_TO_ENEMY));
        this.addBehaviours("PICKUP", new PickUpBehaviour());
        this.addPriorityKey("FOLLOW");
        this.addPriorityKey("PICKUP");
    }

    /**
     * Adds an item to the Alien Bug's inventory.
     *
     * @param item The item to add
     */
    @Override
    public void addItemToInventory(Item item) {
        super.addItemToInventory(item);
    }
    /**
     * Returns the list of scraps that the Alien Bug has collected.
     *
     * @return The list of scraps that the Alien Bug has collected
     */
    public List<Item> getInventory() {
        return this.getItemInventory();
    }

    /**
     * Returns the map that the Alien Bug is in.
     *
     * @return The map that the Alien Bug is in
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        // Drop all portable items
        ArrayList<DropAction> dropActions = new ArrayList<DropAction>();
        for (Item item : getInventory()) {
            if (item.getPickUpAction(actor) != null) {
                dropActions.add(new DropAction(item));
            }
        }

        for (DropAction drops : dropActions){
            drops.execute(this,map);
        }

        return super.unconscious(actor, map);
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