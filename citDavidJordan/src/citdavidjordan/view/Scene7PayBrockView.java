/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.MarbleControl;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.model.Actor;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Item;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author THERIAULT
 */
public class Scene7PayBrockView {
    
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
    InventoryItem[] in = CitDavidJordan.getCurrentGame().getInventory();
    MenuGameView mgv = new MenuGameView();

    public void start() throws IOException {
        if (!Actor.Brock.getLocation().isVisited()) { //Long description only displays on first visit ~Dave
        this.console.println("\n Brock is a big kid and is willing to defend  "
                           + "\n you for an exchange of marbles. His servcies "
                           + "\n are pricy, but how much is your face worth?  "
                           + "\n For 20 alley marbles, you can buy his protection.");
        this.console.println("\n\t (Press <Enter> to continue.)                  ");
        
        this.keyboard.readLine();
        }
        //Set location to visited
        CitDavidJordan.getPlayer().getLocation().setVisited(true);
        this.payBrock();
    }

    private void payBrock() throws IOException {
        this.console.println("\n Brock: \"So, have you come to pay me?  "
                           + "\n\t My protection is not cheap. You got 20 alleys like we agreed?\"     ");
                           
        this.console.println("\n(Press <Enter> to continue.)");
        
        this.keyboard.readLine();
        
        MenuGameView displayInventory = new MenuGameView();
        displayInventory.displayInventory(this.console);
        
        if ( in[Item.alley.ordinal()].getAmount() >= 20 ) {
            try {
                this.console.println("\nBrock: \"Looks like you got enough. Nice.\n"
                        + "\t So, do we have a deal?\"\n"
                        + "(Y/N)?");
                String win = this.keyboard.readLine();
                win = win.trim().toUpperCase();
                switch (win){
                    case "Y":
                    case "YES": try { MarbleControl.adjustMarbles(-20, "alley"); }
                    catch (MarbleControlException ex) { ErrorView.display(this.getClass().getName(), ex.getMessage());}
                    this.console.println("\n"
                            + ".........................................................................\n"
                            + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
                            + "!!                                                                     !!\n"
                            + "!!  Y       Y    OOOO    U      U         W         W  IIIII  N     N  !!\n"
                            + "!!   Y     Y    O    O   U      U         W         W    I    NN    N  !!\n"
                            + "!!    Y   Y    O      O  U      U         W         W    I    N N   N  !!\n"
                            + "!!     Y Y     O      O  U      U         W    W    W    I    N  N  N  !!\n"
                            + "!!      Y      O      O  U      U         W    W    W    I    N   N N  !!\n"
                            + "!!      Y       O    O    U    U           W  W W  W     I    N    NN  !!\n"
                            + "!!      Y        OOOO      UUUU             WW   WW    IIIII  N     N  !!\n"
                            + "!!                                                                     !!\n"
                            + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
                            + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
                    this.keyboard.readLine();
                    MenuMainView mmw = new MenuMainView();
                    mmw.display();
                    break;
                    case "N":
                    case "NO":  this.console.println("\n Brock: \"Are you stupid? Quit wasting my time, you wuss.\" \n"
                            + "(Press <Enter> to return to map.) ");
                    mgv.displayMap();
                        
                    default: throw new IOException("Invalid Selection.");
                }
            } catch (Scene2NumberException | MarbleControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            }
        } else {
            this.console.println("\nBrock: \"Hey wuss! You don't have enough marbles here. "
                                    + "\n\t You're wasting my time here. *sigh*"
                                    + "\n\t Come back when you got 20 ALLEY marbles. "
                                    + "\n\t None of these crappy steelys and swirlturds! "
                    + "\n\t Alleys. Got it?\"");
            this.console.println("\n (Press <Enter> to return to menu.)              ");
            
            this.keyboard.readLine();
            
            
            mgv.display();
        }
    }
    
}
