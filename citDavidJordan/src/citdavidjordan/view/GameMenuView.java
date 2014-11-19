/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.control.MenuControl;
import java.util.Scanner;

/**
 *
 * @author THERIAULT
 */
public class GameMenuView extends MenuView {
     
    public GameMenuView() {
        
        super(""
            + "\n-----------------------------------------------"
            + "\n|            Game Options Menu                |"
            + "\n-----------------------------------------------"
            + "\nM - Map"
            + "\nV - View Marble Inventory"
            + "\nT - View Naoto's Trade Inventory"
            + "\nC - Character List"
            + "\nH - Help Menu"
            + "\nS - Save Game"
            + "\nQ - Quit"
            + "\n-----------------------------------------------");
        
        
    
    }
    
    @Override
    public String getInput() {
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

        //if invalid
            if (userSelection.length() < 1) {
                System.out.println("Invalid Selection.");
                continue;

            } if (!"M".equals(userSelection) & !"V".equals(userSelection) 
                    & !"T".equals(userSelection) & !"C".equals(userSelection) 
                    & !"S".equals(userSelection) & !"H".equals(userSelection)
                    & !"Q".equals(userSelection)){
                System.out.println("Invalid Selection.");
                continue;
            }

            break;
        }

        return userSelection;
    }
    
    @Override
    public void doAction(String choice) {

        switch (choice) {

            case "H": //help menu
                MenuControl.displayHelpMenu();
                break;

            case "S": //Save current game
                MenuControl.saveGame();
                break;
                
            case "M": //View Map
                MenuControl.displayMap();
                break;
                
            case "V": // View marbles
                MenuControl.displayInventory();
                break;
                
            case "T": // view trades
                MenuControl.displayNaotosInventory();
                break;
            
            case "C": // Characters list
                MenuControl.displayActors();
                break;

            case "Q": // Quit Program
                return;

            default:
                System.out.println("\nInvalid Selection.");
                break;

        }
    }
}



    
    

  