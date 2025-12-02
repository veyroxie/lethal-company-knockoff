package game.flora;

/**
 * Class that represents an indvidual growth stage <br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public class GrowthStage {
    /**
     * The number of ticks needed to get past this stage
     */
    private final int DURATION;
    /**
     * The display character for this stage
     */
    private final char DISPLAY_CHAR;

    /**
     * Fruit the plant produces at this stage if any
     */
    private final DroppableItem FRUIT;

    /**
     * Constructor
     * @param duration number of ticks needed to get past this stage
     * @param display_char display character for this stage
     * @param fruit Fruit the plant produces at this stage if any
     */
    public GrowthStage(int duration, char display_char, DroppableItem fruit) {
        this.DURATION = duration;
        this.DISPLAY_CHAR = display_char;
        this.FRUIT = fruit;
    }

    /**
     * Getter for the duration
     * @return duration
     */
    public int getDURATION() {
        return DURATION;
    }

    /**
     * Getter for the display character
     * @return display character
     */
    public char getDISPLAY_CHAR() {
        return DISPLAY_CHAR;
    }

    /**
     * Getter for the fruit
     * @return fruit
     */
    public DroppableItem getFRUIT() {
        return FRUIT;
    }
}
