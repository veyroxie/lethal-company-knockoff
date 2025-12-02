package game;

import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A class that represents a named game map.
 * @author Henry Ma Yee Lik
 * Modified by:
 *
 *
 */
public class NamedGameMap {
    /**
     * The game map
     */
    private GameMap map;

    /**
     * The name of the game map
     */
    private String name;

    /**
     * Constructor.
     *
     * @param map the game map
     * @param name the name of the game map
     */
    public NamedGameMap(GameMap map, String name) {
        this.map = map;
        this.name = name;
    }

    /**
     * Returns the game map.
     *
     * @return the game map
     */
    public GameMap getMap() {
        return map;
    }

    /**
     * Returns the name of the game map
     *
     * @return the name of the game map
     */
    public String getName() {
        return name;
    }
}