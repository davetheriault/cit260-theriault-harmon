/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.SceneControl;
import citdavidjordan.exceptions.MapControlException;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.model.Actor;
import citdavidjordan.model.Game;
import citdavidjordan.model.Location;
import citdavidjordan.model.Map;
import citdavidjordan.model.Player;
import citdavidjordan.model.Scene;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author THERIAULT
 */
public class MapView {
    
    Game game = CitDavidJordan.getCurrentGame();
    Map map = CitDavidJordan.getCurrentGame().getMap();
    Location[][] location = map.getLocations();
    Player player = CitDavidJordan.getCurrentGame().getPlayer();
    
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
    private final String MENU = "\n"
            + "To move to a location on the map, type the row number \n"
            + "and then the column number, without any spaces. \n"
            + "(For example: \'11\' or \'32\')"
            + "\n(Q - Quit)"
            + "\n";
        
    public void displayMenu() throws Scene2NumberException, MarbleControlException, IOException {
        
        String selection = "";
        do {
            this.console.println(MENU); //display Menu
            try {
                selection = this.getInput(); // get the user selection
            } catch (MapControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());
                continue;
            }
            
            this.doAction(selection); //do action based on selection
           
        } while (!"Q".equals(selection)); //not Quit
        
    }
    
    /*@Override*/
    public String getInput() throws MapControlException, IOException {
        boolean valid = false; //indicates if name has been received
        String userSelection = null;
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            this.console.println("Where would you like to go?:");
            
            //get name from keyboard and trim off blanks
            userSelection = this.keyboard.readLine();
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

    public void doAction(String choice) throws Scene2NumberException, MarbleControlException {
        
        /*Map map = CitDavidJordan.getCurrentGame().getMap();
        Location[][] location = map.getLocations();
        Player player = CitDavidJordan.getCurrentGame().getPlayer();*/
        choice = choice.toUpperCase();

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
            if (brody.getLocation() == newPlayerLocation){
                SceneBrodyEncounterView brodyE = new SceneBrodyEncounterView();
                brodyE.display();
            }
            else {
                
                try {
                    player.setLocation(newPlayerLocation);
                    
                    //get scene to start view
                    Scene scene = newPlayerLocation.getScene();
                    SceneControl.startSceneView(scene);
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());}
            }
            }
        }
    }

    

    

    
