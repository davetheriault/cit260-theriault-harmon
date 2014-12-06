/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.MarbleControl;
import citdavidjordan.control.Scene4RPSControl;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.Scene4RPSException;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Item;
import citdavidjordan.model.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author THERIAULT
 */
public class Scene4RPSView {
    
    public static Scene4RPSView rpsGameView;
    
    Player player = CitDavidJordan.getCurrentGame().getPlayer();
    
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
    public void start() throws MarbleControlException{
               
        //Display the banner screen
        this.displayIntro();
        
        while(true){
            try {
                    //Get the players answer
                this.RPSgetYorN();
            
                } catch (Scene4RPSException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
                continue;
            }
        }
        
    }

    private void displayIntro() {
        
        this.console.println(  "\n************************************************************");
        
        this.console.println(  "\n You approach the dodgeball court to find Rocky. Everyone "
                             + "\n at Oak Elementary knows about Rocky and his obsession    "
                             + "\n with the game 'Rock Paper Scissors'. He spends his lunch "
                             + "\n hours challenging other kids to play against him for     "
                             + "\n marbles.                                                 "
                             + "\n                                                          "
                             + "\n Rocky: \"Hey there " + player.getName() + "."//todo get player name <-
                             + "\n\t I heard that you are looking to score some easy marbles."
                             + "\n\t You wanna try me in a game of 'Rock Paper Scissors'?"
                             + "\n\t Loser gives the winner 5 marbles.\"");
        
    }

    private String RPSgetYorN() throws Scene4RPSException, MarbleControlException {
        
        boolean valid = false; //indicates if name has been received
        String YorN = null;
        
        while(!valid) { try {
            //while a valid name has not been retrieved
            
            //prompt for player's name
            this.console.println("(Y/N)?");
            
            //get name from keyboard and trim off blanks
            YorN = this.keyboard.readLine();
            YorN = YorN.trim();
            YorN = YorN.toUpperCase();
            
            InventoryItem[] marbles = CitDavidJordan.getCurrentGame().getInventory();
            if (marbles[Item.swirly.ordinal()].getAmount() < 5) {
                this.console.println("Rocky: \"Oh, wait. Only " + marbles[Item.swirly.ordinal()].getAmount() + " Swirlys? \n"
                        + "It looks like you don't have enough marbles little-miss-" + player.getName() + ".\n"
                        + "Come back when you have enough");
            }
            //if name invalid
            if (YorN.length() < 1) {
                throw new Scene4RPSException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                
            } if (!"Y".equals(YorN) & !"N".equals(YorN)
                    & !"YES".equals(YorN) & !"NO".equals(YorN)) {
                throw new Scene4RPSException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                
            } if ("N".equals(YorN) | "NO".equals(YorN)) {
                this.displayQuitMessage();
            } else {
                this.displayRPSGame();
            }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            }
        }
        
        return YorN;
    }

    private void displayQuitMessage() throws MarbleControlException {
        try {
            this.console.println(    "\n                                                 "
                    + "\nRocky: \"Oh. I see how it is. Too chicken to take"
                    + "\n\t take a risk, eh?\""
                    + "\n\t\"Well, come back when you're not so chicken.\"");
            this.console.println("\nPress <Enter> to continue:");
            
            this.keyboard.readLine();
            
            while (true) {
                return;
            }
        } catch (IOException ex) {
                            ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
        }
    }

    private void displayRPSGame() throws Scene4RPSException, MarbleControlException {
        this.console.println(    "\n                                                 "
                             + "\nRocky: \"Alright then. Let's do this.\""
                             + "\n\t\"So, do you know how to play?\"");
        
        boolean valid = false; //indicates if name has been received
        String YorN2 = null;
        
        while(!valid) { try {
            //while a valid name has not been retrieved
            
            //prompt for player's name
            this.console.println("(Y/N)?");
            
            //get name from keyboard and trim off blanks
            YorN2 = this.keyboard.readLine();
            YorN2 = YorN2.trim();
            YorN2 = YorN2.toUpperCase();
            
            //if name invalid
            if (YorN2.length() < 1) {
                throw new Scene4RPSException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                
            } if (!"Y".equals(YorN2) & !"N".equals(YorN2)
                    & !"YES".equals(YorN2) & !"NO".equals(YorN2)) {
                throw new Scene4RPSException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                
            } if ("N".equals(YorN2) | "NO".equals(YorN2)) {
                this.displayRPSRules();
            } else {
                this.displayRPSGame2();
            }
            } catch (IOException ex) {
                  ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
            }
        }
    }

    private void displayRPSRules() throws MarbleControlException {
        try {
            this.console.println("\n                                                 "
                    + "\nRocky: \"You don't know how to play 'Rock Paper Scissors'?\""
                    + "\n\t\"And I thought you were supposed to be one of the smart kids.\""
                    + "\n"
                    + "\n\t\"It's simple. We each choose either 'rock', 'paper', or 'scissors'.\""
                    + "\n\t\"If we both pick the same thing it's a tie. Otherwise,\""
                    + "\n\t\"Rock Smashes Scissors\""
                    + "\n\t\"Scissors Cut Paper\""
                    + "\n\t\"& Paper Covers Rock.\"");
            
            this.console.println("\nPress <Enter> to continue:");
            
            this.keyboard.readLine();
            
            while (true){
                try {
                    this.displayRPSGame2();
                } catch (Scene4RPSException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    continue;
                }
            }
        } catch (IOException ex) {
               ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
        }
    }

    private void displayRPSGame2() throws Scene4RPSException, MarbleControlException {
        this.console.println("   \n*****************************************"
                            + "\n         ROCK - PAPER - SCISSORS!        "
                            + "\n*****************************************"
                            + "\n"
                            + "\n\tSelect One:"
                            + "\n"
                            + "\n\tR - Rock"
                            + "\n\tP - Paper"
                            + "\n\tS - Scissors");
        
        boolean valid = false; //indicates if name has been received
        String rpsInput = null;
        int choice = 0;
        String rpsResult = null;
        
         /* Instructor: 
         * What happens when the player wins or loses the gam? Should'nt
         * you be calling a control function to update the score or keep track
         * of their progress or something. I believe you need to create and call 
         * a Conrol Layer function in one of your Control Layer classes that 
         * will perform the correct action based on their answer.
         */
        
        while(!valid) { 
            try {
            //while a valid name has not been retrieved
            
            //prompt for player's name
            this.console.println("\n(R/P/S)?");
            
            //get name from keyboard and trim off blanks
            rpsInput = this.keyboard.readLine();
            rpsInput = rpsInput.trim();
            rpsInput = rpsInput.toUpperCase();
            
            //if name invalid
            if (rpsInput.length() < 1) {
                throw new Scene4RPSException("Invalid Selection.");
                
            } if (!"R".equals(rpsInput) & !"ROCK".equals(rpsInput)
                    & !"P".equals(rpsInput) & !"PAPER".equals(rpsInput)
                    & !"S".equals(rpsInput) & !"SCISSORS".equals(rpsInput)) {
                this.console.println("Invalid Selection - Please enter 'R', 'P' or 'S'.");
                continue;
            } if ("R".equals(rpsInput) | "ROCK".equals(rpsInput)) {
                choice = 1;
                Scene4RPSControl rpsGame = new Scene4RPSControl();
                rpsResult = rpsGame.rpsGame(choice);
            } if ("P".equals(rpsInput) | "PAPER".equals(rpsInput)) {
                choice = 2;
                Scene4RPSControl rpsGame = new Scene4RPSControl();
                rpsResult = rpsGame.rpsGame(choice);
            } if ("S".equals(rpsInput) | "SCISSORS".equals(rpsInput)) {
                choice = 3;
                Scene4RPSControl rpsGame = new Scene4RPSControl();
                rpsResult = rpsGame.rpsGame(choice);
            }
            
            this.console.println(rpsResult);
            
            if (rpsResult.toLowerCase().contains("win")) {
                this.console.println("\nRocky: \"Dang! Alright, here's your marbles.\"");
                MarbleControl.adjustMarbles(5, "swirly");//todo insert function to add marbles to player
            }
            if (rpsResult.toLowerCase().contains("lose")) {
                this.console.println("\nRocky: \"Ha! Alright " + player.getName() + ", pay up.\"");//todo get playerName
                MarbleControl.adjustMarbles(-5, "swirly");//todo insert function to subtract marbles to player
            }
            if (rpsResult.toLowerCase().contains("tie")) {
                this.console.println("\nRocky: \"Again!\"");
                continue;
            }
            this.console.println("\n\t\"Wanna play again?\"");
            this.displayRPSGame3();
            } 
            catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
            }
        }
        
        
    }

    private void displayRPSGame3() throws Scene4RPSException, MarbleControlException {
        
        boolean valid = false; //indicates if name has been received
        String YorN = null;
        
        while(!valid) { try {
            //while a valid name has not been retrieved
            
            //prompt for player's name
            this.console.println("(Y/N)?");
            
            //get name from keyboard and trim off blanks
            YorN = this.keyboard.readLine();
            YorN = YorN.trim();
            YorN = YorN.toUpperCase();
            
            //if name invalid
            if (YorN.length() < 1) {
                throw new Scene4RPSException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                
            } if (!"Y".equals(YorN) & !"N".equals(YorN)
                    & !"YES".equals(YorN) & !"NO".equals(YorN)) {
                throw new Scene4RPSException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                
            } if ("N".equals(YorN) | "NO".equals(YorN)) {
                this.displayQuitMessage2();
            } else {
                this.displayRPSGame2();
            }
            } catch (IOException ex) {
                 ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
            }
        }
    }
    
    private void displayQuitMessage2() throws MarbleControlException {
        try {
            this.console.println(    "\n                                                 "
                    + "\nRocky: \"Alright. If you want a rematch, you know where to find me.\"");
            this.console.println("\nPress <Enter> to continue:");
            
            this.keyboard.readLine();
            
            while (true){
                return;
            }
        } catch (IOException ex) {
             ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
        }
    }

    
}
