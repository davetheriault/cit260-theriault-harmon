/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.exceptions.Scene8NaotoException;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Item;
import citdavidjordan.model.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Deann_2
 */
public class Scene8NaotoView {
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
    Player player = CitDavidJordan.getCurrentGame().getPlayer();
    
    public void start() throws MarbleControlException, Scene8NaotoException {
        this.displayIntro();
        
        while(true){
            try {
                    //Get the players answer
                this.YorN();
            
                } catch (Scene8NaotoException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
                continue;
            }
        }
        
        
    }

    private void displayIntro() {
        this.console.println(  "\n************************************************************");
        
        this.console.println(  "\n So you have come to exchange marbles have you?           "
                             + "\n You have come to right place " + player.getName() + ".   "
                             + "\n To trade marbles, I need to know what type of marble you "
                             + "\n are looking to trade with me. Steelys, Swirlys, or       "
                             + "\n Alleys. Do you want to continue?                         ");
    }
    
    private String YorN() throws Scene8NaotoException, MarbleControlException {
        
        boolean valid = false; //indicates if name has been received
        String YorN = null;
        
        while(!valid) { try {
            //while a valid name has not been retrieved
            
            //prompt for player's name
            this.console.println("(Y/N)?");
            
            //get name from keyboard and trim off blanks
            YorN = this.keyboard.readLine();
            YorN = YorN.trim();
            YorN = YorN.toUpperCase();
            
            InventoryItem[] marbles = CitDavidJordan.getCurrentGame().getInventory();
            if (marbles[Item.swirly.ordinal()].getAmount() < 5) {
                this.console.println("Rocky: \"Oh, wait. Only " + marbles[Item.swirly.ordinal()].getAmount() + " Swirlys? \n"
                        + "It looks like you don't have enough marbles little-miss-" + player.getName() + ".\n"
                        + "Come back when you have enough");
            }
            //if name invalid
            if (YorN.length() < 1) {
                throw new Scene8NaotoException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                
            } if (!"Y".equals(YorN) & !"N".equals(YorN)
                    & !"YES".equals(YorN) & !"NO".equals(YorN)) {
                throw new Scene8NaotoException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                
            } if ("N".equals(YorN) | "NO".equals(YorN)) {
                this.displayQuitMessage();
            } else {
                this.marbeTrade();
            }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            }
        }
        
        return YorN;
    }
    
    public void marbleType() {
        
    }

    private void marbeTrade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void displayQuitMessage() throws MarbleControlException {
        try {
            this.console.println(    "\n                                                 "
                    + "\nNaoto: \"If you don't want to trade, I understand. "
                    + "\n\t Come back to me when you have the marbles to do it. \"");
            this.console.println("\nPress <Enter> to continue:");
            
            this.keyboard.readLine();
            
            while (true) {
                MenuGameView gameMenu = new MenuGameView();
                gameMenu.displayMap();
            }
        } catch (IOException | Scene2NumberException ex) {
            ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
        }
    }
}
