package game.creatures;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Creature<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public abstract class Creature extends Actor {
    /**
     * The list of keys sorted by priority
     */
    private String[] priorityKeyList;

    /**
     * Hashmap for behaviours
     */
    private Map<String, Behaviour> behaviours = new HashMap<>();

    /**
     * The constructor of the Creature class.
     *
     * @param name        the name of the Mob
     * @param displayChar the character that will represent the Mob in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Creature(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours.put("WANDER", new WanderBehaviour());
        this.priorityKeyList = new String[]{"WANDER"};
    }

    /**
     * At each turn, select a valid action to perform according to priority.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        String[] keys = this.getPriorityKeyList();

        for (String key: keys){
            if (this.getBehaviours().get(key) != null && this.getBehaviours().get(key).getAction(this,map) != null ){
                return this.getBehaviours().get(key).getAction(this,map);
            }
        }

        return new DoNothingAction();
    }

    /**
     * Get the behaviour hashmap
     *
     * @return Behaviour hashmap
     */
    public Map<String, Behaviour> getBehaviours() {
        return this.behaviours;
    }

    /**
     * Add a behaviour to the hashmap
     *
     * @param key The key
     * @param behaviour The behaviour
     */
    public void addBehaviours(String key, Behaviour behaviour) {
        this.behaviours.put(key,behaviour);
    }

    /**
     * Get the list of keys by priority
     *
     * @return List of keys by priority
     */
    public String[] getPriorityKeyList() {
        return priorityKeyList;
    }

    /**
     * Sets the list of keys by priority
     *
     * @param priorityKeyList The list of keys by priority
     */
    public void setPriorityKeyList(String[] priorityKeyList) {
        this.priorityKeyList = priorityKeyList;
    }

    /**
     * Adds a key to the front of the list of keys
     * @param key The key to be added
     */
    public void addPriorityKey(String key){
        String[] newArray = new String[this.priorityKeyList.length + 1];
        newArray[0] = key;
        for (int i=1; i<newArray.length;i++){
            newArray[i]= priorityKeyList[i-1];
        }
        this.priorityKeyList = newArray;
    }
}
