/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.MenuControl;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.Scene1TriviaException;
import citdavidjordan.exceptions.Scene2NumberException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Deann_2
 */
public class Scene1TriviaView {
    public static Scene1TriviaView startTriviaView;
    
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
    public void start() {
        
        //BEGIN
        //Display the challenge screen
        this.displayTriviaChallenge();
        
        String playerResponse = "";
        do {
        try {
            //Have Them select accept or decline
            this.getPlayerResponse(); 
        } catch (Scene1TriviaException | Scene2NumberException | MarbleControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
            continue;
        }
        } while (!"D".equals(playerResponse));
        
    }

    private void displayTriviaChallenge() {
        this.console.println("\n\n\n************************************************************");
        
        this.console.println(      "*                                                          *"
                             + "\n* Jerry is considered the school ground nerd, and he is.    *"
                             + "\n* His number one goal is to see how smart the kids are.    *"
                             + "\n* He has a trivia question that 60% of people get wrong,   *"
                             + "\n* and he wants to see what you do today.                   *");
        
        this.console.println(      "*                                                          *"
                             + "\n* Are you ready for...                                     *");
        
        this.console.println(      "*                                                          *"
                             + "\n* THE TRIVIA GAME                                          *"
                             + "\n*                                                          *"
                             + "\n************************************************************");
    }

    private String getPlayerResponse() throws Scene1TriviaException, Scene2NumberException, MarbleControlException {
        boolean valid = false; //indicates if name has been received
        String playerResponse = null;
        
        while(!valid) { try {
            //while a valid response has not been received, this will display
            
            //prompt for player's response
            this.console.println("Enter below either 'A' to Accept the challenge or 'D' to decline.");
            
            //get response from keyboard and trim off blanks
            playerResponse = this.keyboard.readLine();
            playerResponse = playerResponse.trim();
            playerResponse = playerResponse.toUpperCase();
            
            //if response invalid
            //if (!'A'.equals(playerResponse) & !'D'.equals(playerResponse)) {
            if (!"A".equals(playerResponse) & !"D".equals(playerResponse)) {
                throw new Scene1TriviaException("Invalid response, you must enter 'A' to Accept or 'D' to Decline.");
                
            }
            if(playerResponse.equals("D")) {
                this.quitMessage();
            }
            else {
                this.triviaQuestion();
            }
            
            break;
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
            }
        }
        
        return playerResponse;
    }

    private void triviaQuestion() throws Scene2NumberException, MarbleControlException {
        try {
            String playerAnswer = null;
            boolean valid = false;
            
            /* Instructor:
            * What happens when the player answers the question correct? Should'nt
            * you be calling a control function to update the score or keep track
            * of their progress or something. I believe you need to create a Conrol
            * Layer function in one of your Control Layer classes that will perfor
            * the correct action based on their answer.
            */
            
            this.console.println("\n ************************************************************** *");
            
            this.console.println("\n* Located in the western hemisphere, one of the world's largest *"
                    + "\n* Bays is named for a British explorer who visited around 1610. *"
                    + "\n* What is it?"
                    + "\n*****************************************************************"
                    + "\n* Answer #1 - Delaware Bay, Delaware                            *"
                    + "\n* Answer #2 - Henry Hudson Bay, Canada                          *"
                    + "\n* Answer #3 - Emerald Bay, California                           *"
                    + "\n* Answer #4 - Coos Bay, Oregon                                  *");
            
            this.console.println("\n* Enter your answer below using the numbers 1, 2, 3, or 4. ");
            
            playerAnswer = this.keyboard.readLine();
            playerAnswer = playerAnswer.trim();
            // int answer = Integer.parseInt(playerAnswer);

            
            if (playerAnswer.equals("2")) {
                try {
                    this.console.println("That is the correct answer");
                    
                    this.console.println("\nPress <Enter> to continue:");
                    
                    this.keyboard.readLine();
                    
                    return;
                    
                    // TO DO - Function to give them marbles.
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
                }
            }
        
            else {
                try {
                    this.console.println("That is the incorrect answer");
                    
                    this.console.println("\nPress <Enter> to continue:");
                    
                    
                    this.keyboard.readLine();
                    
                    return;
                    
                } catch (IOException e) {
                    ErrorView.display(this.getClass().getName(), "Error Reading Input: " + e.getMessage());
                }
                
                
            }
        } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
        }
        }

    private void quitMessage() throws Scene2NumberException, MarbleControlException {
        try {
            this.console.println(    "\n                                                 "
                    + "\nJerry: \"You must be one of those guys who is not"
                    + "\n\t to smart!\""
                    + "\n\t\"If you ever change your mind, then swing by. ");
            this.console.println("\nPress <Enter> to continue:");
            
            
            this.keyboard.readLine();
            
            return;
            
        } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
        }
    }

}
    

