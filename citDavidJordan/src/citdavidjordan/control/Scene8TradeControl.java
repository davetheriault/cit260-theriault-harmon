/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.view.ErrorView;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THERIAULT
 */
public class Scene8TradeControl {
    
        
    public static void trade(int amt, String type, int amt2, String type2) {
        try {
                        
            MarbleControl.adjustMarbles(-amt2, type2); //Subtract Player Marbles
            MarbleControl.adjustNaotoMarbles(-amt, type); // Subtract Naoto
            
            MarbleControl.adjustMarbles(amt, type);  //add to player
            MarbleControl.adjustNaotoMarbles(amt2, type2); // add to Naoto
            
            
        } catch (MarbleControlException ex) {
            ErrorView.display("Scene8TradeControl", ex.getMessage());
        }
        
    }

    public static void trade(int amt, String type, int amt2, String type2, int amt3, String type3) {
        try {
                        
            MarbleControl.adjustMarbles(-amt2, type2); //Subtract Player Marbles
            MarbleControl.adjustMarbles(-amt3, type3); //Subtract Player Marbles
            MarbleControl.adjustNaotoMarbles(-amt, type); // Subtract Naoto
            
            MarbleControl.adjustMarbles(amt, type);  //add to player
            MarbleControl.adjustNaotoMarbles(amt2, type2); // add to Naoto
            MarbleControl.adjustNaotoMarbles(amt3, type3); // add to Naoto
            
            
        } catch (MarbleControlException ex) {
            ErrorView.display("Scene8TradeControl", ex.getMessage());
        }
    }
    
}
