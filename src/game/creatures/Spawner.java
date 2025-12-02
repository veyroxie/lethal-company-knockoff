package game.creatures;

/**
 * Represents a spawner<br>
 * Created by:
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public interface Spawner {

    /**
     * Spawns creature
     *
     * @return The creature
     */
    Creature spawnMob();

    /**
     * Gets spawn chance
     *
     * @return Spawn chance
     */
    int getSpawnChance();
}
