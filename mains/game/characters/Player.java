package game.characters;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.FollowBehaviour;

/**
 * Class representing the Player.<br>
 * @author Adrian Kristanto
 * Modified by:
 * @author Elyesa Tee Way Yien
 *
 */
public class Player extends Actor {

    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Status.EMPLOYEE);
    }

    /**
     * Displays the menu to prompt the player to input a valid action. Then returns the selected action
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return selected action
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions

        display.println(name + "\nHP: " + this.getHitPoints() + "/" + this.getMaxHP());
        display.println("\nCurrent Balance: " + this.getBalance());
        if (lastAction.getNextAction() != null) {
            return lastAction.getNextAction();
        }

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);

    }

    /**
     * Generates the Player's intrinsic weapon
     *
     * @return Player's intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1,"punches",5);
    }



    /**
     * Retrieves the player's current hit points.
     *
     * @return The player's hit points
     */
    public int getHitPoints() {
        return this.getAttribute(BaseActorAttributes.HEALTH);
    }

    public int getMaxHP(){
        return this.getAttributeMaximum(BaseActorAttributes.HEALTH);
    }


}
