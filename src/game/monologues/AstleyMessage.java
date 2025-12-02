package game.monologues;

/**
 * Enum representing various monologue messages for the Astley item.
 * Each message is associated with a specific condition or default state.
 *
 * <p>
 * Example usage:
 * <pre>
 *     AstleyMessage message = AstleyMessage.DEFAULT_1;
 *     System.out.println(message.getMessage());
 * </pre>
 * </p>
 *
 *
 * @author Elyesa Tee Way Yien
 */
public enum AstleyMessage {
    DEFAULT_1("The factory will never gonna give you up, valuable intern!"),
    DEFAULT_2("We promise we never gonna let you down with a range of staff benefits."),
    DEFAULT_3("We never gonna run around and desert you, dear intern!"),
    INV_10_ITEMS("We never gonna make you cry with unfair compensation."),
    CREDITS_50("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you."),
    HEALTH_BELOW_2("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.");

    private final String message;


    /**
     * Constructor for the AstleyMessage enum.
     *
     * @param message The monologue message associated with this enum constant.
     */
    AstleyMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the monologue message associated with this enum constant.
     *
     * @return The monologue message.
     */
    public String getMessage() {
        return message;
    }
}
