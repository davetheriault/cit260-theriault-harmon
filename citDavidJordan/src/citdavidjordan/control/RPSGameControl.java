/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import java.util.Random;

/**
 *
 * @author THERIAULT
 */
public class RPSGameControl {
    
    public String rpsGame(int choice) { 
        //choice is 1 = Rock, 2 = Paper, 3 = Scissors 
        
        if ( choice < 1 ) {
            return "Invalid Selection";
        }

	if ( choice > 3 ) {
            return "Invalid Selection";
        }

	Random rand = new Random(); 
 	int versus = rand.nextInt(3) + 1;

	if ( choice == versus ) {
            return "It'\''s a tie! Play again.";
        }
	
        if ( (choice == 1) && (versus == 2) ) { 
            return "Paper covers rock. You lose.";
        }

	if ( (choice == 1) && (versus == 3) ) {
            return "Rock smashes scissors. You win!";
        }

	if ( (choice == 2) && (versus == 1) ) { 
            return "Paper covers rock. You win!";
        }

	if ( (choice == 2) && (versus == 3) ) { 
            return "Scissors cut paper. You lose.";
        }

	if ( (choice == 3) && (versus == 1) ) { 
            return "Rock smashes scissors. You lose.";
        }

	if ( (choice == 3) & (versus == 2) ) { 
            return "Scissors cut paper. You win!";
        }
        
        return null;
        
    }
    
}
