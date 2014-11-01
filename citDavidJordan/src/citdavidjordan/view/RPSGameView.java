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
        
        Class<ProgramControl> player;
        player = ProgramControl.class;
        
        //Display the banner screen
        this.displayIntro(player);
        
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

    private void displayIntro(Player player) {
        
        System.out.println("\n\n\n************************************************************");
        
        System.out.println(    "\n You approach the monkey bars to find Rocky. Everyone     "
                             + "\n at Oak Elementary knows about Rocky and his obsession    "
                             + "\n with the game 'Rock Paper Scissors'. He spends his lunch "
                             + "\n hours challenging other kids to play against him for     "
                             + "\n marbles.                                                 "
                             + "\n                                                          "
                             + "\n Rocky: \"Hey there " + player.getName() + "."
                             + "\n\t I heard that you are looking to score some easy marbles."
                             + "\n\t You wanna try me in a game of 'Rock Paper Scissors'?"
                             + "\n\t Loser gives the winner 5 marbles."
                             + "\n (Y/N)? ");
        
    }

    private String RPSgetYorN() {
        
        boolean valid = false; //indicates if name has been received
        String playerName = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            System.out.println("Enter the player's name below:");
            
            //get name from keyboard and trim off blanks
            playerName = keyboard.nextLine();
            playerName = playerName.trim();
            
            //if name invalid
            if (playerName.length() < 1) {
                System.out.println("Invalid name - the name must not be blank.");
                continue;
            }
            
            break;
        }
        
        return playerName;
    }

    private void displayWelcomeMessage(Player player) {
        System.out.println("\n\n===============================================");
        System.out.println("\tWelcome " + player.getName() + "!");
        System.out.println("\tEverything is awesome "
                         + "\n\tin Playground Hustle™!");
        System.out.println("===============================================");


        

    }

    private void displayIntro(Class<ProgramControl> player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
