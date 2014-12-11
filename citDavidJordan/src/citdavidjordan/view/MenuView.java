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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THERIAULT
 */
public abstract class MenuView implements ViewInterface {
    
    private String promptMessage;
    
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
    public MenuView(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    @Override
    public void display() {
        String selection = null;
        
        do {
            this.console.println(promptMessage);
            selection = this.getInput();           

            try {
                this.doAction(selection); //do action based on selection
            } catch (MenuControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
                break;
                // MenuGameView and MenuHelpView use the continue and the break
            }

        } while (!"Q".equals(selection)); //not Quit
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
    
    
    
    