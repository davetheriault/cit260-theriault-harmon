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
public class RPSGameControlTest {
    
    public RPSGameControlTest() {
    }

    /**
     * Test of rpsGame method, of class RPSGameControl.
     */
    @Test
    public void testRpsGame() {
        System.out.println("rpsGame");
        
        //test case 1
        
        System.out.println("\tTest Case 1");
        int choice = 1;
        RPSGameControl instance = new RPSGameControl();
        String expResult1 = "Paper covers rock. You lose.";
        String expResult2 = "Rock smashes scissors. You win!";
        String expResult3 = "It'\''s a tie! Play again.";
        String result = instance.rpsGame(choice);
        assertTrue(expResult1.equals(result) || expResult2.equals(result)
                    || expResult3.equals(result));
        
        //test case 2
        
        System.out.println("\tTest Case 2");
        choice = 2;
        expResult1 = "Paper covers rock. You win!";
        expResult2 = "Scissors cut paper. You lose.";
        expResult3 = "It'\''s a tie! Play again.";
        result = instance.rpsGame(choice);
        assertTrue(expResult1.equals(result) || expResult2.equals(result)
                    || expResult3.equals(result));
        
        //test case 3
        
        System.out.println("\tTest Case 3");
        choice = 3;
        expResult1 = "Rock smashes scissors. You lose.";
        expResult2 = "Scissors cut paper. You win!";
        expResult3 = "It'\''s a tie! Play again.";
        result = instance.rpsGame(choice);
        assertTrue(expResult1.equals(result) || expResult2.equals(result)
                    || expResult3.equals(result));
        
        //test case 4
        
        System.out.println("\tTest Case 4");
        choice = 0;
        expResult1 = "Invalid Selection";
        result = instance.rpsGame(choice);
        assertEquals(expResult1, result);
        
        //test case 5
        
        System.out.println("\tTest Case 5");
        choice = 4;
        expResult1 = "Invalid Selection";
        result = instance.rpsGame(choice);
        assertEquals(expResult1, result);
        
    }
    
}
