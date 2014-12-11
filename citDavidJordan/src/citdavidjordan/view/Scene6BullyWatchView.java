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
import citdavidjordan.model.Actor;
import citdavidjordan.model.Game;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Item;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THERIAULT
 */
public class Scene6BullyWatchView extends View{

    public Scene6BullyWatchView() {
        super("");
    }
    Game game = CitDavidJordan.getCurrentGame();
        
    //Intro Message
    String msg = "\n\nYou come to the hopscoth of the school playground. You find a bunch of \n"
            + "2nd grader girls, playing hopscotch with their marbles. \n" 
            + "One of them comes up to you. \n\n"
            + "Lucy: \"Hey there. I'm Lucy. \n"
            + "\tI noticed you've been having trouble with that bully Brody. \n"
            + "\tHe sometimes steals our marbles too, so were always keeping \n"
            + "\tan eye out for him. If you want, we can help YOU watch out  \n"
            + "\tfor him too. All you have to do is give us 4 steely marbles.\"\n";
    
    //BullyWatch offer message
    String msg2 = "Lucy: \"So... do you want us to keep a watch out for Brody \n"
            + "\tfor 4 steelys?\"\n\n"
            + "(Choosing 'YES' will allow you to view Brodies location on the map.)\n"
            + "(Y/N)?";
    
    //already got BullyWatch message
    String msg3 = "Lucy is watching out for Brody already. No need to visit here. \n"
            + "<Press <Enter> to return to Map.>";
    

    @Override
    public void display(){
        String value;
        boolean done = false;
        
        do{
            try {
                if(!Actor.Lucy.getLocation().isVisited()){ //if first visit to lucy/hopscotch
                    this.console.println(this.msg);
                    this.console.println(this.msg2);
                }
                if(Actor.Lucy.getLocation().isVisited() && !game.isBullyWatchYorN()) { //Visited but not bought
                    this.console.println(this.msg2);
                }
                if(Actor.Lucy.getLocation().isVisited() && game.isBullyWatchYorN()) { //
                    this.console.println(this.msg3);
                    
                }
                
                value = this.getInput();
                this.doAction(value);
            } catch (MenuControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            }
        } while (!done);
    }        
            
    @Override
    public void doAction(String value) throws MenuControlException {
        
        try {
            value = value.toUpperCase();
            InventoryItem[] items = game.getInventory();
            
            switch (value) {
                
                case "Y": //yes to bullywatch
                    if ( items[Item.steely.ordinal()].getAmount() >= 4 ) {      //if you have enough marbles
                        game.setBullyWatchYorN(true);
                        MarbleControl.adjustMarbles(-4, value);
                        this.console.println("You give Lucy 4 steely marbles. \n\n"
                                + "Lucy: \"Thanks! We'll keep an eye on him for you.\" \n\n"
                                + "(Now, whenever you view the map, Brody's location will be displayed.)");
                        this.console.println("<Press <Enter> to continue.>");
                    }    
                    else {                                                      //if you don't have enough
                        this.console.println("You don't have enough steely marbles. \n"
                                + "<Press <Enter> to return to Map.>");                        
                    }
                    this.keyboard.readLine();
                    this.leave();
                    break;
                
                case "N": //no to bullywatch
                    this.console.println("Lucy: \"Ok. Well, if you change your mind, Let me know.");
                    this.console.println("<Press <Enter> to continue.>");
                    this.keyboard.readLine();
                    this.leave();
                    break;
                
                    
                default:
                    throw new IOException("Invalid Entry");
                   
            }
        } catch (MarbleControlException | IOException ex) {
            Logger.getLogger(Scene6BullyWatchView.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void leave() { //return to map
        try {
            game.getPlayer().getLocation().setVisited(true);
            MenuGameView gameMenu = new MenuGameView();
            gameMenu.displayMap();
        }
        catch (Scene2NumberException | MarbleControlException | IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }
    
}
