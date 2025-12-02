package game;

import java.util.Random;

/**
 * The class for utility actions<br>
 * @author Tong Zhi Hao
 * Modified by:
 *
 */
public class Utility {

    /**
     * Returns a random number within the specified range
     *
     * @param lower Inclusive lower bound
     * @param upper Exclusive upper bound
     * @return Generated number
     */
    public static int generateNumber(int lower, int upper){
        Random random = new Random();
        return random.nextInt(upper-lower) + lower;
    }

    /**
     * Returns a String consisting of a specified amount of concatenated random numbers within the given range
     *
     * @param lower Inclusive lower bound
     * @param upper Exclusive upper bound
     * @return Generated number
     */
    public static String generateMultipleNumberString(int lower, int upper, int count){
        String returnedString = "";

        for (int i=0; i<count ; i++){
            returnedString += String.valueOf(generateNumber(lower,upper));
        }

        return returnedString;
    }
}
