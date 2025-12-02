package game.creatures;

/**
 * Represents the spawner for the huntsman spider<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public class HuntsmanSpiderSpawner implements Spawner {
    /**
     * Spawn Chance
     */
    private int spawnChance;

    /**
     * Constructor
     */
    public HuntsmanSpiderSpawner(){
        this.spawnChance = 5;
    }

    /**
     * Spawns HuntsmanSpider
     *
     * @return HuntsmanSpider
     */
    @Override
    public HuntsmanSpider spawnMob() {
        return new HuntsmanSpider();
    }

    /**
     * Gets spawn chance
     *
     * @return Spawn chance
     */
    @Override
    public int getSpawnChance() {
        return spawnChance;
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
