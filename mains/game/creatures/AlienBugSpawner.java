package game.creatures;

import edu.monash.fit2099.engine.positions.GameMap;
import game.characters.Player;

/**
 * Represents the spawner for the alien bug<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public class AlienBugSpawner implements Spawner{
    /**
     * Spawn Chance
     */
    private int spawnChance;

    /**
     * Player
     */
    private Player player;

    /**
     * GameMap
     */
    private GameMap map;

    /**
     * Constructor.
     *
     */
    public AlienBugSpawner (){
        this.spawnChance  = 10;
    }

    /**
     * Spawns an Alien Bug
     *
     * @return Alien Bug
     */
    @Override
    public AlienBug spawnMob() {
        return new AlienBug();
    }

    /**
     * Gets spawn chance
     *
     * @return Spawn chance
     */
    @Override
    public int getSpawnChance() {
        return this.spawnChance;
    }

    /**
     * Sets spawn chance
     *
     * @param spawnChance Spawn chance
     */
    public void setSpawnChance(int spawnChance) {
        this.spawnChance = spawnChance;
    }
}
