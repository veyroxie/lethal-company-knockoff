package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utility;
import game.ables.Consumable;
import game.ables.Perishable;
import game.ables.Sellable;
import game.actions.ConsumeAction;
import game.actions.SellAction;

/**
 * Represents a Jar of Pickles item that is consumable, perishable, and sellable.
 * @author Elyesa Tee Way Yien
 * Modified by: Timothy Yeng Kai Ze
 */
public class JarOfPickles extends Item implements Consumable, Perishable, Sellable {
    private static final int HEALED = 1;
    private static final int HURT = 1;
    private static final int PROB = 50;

    /** The price at which the jar of pickles can be sold. */
    private int sellPrice;

    /** The chance of selling the jar of pickles at double the price. */
    private int chance;

    /**
     * Constructor.
     * Initializes a jar of pickles with a name, display character, and availability.
     * Sets default values for sell price and chance.
     */
    public JarOfPickles() {
        super("Jar of Pickles", 'n', true);
        this.sellPrice = 25;
        this.chance = 50;
    }

    /**
     * Returns a list of allowable actions for the owner of the jar of pickles.
     * Only includes a ConsumeAction.
     *
     * @param owner the actor that owns the item
     * @return a list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(consume());
        return actions;
    }

    /**
     * Heals the player for 1 point if the item is not expired, otherwise the player loses 1 HP.
     * Displays a message if the item is expired.
     *
     * @param owner the owner of the consumable
     */
    @Override
    public void effect(Actor owner) {
        if (!this.expired()) {
            owner.heal(HEALED);
        } else {
            owner.hurt(HURT);
            System.out.println("It was expired!.");
        }
    }

    /**
     * Returns a ConsumeAction instance with the jar of pickles as argument.
     *
     * @return a ConsumeAction with the jar of pickles as argument
     */
    @Override
    public ConsumeAction consume() {
        return new ConsumeAction(this);
    }

    /**
     * Sells the jar of pickles to the specified actor.
     * Adds the sell price to the actor's balance. There's a chance to sell it at double the price.
     *
     * @param actor the actor who is selling the jar of pickles
     * @param roll a value that may influence the sale
     * @param map the current game map
     * @return a description of the result of the sell action
     */
    @Override
    public String sell(Actor actor, int roll, GameMap map) {
        if (roll < this.getChance()) {
            this.setSellPrice(this.getSellPrice() * 2);
            actor.addBalance(this.getSellPrice());
            return actor + " has sold " + this + " at double the price";
        } else {
            actor.addBalance(this.getSellPrice());
            return actor + " has sold " + this;
        }
    }

    /**
     * Returns a SellAction instance for selling the jar of pickles.
     *
     * @return a SellAction object
     */
    @Override
    public SellAction selling() {
        return new SellAction(this);
    }

    /**
     * Returns the price at which the jar of pickles can be sold.
     *
     * @return the price of the jar of pickles
     */
    @Override
    public int getSellPrice() {
        return sellPrice;
    }

    /**
     * Returns the chance of selling the jar of pickles at double the price.
     *
     * @return the chance of selling at double the price
     */
    public int getChance() {
        return chance;
    }

    /**
     * Sets the sell price of the jar of pickles.
     *
     * @param sellPrice the price at which the jar of pickles can be sold
     */
    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * Returns the jar of pickles itself as an item.
     *
     * @return the jar of pickles as an item
     */
    @Override
    public Item returnItem() {
        return this;
    }

    /**
     * Returns true if the item is expired, otherwise false
     *
     * @return true if the item is expired, otherwise false
     */
    @Override
    public boolean expired() {
        int expired = Utility.generateNumber(0, 100);
        if (expired <= PROB) {
            return true;
        } else {
            return false;
        }
    }

}