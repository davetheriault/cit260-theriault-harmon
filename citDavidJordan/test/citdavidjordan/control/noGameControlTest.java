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
public class noGameControlTest {
    
    public noGameControlTest() {
    }

    /**
     * Test of numberGame method, of class noGameControl.
     */
    @Test
    public void testNumberGame() {
        System.out.println("numberGame");
        
        
        System.out.println("\t test case 1");
        int guess = 5;
        long currentTimeInSeconds = 10000;
        noGameControl instance = new noGameControl();
        String expResult = "Sorry, the number was 8.";
        String result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        System.out.println("\t test case 2");
        guess = 9;
        currentTimeInSeconds = 54263;
        expResult = "You Win!";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        System.out.println("\t test case 3");
        guess = 0;
        currentTimeInSeconds = 10453;
        expResult = "Number guessed is too low";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        System.out.println("\t test case 4");
        guess = 11;
        currentTimeInSeconds = 60222;
        expResult = "The number guessed is too high";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        System.out.println("\t test case 5");
        guess = 1;
        currentTimeInSeconds = 20034;
        expResult = "Sorry, the number was 6.";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        System.out.println("\t test case 6");
        guess = 10;
        currentTimeInSeconds = 46593;
        expResult = "Sorry, the number was 6.";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        System.out.println("\t test case 7");
        guess = 2;
        currentTimeInSeconds = 1;
        expResult = "Sorry, the number was 5.";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        System.out.println("\t test case 8");
        guess = 8;
        currentTimeInSeconds = 86400;
        expResult = "You Win!";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
}
