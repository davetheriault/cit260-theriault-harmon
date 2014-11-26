/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.GameControl;
import citdavidjordan.control.MenuControl;
import java.util.Scanner;

/**
*
* @author THERIAULT
*/
public class MenuMainView extends MenuView {
    
    public MenuMainView(){
    
    //private final String MENU = 
            super(""
        + "\n-----------------------------------------------"
        + "\n| Main Menu |"
        + "\n-----------------------------------------------"
        + "\nN - New Game"
        + "\nL - Load Game"
        + "\nH - Help / How to play"
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

        //if name invalid
            if (userSelection.length() < 1) {
                System.out.println("Invalid Selection.");
                continue;
            } 
            
        //if not a valid option
            if (!"N".equals(userSelection) & !"L".equals(userSelection)
                & !"H".equals(userSelection) & !"Q".equals(userSelection)
                & !"S".equals(userSelection)){
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

            case "N": //New Game
                MenuControl.startNewGame();
                break;

            case "L": //Load Game
                MenuControl.loadGame();
                break;

            case "H": //help menu
                MenuControl.displayHelpMenu();
                break;

            case "S": //Save current game
                MenuControl.saveGame();
                break;
                
            case "Q": // Quit Program
                return;

            default:
                System.out.println("\nInvalid Selection.");
                break;

        }
    }
    
    

    /*void displayMenu() {
        
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

            } if (!"N".equals(userSelection) & !"L".equals(userSelection)
                & !"H".equals(userSelection) & !"Q".equals(userSelection)
                & !"S".equals(userSelection)){

                System.out.println("Invalid Selection.");
                continue;
            }

            break;
        }

        return userSelection;

    }

    public void doAction(String choice) {

        switch (choice) {

            case "N": //New Game
                this.startNewGame();
                break;

            case "L": //Load Game
                this.loadGame();
                break;

            case "H": //help menu
                this.displayHelpMenu();
                break;

            case "S": //Save current game
                this.saveGame();
                break;

            case "Q": // Quit Program
                return;

            default:
                System.out.println("\n*** Invalid Selection ***");
                break;

        }

    }

    private void startNewGame() {

        GameControl.createNewGame(CitDavidJordan.getPlayer());

        //display game menu

        GameIntroView gameMenu = new GameIntroView();
        gameMenu.displayMenu();

    }

    private void loadGame() {

        System.out.println("**** loadGame()called ***");

    }

    private void displayHelpMenu() {
HelpMenuView helpMenu = new HelpMenuView();
helpMenu.displayMenu();
}
private void saveGame() {
System.out.println("**** saveGame()called ***");
}
*/

    
}