/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.MenuControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.model.Actor;
import citdavidjordan.model.Game;
import citdavidjordan.model.Location;
import citdavidjordan.model.Map;
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

        
    String msg = "You come to the hopscoth of the school playground. You find a bunch of \n"
            + "2nd grader girls, playing hopscotch with their marbles. \n" 
            + "One of them comes up to you. \n "
            + "Lucy: \"Hey there. I'm Lucy. \n"
            + "\tI noticed you've been having trouble with that bully Brody. \n"
            + "\tHe sometimes steals our marbles too, so were always keeping \n"
            + "\tan eye out for him. If you want, we can help YOU watch out  \n"
            + "for him too. All you have to do is give us 4 steely marbles.\"";
    
    String msg2 = "Lucy: \"So... do you want us to keep a watch out for Brody \n"
            + "\tfor 4 steelys?\"\n\n"
            + "(Choosing 'YES' will allow you to view Brodies location on the map.)\n"
            + "(Y/N)?";
    
    String msg3 = "Lucy is watching out for Brody already. No need to visit here.";
    

    @Override
    public void display(){
        String value;
        boolean done = false;
        
        do{
            try {
                if(!Actor.Lucy.getLocation().isVisited()){
                    this.console.println(this.msg);
                    this.console.println(this.msg2);
                }
                if(Actor.Lucy.getLocation().isVisited() && !game.isBullyWatchYorN()) {
                    this.console.println(this.msg2);
                }
                if(Actor.Lucy.getLocation().isVisited() && game.isBullyWatchYorN()) {
                    this.console.println(this.msg3);
                    MenuGameView gameMenu = new MenuGameView();
                    gameMenu.displayMap();
                    break;
                }
                
                value = this.getInput();
                this.doAction(value);
            } catch (MenuControlException | Scene2NumberException | MarbleControlException | IOException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            }
        } while (!done);
    }        
            
    @Override
    public void doAction(String value) throws MenuControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
