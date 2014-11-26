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
public class TriviaGameControlTest {
    
    public TriviaGameControlTest() {
    }

    /**
     * Test of triviaGame method, of class Scene1TriviaControl.
     */
    @Test
    public void testTriviaGame() {
        System.out.println("triviaGame");
        
        // Test Case #1
        
        System.out.println("\tTest Case #1");
        String guess = "Burley, ID";
        Scene1TriviaControl instance = new Scene1TriviaControl();
        String expResult = "That is not the correct input, make sure you type the answer exactly.";
        String result = instance.triviaGame(guess);
        assertEquals(expResult, result);
        
        // Test Case #2
        
        System.out.println("\tTest Case #2");
        guess = "Delaware Bay, Delaware";
        expResult = "That is the incorrect guess.";
        result = instance.triviaGame(guess);
        assertEquals(expResult, result);
        
        System.out.println("\tTest Case #3");
        guess = "Henry Hudson Bay, Canada";
        expResult = "That is the correct guess!";
        result = instance.triviaGame(guess);
        assertEquals(expResult, result);
        
        System.out.println("\tTest Case #4");
        guess = "Emerald Bay, California";
        expResult = "That is the incorrect guess, but nice try.";
        result = instance.triviaGame(guess);
        assertEquals(expResult, result);
        
        System.out.println("\tTest Case #5");
        guess = "Coos Bay, Oregon";
        expResult = "Close, but no cigar.";
        result = instance.triviaGame(guess);
        assertEquals(expResult, result);
        
    }
    
}
