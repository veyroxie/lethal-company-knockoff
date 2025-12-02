package game.terrain;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.creatures.Spawner;

/**
 * Represents a crater<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public class Crater extends Ground implements Spawnpoint {
    /**
     * The spawner
     */
    private Spawner spawner;

    /**
     * Constructor.
     */
    public Crater(Spawner spawner) {
        super('u');
        this.spawner = spawner;
    }

    /**
     * Tries to spawn something every tick
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        this.spawnObject(location);
    }

    /**
     * Spawns the object at the spawnpoint
     *
     * @param location the location of the spawnpoint
     */
    @Override
    public void spawnObject(Location location) {
        Location selected = getSpawnLocation(location);
        int roll = Utility.generateNumber(0,100);
        if (roll < this.spawner.getSpawnChance() && selected != null){
            selected.addActor(this.spawner.spawnMob());
        }
    }
}
