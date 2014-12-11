/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.exceptions.MenuControlException;
import citdavidjordan.model.Actor;

/**
 *
 * @author THERIAULT
 */
public class Scene3ShellView extends View{

    public Scene3ShellView() {
        super("");
    }

    String msg = "At the edge of the playground, there sits a tree stump. \n"
            + "Shifty Shelton is always there, shuffling his cups and ball around. \n";
    
    String msg2 = "Shelton: \"So. Wanna play?";
    
    @Override
    public void display(){
        String value;
        boolean done = false;
        
        do{
            try {
                if(!Actor.Sheldon.getLocation().isVisited()){ //if first visit to lucy/hopscotch
                    this.console.println(this.msg);
                    this.console.println(this.msg2);
                }
                else { //Visited but not bought
                    this.console.println(this.msg2);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
