/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.Scene8TradeControl;
import citdavidjordan.exceptions.MenuControlException;
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
public class Scene8TradeView extends View{

    public Scene8TradeView() {
        super("");
    }
    InventoryItem[] ni = CitDavidJordan.getCurrentGame().getNaotosInventory();
    InventoryItem[] in = CitDavidJordan.getCurrentGame().getInventory();
    
    String msg = "\n\nYou enter the school cafeteria. You find Naoto. He is the biggest \n"
                   + "marble collector in the school. He has so many marbles, that he \n"
                   + "brings all his excess to school to trade with other kids.";
    
    String msg2 = "\nNaoto: \"Hello. did you want to make a trade?\"\n"
            + "(Y/N)?";
    
    MenuGameView mgv = new MenuGameView();
    
    @Override
    public void display(){
        
        String value;
        boolean done = false;
        
        do{
            try {
                if(!Actor.Naoto.getLocation().isVisited()){ //if first visit to lucy/hopscotch
                    this.console.println(msg);                    
                }
                           
                mgv.displayInventory(this.console);
                mgv.displayNaotosInventory();
                this.console.println(msg2);
                
                value = this.getInput();
                this.doAction(value);
            } catch (MenuControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            }
        } while (!done);
    }        

    @Override
    public void doAction(String input) throws MenuControlException {
        
        input = input.toUpperCase();
        
        switch (input) {
            
            case "Y":
                this.console.println("\nNaoto: \"Ok. What would you like to trade?\n"
                                               + "\t First tell me what kind of marble you want:\n"
                                               + "(swirly - steely - alley)?");
                this.getInput();
                break;
                
            case "N":
                this.doAction("QUIT");
                break;
                
            case "SWIRLY":
            case "STEELY":
            case "ALLEY":
                String type = input.toLowerCase();
                int amt = 0;
                this.console.println("\nNaoto: \"And how many do you want?\"");
                try { amt = parseInt(this.keyboard.readLine());
                if (amt < 1 || amt > ni[Item.valueOf(type).ordinal()].getAmount()); {throw new IOException("Invalid Amount.");}
                } catch (IOException ex) { ErrorView.display(this.getClass().getName(), ex.getMessage()); }
                
                this.console.println("\nNaoto: \"Ok. " + Integer.toString(amt) + " " + type + " marble(s). \n"
                                            + "\t That has a total value of " + 
                        Integer.toString(amt * ni[Item.valueOf(type).ordinal()].getValue()) + "."
                        + "\n\t I'll trade you anything of equal or greater value.\" \n\n"
                        + "(Values: swirly = 1 | steely = 2 | alley = 5)");
                Scene8TradeControl.trade(amt, type);
               
        }
        
    }

    
}
    
    
    

