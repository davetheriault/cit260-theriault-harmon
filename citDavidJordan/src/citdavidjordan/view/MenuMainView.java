/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.GameControl;
import citdavidjordan.control.ProgramControl;
import citdavidjordan.exceptions.MenuControlException;
import citdavidjordan.exceptions.ProgramControlException;
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
        + "\nS - Save Game"
        + "\nQ - Quit"
        + "\n-----------------------------------------------");
    }
    
    

    @Override
    public void doAction(String choice) throws MenuControlException {
        
        choice = choice.toUpperCase();

        switch (choice) {

            case "N": {
            try {
                //New Game
                this.startNewGame();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            }
        }
                break;

            case "L": //Load Game
                this.loadGame();
                break;

            /*case "H": //help menu
                this.displayHelpMenu();
                break;
                    */
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
        public  void startNewGame() throws IOException{
        
        try {
            ProgramControl.createPlayer(" ");
            GameControl.createNewGame(CitDavidJordan.getPlayer());
            
            //display game menu
            
            StartProgramView spv = new StartProgramView();
            spv.display();
        } catch (ProgramControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

    }

    public void loadGame() throws MenuControlException {

        // prompt for name of file
        this.console.println("\nEnter the file path for the file to be loaded:");
        
        String filePath = this.getInput();
        
        try {
            //load a saved game
            GameControl.loadGame(filePath);
        }
        catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        //display loaded game menu
        MenuGameView gameMenu = new MenuGameView();
        gameMenu.display();
    }

    public void displayHelpMenu() {

        MenuHelpView helpMenu = new MenuHelpView();
        helpMenu.display();

    }

    public void saveGame() throws MenuControlException {

        this.console.println("\nEnter the file path for the file where the game will be saved:");
        
        String filePath = this.getInput();
        
        try {
            //save the game to the specified file
            GameControl.saveGame(CitDavidJordan.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

    }

    
    }
    
    

    