/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.control.Scene3ShellControl;
import citdavidjordan.exceptions.MenuControlException;
import citdavidjordan.model.Actor;
import java.io.IOException;
import static java.lang.Integer.parseInt;

/**
 *
 * @author THERIAULT
 */
public class Scene3ShellView extends View{

    public Scene3ShellView() {
        super(" ");
    }

    
    @Override
    public void display(){
        String msg = "At the edge of the playground, there sits a tree stump. \n"
            + "Shifty Shelton is always there, shuffling his cups and ball around. \n";
        String msg2 = "Shelton: \"So. Wanna play?";
        String value;
        boolean done = false;
        
        do{
            try {
                if(!Actor.Sheldon.getLocation().isVisited()){ //if first visit to lucy/hopscotch
                    this.console.println(msg);
                    this.console.println(msg2);
                }
                else { //Visited but not bought
                    this.console.println(msg2);
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
            
            switch (value) {
                
                case "Y":
                    this.console.println("\nShelton: \"Alright. Do you you know how to play?\" \n"
                            + "(Y/N)?");
                    String x = this.keyboard.readLine();
                    if (x.toUpperCase().equals("Y")) { this.doAction("Y2");}
                    else if (x.toUpperCase().equals("N")) { this.doAction("HOWTO");}
                    else { throw new IOException("Invalid Response.");}
                    break;
                    
                case "N":
                    this.console.println("\nShelton: \"Don't got what it takes, eh? Suit yourself.\"\n"
                            + "(Press <Enter> to return to the map.)");
                    this.doAction("QUIT");
                    break;
                    
                case "HOWTO":
                    this.console.println("\nSheldon: \"It's simple. I have 3 cups and 1 ball.\n"
                            + "\t I'll place the ball under the center cup to start. \n"
                            + "\t Then I will rearrange the cups. You just keep your eye\n"
                            + "\t on the cup with the ball under it, and tell me wear it\n"
                            + "\t is, and you win.\"");
                    this.console.println("\n(To represent the cup game, you must picture three separate)\n"
                                         + "(cup positions - LEFT, CENTER, & RIGHT.  For each time     )\n"
                                         + "(Sheldon shuffles the cups, either the words LEFT or RIGHT )\n"
                                         + "(will display on the screen, representing the movement of  )\n"
                                         + "(the center cup which contains the ball. Based on the move-)\n"
                                         + "(ment of the center cup, determine its final position.     )");
                    this.console.println("(Press <Enter> to continue.)");
                    this.keyboard.readLine();
                    this.doAction("Y2");
                    break;
                    
                case "Y2":
                    MenuGameView mgv = new MenuGameView(); mgv.displayInventory(this.console);
                    this.console.println("\nSheldon: \"So, what kind of marbles are you betting?");
                    String mType = this.keyboard.readLine().trim().toLowerCase();
                    this.console.println("Sheldon: \"And how many?\"");
                    int mNo = parseInt(this.keyboard.readLine().trim());
                    
                    this.console.println("\nSheldon: \"Ok. Let's do this.\"\n\n"
                            + "Sheldon puts the ball under the center cup. It moves:\n");
                    Scene3ShellControl shell = new Scene3ShellControl(); 
                    int ans = shell.shellGame();
            }
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }
    
}
