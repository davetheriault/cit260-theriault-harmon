/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.MarbleControl;
import citdavidjordan.control.MenuControl;
import citdavidjordan.control.Scene4RPSControl;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.exceptions.SceneBrodyEncounterException;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Item;
import citdavidjordan.model.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author THERIAULT
 */
public class SceneBrodyEncounterView {
    
    public static SceneBrodyEncounterView bEncounterView;
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
    Player player = CitDavidJordan.getCurrentGame().getPlayer();
    InventoryItem[] inventory = CitDavidJordan.getCurrentGame().getInventory();

    public void start() throws MarbleControlException, IOException {
        
        //calculate brody's demands
        String request = this.payUp();
        
        //Display the banner screen
        this.displayIntro(1, request);
        
        boolean valid = false;
        while(!valid){
            try {//Get the players answer
                String PorR = this.payOrRun(request);
            } catch (SceneBrodyEncounterException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
                continue;
            }
        }
    }
    
    public String payUp() {
        if (inventory[Item.alley.ordinal()].getAmount() > 0){
            return "alley"; 
        } if (inventory[Item.steely.ordinal()].getAmount() > 0){
            return "steely";
        } if (inventory[Item.swirly.ordinal()].getAmount() > 0){
            return "swirly";
        } else {
        return null;
        }
    }

    private void displayIntro(int number, String request) {
        
        this.console.println("\n\n\n************************************************************");
        
        
        this.console.println(    "\n As you walk over to ...  "
                             + "\n todo insert story text here... "
                            
                             + "\n Brody: \"Hey Little-Miss-" + player.getName() + "-Pants."//todo get player name <-
                             + "\n\t Where do you think you're going?"
                             + "\n\t I never said you could go past me."
                             + "\n\t Tell you what... I'll let you pass for " + number + " " + request + " marble.\"");
        
    }

    private String payOrRun(String r) throws SceneBrodyEncounterException, MarbleControlException, IOException {
        
        boolean valid = false; //indicates if name has been received
        String PorR = null;
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            this.console.println("You may choose to pay Brody and continue to your destination,\n"
                    + "or to make a run for it. What would you like to do? \n"
                    + "P - Pay Up \n"
                    + "R - Run \n");
            
            //get name from keyboard and trim off blanks
            PorR = this.keyboard.readLine();
            PorR = PorR.trim();
            PorR = PorR.toUpperCase();
            
            InventoryItem[] marbles = CitDavidJordan.getCurrentGame().getInventory();
            if (r == null) {
                this.console.println("Rocky: \"Oh, wait. Only " + marbles[Item.swirly.ordinal()].getAmount() + " Swirlys? \n"
                        + "It looks like you don't have enough marbles little-miss-" + player.getName() + ".\n"
                        + "Come back when you have enough");
            }
            //if name invalid
            if (PorR.length() < 1) {
                throw new SceneBrodyEncounterException("Invalid Selection - Please enter 'P' or 'R'.");    
            } 
            if (!"P".equals(PorR) & !"R".equals(PorR)) {
                throw new SceneBrodyEncounterException("Invalid Selection - Please enter 'P' or 'R'.");
            }
            if ("P".equals(PorR) && r == null) {
                throw new SceneBrodyEncounterException("You currently have no marbles. You can't choose this option.");
            } 
            if ("P".equals(PorR)) {
                MarbleControl.adjustMarbles(-1, r);
                this.console.println("You give Brody 1 " + r + " marble. \n\n"
                        + "Brody: \"Thanks chump.\" \n\n"
                        + "Press <Enter> to continue.");
                this.keyboard.readLine();
                //*****************************************************************************************************
                //TODO ENTER CODE TO RETURN TO MAPVIEW DOACTION TO MOVE PLAYER TO THERE PREVIOUSLY SELECTED DESTINATION
                //*****************************************************************************************************
            }
            else {
                //TODO Insert Run Away Function
            }
        }
        
        return PorR;
    }

    private void displayQuitMessage() throws IOException {
        this.console.println(    "\n                                                 "
                             + "\nRocky: \"Oh. I see how it is. Too chicken to take"
                             + "\n\t take a risk, eh?\""
                             + "\n\t\"Well, come back when you're not so chicken.\"");
        this.console.println("\nPress <Enter> to continue:");
        
        this.keyboard.readLine();
        
        return;

    }

    private void displayRPSGame() throws MarbleControlException, IOException {
        this.console.println(    "\n                                                 "
                             + "\nRocky: \"Alright then. Let's do this.\""
                             + "\n\t\"So, do you know how to play?\"");
        
        boolean valid = false; //indicates if name has been received
        String YorN2 = null;
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            this.console.println("(Y/N)?");
            
            //get name from keyboard and trim off blanks
            YorN2 = this.keyboard.readLine();
            YorN2 = YorN2.trim();
            YorN2 = YorN2.toUpperCase();
            
            //if name invalid
            if (YorN2.length() < 1) {
                ErrorView.display(this.getClass().getName(), "Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                continue;
            } if (!"Y".equals(YorN2) & !"N".equals(YorN2)
                    & !"YES".equals(YorN2) & !"NO".equals(YorN2)) {
                ErrorView.display(this.getClass().getName(), "Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                continue;
            } if ("N".equals(YorN2) | "NO".equals(YorN2)) {
                this.displayRPSRules();
            } else {
                this.displayRPSGame2();
            }
        }
    }

    private void displayRPSRules() throws MarbleControlException, IOException {
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
        
        this.displayRPSGame2();
    }

    private void displayRPSGame2() throws MarbleControlException, IOException {
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
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            this.console.println("\n(R/P/S)?");
            
            //get name from keyboard and trim off blanks
            rpsInput = this.keyboard.readLine();
            rpsInput = rpsInput.trim();
            rpsInput = rpsInput.toUpperCase();
            
            //if name invalid
            if (rpsInput.length() < 1) {
                ErrorView.display(this.getClass().getName(), "Invalid Selection.");
                continue;
            } if (!"R".equals(rpsInput) & !"ROCK".equals(rpsInput)
                    & !"P".equals(rpsInput) & !"PAPER".equals(rpsInput)
                    & !"S".equals(rpsInput) & !"SCISSORS".equals(rpsInput)) {
                ErrorView.display(this.getClass().getName(), "Invalid Selection - Please enter 'R', 'P' or 'S'.");
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
                this.console.println("\nRocky: \"Ha! Alright *playerName*, pay up.\"");//todo get playerName
                MarbleControl.adjustMarbles(-5, "swirly");//todo insert function to subtract marbles to player
            }
            if (rpsResult.toLowerCase().contains("tie")) {
                this.console.println("\nRocky: \"Again!\"");
                continue;
            }
            this.console.println("\n\t\"Wanna play again?\"");
            this.displayRPSGame3();
        }
        
        
    }

    private void displayRPSGame3() throws MarbleControlException, IOException {
        
        boolean valid = false; //indicates if name has been received
        String YorN = null;
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            
            this.console.println("(Y/N)?");
            
            //get name from keyboard and trim off blanks
            YorN = this.keyboard.readLine();
            YorN = YorN.trim();
            YorN = YorN.toUpperCase();
            
            //if name invalid
            if (YorN.length() < 1) {
                ErrorView.display(this.getClass().getName(), "Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                continue;
            } if (!"Y".equals(YorN) & !"N".equals(YorN)
                    & !"YES".equals(YorN) & !"NO".equals(YorN)) {
                ErrorView.display(this.getClass().getName(), "Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                continue;
            } if ("N".equals(YorN) | "NO".equals(YorN)) {
                this.displayQuitMessage2();
            } else {
                this.displayRPSGame2();
            }
        }
    }
    
    private void displayQuitMessage2() throws IOException {
        this.console.println(    "\n                                                 "
                             + "\nRocky: \"Alright. If you want a rematch, you know where to find me.\"");
        this.console.println("\nPress <Enter> to continue:");
        
        this.keyboard.readLine();
        
        return;

    }

    

    
}
    
    

