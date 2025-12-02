package game.terrain;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;

import java.util.ArrayList;

/**
 * Represents a spawnpoint<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public interface Spawnpoint {

    /**
     * Returns a valid location to spawn (no actors)
     *
     * @param location the location of the spawnpoint
     * @return spawn location
     */
    default Location getSpawnLocation(Location location){
        ArrayList<Exit> exits = new ArrayList<>();
        for (Exit exit : location.getExits()) {
            if(!exit.getDestination().containsAnActor())
            exits.add(exit);
        }
        if (!exits.isEmpty()) {
            Location selected = exits.get(Utility.generateNumber(0,exits.size())).getDestination();
            return  selected;
        }
        else {
            return null;
        }
    }

    /**
     * Spawns the object
     *
     * @param location the location of the spawnpoint
     */
    void spawnObject(Location location);
}
