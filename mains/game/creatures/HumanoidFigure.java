package game.creatures;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ables.Sellable;
import game.actions.BuyAction;
import game.actions.SellAction;
import game.behaviours.WanderBehaviour;
import game.characters.Player;
import game.characters.Status;
import game.item.ToiletPaperRoll;
import game.scraps.DragonSlayerSword;
import game.scraps.EnergyDrink;
import game.scraps.LargeBolt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a Humanoid Figure<br>
 * @author Timothy Yeng Kai Ze
 * Modified by:
 *
 */
public class HumanoidFigure extends Actor{
    /**
     * Constructor.
     * Initializes a HumanoidFigure with the name "Humanoid Figure", display character 'H', and hit points of 99.
     */
    public HumanoidFigure(){
        super("Humanoid Figure",'H', 99);
    }
    /**
     * Determines the action to be taken by the HumanoidFigure on its turn.
     * Currently, the HumanoidFigure does nothing each turn.
     *
     * @param actions a list of possible actions
     * @param lastAction the last action performed
     * @param map the current game map
     * @param display the display
     * @return the action to be performed by the HumanoidFigure
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
    /**
     * Returns a list of actions that the HumanoidFigure can perform on the specified actor.
     * If the other actor is a player, and they have sellable items in their inventory,
     * the HumanoidFigure will be able to buy those items.
     *
     * @param otherActor the actor that might interact with the HumanoidFigure
     * @param direction the direction of the other actor
     * @param map the current game map
     * @return a list of allowable actions
     */

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList list = new ActionList();
            for (Item item: otherActor.getItemInventory() ){
                try {
                    Sellable sellableItem = (Sellable) item;
                    list.add(sellableItem.selling());
                } catch (ClassCastException e) {
                }
            }
        return list;
    }
}
