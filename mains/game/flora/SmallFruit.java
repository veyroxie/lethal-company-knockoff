package game.flora;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.ables.Consumable;
import game.actions.ConsumeAction;

/**
 * Represents a small fruit<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public class SmallFruit extends DroppableItem implements Consumable{
    /***
     * Constructor.
     */
    public SmallFruit() {
        super("Small Fruit", 'o',30);
    }

    /**
     * Returns an ActionList with only a ConsumeAction with the fruit as argument
     *
     * @param owner the actor that owns the item
     * @return ActionList with a ConsumeAction
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(consume());
        return actions;
    }

    /**
     * Heals the player for 2 points
     *
     * @param owner Owner of the consumable
     */
    @Override
    public void effect(Actor owner) {
        owner.heal(1);
    }

    /**
     * Returns a ConsumeAction with the fruit as argument
     *
     * @return ConsumeAction with the fruit as argument
     */
    @Override
    public ConsumeAction consume() {
        return new ConsumeAction(this);
    }

    /**
     * Returns itself
     *
     * @return The fruit
     */
    @Override
    public Item returnItem() {
        return this;
    }
}
