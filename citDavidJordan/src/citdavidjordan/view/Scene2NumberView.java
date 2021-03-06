/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.MarbleControl;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author Deann_2
 */
public class Scene2NumberView {
    
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
    public static Scene2NumberView NumberGameView;
    public void start() throws MarbleControlException {
        // display game description
        String YorN2 = null;
        do {  
            try {
                this.displayDescription();
            } catch (Scene2NumberException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
                continue;
            }
        } while(!"N".equals(YorN2));
    }

    private void displayDescription() throws Scene2NumberException, MarbleControlException {
        boolean valid = false; //indicates if name has been received
        String YorN2 = null;

        this.console.println("\n\n\n************************************************************");
        
        this.console.println(
                             "* Sally's favorite game is see if you can pick             *"
                             + "\n* the number she is thinking about. She gives              *"
                             + "\n* you the option to pick between 1-10.                     *"
                             + "\n* Do you want to play?                                     *");
        
        //set location to visited
        CitDavidJordan.getPlayer().getLocation().setVisited(true);
        
        while(!valid) { 
            try {
            //while a valid name has not been received
            
            this.console.println("(Y/N)?");
        
            YorN2 = this.keyboard.readLine();
            YorN2 = YorN2.trim();
            YorN2 = YorN2.toUpperCase();
            
            //if name invalid
            //if name invalid
            if (YorN2.length() < 1) {
                throw new Scene2NumberException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
            } if (!"Y".equals(YorN2) & !"N".equals(YorN2)
                    & !"YES".equals(YorN2) & !"NO".equals(YorN2)) {
                throw new Scene2NumberException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
            } if ("Y".equals(YorN2)) {
                this.askQuestion();
            }
            
            else {
                this.quitMessage();
            }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
            }
        }
    }

    private void quitMessage() throws Scene2NumberException, MarbleControlException {
        try {
            this.console.println(    "\n                                                 "
                    + "\nSally: \"I did not think you could handle it.    "
                    + "\n Go back to where you came from.                 ");
            this.console.println("\nPress <Enter> to continue:");
            
            this.keyboard.readLine();
            
            MenuGameView gameMenu = new MenuGameView();
            gameMenu.displayMap();
            
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
        }
    }

    @SuppressWarnings("UnusedAssignment")
    private void askQuestion() throws Scene2NumberException, MarbleControlException {
        
        this.console.println("\n\n\n************************************************************");
        
        this.console.println(    "*                                                             *" 
                             + "\n* Pick a number between 1 - 10, and you only have three     *" 
                             + "\n* chances to get it right. May the odds ever be in your     *"
                             + "\n* favor.                                                    *");
        
        Random rand = new Random();
        int correctNo = rand.nextInt(10) + 1;
        
        this.anotherChance(correctNo);
        
    }
        
        private void anotherChance(int correctNo) throws Scene2NumberException, MarbleControlException {
            
        
        try {
            /* Steps for game
            run for loop for three chances
            guess parameters
            if guess != correctNo then display no and enter to try again.*/
            
            for(int i = 2; i > -1; i--) {
                String playerAnswer = null;
                boolean valid = false;
                
                int guess = 0;
                
                while(!valid) {
                    try {
                        this.console.println("\n* Enter number below.");
                        playerAnswer = this.keyboard.readLine();
                        playerAnswer = playerAnswer.trim();
                        
                        
                        if (playerAnswer.length() < 1) {
                            this.console.println("***You must enter a number between 1 and 10.***");
                            continue;
                        }
                        
                        guess = Integer.parseInt(playerAnswer);
                        
                        if ( guess < 1 ) {
                            this.console.println("The number guessed is too low.");
                            continue;
                        }
                        
                        if ( guess > 10 ) {
                            this.console.println("The number guessed is too high.");
                            continue;
                        }
                        else {
                            break;
                        }
                    } catch (IOException ex) {
                        ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
                    }
                    
                }
                
                if ( guess == correctNo ) {
                    try {
                        this.console.println("\n You Win!");
                        this.console.println("\nPress <Enter> to continue:");
                        
                        this.keyboard.readLine();
                        
                    MenuGameView gameMenu = new MenuGameView();
                    gameMenu.displayMap();
                    
                    } catch (IOException ex) {
                        ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
                    }
                } if ( guess == correctNo ) {
                    this.console.println("\nSally: \"Dang! Alrigh, here are your marbles.\" ");
                    MarbleControl.adjustMarbles(5, "swirly"); // Total marbles awarded.
                } if ( guess != correctNo ) {
                    this.console.println("\nSally: \"That is rough, that is one marble for me.\" ");
                    MarbleControl.adjustMarbles(-1, "swirly"); // Total marbles deducted if lose
                }
                
                else {
                    try {
                        this.console.println("That is the incorrect answer, you have " + i + " guesses left.");
                        
                        this.console.println("\nPress <Enter> to continue:");
                        
                        this.keyboard.readLine();
                    } catch (IOException ex) {
                        ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
                    }
                }
            
                
            }
            
            this.console.println("That is the incorrect answer. \nThe correct number was " + correctNo + ".");
            
            this.console.println("\nPress <Enter> to continue:");
            
            this.keyboard.readLine();
            
            MenuGameView gameMenu = new MenuGameView();
            gameMenu.displayMap();
            
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
        }
    
    }
}
