/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.ProgramControlException;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Item;

/**
 *
 * @author THERIAULT
 */
public class MarbleControl {

    static InventoryItem[] inventory = CitDavidJordan.getCurrentGame().getInventory();
    static InventoryItem[] naotoInventory = CitDavidJordan.getCurrentGame().getNaotosInventory();
    private static int amount = 0;
    private static int adjusted = 0;
        
    
    public static void adjustMarbles( int add, String type) throws MarbleControlException{
        
        if ("swirly".equals(type)) {
            amount = inventory[Item.swirly.ordinal()].getAmount();
            adjusted = amount + add;
            inventory[Item.swirly.ordinal()].setAmount(adjusted);
        }
        if ("steely".equals(type)) {
            amount = inventory[Item.steely.ordinal()].getAmount();
            adjusted = amount + add;
            inventory[Item.steely.ordinal()].setAmount(adjusted);
        }
        if ("alley".equals(type)) {
            amount = inventory[Item.alley.ordinal()].getAmount();
            adjusted = amount + add;
            inventory[Item.alley.ordinal()].setAmount(adjusted);
        }
    }
    
    public static void adjustNaotoMarbles( int add, String type) throws MarbleControlException{
        
        if ("swirly".equals(type)) {
            amount = naotoInventory[Item.swirly.ordinal()].getAmount();
            adjusted = amount + add;
            naotoInventory[Item.swirly.ordinal()].setAmount(adjusted);
        }
        if ("steely".equals(type)) {
            amount = naotoInventory[Item.steely.ordinal()].getAmount();
            adjusted = amount + add;
            naotoInventory[Item.steely.ordinal()].setAmount(adjusted);
        }
        if ("alley".equals(type)) {
            amount = naotoInventory[Item.alley.ordinal()].getAmount();
            adjusted = amount + add;
            naotoInventory[Item.alley.ordinal()].setAmount(adjusted);
        }
    }
    
    
}
