/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.model.Actor;
import citdavidjordan.model.Game;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Location;
import citdavidjordan.model.Map;
import citbyui.cit260.playgroundhustle.views.StartGameIntroView;
import citbyui.cit260.playgroundhustle.views.MenuHelpView;
import citbyui.cit260.playgroundhustle.views.Scene5HomeworkView;
import citbyui.cit260.playgroundhustle.views.MapView;
import citbyui.cit260.playgroundhustle.views.Scene2NumberView;
import citbyui.cit260.playgroundhustle.views.Scene4RPSView;
import citbyui.cit260.playgroundhustle.views.Scene1TriviaView;
import java.util.Random;

/**
 *
 * @author THERIAULT
 */
public class MenuControl {

    private MenuControl(){
        
    }

    public static void startNewGame(){

        GameControl.createNewGame(CitDavidJordan.getPlayer());

        //display game menu

        StartGameIntroView gameMenu = new StartGameIntroView();
        gameMenu.displayMenu();

    }

    public static void loadGame() {

        System.out.println("**** loadGame()called ***");

    }

    public static void displayHelpMenu() {

        MenuHelpView helpMenu = new MenuHelpView();
        helpMenu.display();

    }

    public static void saveGame() {

        System.out.println("**** saveGame()called ***");

    }

    public static void displayGoal() {
        System.out.println("**** displayGoal()called ***");    }

    public static void displayInstructions() {
        System.out.println("**** displayInstructions() called ***");
    }

    public static void displayAbout() {
        System.out.println("**** displayAbout() called ***");
    }
    
    public static void displayPlayground() {
        
        Scene1TriviaView triviaView = new Scene1TriviaView();
        triviaView.start();
    }

    public static void displayMonkeyBars() throws Scene2NumberException {
        Scene2NumberView numGame = new Scene2NumberView();
        numGame.start();
    }

    public static void displayTreeStump() {
        System.out.println("*** displayTreeStump function called ***");
    }

    public static void displayDodgeballCourt() {
        
        Scene4RPSView rpsGame = new Scene4RPSView();
        rpsGame.start();
        
    }

    public static void displaySteps() {
        Scene5HomeworkView homeworkHelp = new Scene5HomeworkView();
        homeworkHelp.start();
    }

    public static void displayHopscotch() {
        System.out.println("*** displayHopscotch function called ***");
    }

    public static void displaySoccerField() {
        System.out.println("*** displaySoccerField function called ***");
    }

    public static void displayInventory() {
        //get the sorted list of marbles for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\nMarble Inventory \n");
        System.out.println("Description" + "\t" +
                           "Value" + "\t" +
                           "Amount" + "\t" +
                           "Total Value");
        
        //for each inventory item
        for (InventoryItem inventoryItem : inventory) {
            //display description amount and value
            System.out.println(inventoryItem.getDescription() + "\t\t  " +
                               inventoryItem.getValue() + "\t   " +
                               inventoryItem.getAmount() + "\t   " + 
                               (inventoryItem.getValue()*inventoryItem.getAmount()));
        }
    }
    
    public static void displayNaotosInventory() {
        InventoryItem[] inventory = CitDavidJordan.getCurrentGame().getNaotosInventory();
        Game game = CitDavidJordan.getCurrentGame();
        Map map = game.getMap();
        Location[][] location = map.getLocations();
        
        if ((location[2][1].isVisited()) == true){
        
            System.out.println("\nNaoto's Awesome Marble Trading Super Fantastic Inventory!!! \n");
            System.out.println("Description" + "\t" +
                               "Value" + "\t" +
                               "Amount" + "\t" +
                               "Total Value");
        
            //for each inventory item
            for (InventoryItem inventoryItem : inventory) {
                //display description amount and value
                int total = (inventoryItem.getValue()) * (inventoryItem.getAmount());
                
                System.out.println(inventoryItem.getDescription() + "\t\t  " +
                               inventoryItem.getValue() + "\t   " +
                               inventoryItem.getAmount() + "\t   " + 
                               total);
            }
        } else {
            System.out.println("\n ***** You must first visit Naoto to unlock this feature. ****");
        }
        
    }

    public static void displayActors() {
        Actor[] characters = CitDavidJordan.getCurrentGame().getActors();
        
        
        for (Actor actor : characters) {
            
            
            System.out.println("Name:         " + actor + 
                             "\nLocation:     " + actor.getLocation() + 
                             "\nEvent Name:   " + actor.getGameName() + 
                             "\nDescription:  \n" + actor.getDescription() + "\n\n"); 
        }
    }

    public static void displayMap() throws Scene2NumberException {
        
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
        
        System.out.println("\n\t\t     **** MAP ****");
        System.out.print("\n\t     1" + "\t\t         2" + "\t\t     3");
        
        for (int row = 0; row < map.getNoOfRows(); row++) {
            System.out.print("\n-------------------------------------------------------------" +
                               "\n" + (row + 1) + "  ");
            for (int column = 0; column < map.getNoOfColumns(); column++){
                System.out.print(" | ");
                Location location = locations[row][column];
                //todo add code for bullywatch 
                if ((location.isVisited()) == true) {
                    String name = location.getLocationName();
                    int frontSpace = (14 - name.length()) / 2;
                    int backSpace = 14 - name.length() - frontSpace;
                    for (int i = 0; i < frontSpace; i++) {
                        System.out.print(" ");
                    }
                    System.out.print(name);
                    for (int i = 0; i < backSpace; i++) {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print("      ??      ");
                } 
            System.out.print(" | ");
            }
        }
        System.out.print("\n-------------------------------------------------------------");

        MapView mapView = new MapView();
        mapView.displayMenu();
    }
    
    
    
}
