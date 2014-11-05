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
public class StartTriviaView {
    public static StartTriviaView startTriviaView;
    
    public void startTrivia() {
        
        //BEGIN
        //Display the challenge screen
        this.displayTriviaChallenge();
        
        //Have Them select accept or decline
        this.getPlayerResponse();
        
        // If correct answer
        // is selected, display "That is correct!". Save additional marbles and return to main menu
        
        // If any other answer
        // is selected, display "That is incorrect, and return to main menu. 
        
    }

    private void displayTriviaChallenge() {
        System.out.println("\n\n\n************************************************************");
        
        System.out.println(      "*                                                          *"
                             + "\n* Jerry is considered the school ground nerd, and he is.    *"
                             + "\n* His number one goal is to see how smart the kids are.    *"
                             + "\n* He has a trivia question that 60% of people get wrong,   *"
                             + "\n* and he wants to see what you do today.                   *");
        
        System.out.println(      "*                                                          *"
                             + "\n* Are you ready for...                                     *");
        
        System.out.println(      "*                                                          *"
                             + "\n* THE TRIVIA GAME                                          *"
                             + "\n*                                                          *"
                             + "\n************************************************************");
    }

    private String getPlayerResponse() {
        boolean valid = false; //indicates if name has been received
        String playerResponse = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid response has not been received, this will display
            
            //prompt for player's response
            System.out.println("Enter below either 'A' to Accept the challenge or 'D' to decline.");
            
            //get response from keyboard and trim off blanks
            playerResponse = keyboard.nextLine();
            playerResponse = playerResponse.trim();
            playerResponse = playerResponse.toUpperCase();
            
            //if response invalid
            //if (!'A'.equals(playerResponse) & !'D'.equals(playerResponse)) {
            if (!"A".equals(playerResponse) & !"D".equals(playerResponse)) {
                System.out.println("Invalid response, you must enter 'A' to Accept or 'D' to Decline.");
                continue;
            }
            if(playerResponse.equals("D")) {
                this.quitMessage();
            }
            else {
                this.triviaQuestion();
            }
            
            break;
        }
        
        return playerResponse;
    }

    private void triviaQuestion() {
        String playerAnswer = null;
        boolean valid = false;
        Scanner keyboard = new Scanner(System.in);
                   
        System.out.println("\n ************************************************************** *");
        
        System.out.println("\n* Located in the western hemisphere, one of the world's largest *"
                         + "\n* Bays is named for a British explorer who visited around 1610. *"
                         + "\n* What is it?"
                         + "\n*****************************************************************"
                         + "\n* Answer #1 - Delaware Bay, Delaware                            *"
                         + "\n* Answer #2 - Henry Hudson Bay, Canada                          *"
                         + "\n* Answer #3 - Emerald Bay, California                           *"
                         + "\n* Answer #4 - Coos Bay, Oregon                                  *");
        
        System.out.println("\n* Enter your answer below using the numbers 1, 2, 3, or 4. ");
        
        playerAnswer = keyboard.nextLine();
        playerAnswer = playerAnswer.trim();
        int answer = Integer.parseInt(playerAnswer);
        
        
            if (answer == 2) {
                System.out.println("That is the correct answer");
                
                System.out.println("\nPress <Enter> to continue:");
        
                keyboard = new Scanner(System.in);
                keyboard.nextLine();
        
                MapView mapView = new MapView();
                mapView.displayMenu();
                
                // TO DO - Function to give them marbles.
            }
        
            else {
                System.out.println("That is the incorrect answer");
                
                System.out.println("\nPress <Enter> to continue:");
        
                keyboard = new Scanner(System.in);
                keyboard.nextLine();
        
                MapView mapView = new MapView();
                mapView.displayMenu();
            
            }
        }

    private void quitMessage() {
        System.out.println(    "\n                                                 "
                             + "\nJerry: \"You must be one of those guys who is not"
                             + "\n\t to smart!\""
                             + "\n\t\"If you ever change your mind, then swing by. ");
        System.out.println("\nPress <Enter> to continue:");
        
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        
        MapView mapView = new MapView();
        mapView.displayMenu();
    }
    }
    

