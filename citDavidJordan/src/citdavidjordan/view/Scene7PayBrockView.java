/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
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
             
        } else {
            this.console.println("\nBrock: \"Hey wuss! You don't have enough marbles here. "
                                    + "\n\t You're wasting my time here. *sigh*"
                                    + "\n\t Come back when you got 20 ALLEY marbles. "
                                    + "\n\t None of these crappy steelys and swirlturds! "
                    + "\n\t Alleys. Got it?\"");
            this.console.println("\n (Press <Enter> to return to menu.)              ");
            
            this.keyboard.readLine();
            
            MenuGameView mgv = new MenuGameView();
            mgv.display();
        }
    }
    
}
