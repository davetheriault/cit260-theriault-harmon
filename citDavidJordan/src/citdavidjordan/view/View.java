/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.exceptions.MenuControlException;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author THERIAULT
 */
public abstract class View implements ViewInterface {
    
    String message;
    
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
    public View(String message) {
        this.message = message;
    }
    
    @Override
    public void display(){
        String value;
        boolean done = false;
        
        do{
            try {
                this.console.println(this.message);
                value = this.getInput();
                this.doAction(value);
            } catch (MenuControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            }
        } while (!done);
    }
            
    @Override
    public String getInput() {
        boolean valid = false;
        String selection = null;
        try {
            while (!valid) {
                
                //get input from keyboard
                selection = this.keyboard.readLine();
                selection = selection.trim();
                
                if (selection.length() < 1) {
                    ErrorView.display(this.getClass().getName(), "Invalid Entry.");
                    continue;
                }
                break;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error Reading Input: " + e.getMessage());
        }
        return selection;
    }
    
    
    
    
}
