/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.model.InventoryItem;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author THERIAULT
 */
public class Scene8TradeControl {
    
        
    public static void trade(int amt, String type, int amt2, String type2) {
        InventoryItem[] ni = CitDavidJordan.getCurrentGame().getNaotosInventory();
        InventoryItem[] in = CitDavidJordan.getCurrentGame().getInventory();  
        
        
    }

    public static void trade(int amt, String type, int amt2, String type2, int amt3, String type3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
