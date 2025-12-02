package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.ables.Buyable;
import game.ables.Consumable;
import game.actions.ConsumeAction;

/**
 * Represents an Energy Drink<br>
 * @author Henry Ma Yee Lik
 */
public class EnergyDrink extends Item implements Consumable, Buyable {
    /**
     * The price of the item
     */
    private int price;
    /**
     * The chance of a special event happening
     */
    private int chance;

    /**
     * Constructor.
     */
    public EnergyDrink() {
        super("Energy Drink", '*', true);
        this.chance = 20;
        this.price = 10;
    }

    /**
     * Returns an ActionList with only a ConsumeAction with the Energy Drink as argument
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
     * Heals the player for 1 point
     *
     * @param owner Owner of the consumable
     */
    @Override
    public void effect(Actor owner) {
        owner.heal(1);
    }

    /**
     * Returns a ConsumeAction with the Energy Drink as argument
     *
     * @return ConsumeAction with the Energy Drink as argument
     */
    @Override
    public ConsumeAction consume() {
        return new ConsumeAction(this);
    }

    /**
     * Returns itself
     *
     * @return The Energy Drink
     */
    @Override
    public Item returnItem() {
        return this;
    }

    /**
     * Executes the action where the actor buys an item
     *
     * @param actor the actor performing the action
     * @param roll the random number generated
     * @return a description of the action after it is processed
     */
    @Override
    public String buy(Actor actor , int roll) {
        if (roll < this.getChance()){
            this.setPrice(this.getPrice()*2);
        }
        if (actor.getBalance() < this.getPrice()) {
            return actor + " does not have enough credits to buy " + this;
        }

        actor.deductBalance(this.getPrice());
        actor.addItemToInventory(this);
        return actor + " bought " + this;

    }

    /**
     * Returns the price of the item
     *
     * @return the price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the chance of a special event happening
     *
     * @return the chance of a special event happening
     */
    public int getChance() {
        return chance;
    }

    /**
     * Sets the price of the item
     *
     * @param price the price of the item
     */
    public void setPrice(int price) {
        this.price = price;
    }
}