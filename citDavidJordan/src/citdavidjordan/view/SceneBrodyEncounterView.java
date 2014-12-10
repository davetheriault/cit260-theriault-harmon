/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.MarbleControl;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.MenuControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.exceptions.SceneBrodyEncounterException;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Item;
import citdavidjordan.model.Player;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THERIAULT
 */
public class SceneBrodyEncounterView extends View{
    
    Player player = CitDavidJordan.getCurrentGame().getPlayer();
    InventoryItem[] inventory = CitDavidJordan.getCurrentGame().getInventory();
    String r;
    
    public SceneBrodyEncounterView() {
/*
    public void start() throws MarbleControlException, IOException {
        String result = null;
        //calculate brody's demands
        String request = this.payUp();
        
        //Display the banner screen
        this.displayIntro(1, request);
        
        //get figure out if player runs or pays
        boolean valid = false;
        while(!valid){
            try {//Get the players answer
                result = this.payOrRun(request);
            } catch (SceneBrodyEncounterException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
                continue;
            }
        }
        
        //carry out choice
        this.doAction(result);
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
*/
    //private void displayIntro(int number, String request) {
        
        super("\n************************************************************"
                + "\n As you walk over to ...  "
                + "\n todo insert story text here... "
                + "\n Brody: \"Hey Little-Miss-" + CitDavidJordan.getCurrentGame().getPlayer().getName() + "-Pants."//todo get player name <-
                + "\n\t Where do you think you're going?"
                + "\n\t I never said you could go past me."
                + "\n\t Tell you what... I'll let you pass for 1 " + SceneBrodyEncounterView.payUp() + " marble.\""
                
                + "\n\nYou may choose to pay Brody and continue to your destination,\n"
                    + "or to make a run for it. What would you like to do? \n"
                    + "P - Pay Up \n"
                    + "R - Run \n");
        
        
    }
    
    @Override
    public void display(){
        String value;
        boolean done = false;
        r = SceneBrodyEncounterView.payUp();
        
        do{
            this.console.println(this.message);
            value = this.getInput();
            this.doAction(value);
        } while (!done);
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
            
            if (r == null) {
                this.console.println("Rocky: \"Oh, wait. \n"
                                   + "       It looks like you don't even have any marbles little-miss-" + player.getName() + ".\n"
                                   + "       You are so worthless! Get outta here!!");
                PorR = "NA";
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
    
    @Override
    public void doAction(String result) {
        
        
        
        try {
            result = result.toUpperCase(); //convert to uppercase
            
            if (result == null) { result = "NA"; } //if player has no marbles
            
            switch (result) {
                
                case "NA":
                    this.console.println("Rocky: \"Oh, wait. \n"
                                   + "       It looks like you don't even have any marbles little-miss-" + player.getName() + ".\n"
                                   + "       You are so worthless! Get outta here!!");
                    try {
                        MenuGameView gameMenu = new MenuGameView();
                        gameMenu.displayMap();
                    } catch (Scene2NumberException | MarbleControlException | IOException ex) {
                        ErrorView.display(this.getClass().getName(), ex.getMessage());
                    }
                    break;
                    
                case "P":
                    MarbleControl.adjustMarbles(-1, r);
                    this.console.println("You give Brody 1 " + r + " marble. \n\n"
                            + "Brody: \"Thanks chump.\" \n\n"
                            + "Press <Enter> to continue to your destination.");
                    this.keyboard.readLine();
                    break;
                    
                case "R":
                    boolean esc = this.escape();
                    if (esc == false) {
                        this.console.println("You make a run for it, but Brody chases you down. \n\n"
                            + "Brody: \"Where do you think you're going fart-face?");
                        MarbleControl.adjustMarbles(-1, r);
                        this.console.println("He takes 1 of your " + r + " marbles.");
                        this.console.println("Brody: \"Remind me to pound your face in after school.\"");
                    } else {
                        this.console.println("You make a run for it. From behind you here Brody yell: \n"
                                + "\"You BETTER run! I'm gonna beat your face in!!!\" \n\n"
                                + "You make it back to the " + player.getLocation().getLocationName() + ".");
                        MenuGameView gameMenu = new MenuGameView();
                        gameMenu.displayMap();
                    }
                default:
                    
            }
        } catch (MarbleControlException | IOException | Scene2NumberException ex) {
            Logger.getLogger(SceneBrodyEncounterView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String payUp() {
        InventoryItem[] inventory = CitDavidJordan.getCurrentGame().getInventory();

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

    private boolean escape() {
        
        Random rand = new Random();
        int b = rand.nextInt(2);
        return b != 0;
        
    }

    
}
    
    

