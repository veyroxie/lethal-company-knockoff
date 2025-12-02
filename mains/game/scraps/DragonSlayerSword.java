package game.scraps;

import edu.monash.fit2099.engine.actors.Actor;
import game.ables.Buyable;

/**
 * Represents a Dragon Slayer Sword<br>
 * @author Henry Ma Yee Lik
 */
public class DragonSlayerSword extends ScrapWeapon implements  Buyable {
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
    public DragonSlayerSword() {
        super("Dragon Slayer Sword", 'x', 50, "excalibur(ed)", 75);
        this.chance = 50;
        this.price = 100;
    }

    /**
     * Executes the action where the actor buys an item
     *
     * @param actor the actor performing the action
     * @param roll the random number generated
     * @return a description of the action after it is processed
     */
    @Override
    public String buy(Actor actor, int roll) {
        if (actor.getBalance() < price) {
            return actor + " does not have enough credits to buy " + this;
        }
        if (roll < this.getChance()){
            actor.deductBalance(this.getPrice());
            return actor + " paid for " + this + ", but the item was not printed";
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