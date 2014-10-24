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
     * Test of homeworkHelp method, of class HomeworkHelpControl.
     */
    @Test
    public void testHomeworkHelp() {
        System.out.println("homeworkHelp");
        
        // Test Case 1
        
        System.out.println("\tTest Case #1");
        double guess = 0.05;
        HomeworkHelpControl instance = new HomeworkHelpControl();
        String expResult = "That is the correct answer!";
        String result = instance.homeworkHelp(guess);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
