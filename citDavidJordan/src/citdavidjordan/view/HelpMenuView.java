/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.GameControl;
import java.util.Scanner;

/**
 *
 * @author THERIAULT
 */
public class HelpMenuView extends MenuView {
    
    public HelpMenuView() {
    
    //private final String MENU = 
            super("\n"
            + "\n-----------------------------------------------"
            + "\n|                 Help Menu                   |"
            + "\n-----------------------------------------------"
            + "\nG - What's the goal of the game?"
            + "\nI - Instructions / How to Play"
            + "\nA - About Playground Hustle™"
            + "\nQ - Quit"
            + "\n-----------------------------------------------"); 
    }

    /* void displayMenu() {
        
        char selection = ' ';
        do {
            System.out.println(MENU); //display Menu
            
            String input = this.getInput(); // get the user selection
            selection = input.charAt(0); //get first character of a string
            
            this.doAction(selection); //do action based on selection
           
        } while (!"Q".equals(selection)); //not Quit
        
        
    }

    private String getInput() {
        boolean valid = false; //indicates if name has been received
        String userSelection = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            System.out.println("Enter your selection below:");
            
            //get name from keyboard and trim off blanks
            userSelection = keyboard.nextLine();
            userSelection = userSelection.trim();
            userSelection = userSelection.toUpperCase();
            
            //if name invalid
            if (userSelection.length() < 1) {
                System.out.println("Invalid Selection.");
                continue;
            } if (!"G".equals(userSelection) & !"A".equals(userSelection) 
                    & !"H".equals(userSelection) & !"Q".equals(userSelection)){
                System.out.println("Invalid Selection.");
                continue;
            }
            
            break;
        }
        
        return userSelection;
    }

    private void doAction(char choice) {
        
        switch (choice) {
            case 'G': //display Goal of Game
                this.displayGoal();
                break;
            case 'H': //
                this.displayHowToMenu();
                break;
            case 'A': //
                this.displayAboutGame();
                break;
            case 'Q': // Quit Program
                return;
            default:
                System.out.println("\n*** Invalid Selection ***");
                break;
                
        }
        
       
    }

    private void displayGoal() {
        System.out.println("*** displayGoal function called ***");
    }

    private void displayHowToMenu() {
        System.out.println("*** displayHowToMenu function called ***");
    }

    private void displayAboutGame() {
        System.out.println("*** displayAboutGame function called ***");
    }
    */
}
