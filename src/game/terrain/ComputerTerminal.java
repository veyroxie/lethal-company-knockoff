package game.terrain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.NamedGameMap;
import game.actions.BuyAction;
import game.item.Astley;
import game.item.ToiletPaperRoll;
import game.scraps.DragonSlayerSword;
import game.scraps.EnergyDrink;
import game.scraps.THESEUS;

import java.util.List;

/**
 * A class that represents a computer terminal.
 * @author Henry Ma Yee Lik
 * Modified by:
 *
 *
 */
public class ComputerTerminal extends Ground {
    /**
     * The list of locations that can be accessed from the computer terminal
     */
    private final List<NamedGameMap> locations;

    /**
     * Constructor.
     *
     * @param locations the list of locations that can be accessed from the computer terminal
     */
    public ComputerTerminal(List<NamedGameMap> locations) {
        super('=');
        this.locations = locations;
    }

    /**
     * Returns a list of actions that can be performed on the computer terminal.
     *
     * @param actor     the actor that is interacting with the computer terminal
     * @param location  the location of the computer terminal
     * @param direction the direction of the actor
     * @return a list of actions that can be performed on the computer terminal
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = new ActionList();
        list.add(new BuyAction(new EnergyDrink()));
        list.add(new BuyAction(new DragonSlayerSword()));
        list.add(new BuyAction(new ToiletPaperRoll()));
        list.add(new BuyAction(new THESEUS()));
        list.add(new BuyAction(new Astley()));

        for (NamedGameMap targetLocation : locations) {
            if (location.map() != targetLocation.getMap()) {
                Location terminalLocation = findComputerTerminalLocation(targetLocation);
                if (terminalLocation != null) {
                    list.add(new MoveActorAction(terminalLocation, "to " + targetLocation.getName()));
                }
            }
        }

        return list;
    }

    /**
     * Finds the location of the computer terminal in the target map.
     *
     * @param targetMap the target map
     * @return the location of the computer terminal in the target map
     */
    public Location findComputerTerminalLocation(NamedGameMap targetMap) {
        for (int x : targetMap.getMap().getXRange()) {
            for (int y : targetMap.getMap().getYRange()) {
                Location location = targetMap.getMap().at(x, y);
                if (location.getGround().getClass() == ComputerTerminal.class) {
                    return location;
                }
            }
        }
        return null;
    }
}