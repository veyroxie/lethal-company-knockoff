package game.item;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.ables.Buyable;
import game.ables.Monologuable;
import game.ables.Subscribable;
import game.ables.Usable;
import game.actions.UseAction;
import game.characters.Status;
import game.monologues.AstleyMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class representing an Astley item
 *
 * @author Elyesa Tee Way Yien
 */
public class Astley extends Item implements Buyable, Usable, Subscribable, Monologuable {
    private List<AstleyMessage> monologues = new ArrayList<>();

    private static final int TICK_PERIOD = 5;
    private static final int FREE_PERIOD = 5; // Free period of 5 ticks
    private int current_tick = 0; // Start from 0
    private boolean subscription_active = false;
    private static final int SUBSCRIPTION_FEE = 1;

    private int price;

    /***
     * Constructor.
     */
    public Astley() {
        super("Astley", 'z', true);
        this.price = 50;
        monologues.add(AstleyMessage.DEFAULT_1);
        monologues.add(AstleyMessage.DEFAULT_2);
        monologues.add(AstleyMessage.DEFAULT_3);
    }

    /**
     * Handles the ticking logic for the Astley item.
     * Increments the tick counter and checks the subscription status if the item is in the actor's inventory.
     *
     * @param currentLocation the current location of the actor
     * @param actor           the actor holding the item
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        if (isInInventory(actor)) {
            current_tick++;
            checkActive(actor);
        }
    }


    /**
     * Returns the list of allowable actions for the Astley item.
     *
     * @param owner the actor owning the item
     * @return a list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        if (subscription_active && owner.hasCapability(Status.EMPLOYEE)) {
            actions.add(use());
        }
        return actions;
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
        if (actor.getBalance() < this.getPrice()) {
            return actor + " does not have enough credits to buy " + this;
        }
        subscription_active = true; // Start with subscription active
        actor.deductBalance(this.getPrice());
        actor.addItemToInventory(this);
        return actor + " bought " + this;
    }

    /**
     * Returns the price of the item
     *
     * @return the price of the item
     */
    @Override
    public int getPrice() {
        return price;
    }


    /**
     * effect of using Astley
     * @param owner
     */
    @Override
    public void effect(Actor owner) {
        System.out.println(getMonologue(owner));
    }

    /**
     * Use of Astley
     * @return new UseAction for Astley
     */
    @Override
    public UseAction use() {
        return new UseAction(this);
    }

    /**
     * Returns a monologue based on the actor's state.
     *
     * @param owner the actor requesting the monologue
     * @return a monologue string
     */
    public String getMonologue(Actor owner) {
        List<AstleyMessage> availableAstleyMessages = new ArrayList<>(monologues);
        if (owner.getItemInventory().size() > 10) {
            availableAstleyMessages.add(AstleyMessage.INV_10_ITEMS);
        }
        if (owner.getBalance() > 50) {
            availableAstleyMessages.add(AstleyMessage.CREDITS_50);
        }
        if (owner.getAttribute(BaseActorAttributes.HEALTH) < 2) {
            availableAstleyMessages.add(AstleyMessage.HEALTH_BELOW_2);
        }
        Random random = new Random();
        return availableAstleyMessages.get(random.nextInt(availableAstleyMessages.size())).getMessage();
    }


    /**
     * Checks if the item is in the actor's inventory.
     *
     * @param owner the actor
     * @return true if the item is in the actor's inventory, false otherwise
     */
    private boolean isInInventory(Actor owner) {
        return owner != null && owner.getItemInventory().contains(this);
    }

    /**
    //     * Checks and updates the subscription status based on the current tick and actor's balance.
    //     *
    //     * @param owner the actor
    //     * @return true if the subscription is active, false otherwise
    //     */
    public boolean checkActive(Actor owner){
        if (isInInventory(owner)) {
            if (current_tick < FREE_PERIOD) {
                subscription_active = true;
            } else if (current_tick >= FREE_PERIOD && (current_tick - FREE_PERIOD) % TICK_PERIOD == 0 && owner.hasCapability(Status.EMPLOYEE)) {
                subscription_active = paySubscription(owner);
            }
        } else {
            subscription_active = false;
        }
        return subscription_active;
    }


    /**
     * Deducts the subscription fee from the actor's balance if they have enough credits.
     *
     * @param owner the actor
     * @return true if the subscription fee was successfully deducted, false otherwise
     */
    public boolean paySubscription(Actor owner) {
        if (owner.getBalance() >= SUBSCRIPTION_FEE) {
            owner.deductBalance(SUBSCRIPTION_FEE);
            System.out.println("owner paid Astley fee successfully!");
            return true;
        } else {
            System.out.println("Not enough balance to pay Astley fee!");
            return false;
        }
    }
}
