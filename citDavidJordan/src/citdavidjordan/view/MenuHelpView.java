/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.exceptions.MenuControlException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THERIAULT
 */
public class MenuHelpView extends MenuView {
    
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
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
            case "G": 
                try {
                //What's the goal of the game?
                this.displayGoal();
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
                }
                break;
                
            case "I": 
                try {
                // How to / Instructions
                this.displayInstructions();
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
                }
                break;
                
            case "A": 
                try {
                //About Playground Hustle
                this.displayAbout();
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
                }
                break;
                
            case "Q": // Quit Program
                return;

            default:
                throw new MenuControlException("\nInvalid Selection.");
                

        }
    }
        
    public void displayGoal() throws IOException {
        this.console.println("\n\n\n*********************Goal of the Game*******************");
        
        this.console.println(      "*                                                           *"
                             + "\n* The goal of Playground Hustle is to travel from             *"
                             + "\n* location to location, accomplishing the tasks that other    *"
                             + "\n* students ask. When we have completed certain tasks, we      *"
                             + "\n* will receive marbles.                                       *");
        
        this.console.println(      "*                                                           *"
                             + "\n\t* The marbles are to defend ourselves from Brody, the       *");
        
        this.console.println(  "\n* school bully by paying a certain amount of marbles to       *"
                             + "\n* Brock, the even larger, but nice school bully so he will    *"
                             + "\n* defend you from Brody and his wrath.                        *"
                             + "\n************************************************************");
        this.console.println(  "\n* Click <Enter> to Continue                                   *");

        this.keyboard.readLine();
    }

    public void displayInstructions() throws IOException {
        this.console.println("\n\n\n*********************How to Play the Game*******************");
        
        this.console.println(      "*                                                           *"
                             + "\n* As your travel from location to location, you will be       *"
                             + "\n* given tasks, and in order to move around inside of the map  *"
                             + "\n* and within those tasks, you will need to use your keyboard. *"
                             + "\n* For Example:                                                *");
        
        this.console.println(      "*                                                           *"
                             + "\n\t* <N - New Game>                                            *");
        
        this.console.println(  "\n* This lets you know that to start a new game, you must       *"
                             + "\n* press the letter <N>                                        *"
                             + "\n* There will be different letters and numbers to navigate.    *"
                             + "\n************************************************************");
        
        this.console.println(  "\n* Click <Enter> to Continue                                   *");

        this.keyboard.readLine();
    }

    public void displayAbout() throws IOException {
        this.console.println("\n\n\n*********************About Us********************************");
        
        this.console.println(      "*                                                           *"
                             + "\n* The Playgorund Hustle was created by David Theriault and    *"
                             + "\n* Jordan Harmon to accomplish assignments for their college   *"
                             + "\n* course, CIT 260.                                            *");
        
        this.console.println(  "\n* Click <Enter> to Continue                                   *");

        this.keyboard.readLine();
    }
    
    
}

    

