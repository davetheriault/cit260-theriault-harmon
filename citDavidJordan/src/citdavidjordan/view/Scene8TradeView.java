/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.Scene8TradeControl;
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
public class Scene8TradeView extends View{

    public Scene8TradeView() {
        super("");
    }
    
    
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
                CitDavidJordan.getPlayer().getLocation().setVisited(true);
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
        InventoryItem[] ni = CitDavidJordan.getCurrentGame().getNaotosInventory();
        InventoryItem[] in = CitDavidJordan.getCurrentGame().getInventory();
        try {
            input = input.toUpperCase();
            
            switch (input) {
                case "Y":
                    this.console.println("\nNaoto: \"Ok. What would you like to trade?\n"
                            + "\t First tell me what kind of marble you want:\n"
                            + "(swirly - steely - alley)?");
                    String kind = this.keyboard.readLine();
                    this.doAction(kind);
                    break;
                case "N":
                    this.doAction("QUIT");
                    break;
                case "SWIRLY":
                case "STEELY":
                case "ALLEY":
                    String type = input.toLowerCase();
                    String type2;
                    int amt = 0;
                    int amt2 = 0;
                    while(true) {
                    this.console.println("\nNaoto: \"And how many do you want?\"");                    
                    try { amt = parseInt(this.keyboard.readLine());
                        if ( amt < 1 ) {throw new IOException("Invalid Amount. Must be greater than 0.");} 
                        else if ( amt > ni[Item.valueOf(type).ordinal()].getAmount() ) {throw new IOException("Invalid Amount. Naoto does not have that many."); }
                        else { break; }
                    } catch (IOException ex) { ErrorView.display(this.getClass().getName(), ex.getMessage()); }
                    }
                    this.console.println("\nNaoto: \"Ok. " + Integer.toString(amt) + " " + type + " marble(s). \n"
                            + "\t That has a total value of " +
                            Integer.toString(amt * ni[Item.valueOf(type).ordinal()].getValue()) + "."
                            + "\n\t I'll trade you anything of equal or greater value.\" \n\n"
                            + "(Values: swirly = 1 | steely = 2 | alley = 5)");
                    while(true) {
                        this.console.println("\nMake Naoto an offer. \n"
                                + "Select the type of marbles to offer: \n"
                                + "1. swirly | 2. steely | 3. alley | V - View Inventory:");
                        try { type2 = this.keyboard.readLine().trim().toUpperCase();
                            if (in[(parseInt(type2) - 1)].getAmount() <= 0) { 
                                throw new IOException("You do not have any " + in[(parseInt(type2) - 1)].getDescription() + " marbles.");}
                            if (!"1".equals(type2) && !"2".equals(type2) && !"3".equals(type2) && !"V".equals(type2)) {
                                throw new IOException("Invalid Entry.");}
                            if ("V".equals(type2)) { mgv.displayInventory(this.console); continue;}
                            if ("1".equals(type2)) { type2 = "swirly"; break;}
                            if ("2".equals(type2)) { type2 = "steely"; break;}
                            if ("3".equals(type2)) { type2 = "alley"; break;}
                            
                        } catch (IOException ex) { ErrorView.display(this.getClass().getName(), ex.getMessage() ); }
                    }
                    while(true) {
                        this.console.println("\nEnter an amount of " + type2 + " marbles to offer:");
                        try { amt2 = parseInt(this.keyboard.readLine().trim());
                            if (amt2 < 1) { throw new IOException("Invalid Amount.");}
                            if (amt2 > in[Item.valueOf(type2).ordinal()].getAmount()) {
                                throw new IOException("Invalid Amount.");
                            } else {break;}
                        } catch (IOException ex) { ErrorView.display(this.getClass().getName(), ex.getMessage()); }
                    }
                    int vN = (ni[Item.valueOf(type).ordinal()].getValue() * amt);
                    int vI = (in[Item.valueOf(type2).ordinal()].getValue() * amt2);
                    if (vN > vI) {
                        this.console.println("\nThe value of your offer is not enough. \n"
                                + "Requested: " + amt + " " + type + "   Value = " + vN + "\n"
                                + "Offered:   " + amt2+ " " + type2+ "   Value = " + vI + "\n");
                        this.console.println("Would you like to:    1.Restart your trade\n"
                                           + "              -or-    2.Add to your offer");
                        String ans = this.keyboard.readLine().trim();
                        switch (ans) {
                            case "1":  this.doAction("Y");                      break;
                            case "2":  this.addOffer(amt, type, amt2, type2);   break;
                            default:   throw new IOException("Invalid Entry.");
                        }
                    } else { this.console.println("\nTrade Details: \n"
                                + "Requested: " + amt + " " + type + "   Value = " + vN + "\n"
                                + "Offered:   " + amt2+ " " + type2+ "   Value = " + vI + "\n");
                        this.console.println("T - Make the Trade \n"
                                           + "C - Cancel Trade & Restart \n"
                                           + "Q - Cancel Trade & Quit");
                        String ans2 = this.keyboard.readLine().trim().toUpperCase();
                        switch (ans2) {
                            case "T":  Scene8TradeControl.trade(amt, type, amt2, type2);  break;
                            case "C":  this.doAction("Y");                                break;
                            case "Q":  this.doAction("QUIT");                             break;
                            default:   throw new IOException("Invalid Entry.");
                        }
                        this.console.println("\nNaoto: \"Nice doing business with you.\"");
                        this.console.println("\n1 - Make another trade."
                                           + "\n2 - Return to Map.");
                        String end = this.keyboard.readLine().trim();
                        switch (end) {
                            case "1":   this.doAction("Y");    break;
                            case "2":   this.doAction("QUIT"); break;
                        }
                    }
                    break;
                case "QUIT":
                    mgv.displayMap();
                    break;
                default: 
                    throw new IOException("Invalid Selection.");
            }
        } catch (Scene2NumberException | MarbleControlException | IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }                                   
    }

    private void addOffer(int amt, String type, int amt2, String type2) {
        InventoryItem[] ni = CitDavidJordan.getCurrentGame().getNaotosInventory();
        InventoryItem[] in = CitDavidJordan.getCurrentGame().getInventory();
        int amt3 = 0;
        String type3;
        while(true) {
            this.console.println("\nMake Naoto an offer. \n"
                               + "Select the type of marbles to add to your offer:\n "
                               + "1. swirly | 2. steely | 3. alley | V - View Inventory:");
            try { type3 = this.keyboard.readLine().trim().toUpperCase();
                if (in[parseInt(type3) - 1].getAmount() <= 0) { 
                      throw new IOException("You do not have any" + type2 + " marbles.");}
                if (!"1".equals(type3) && !"2".equals(type3) && !"3".equals(type3) && !"V".equals(type3)) {
                    throw new IOException("Invalid Entry.");}
                if ("V".equals(type3)) { mgv.displayInventory(this.console); continue;}
                if ("1".equals(type3)) { type3 = "swirly"; break;}
                if ("2".equals(type3)) { type3 = "steely"; break;}
                if ("3".equals(type3)) { type3 = "alley"; break;}
                
            } catch (IOException ex) { ErrorView.display(this.getClass().getName(), ex.getMessage() ); }
        }
        while(true) {
            this.console.println("\nEnter an amount of " + type3 + " marbles to add to offer:");
            try { amt3 = parseInt(this.keyboard.readLine().trim());
                if (amt3 < 1 || amt3 > in[Item.valueOf(type3).ordinal()].getAmount()) {
                    throw new IOException("Invalid Amount.");
                } else {break;}
            } catch (IOException ex) { ErrorView.display(this.getClass().getName(), ex.getMessage()); }
        }
        int vN = (ni[Item.valueOf(type).ordinal()].getValue() * amt);
        int vI = (in[Item.valueOf(type2).ordinal()].getValue() * amt2) +
                     (in[Item.valueOf(type3).ordinal()].getValue() * amt3);
        if (vN > vI) {
            try {
                this.console.println("\nThe value of your offer is not enough. \n"
                        + "Requested: " + amt + " " + type + "   Value = " + vN + "\n"
                        + "Offered:   " + amt2+ " " + type2 //+ "   Value = " + vI + "\n"
                        + "           " + amt3+ " " + type3+ "   Value = " + vI + "\n");
                this.console.println("Would you like to:    1.Restart your trade\n"
                                   + "              -or-    2.Cancel trade & return to Map");
                String ans = this.keyboard.readLine().trim();
                switch (ans) {
                    case "1":  this.doAction("Y");                      break;
                    case "2":  this.doAction("QUIT");                   break;
                    default:   throw new IOException("Invalid Entry.");
                }
            } catch (IOException | MenuControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            }
        } else { 
            try {
                this.console.println("\nTrade Details: \n"
                    + "Requested: " + amt + " " + type + "   Value = " + vN + "\n"
                    + "Offered:   " + amt2+ " " + type2 //+ "   Value = " + vI + "\n"
                    + "           " + amt3+ " " + type3+ "   Value = " + vI + "\n");
                this.console.println("T - Make the Trade \n"
                                   + "C - Cancel Trade & Restart \n"
                                   + "Q - Cancel Trade & Quit");
                String ans2 = this.keyboard.readLine().trim().toUpperCase();
                switch (ans2) {
                    case "T":  Scene8TradeControl.trade(amt, type, amt2, type2, amt3, type3);  break;
                    case "C":  this.doAction("Y");                                break;
                    case "Q":  this.doAction("QUIT");                             break;
                    default:   throw new IOException("Invalid Entry.");
                }
                this.console.println("\nNaoto: \"Nice doing business with you.\"");
                this.console.println("\n1 - Make another trade."
                                   + "\n2 - Return to Map.");
                String end = this.keyboard.readLine().trim();
                switch (end) {
                    case "1":   this.doAction("Y");    break;
                    case "2":   this.doAction("QUIT"); break;
                }
            } catch (IOException | MenuControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            }
        }
    }
        
    
}

    

    
    
    

