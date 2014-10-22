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
 * @author THERIAULT
 */
public class NumberGameControlTest {
    
    public NumberGameControlTest() {
    }

    /**
     * Test of numberGame method, of class NumberGameControl.
     */
    @Test
    public void testNumberGame() {
        
        System.out.println("numberGame");
        
        /********************
         *** Test Case #1 ***
         *******************/
        
        System.out.println("\tTest case #1");
        int guess = 5;
        long currentTimeInSeconds = 10000;
        NumberGameControl instance = new NumberGameControl();
        String expResult = "Sorry. The number was 8.";
        String result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        
        /********************
         *** Test Case #2 ***
         *******************/
        
        System.out.println("\tTest case #2");
        guess = 9;
        currentTimeInSeconds = 54263;
        expResult = "You Win!";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        /********************
         *** Test Case #3 ***
         *******************/
        
        System.out.println("\tTest case #3");
        guess = 0;
        currentTimeInSeconds = 10453;
        expResult = "The number guessed is too low.";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        /********************
         *** Test Case #4 ***
         *******************/
        
        System.out.println("\tTest case #4");
        guess = 11;
        currentTimeInSeconds = 60222;
        expResult = "The number guessed is too high.";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        /********************
         *** Test Case #5 ***
         *******************/
        
        System.out.println("\tTest case #5");
        guess = 1;
        currentTimeInSeconds = 20034;
        expResult = "Sorry. The number was 6.";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        /********************
         *** Test Case #6 ***
         *******************/
        
        System.out.println("\tTest case #6");
        guess = 10;
        currentTimeInSeconds = 46593;
        expResult = "Sorry. The number was 6.";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        /********************
         *** Test Case #7 ***
         *******************/
        
        System.out.println("\tTest case #6");
        guess = 2;
        currentTimeInSeconds = 1;
        expResult = "Sorry. The number was 5.";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
        
        /********************
         *** Test Case #8 ***
         *******************/
        
        System.out.println("\tTest case #8");
        guess = 8;
        currentTimeInSeconds = 86400;
        expResult = "You Win!";
        result = instance.numberGame(guess, currentTimeInSeconds);
        assertEquals(expResult, result);
     
      
    }
    
    
}
