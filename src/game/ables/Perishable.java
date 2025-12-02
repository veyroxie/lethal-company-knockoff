package game.ables;

/**
 * Represents items that can expire over time<br>
 * @author Elyesa Tee Way Yien
 * Modified by:
 *
 */
public interface Perishable {

    /**
     * details of how an item expires, and checks whether item has
     *
     * @return true if item has expired
     */
    public boolean expired();

}
