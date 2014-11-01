/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.control.ProgramControl;
import citdavidjordan.model.Player;
import java.util.Scanner;

/**
 *
 * @author THERIAULT
 */
public class RPSGameView {
    
    public static RPSGameView rpsGameView;
    
    public void startRPSGame(){
               
        //Display the banner screen
        this.displayIntro();
        
        //Get the players answer
        String YorN = this.RPSgetYorN();
                
        //Create a new player
        //Player player = ProgramControl.createPlayer(playerName);
        
        //DISPLAY a customized welcome message
        //this.displayWelcomeMessage(player);
        
        //DISPLAY the main menu
        //MainMenuView mainMenu = new MainMenuView();
        //mainMenu.displayMenu();
        
        //END/
        
        
    }

    private void displayIntro() {
        
        System.out.println("\n\n\n************************************************************");
        
        System.out.println(    "\n You approach the dodgeball court to find Rocky. Everyone "
                             + "\n at Oak Elementary knows about Rocky and his obsession    "
                             + "\n with the game 'Rock Paper Scissors'. He spends his lunch "
                             + "\n hours challenging other kids to play against him for     "
                             + "\n marbles.                                                 "
                             + "\n                                                          "
                             + "\n Rocky: \"Hey there *playerName*."//todo get player name <-
                             + "\n\t I heard that you are looking to score some easy marbles."
                             + "\n\t You wanna try me in a game of 'Rock Paper Scissors'?"
                             + "\n\t Loser gives the winner 5 marbles.\"");
        
    }

    private String RPSgetYorN() {
        
        boolean valid = false; //indicates if name has been received
        String YorN = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            System.out.println("(Y/N)?");
            
            //get name from keyboard and trim off blanks
            YorN = keyboard.nextLine();
            YorN = YorN.trim();
            YorN = YorN.toUpperCase();
            
            //if name invalid
            if (YorN.length() < 1) {
                System.out.println("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                continue;
            } if (!"Y".equals(YorN) & !"N".equals(YorN)
                    & !"YES".equals(YorN) & !"NO".equals(YorN)) {
                System.out.println("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                continue;
            } if ("N".equals(YorN)) {
                this.displayQuitMessage();
            } else {
                this.displayRPSGame();
            }
        }
        
        return YorN;
    }

    private void displayQuitMessage() {
        System.out.println(    "\n                                                 "
                             + "\nRocky: \"Oh. I see how it is. Too chicken to take"
                             + "\n\t take a risk, eh?\""
                             + "\n\t\"Well, come back when you're not so chicken.\"");
        System.out.println("\nPress <Enter> to continue:");
        
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        
        MapView mapView = new MapView();
        mapView.displayMenu();

    }

    private void displayRPSGame() {
        System.out.println("*** displayRPSGame function called***");
        
        System.out.println(    "\n                                                 "
                             + "\nRocky: \"Alright then. Let's do this.\""
                             + "\n\t\"So, do you know how to play?\"");
        
        boolean valid = false; //indicates if name has been received
        String YorN2 = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            System.out.println("(Y/N)?");
            
            //get name from keyboard and trim off blanks
            YorN2 = keyboard.nextLine();
            YorN2 = YorN2.trim();
            YorN2 = YorN2.toUpperCase();
            
            //if name invalid
            if (YorN2.length() < 1) {
                System.out.println("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                continue;
            } if (!"Y".equals(YorN2) & !"N".equals(YorN2)
                    & !"YES".equals(YorN2) & !"NO".equals(YorN2)) {
                System.out.println("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                continue;
            } if ("N".equals(YorN2)) {
                this.displayRPSRules();
            } else {
                this.displayRPSGame2();
            }
        }
    }

    private void displayRPSRules() {
        
    }

    private void displayRPSGame2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
