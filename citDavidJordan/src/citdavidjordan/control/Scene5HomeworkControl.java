/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.control;

import citdavidjordan.exceptions.Scene5HomeworkException;

/**
 *
 * @author Deann_2
 */
public class Scene5HomeworkControl {
    
    public String homeworkHelp(double guess) throws Scene5HomeworkException {
        if(guess < 0) {
            throw new Scene5HomeworkException("That guess is too low.");
        }
        
        if(guess > 5) {
            throw new Scene5HomeworkException("That guess is too high.");
        }

        double total = 1.10;
        double bat;
        double ball = (total - 1) / 2;
        double ballRounded = Math.round(ball * 100)/100.0;
                
        if (guess == ballRounded) {
            return "That is the correct answer!";
        }

        else {
            return "Sorry, that is the incorrect answer.";
        }
    }
    
}
