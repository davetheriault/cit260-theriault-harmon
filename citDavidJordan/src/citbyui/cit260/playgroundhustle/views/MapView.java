/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.playgroundhustle.views;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.SceneControl;
import citdavidjordan.exceptions.MapControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.model.Actor;
import citdavidjordan.model.Game;
import citdavidjordan.model.Location;
import citdavidjordan.model.Map;
import citdavidjordan.model.Player;
import citdavidjordan.model.Scene;
import citdavidjordan.model.SceneType;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THERIAULT
 */
public class MapView {
    
    Game game = CitDavidJordan.getCurrentGame();
    Map map = CitDavidJordan.getCurrentGame().getMap();
    Location[][] location = map.getLocations();
    Player player = CitDavidJordan.getCurrentGame().getPlayer();
    
    private final String MENU = "\n"
            + "To move to a location on the map, type the row number \n"
            + "and then the column number, without any spaces. \n"
            + "(For example: \'11\' or \'32\')"
            + "\n(Q - Quit)"
            + "\n";
        
    public void displayMenu() throws Scene2NumberException {
        
        String selection = "";
        do {
            System.out.println(MENU); //display Menu
            try {
                selection = this.getInput(); // get the user selection
            } catch (MapControlException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            
            this.doAction(selection); //do action based on selection
           
        } while (!"Q".equals(selection)); //not Quit
        
    }
    
    /*@Override*/
    public String getInput() throws MapControlException {
        boolean valid = false; //indicates if name has been received
        String userSelection = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            System.out.println("Where would you like to go?:");
            
            //get name from keyboard and trim off blanks
            userSelection = keyboard.nextLine();
            userSelection = userSelection.trim();
            userSelection = userSelection.toUpperCase();
            
            if (!"Q".equals(userSelection)) {
                userSelection = userSelection.replaceAll("[^0-9]", "");
            }
            
            //if name invalid
            if (userSelection.length() < 1) {
                throw new MapControlException("Invalid Selection.");
            
            } if (!"11".equals(userSelection) & !"12".equals(userSelection) 
                    & !"13".equals(userSelection) & !"21".equals(userSelection) 
                    & !"22".equals(userSelection) & !"23".equals(userSelection)
                    & !"31".equals(userSelection) & !"32".equals(userSelection) 
                    & !"33".equals(userSelection) & !"Q".equals(userSelection)){
                throw new MapControlException("Invalid Selection.");
            }
            
            break;
        }
        
        return userSelection;
    }

    public void doAction(String choice) throws Scene2NumberException {
        
        /*Map map = CitDavidJordan.getCurrentGame().getMap();
        Location[][] location = map.getLocations();
        Player player = CitDavidJordan.getCurrentGame().getPlayer();*/
        
        if ("Q".equals(choice)) {
            MenuGameView gameMenu = new MenuGameView();
            gameMenu.display();
        } else {
            char r = choice.charAt(0);
            char c = choice.charAt(1);
            int rowChoice = Character.getNumericValue(r)-1;
            int colChoice = Character.getNumericValue(c)-1;
        
            //set location and isVisited
            Location newPlayerLocation = location[rowChoice][colChoice];
            
            //check for a Brody Encounter
            Actor brody = Actor.Brody;
            if (newPlayerLocation == brody.getLocation()){
                Scene[] scene = null;
                SceneControl.startSceneView(scene[SceneType.brodyencounter.ordinal()]);
            }
            else {
            
            newPlayerLocation.setVisited(true);
            player.setLocation(newPlayerLocation);
            
            //get scene to start view
            Scene scene = newPlayerLocation.getScene();
            SceneControl.startSceneView(scene);
            }
        }
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
            System.out.println("Where would you like to go?:");
            
            //get name from keyboard and trim off blanks
            userSelection = keyboard.nextLine();
            userSelection = userSelection.trim();
            userSelection = userSelection.toUpperCase();
            
            //if name invalid
            if (userSelection.length() < 1) {
                System.out.println("Invalid Selection.");
                continue;
            } if (!"1".equals(userSelection) & !"2".equals(userSelection) 
                    & !"3".equals(userSelection) & !"4".equals(userSelection) 
                    & !"5".equals(userSelection) & !"6".equals(userSelection)
                    & !"7".equals(userSelection) & !"Q".equals(userSelection)){
                System.out.println("Invalid Selection.");
                continue;
            }
            
            break;
        }
        
        return userSelection;
    }

    private void doAction(char choice) {
        
        switch (choice) {
            case '1': //display Goal of Game
                this.displayPlayground();
                break;
            case '2': //
                this.displayMonkeyBars();
                break;
            case '3': //
                this.displayTreeStump();
                break;
            case '4': //
                this.displayDodgeballCourt();
                break;
            case '5': //
                this.displaySteps();
                break;
            case '6': //
                this.displayHopscotch();
                break;
            case '7': //
                this.displaySoccerField();
                break;
            case 'Q': // Quit Program
                return;
            default:
                System.out.println("\n*** Invalid Selection ***");
                break;
                
        }
        
       
    }

    private void displayPlayground() {
        
        StartTriviaView triviaView = new StartTriviaView();
        triviaView.startTrivia();
    }

    private void displayMonkeyBars() {
        System.out.println("*** displayMonkeyBars function called ***");
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
    } */

    
