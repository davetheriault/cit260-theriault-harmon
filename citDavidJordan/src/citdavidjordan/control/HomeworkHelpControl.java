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
public class HomeworkHelpControl {
    
    public String homeworkHelp(double guess) {
        if(guess < 0) {
            return "That guess is too low.";
        }
        
        if(guess > 5) {
            return "That guess is too high.";
        }

        double total = 1.1;
        double bat;
        double ball = (total - 1) / 2;    
        
        if(guess == ball) {
            return "That is the correct answer!";
        }

        else {
            return "Sorry, that is the incorrect answer.";
        }
    }
    
}