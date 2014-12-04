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
    public String getInput() throws MenuControlException {
        boolean valid = false; //indicates if name has been received
        String userSelection = null;

        while(!valid) { 
            try {
            //while a valid name has not been retrieved
            
            //prompt for player's name
            this.console.println("Enter your selection below:");
            
            //get name from keyboard and trim off blanks
            userSelection = this.keyboard.readLine();
            userSelection = userSelection.trim();
            userSelection = userSelection.toUpperCase();
            
            //if invalid
            if (userSelection.length() < 1) {
                throw new MenuControlException("Invalid Selection.");
                // extends MenuView to receive continue;
            } if (!"G".equals(userSelection)
                    & !"A".equals(userSelection) & !"Q".equals(userSelection)
                    & !"I".equals(userSelection)){
                throw new MenuControlException("Invalid Selection.");
                // extends MenuView to receive continue;
            }

            break;
             } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
             }
        }

        return userSelection;
    }

    @Override
    public void doAction(String choice) throws MenuControlException {

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

    

