package main.actions;

import java.util.List;

/**
 * Interface that allows for storage of allowable actions by particular entity
 *
 * @author Elyesa Tee
 * @version 1.0.0
 */

public interface ActionCapable {
    /**
     * Shows allowable actions in a list
     * @return list of allowable actions
     */
    public List<Action> allowableActions();
}
