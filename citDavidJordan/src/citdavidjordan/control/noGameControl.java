/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.control;

/**
 *
 * @author Deann_2
 */
public class noGameControl {
    public String numberGame(int guess, long currentTimeInSeconds) {
        if (guess < 1) {
            return "Number guessed is too low";
        }
        
        if (guess > 10) {
            return "The number guessed is too high";
        }
        
        long seedNo = currentTimeInSeconds * 654321 + 12345;
        long randomNo = (seedNo / 789) % 10;
        int correctNumber = (int) (randomNo + 1);
        
        if (guess == correctNumber) {
            return "You Win!";
        }
        
        else {
            return "Sorry, the number was " + correctNumber + ".";
        }
    }
}
