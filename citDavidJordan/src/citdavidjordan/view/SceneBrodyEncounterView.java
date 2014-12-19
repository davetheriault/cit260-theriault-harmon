/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.MarbleControl;
import citdavidjordan.control.SceneControl;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.exceptions.SceneBrodyEncounterException;
import citdavidjordan.model.Actor;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Item;
import citdavidjordan.model.Location;
import citdavidjordan.model.Player;
import citdavidjordan.model.Scene;
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
        
        super("");
        
        
    }
    
    @Override
    public void display(){
        String value;
        boolean done = false;
        r = SceneBrodyEncounterView.payUp();
        String msg = "\n************************************************************"
                + "\nAs you walk over to the " + Actor.Brody.getLocation().getLocationName() + ", suddenly,"
                + "\nyour mortal enemy, Brody, cuts you off.\n"               
                + "\n Brody: \"Hey Little-Miss-" + CitDavidJordan.getCurrentGame().getPlayer().getName() + "-Pants."//todo get player name <-
                + "\n\t Where do you think you're going?"
                + "\n\t I never said you could go past me."
                + "\n\t Tell you what... I'll let you pass for 1 " + r + " marble.\""
                
                + "\n\nYou may choose to pay Brody and continue to your destination,\n"
                    + "or to make a run for it. What would you like to do? \n"
                    + "P - Pay Up \n"
                    + "R - Run \n";
        do{
            this.console.println(msg);
            value = this.getInput();
            this.doAction(value); 
        } while (!done);
    }
    
    @Override
    public void doAction(String result) {
                 
        try {
            if (result == null) { result = "NA"; } //if player has no marbles
            result = result.toUpperCase(); //convert to uppercase
            
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
                    Location cont = Actor.Brody.getLocation();
                    player.setLocation(cont);
                    
                    //get scene to start view
                    Scene scene = cont.getScene();
                    SceneControl.startSceneView(scene);
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
                    }
                    this.keyboard.readLine();
                    MenuGameView gameMenu = new MenuGameView();
                    gameMenu.displayMap();
                    break;
                
                default:
                    ErrorView.display(SceneBrodyEncounterView.class.getName(), "Invalid Entry");
                    this.display();
                    
            }
        } catch (IOException | Scene2NumberException | MarbleControlException ex) {
            ErrorView.display(SceneBrodyEncounterView.class.getName(), ex.getMessage());
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
    
    

