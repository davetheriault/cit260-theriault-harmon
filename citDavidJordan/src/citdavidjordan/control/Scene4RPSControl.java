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
public class Scene4RPSControl {
    
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
            return "Rocky chose the same thing. \nIt's a tie! Play again.";
        }
	
        if ( (choice == 1) && (versus == 2) ) { 
            return "Rocky chose Paper. \nPaper covers rock. You lose.";
        }

	if ( (choice == 1) && (versus == 3) ) {
            return "Rocky chose scissors. \nRock smashes scissors. You win!";
        }

	if ( (choice == 2) && (versus == 1) ) { 
            return "Rocky chose Rock. \nPaper covers rock. You win!";
        }

	if ( (choice == 2) && (versus == 3) ) { 
            return "Rocky chose Scissors. \nScissors cut paper. You lose.";
        }

	if ( (choice == 3) && (versus == 1) ) { 
            return "Rocky chose Rock. \nRock smashes scissors. You lose.";
        }

	if ( (choice == 3) & (versus == 2) ) { 
            return "Rocky chose Paper. \nScissors cut paper. You win!";
        }
        
        return null;
        
    }
    
}
