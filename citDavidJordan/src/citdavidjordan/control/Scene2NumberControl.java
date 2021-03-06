/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.exceptions.Scene2NumberException;



/**
 *
 * @author THERIAULT
 */
public class Scene2NumberControl {
    
    public String numberGame(int guess, long currentTimeInSeconds) throws Scene2NumberException {
        
        
        if ( guess < 1 ) {
            throw new Scene2NumberException("The number guessed is too low.");
        }
            
	if ( guess > 10 ) {
            throw new Scene2NumberException("The number guessed is too high.");
        }
		
	long seedNo = currentTimeInSeconds * 654321 + 12345;
	long randomNo = (seedNo / 789) % 10;

	int correctNo = (int) (randomNo + 1);

	if ( guess == correctNo ) {
		return "You Win!" ;
        }
	
        else {
		return "Sorry. The number was " + correctNo + "." ;
        }
        
       

    }
    
}
