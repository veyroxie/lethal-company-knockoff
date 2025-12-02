package game.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ables.Buyable;
import game.ables.Sellable;
import game.actions.SellAction;

/**
 * Represents a Toilet Paper Roll
 * @author Henry Ma Yee Lik
 * Modified by: Timothy Yeng Kai Ze
 */
public class ToiletPaperRoll extends Item implements Buyable, Sellable {
    /**
     * The price of the item
     */
    private int price;
    /**
     * The chance of a special event happening
     */
    private int chance;
    /**
     * The chance of a special event happening when selling
     */
    private int sellChance;
    /**
     * The selling price of the item
     */
    private int SellPrice;

    /**
     * Constructor.
     * Initializes a toilet paper roll with a name, display character, and availability.
     * Sets default values for price, chance, sell chance, and sell price.
     */
    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
        this.chance = 75;
        this.price = 5;
        this.sellChance = 50;
        this.SellPrice=1;
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
            this.setPrice(1);
        }
        if (actor.getBalance() < this.getPrice()) {
            return actor + " does not have enough credits to buy " + this;
        }

        actor.deductBalance(this.getPrice());
        actor.addItemToInventory(this);
        return actor + " bought " + this;

    }
    /**
     * Executes the action where the actor sells the toilet paper roll.
     *
     * @param actor the actor performing the action
     * @param roll the random number generated
     * @param map the current game map
     * @return a description of the action after it is processed
     */
    @Override
    public String sell(Actor actor, int roll, GameMap map) {
        if (roll < this.getSellChance()){
            actor.unconscious(map);
            return actor+" was killed by Humanoid Figure";
        }else{
            actor.addBalance(this.getSellPrice());
            return actor + " has sold " + this;
        }
    }
    /**
     * Returns a SellAction instance for selling the toilet paper roll.
     *
     * @return a SellAction object
     */
    @Override
    public SellAction selling() {
        return new SellAction(this);
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
     * Returns the toilet paper roll itself as an item.
     *
     * @return the toilet paper roll as an item
     */
    @Override
    public Item returnItem() {
        return this;
    }
    /**
     * Returns the chance of a special event happening when buying the toilet paper roll.
     *
     * @return the chance of a special event happening
     */

    public int getSellChance() {
        return sellChance;
    }
    /**
     * Sets the price of the toilet paper roll.
     *
     * @return the selling price of the toilet paper roll
     */
    public int getSellPrice() {
        return SellPrice;
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