/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.view;

import java.util.Scanner;

/**
 *
 * @author Deann_2
 */
public class NumberGameView {
    
    public static NumberGameView NumberGameView;
    public void numberGame() {
        // display game description
        this.displayDescription();
    }

    private void displayDescription() {
        boolean valid = false; //indicates if name has been received
        String YorN2 = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream

        System.out.println("\n\n\n************************************************************");
        
        System.out.println(      "*                                                          *"
                             + "\n* Sally's favorite game is see if you can pick             *"
                             + "\n* the number she is thinking about. She gives              *"
                             + "\n* you the option to pick between 1-10.                     *"
                             + "\n* Do you want to play?                                     *");
        
        while(!valid) { //while a valid name has not been received
            
            System.out.println("(Y/N)?");
        
            YorN2 = keyboard.nextLine();
            YorN2 = YorN2.trim();
            YorN2 = YorN2.toUpperCase();
            
            //if name invalid
            //if name invalid
            if (YorN2.length() < 1) {
                System.out.println("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                continue;
            } if (!"Y".equals(YorN2) & !"N".equals(YorN2)
                & !"YES".equals(YorN2) & !"NO".equals(YorN2)) {
                System.out.println("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
            } if ("Y".equals(YorN2)) {
                this.askQuestion();
            }
            
            else {
                this.quitMessage();
            }
        }
    }

    private void quitMessage() {
        System.out.println(    "\n                                                 "
                             + "\nSally: \"I did not think you could handle it.    "
                             + "\n Go back to where you came from.                 ");
        System.out.println("\nPress <Enter> to continue:");
        
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        
        MapView mapView = new MapView();
        mapView.display();
    }

    @SuppressWarnings("UnusedAssignment")
    private void askQuestion() {
        String playerAnswer = null;
        boolean valid = false;
        Scanner keyboard = new Scanner(System.in);
        int currentTimeInSeconds = 0;
        
        System.out.println("\n\n\n************************************************************");
        
        System.out.println(    "*                                                             *" 
                             + "\n* Pick a number between 1 - 10, and you only have three     *" 
                             + "\n* chances to get it right. May the odds ever be in your     *"
                             + "\n* favor.                                                    *");
        
        System.out.println("\n* Enter number below.");
        
        playerAnswer = keyboard.nextLine();
        playerAnswer = playerAnswer.trim();
        
        int guess = Integer.parseInt(playerAnswer);
        
        /* Steps for game
        run for loop for three chances
        guess parameters
        if guess != correctNo then display no and enter to try again.*/
        
        for(int i = 0; i < 3; i++) {
            if ( guess < 1 ) {
                System.out.println("The number guessed is too low.");
            }
            
            if ( guess > 10 ) {
                System.out.println("The number guessed is too high.");
            }
		
            long seedNo = currentTimeInSeconds * 654321 + 12345;
            long randomNo = (seedNo / 789) % 10;

            int correctNo = (int) (randomNo + 1);

            if ( guess == correctNo ) {
		System.out.println("\n You Win!"); 
                System.out.println("\nPress <Enter> to continue:");
        
                keyboard = new Scanner(System.in);
                keyboard.nextLine();
                
                MapView mapView = new MapView();
                mapView.display();
            }
	
            else {
                System.out.println("That is the incorrect answer");
            
                System.out.println("\nPress <Enter> to continue:");
        
                keyboard = new Scanner(System.in);
                keyboard.nextLine();
                
                this.askQuestion();
            }
            
        }
        
        System.out.println("That is the incorrect answer");
            
        System.out.println("\nPress <Enter> to continue:");
        
        keyboard = new Scanner(System.in);
        keyboard.nextLine();
        
        MapView mapView = new MapView();
        mapView.display();
    
    }
}
