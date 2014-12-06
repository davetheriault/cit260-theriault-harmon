/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.GameControl;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.MenuControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.model.Actor;
import citdavidjordan.model.Game;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Location;
import citdavidjordan.model.Map;
import citdavidjordan.model.Player;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author THERIAULT
 */
public class MenuGameView extends MenuView {
     
    public MenuGameView() {
        
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
            + "\nW - Write Character List to a File"
            + "\nI - Write Inventory List to a File"   
            + "\n-----------------------------------------------");
        
        
    
    }
    
   
    
    @Override
    public void doAction(String choice) throws MenuControlException {
        choice = choice.toUpperCase();
        Player player = CitDavidJordan.getPlayer();


        switch (choice) {

            case "H": //help menu
                this.displayHelpMenu();
                break;

            case "S": //Save current game
                this.saveGame();
                break;
                
            case "M": 
            try {
                //View Map
                this.displayMap();
                
            } catch (Scene2NumberException | MarbleControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
                break;
                
            case "V": // View marbles
                this.displayInventory(this.console);
                break;
                
            case "T": // view trades
                this.displayNaotosInventory();
                break;
            
            case "C": // Characters list
                this.displayActors(this.console);
                break;

            case "Q": // Quit Program
                return;
                
            case "W": //write to file
                this.console.println("\nEnter the file path where the character list will be saved:");
                String filePath = this.getInput();
                try (PrintWriter fw = new PrintWriter(filePath)) {
                    this.displayActors(fw);
                    this.console.println(filePath + " has been saved.");
                } catch (Exception ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                }
                break;
                
            case "I": //write inventory to a file
                try (PrintWriter pw = new PrintWriter("IventoryList" + player.getName() + ".txt")) {
                    this.displayInventory(pw);
                } catch (Exception ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                }
                

            default:
                throw new MenuControlException("\nInvalid Selection.");

        }
    }
    
    public void startNewGame() throws IOException{

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

    public void displayGoal() {
        this.console.println("**** displayGoal()called ***");    }

    public void displayInstructions() {
        this.console.println("**** displayInstructions() called ***");
    }

    public void displayAbout() {
        this.console.println("**** displayAbout() called ***");
    }
    
    public void displayPlayground() {
        
        Scene1TriviaView triviaView = new Scene1TriviaView();
        triviaView.start();
    }

    public void displayMonkeyBars() throws Scene2NumberException, MarbleControlException {
        Scene2NumberView numGame = new Scene2NumberView();
        numGame.start();
    }

    public void displayTreeStump() {
        this.console.println("*** displayTreeStump function called ***");
    }

    public void displayDodgeballCourt() throws MarbleControlException {
        
        Scene4RPSView rpsGame = new Scene4RPSView();
        rpsGame.start();
        
    }

    public void displaySteps() {
        Scene5HomeworkView homeworkHelp = new Scene5HomeworkView();
        homeworkHelp.start();
    }

    public void displayHopscotch() {
        this.console.println("*** displayHopscotch function called ***");
    }

    public void displaySoccerField() {
        this.console.println("*** displaySoccerField function called ***");
    }

    public void displayInventory(PrintWriter pw) {
        //get the sorted list of marbles for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryList();
        
        pw.println("\nMarble Inventory \n");
        pw.println("Description" + "\t" +
                           "Value" + "\t" +
                           "Amount" + "\t" +
                           "Total Value");
        
        //for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            //display description amount and value
            pw.println(inventoryItem.getDescription() + "\t\t  " +
                               inventoryItem.getValue() + "\t   " +
                               inventoryItem.getAmount() + "\t   " + 
                               (inventoryItem.getValue()*inventoryItem.getAmount()));
        }
    }
    
    public void displayNaotosInventory() {
        InventoryItem[] inventory = CitDavidJordan.getCurrentGame().getNaotosInventory();
        Game game = CitDavidJordan.getCurrentGame();
        Map map = game.getMap();
        Location[][] location = map.getLocations();
        
        if ((location[2][1].isVisited()) == true){
        
            this.console.println("\nNaoto's Awesome Marble Trading Super Fantastic Inventory!!! \n");
            this.console.println("Description" + "\t" +
                               "Value" + "\t" +
                               "Amount" + "\t" +
                               "Total Value");
        
            //for each inventory item
            for (InventoryItem inventoryItem : inventory) {
                //display description amount and value
                int total = (inventoryItem.getValue()) * (inventoryItem.getAmount());
                
                this.console.println(inventoryItem.getDescription() + "\t\t  " +
                               inventoryItem.getValue() + "\t   " +
                               inventoryItem.getAmount() + "\t   " + 
                               total);
            }
        } else {
            this.console.println("\n ***** You must first visit Naoto to unlock this feature. ****");
        }
        
    }

    public void displayMap() throws Scene2NumberException, MarbleControlException, IOException {
        
        Game game = CitDavidJordan.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        
        Random rand = new Random();
        Random rand2 = new Random();
        int brodyRow = rand.nextInt(3);
        int brodyCol = rand2.nextInt(3);
        Actor brody = Actor.Brody;
        Location brodyLocation = locations[brodyRow][brodyCol];
        
        brody.setLocation(brodyLocation);
        
        this.console.println("\n\t\t     **** MAP ****");
        this.console.print("\n\t     1" + "\t\t         2" + "\t\t     3");
        
        for (int row = 0; row < map.getNoOfRows(); row++) {
            this.console.print("\n-------------------------------------------------------------" +
                               "\n" + (row + 1) + "  ");
            for (int column = 0; column < map.getNoOfColumns(); column++){
                this.console.print(" | ");
                Location location = locations[row][column];
                //todo add code for bullywatch 
                if ((location.isVisited()) == true) {
                    String name = location.getLocationName();
                    int frontSpace = (14 - name.length()) / 2;
                    int backSpace = 14 - name.length() - frontSpace;
                    for (int i = 0; i < frontSpace; i++) {
                        this.console.print(" ");
                    }
                    this.console.print(name);
                    for (int i = 0; i < backSpace; i++) {
                        this.console.print(" ");
                    }
                } else {
                    this.console.print("      ??      ");
                } 
            this.console.print(" | ");
            }
        }
        this.console.print("\n-------------------------------------------------------------");

        MapView mapView = new MapView();
        mapView.displayMenu();
    }

    private void displayActors(PrintWriter fw) {
               
        Actor[] characters = CitDavidJordan.getCurrentGame().getActors();

        for (Actor actor : characters) {
            
            fw.println("Name:         " + actor);
            fw.println("Location:     " + actor.getLocation());
            fw.println("Event Name:   " + actor.getGameName());
            fw.println("Description:  \n" + actor.getDescription() + "\n");
            fw.println("");
        }
        
    }
}



    
    

  