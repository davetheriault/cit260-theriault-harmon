/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.GameControl;
import citdavidjordan.control.MapControl;
import citdavidjordan.model.Actor;
import citdavidjordan.model.Game;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Location;
import citdavidjordan.model.Map;
import java.util.Scanner;

/**
 *
 * @author THERIAULT
 */
public abstract class MenuView implements ViewInterface {
    
    private String promptMessage;
    
    public MenuView(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    @Override
    public void display() {
        String selection = null;
        
        do {
        System.out.println(promptMessage); //display Menu
        
        selection = this.getInput(); // get the user selection
        //selection = input.charAt(0); //get first character of a string

        this.doAction(selection); //do action based on selection

    } while (!"Q".equals(selection)); //not Quit
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

            } if (promptMessage.contains("Main") & !"N".equals(userSelection) & !"L".equals(userSelection)
                & !"H".equals(userSelection) & !"Q".equals(userSelection)
                & !"S".equals(userSelection)){
                System.out.println("Invalid Selection.");
                continue;
            } if (promptMessage.contains("goal") & !"G".equals(userSelection)
                & !"A".equals(userSelection) & !"Q".equals(userSelection)
                & !"I".equals(userSelection)){
                System.out.println("Invalid Selection.");
                continue;
            } if (promptMessage.contains("Playground") & !"1".equals(userSelection) & !"2".equals(userSelection) 
                    & !"3".equals(userSelection) & !"4".equals(userSelection) 
                    & !"5".equals(userSelection) & !"6".equals(userSelection)
                    & !"7".equals(userSelection) & !"Q".equals(userSelection)){
                System.out.println("Invalid Selection.");
                continue;
            } if (promptMessage.contains("Game Options Menu") & !"M".equals(userSelection) & !"V".equals(userSelection) 
                    & !"C".equals(userSelection) & !"S".equals(userSelection) 
                    & !"Q".equals(userSelection) & !"H".equals(userSelection)/*
                    & !"7".equals(userSelection) & !"Q".equals(userSelection)*/){
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
                
                // following are for MapView
                
            case "1": //display Goal of Game
                this.displayPlayground();
                break;
                
            case "2": //
                this.displayMonkeyBars();
                break;
                
            case "3": //
                this.displayTreeStump();
                break;
                
            case "4": //
                this.displayDodgeballCourt();
                break;
                
            case "5": //
                this.displaySteps();
                break;
                
            case "6": //
                this.displayHopscotch();
                break;
                
            case "7": //
                this.displaySoccerField();
                break;
                
            //game options
                
            case "M": //View Map
                this.displayMap();
                break;
                
            case "V": // View marbles
                this.displayInventory();
                break;
            
            case "C": // Characters list
                this.displayActors();
                break;

            case "Q": // Quit Program
                return;

            default:
                System.out.println("\nInvalid Selection.");
                break;

        }
    }
        private void startNewGame(){

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
        helpMenu.display();

    }

    private void saveGame() {

        System.out.println("**** saveGame()called ***");

    }

    private void displayGoal() {
        System.out.println("**** displayGoal()called ***");    }

    private void displayInstructions() {
        System.out.println("**** displayInstructions() called ***");
    }

    private void displayAbout() {
        System.out.println("**** displayAbout() called ***");
    }
    
    private void displayPlayground() {
        
        StartTriviaView triviaView = new StartTriviaView();
        triviaView.startTrivia();
    }

    private void displayMonkeyBars() {
        NumberGameView numGame = new NumberGameView();
        numGame.numberGame();
    }

    private void displayTreeStump() {
        System.out.println("*** displayTreeStump function called ***");
    }

    private void displayDodgeballCourt() {
        
        RPSGameView rpsGame = new RPSGameView();
        rpsGame.startRPSGame();
        
    }

    private void displaySteps() {
        HomeworkHelpView homeworkHelp = new HomeworkHelpView();
        homeworkHelp.homeworkHelp();       
    }

    private void displayHopscotch() {
        System.out.println("*** displayHopscotch function called ***");
    }

    private void displaySoccerField() {
        System.out.println("*** displaySoccerField function called ***");
    }

    private void displayInventory() {
        //get the sorted list of marbles for the current game
        InventoryItem[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\nMarble Inventory");
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

    private void displayActors() {
        Actor[] characters = CitDavidJordan.getCurrentGame().getActors();
        
        // create similar for loop as the InventoryItem 
        // Name 
        // description
        // location or where they are situated
        // 
        
        
        System.out.println("\nActors");
        System.out.println("Name" + "\t" + 
                           "Description" + "\t" + 
                           "Location");
        
        for (Actor actor : characters) {
            
            System.out.println(actor.getDescription() + "\t\t " + 
                               actor.getName() + "\t " + 
                               actor.getLocation());
        }
    }

    private void displayMap() {
        
        Game game = CitDavidJordan.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        
        System.out.println("\n\t\t     **** MAP ****");
        System.out.println("\n\t     1" + "\t\t         2" + "\t\t     3");
        
        for (int row = 0; row < map.getNoOfRows(); row++) {
            System.out.print("\n-------------------------------------------------------------" +
                               "\n" + (row + 1) + "  ");
            for (int column = 0; column < map.getNoOfColumns(); column++){
                System.out.print(" | ");
                Location location = locations[row][column];
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
        mapView.display();
    }
}
