/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.exceptions.MenuControlException;
import java.io.IOException;

/**
 *
 * @author THERIAULT
 */
public class MenuHelpView extends MenuView {
    
    public MenuHelpView() {
    
    //private final String MENU = 
            super(""
            + "\n-----------------------------------------------"
            + "\n|                 Help Menu                   |"
            + "\n-----------------------------------------------"
            + "\nG - What's the goal of the game?"
            + "\nI - Instructions / How to Play"
            + "\nA - About Playground Hustle™"
            + "\nQ - Quit"
            + "\n-----------------------------------------------"); 
    }
    
    
    

    @Override
    public void doAction(String choice) throws MenuControlException {
        choice = choice.toUpperCase();

        switch (choice) {
                
            //help menu options
            case "G": //What's the goal of the game?
                this.displayGoal();
                break;
                
            case "I": // How to / Instructions
                this.displayInstructions();
                break;
                
            case "A": //About Playground Hustle
                this.displayAbout();
                break;
                
            case "Q": // Quit Program
                return;

            default:
                throw new MenuControlException("\nInvalid Selection.");
                

        }
    }
        
    public void displayGoal() {
        this.console.println("**** displayGoal()called ***");    }

    public void displayInstructions() {
        this.console.println("**** displayInstructions() called ***");
    }

    public void displayAbout() {
        this.console.println("**** displayAbout() called ***");
    }
    
    
}

    

