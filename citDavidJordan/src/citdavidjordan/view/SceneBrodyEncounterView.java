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
import java.util.Scanner;

/**
 *
 * @author THERIAULT
 */
public class SceneBrodyEncounterView {
    
    public static SceneBrodyEncounterView bEncounterView;
    
    Player player = CitDavidJordan.getCurrentGame().getPlayer();
    InventoryItem[] inventory = CitDavidJordan.getCurrentGame().getInventory();

    public void start() throws MarbleControlException {
        
        //calculate brody's demands
        String request = this.payUp();
        
        //Display the banner screen
        this.displayIntro(1, request);
        
        boolean valid = false;
        while(!valid){
            try {//Get the players answer
                String PorR = this.payOrRun(request);
            } catch (SceneBrodyEncounterException ex) {
                System.out.println(ex.getMessage());
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
        
        System.out.println("\n\n\n************************************************************");
        
        
        System.out.println(    "\n As you walk over to ...  "
                             + "\n todo insert story text here... "
                            
                             + "\n Brody: \"Hey Little-Miss-" + player.getName() + "-Pants."//todo get player name <-
                             + "\n\t Where do you think you're going?"
                             + "\n\t I never said you could go past me."
                             + "\n\t Tell you what... I'll let you pass for " + number + " " + request + " marble.\"");
        
    }

    private String payOrRun(String r) throws SceneBrodyEncounterException, MarbleControlException {
        
        boolean valid = false; //indicates if name has been received
        String PorR = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            System.out.println("You may choose to pay Brody and continue to your destination,\n"
                    + "or to make a run for it. What would you like to do? \n"
                    + "P - Pay Up \n"
                    + "R - Run \n");
            
            //get name from keyboard and trim off blanks
            PorR = keyboard.nextLine();
            PorR = PorR.trim();
            PorR = PorR.toUpperCase();
            
            InventoryItem[] marbles = CitDavidJordan.getCurrentGame().getInventory();
            if (r == null) {
                System.out.println("Rocky: \"Oh, wait. Only " + marbles[Item.swirly.ordinal()].getAmount() + " Swirlys? \n"
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
                System.out.println("You give Brody 1 " + r + " marble. \n\n"
                        + "Brody: \"Thanks chump.\" \n\n"
                        + "Press <Enter> to continue.");
                Scanner keyEnter = new Scanner(System.in);
                keyEnter.nextLine();
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

    private void displayQuitMessage() {
        System.out.println(    "\n                                                 "
                             + "\nRocky: \"Oh. I see how it is. Too chicken to take"
                             + "\n\t take a risk, eh?\""
                             + "\n\t\"Well, come back when you're not so chicken.\"");
        System.out.println("\nPress <Enter> to continue:");
        
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        
        try {
            MenuControl.displayMap();
        } catch (Scene2NumberException ex) {
            System.out.println(ex.getMessage());        }

    }

    private void displayRPSGame() throws MarbleControlException {
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
            } if ("N".equals(YorN2) | "NO".equals(YorN2)) {
                this.displayRPSRules();
            } else {
                this.displayRPSGame2();
            }
        }
    }

    private void displayRPSRules() throws MarbleControlException {
        System.out.println("\n                                                 "
                             + "\nRocky: \"You don't know how to play 'Rock Paper Scissors'?\""
                             + "\n\t\"And I thought you were supposed to be one of the smart kids.\""
                             + "\n"
                             + "\n\t\"It's simple. We each choose either 'rock', 'paper', or 'scissors'.\""
                             + "\n\t\"If we both pick the same thing it's a tie. Otherwise,\""
                             + "\n\t\"Rock Smashes Scissors\""
                             + "\n\t\"Scissors Cut Paper\""
                             + "\n\t\"& Paper Covers Rock.\"");   
        
        System.out.println("\nPress <Enter> to continue:");
        
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        
        this.displayRPSGame2();
    }

    private void displayRPSGame2() throws MarbleControlException {
        System.out.println("   \n*****************************************"
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
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
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
            System.out.println("\n(R/P/S)?");
            
            //get name from keyboard and trim off blanks
            rpsInput = keyboard.nextLine();
            rpsInput = rpsInput.trim();
            rpsInput = rpsInput.toUpperCase();
            
            //if name invalid
            if (rpsInput.length() < 1) {
                System.out.println("Invalid Selection.");
                continue;
            } if (!"R".equals(rpsInput) & !"ROCK".equals(rpsInput)
                    & !"P".equals(rpsInput) & !"PAPER".equals(rpsInput)
                    & !"S".equals(rpsInput) & !"SCISSORS".equals(rpsInput)) {
                System.out.println("Invalid Selection - Please enter 'R', 'P' or 'S'.");
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
            
            System.out.println(rpsResult);
            
            if (rpsResult.toLowerCase().contains("win")) {
                System.out.println("\nRocky: \"Dang! Alright, here's your marbles.\"");
                MarbleControl.adjustMarbles(5, "swirly");//todo insert function to add marbles to player
            }
            if (rpsResult.toLowerCase().contains("lose")) {
                System.out.println("\nRocky: \"Ha! Alright *playerName*, pay up.\"");//todo get playerName
                MarbleControl.adjustMarbles(-5, "swirly");//todo insert function to subtract marbles to player
            }
            if (rpsResult.toLowerCase().contains("tie")) {
                System.out.println("\nRocky: \"Again!\"");
                continue;
            }
            System.out.println("\n\t\"Wanna play again?\"");
            this.displayRPSGame3();
        }
        
        
    }

    private void displayRPSGame3() throws MarbleControlException {
        
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
            } if ("N".equals(YorN) | "NO".equals(YorN)) {
                this.displayQuitMessage2();
            } else {
                this.displayRPSGame2();
            }
        }
    }
    
    private void displayQuitMessage2() {
        System.out.println(    "\n                                                 "
                             + "\nRocky: \"Alright. If you want a rematch, you know where to find me.\"");
        System.out.println("\nPress <Enter> to continue:");
        
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        
        try {
            MenuControl.displayMap();
        } catch (Scene2NumberException ex) {
            System.out.println(ex.getMessage());
        }

    }

    

    
}
    
    

