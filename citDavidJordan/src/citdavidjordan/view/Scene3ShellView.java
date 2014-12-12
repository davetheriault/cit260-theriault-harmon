/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.MarbleControl;
import citdavidjordan.control.Scene3ShellControl;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.MenuControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.model.Actor;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Item;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String msg2 = "Shelton: \"So. Wanna play? \n(Y/N)?";
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
                    
                  try {  
                    MenuGameView mgv = new MenuGameView(); mgv.displayInventory(this.console);
                    InventoryItem[] inventory = CitDavidJordan.getCurrentGame().getInventory();
                    this.console.println("\nSheldon: \"So, what kind of marbles are you betting?");
                    String mType = this.keyboard.readLine(); mType = mType.trim(); mType = mType.toLowerCase();
                        if (!mType.equals("swirly") && !mType.equals("steely") && !mType.equals("alley"))
                        { throw new IOException("Invalid entry. Double check spelling."); }
                        
                    this.console.println("Sheldon: \"And how many?\"");
                    int mNo = parseInt(this.keyboard.readLine().trim());
                        if ((mType.equals("swirly") && (mNo > inventory[Item.swirly.ordinal()].getAmount())) ||
                              (mType.equals("steely") && (mNo > inventory[Item.steely.ordinal()].getAmount())) ||
                                (mType.equals("alley") && (mNo > inventory[Item.alley.ordinal()].getAmount()))) {
                        throw new IOException("You do not have enough of that type.");}
                    
                    this.console.println("\nSheldon: \"Ok. Let's do this.\"\n\n"
                            + "Sheldon puts the ball under the center cup. It moves:\n"
                            + "(Press <Enter> to start)");
                    this.keyboard.readLine();
                    Scene3ShellControl shell = new Scene3ShellControl(); 
                    int ans = shell.shellGame();
                    
                    this.console.println("Sheldon: \"So. Where do you think the ball is?\"\n"
                            + "(Enter - LEFT, CENTER, or RIGHT)");
                    while(true) {
                        String guess = this.keyboard.readLine();
                        guess = guess.trim(); guess = guess.toUpperCase();
                                      
                        if (!guess.equals("LEFT") && !guess.equals("L") && !guess.equals("CENTER")
                                && !guess.equals("C") && !guess.equals("RIGHT") && !guess.equals("R")) {
                            throw new IOException("Invalid Entry.");
                            
                        } 
                        if (((guess.equals("LEFT") || guess.equals("L")) && (ans == -1)) ||
                            ((guess.equals("CENTER") || guess.equals("C")) && (ans == 0)) ||
                                ((guess.equals("RIGHT") || guess.equals("R")) && (ans == 1))) {
                            this.console.println("Sheldon lifts the cup to reveal the ball.\n"
                                + "YOU WIN!\n\n"
                                + "Sheldon gives you " + mNo + " " + mType + " marble(s).");
                            MarbleControl.adjustMarbles(mNo, mType);
                            break;
                        } else {  String answ = null;
                            if (ans == -1) {answ = "LEFT";}
                            if (ans == 0) {answ = "CENTER";}
                            if (ans == 1) {answ = "RIGHT";}
                            this.console.println("Sheldon lifts the cups. \n"
                                    + "SORRY. The ball was under the " + answ + " cup.");
                            this.console.println("Sheldon: \"Tough luck.\"\n\n"
                                    + "You give Sheldon " + mNo + " " + mType + " marble(s).");
                            MarbleControl.adjustMarbles(-mNo, mType);
                            break;
                        }
                    }
                    this.console.println("\nSheldon: \"Wanna go again?\"\n"
                            + "(Y/N)?");
                    String again = this.keyboard.readLine().trim().toUpperCase();
                    switch (again) {
                        case "Y":   this.doAction("Y2");     break;
                        case "N":   this.doAction("QUIT");   break;
                        default:    throw new IOException("Invalid Entry");  
                        }
                  } catch (IOException ex) {
                      ErrorView.display(this.getClass().getName(), ex.getMessage());
                  }
                    break; //case "Y2" break
                    
                case "QUIT":
                    CitDavidJordan.getPlayer().getLocation().setVisited(true);
                    MenuGameView mgv2 = new MenuGameView();
                    mgv2.displayMap();
                    break;
                    
                default:
                    throw new IOException("Invalid Entry.");
            }
        } catch (IOException | MarbleControlException | Scene2NumberException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }
    
}
