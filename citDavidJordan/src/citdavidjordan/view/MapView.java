/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.SceneControl;
import citdavidjordan.model.Location;
import citdavidjordan.model.Map;
import citdavidjordan.model.Player;
import citdavidjordan.model.Scene;
import java.util.Scanner;

/**
 *
 * @author THERIAULT
 */
public class MapView {
    
    private final String MENU = "\n"
            + "To move to a location on the map, type the row number \n"
            + "and then the column number, without any spaces. \n"
            + "(For example: \'11\' or \'32\')"
            + "\n(Q - Quit)"
            + "\n";
        
    public void displayMenu() {
        
        String selection = "";
        do {
            System.out.println(MENU); //display Menu
            
            selection = this.getInput(); // get the user selection
            
            this.doAction(selection); //do action based on selection
           
        } while (!"Q".equals(selection)); //not Quit
        
        
    }
    
    /*@Override*/
    public String getInput() {
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
                System.out.println("Invalid Selection.");
                continue;
            } if (!"11".equals(userSelection) & !"12".equals(userSelection) 
                    & !"13".equals(userSelection) & !"21".equals(userSelection) 
                    & !"22".equals(userSelection) & !"23".equals(userSelection)
                    & !"31".equals(userSelection) & !"32".equals(userSelection) 
                    & !"33".equals(userSelection) & !"Q".equals(userSelection)){
                System.out.println("Invalid Selection.");
                continue;
            }
            
            break;
        }
        
        return userSelection;
    }

    public void doAction(String choice) {
        
        if ("Q".equals(choice)) {
            return;
        } else {
            char r = choice.charAt(0);
            char c = choice.charAt(1);
            int rowChoice = Character.getNumericValue(r)-1;
            int colChoice = Character.getNumericValue(c)-1;
        
        
            Map map = CitDavidJordan.getCurrentGame().getMap();
            Location[][] location = map.getLocations();
            Player player = CitDavidJordan.getCurrentGame().getPlayer();
        
            Location newPlayerLocation = location[rowChoice][colChoice];
            newPlayerLocation.setVisited(true);
            player.setLocation(newPlayerLocation);
            
            Scene scene = newPlayerLocation.getScene();
            SceneControl.startSceneView(scene);
            
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

    
