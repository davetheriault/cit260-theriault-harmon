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
            this.console.println(promptMessage); //display Menu
            try {
                selection = this.getInput(); // get the user selection
                //selection = input.charAt(0); //get first character of a string
            } catch (MenuControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
                continue;
            }

            try {
                this.doAction(selection); //do action based on selection
            } catch (MenuControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
                break;
                // MenuGameView and MenuHelpView use the continue and the break
            }

        } while (!"Q".equals(selection)); //not Quit
    }
    
    
}   
    
    
    
    