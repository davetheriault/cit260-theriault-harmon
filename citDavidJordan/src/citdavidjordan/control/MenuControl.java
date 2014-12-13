/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.model.Actor;
import citdavidjordan.model.Game;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Location;
import citdavidjordan.model.Map;
import citdavidjordan.view.StartGameIntroView;
import citdavidjordan.view.MenuHelpView;
import citdavidjordan.view.Scene5HomeworkView;
import citdavidjordan.view.MapView;
import citdavidjordan.view.Scene2NumberView;
import citdavidjordan.view.Scene4RPSView;
import citdavidjordan.view.Scene1TriviaView;
import citdavidjordan.view.View;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author THERIAULT
 */
public class MenuControl {

    private MenuControl(){
        
    }
    
    protected final PrintWriter console = CitDavidJordan.getOutFile();


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
    
    public static void displayPlayground() {
        
        Scene1TriviaView triviaView = new Scene1TriviaView();
        triviaView.start();
    }

    public static void displayMonkeyBars() throws Scene2NumberException, MarbleControlException {
        Scene2NumberView numGame = new Scene2NumberView();
        numGame.start();
    }

    public void displayTreeStump() {
        this.console.println("*** displayTreeStump function called ***");
    }

    public static void displayDodgeballCourt() throws MarbleControlException {
        
        Scene4RPSView rpsGame = new Scene4RPSView();
        rpsGame.start();
        
    }

    public static void displaySteps() {
        Scene5HomeworkView homeworkHelp = new Scene5HomeworkView();
        homeworkHelp.start();
    }

    public void displayHopscotch() {
        this.console.println("*** displayHopscotch function called ***");
    }

    public void displaySoccerField() {
        this.console.println("*** displaySoccerField function called ***");
    }

    public void displayInventory() {
        //get the sorted list of marbles for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryList();
        
        this.console.println("\nMarble Inventory \n");
        this.console.println("Description" + "\t" +
                           "Value" + "\t" +
                           "Amount" + "\t" +
                           "Total Value");
        
        //for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            //display description amount and value
            this.console.println(inventoryItem.getDescription() + "\t\t  " +
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

    public void displayActors() {
        Actor[] characters = CitDavidJordan.getCurrentGame().getActors();
        
        
        for (Actor actor : characters) {
            
            
            this.console.println("Name:         " + actor + 
                             "\nLocation:     " + actor.getLocation() + 
                             "\nEvent Name:   " + actor.getGameName() + 
                             "\nDescription:  \n" + actor.getDescription() + "\n\n"); 
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
    
    
    
}
