/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.GameControl;
import citdavidjordan.exceptions.MenuControlException;
import java.io.IOException;

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
            
            //if name invalid
            if (userSelection.length() < 1) {
                throw new MenuControlException("Invalid Selection.");
                
            } 
            
            //if not a valid option
            if (!"N".equals(userSelection) & !"L".equals(userSelection)
                    & !"H".equals(userSelection) & !"Q".equals(userSelection)
                    & !"S".equals(userSelection)){
                throw new MenuControlException("Invalid Selection.");
                
            }
            
            break;
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
            }
        }

        return userSelection;
    }

    @Override
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
                this.console.println("\nInvalid Selection.");
                break;

        }
    }
        public  void startNewGame(){

        GameControl.createNewGame(CitDavidJordan.getPlayer());

        //display game menu

        StartGameIntroView gameMenu = new StartGameIntroView();
        gameMenu.displayMenu();

    }

    public void loadGame() {

        this.console.println("**** loadGame()called ***");

    }

    public void displayHelpMenu() {

        MenuHelpView helpMenu = new MenuHelpView();
        helpMenu.display();

    }

    public void saveGame() {

        this.console.println("**** saveGame()called ***");

    }

    
    }
    
    

    