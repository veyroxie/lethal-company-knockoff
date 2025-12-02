package game.flora;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Represents an Inheritree<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public class Inheritree extends FruitPlant{
    /**
     * The constructor of the Inheritree class.
     * Currently, changes state every 3, 6, and 5 turns until it remains a mature Inheritree ('T')
     * Only sapling ('t') and mature ('T') states produce fruit.
     *
     */
    public Inheritree() {
        super("Inheritree",  ',', null);
        this.addGrowthStage(3, ',');
        this.addGrowthStage(6, 't', new SmallFruit());
        this.addGrowthStage(5, 'y');
        this.addGrowthStage(999,'T', new LargeFruit());
    }

}
