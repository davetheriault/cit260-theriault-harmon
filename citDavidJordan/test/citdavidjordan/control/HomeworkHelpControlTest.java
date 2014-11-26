/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Deann_2
 */
public class HomeworkHelpControlTest {
    
    public HomeworkHelpControlTest() {
    }

    /**
     * Test of homeworkHelp method, of class Scene5HomeworkControl.
     */
    @Test
    public void testHomeworkHelp() {
        System.out.println("homeworkHelp");
        
        // Test Case 1
        
        System.out.println("\tTest Case #1");
        double guess = 0.05;
        Scene5HomeworkControl instance = new Scene5HomeworkControl();
        String expResult = "That is the correct answer!";
        String result = instance.homeworkHelp(guess);
        assertEquals(expResult, result);
        
        // Test Case 2
        
        System.out.println("\tTest Case #2");
        guess = 0.01;
        expResult = "Sorry, that is the incorrect answer.";
        result = instance.homeworkHelp(guess);
        assertEquals(expResult, result);
        
        // Test Case 3
        
        System.out.println("\tTest Case #3");
        guess = -1;
        expResult = "That guess is too low.";
        result = instance.homeworkHelp(guess);
        assertEquals(expResult, result);
        
        // Test Case 4
        
        System.out.println("\tTest Case #4");
        guess = 6;
        expResult = "That guess is too high.";
        result = instance.homeworkHelp(guess);
        assertEquals(expResult, result);
        
        // Test Case 5
        
        System.out.println("\tTest Case #5");
        guess = 0;
        expResult = "Sorry, that is the incorrect answer.";
        result = instance.homeworkHelp(guess);
        assertEquals(expResult, result);
        
        // Test Case 6
        
        System.out.println("\tTest Case #6");
        guess = 5;
        expResult = "Sorry, that is the incorrect answer.";
        result = instance.homeworkHelp(guess);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
