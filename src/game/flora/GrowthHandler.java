package game.flora;

import java.util.ArrayList;

/**
 * Class to handle growth for plants<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public class GrowthHandler {
    private final ArrayList<GrowthStage> GROWTH_STAGES = new ArrayList<>();

    /**
     * current elapsed ticks for this stage
     */
    private int elapsed = 0;

    /**
     * Index of the stage currently looked at
     */
    private int stageIndex = 0;

    /**
     * Constructor for a growth stage that bears fruits
     * @param duration duration to pass this stage
     * @param displayChar the display character for this stage
     * @param fruit the fruit to bear
     */
    public void addGrowthStage(int duration, char displayChar, DroppableItem fruit){
        this.GROWTH_STAGES.add(new GrowthStage(duration, displayChar, fruit));
    }

    /**
     * Constructor for a growth stage that does not bear fruit
     * @param duration duration to pass this stage
     * @param displayChar the display character for this stage
     */
    public void addGrowthStage(int duration, char displayChar){
        this.GROWTH_STAGES.add(new GrowthStage(duration, displayChar, null));
    }

    /**
     * Increments the tick count by 1
     * If the current elapsed ticks hits the duration count of the current stage, move the stage index forward,
     * reset the ticks to 0 and return true
     */
    public boolean grow(){
        boolean changed = false;
        if (this.stageIndex != this.GROWTH_STAGES.size() - 1 && this.elapsed == this.GROWTH_STAGES.get(stageIndex).getDURATION()){
            this.elapsed = 0;
            this.stageIndex += 1;
            changed = true;
        }

        this.elapsed += 1;
        return changed;
    }

    /**
     * Getter for the fruit
     * @return the fruit
     */
    public DroppableItem getFruit(){
        return this.GROWTH_STAGES.get(this.stageIndex).getFRUIT();
    }

    /**
     * The display character
     * @return the display character
     */
    public char getDisplayChar(){
        return this.GROWTH_STAGES.get(this.stageIndex).getDISPLAY_CHAR();
    }

    /**
     * The index for the stage we are looking at
     * @return the index for the stage we are looking at
     */
    public int getStageIndex() {
        return stageIndex;
    }

    /**
     * The amount of stages
     * @return the amount of stages
     */
    public int getAmountStages(){
        return this.GROWTH_STAGES.size();
    }

    /**
     * Checks whether the plant only has 1 stage
     * @return whether the plant only has 1 stage
     */
    public boolean singleStage(){
        return this.GROWTH_STAGES.size() <= 1;
    }
}
