package game.creatures;

/**
 * Represents the spawner for the suspicious astronaut<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public class SuspiciousAstronautSpawner implements Spawner{
    /**
     * Spawn Chance
     */
    private int spawnChance;

    /**
     * Constructor
     */
    public SuspiciousAstronautSpawner(){
        this.spawnChance = 5;
    }
    /**
     * Spawns SuspiciousAstronaut
     * @return SuspiciousAstronaut
     */
    @Override
    public SuspiciousAstronaut spawnMob() {
        return new SuspiciousAstronaut();
    }

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
