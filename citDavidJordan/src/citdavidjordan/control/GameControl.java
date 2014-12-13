/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.exceptions.GameControlException;
import citdavidjordan.model.Actor;
import citdavidjordan.model.Game;
import citdavidjordan.model.Map;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Item;
import citdavidjordan.model.Location;
import citdavidjordan.model.Player;
import citdavidjordan.model.Scene;
import citdavidjordan.model.SceneType;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author THERIAULT
 */
public class GameControl {

    public static Game createNewGame(Player player){

        Game game = new Game();
        CitDavidJordan.setCurrentGame(game);
        
        game.setPlayer(player);
        
        Actor[] actorList = GameControl.createActorList();
        game.setActors(actorList);
        
        Map map = MapControl.createMap(); //create new map
        game.setMap(map); //save map in game
        
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        InventoryItem[] naotosInventory = GameControl.createInventoryList();
        game.setNaotosInventory(naotosInventory);
        GameControl.adjustNaotosInventory(naotosInventory);
        
        MapControl.moveToStartingLocation(map);
        ActorControl.assignActorsToLocations(map, actorList);
        
        game.setBullyWatchYorN(false);
        game.setHomeworkCompleted(null);
        game.setTriviaCompleted(null);
        game.setSaveDate(null);
        
        
        
        return game;    }

    private static Actor[] createActorList() {
        // create actor list here
        Actor[] actorList = Actor.values();
        
        return actorList;
    }

    private static InventoryItem[] createInventoryList() {
        
        // create array list of inventory marbles
        InventoryItem[] inventory = new InventoryItem[3];
        
        InventoryItem swirly = new InventoryItem();
        swirly.setDescription("Swirly");
        swirly.setAmount(20);
        swirly.setValue(1);
        inventory[Item.swirly.ordinal()] = swirly;
        
        InventoryItem steely = new InventoryItem();
        steely.setDescription("Steely");
        steely.setAmount(5);
        steely.setValue(2);
        inventory[Item.steely.ordinal()] = steely;
        
        InventoryItem alley = new InventoryItem();
        alley.setDescription("Alley");
        alley.setAmount(0);
        alley.setValue(5);
        inventory[Item.alley.ordinal()] = alley;
        
        return inventory;

    }

    static void assignScenesToLocations(Map map, Scene[] scenes) {
        
        Location[][] locations = map.getLocations();
        
        //start point
        locations[0][0].setScene(scenes[SceneType.playground.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.monkeybars.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.treestump.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.dodgeballcourt.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.steps.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.hopscotch.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.soccerfield.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.cafeteria.ordinal()]);
        locations[2][2].setScene(null);
        
        //set Names
        locations[0][0].setLocationName("PlayGround");
        locations[0][1].setLocationName("Monkey Bars");
        locations[0][2].setLocationName("Tree Stump");
        locations[1][0].setLocationName("Dodgeball Court");
        locations[1][1].setLocationName("Steps");
        locations[1][2].setLocationName("Hopscotch");
        locations[2][0].setLocationName("Soccer Field");
        locations[2][1].setLocationName("Cafeteria");
        locations[2][2].setLocationName(null);
        //set descriptions
        locations[0][0].setDescription("Jerry's Trivia Challenge");
        locations[0][1].setDescription("Sally's Guess-A-Number Challenge");
        locations[0][2].setDescription("Sheldon's Shell Game");
        locations[1][0].setDescription("Rocky's Rock-Paper-Scissors");
        locations[1][1].setDescription("Help Johnny with Homework");
        locations[1][2].setDescription("Lucy's Bully-Watch");
        locations[2][0].setDescription("Buy Protection from Brock");
        locations[2][1].setDescription("Trade Marbles with Naoto");
        locations[2][2].setDescription(null);
    }
    

    public static InventoryItem[] getSortedInventoryList() {
        
        //get inventory of current game
        InventoryItem[] originalInventoryList = 
                CitDavidJordan.getCurrentGame().getInventory();
        
        //clone inventory list
        InventoryItem[] inventoryList = originalInventoryList.clone();
        
        //use bubblesort to sort inventory by name
        
        for (int i = 0; i < inventoryList.length-1; i++) {
            for (int j = 0; j < inventoryList.length-1-i; j++) {
                if (inventoryList[j].getValue() < inventoryList[j + 1].getValue()) {
                    InventoryItem tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j+1];
                    inventoryList[j+1] = tempInventoryItem;
                }
            }
        }
        return inventoryList;
    }

    private static void adjustNaotosInventory(InventoryItem[] naotoInventory) {
        
        naotoInventory[Item.swirly.ordinal()].setAmount(50);
        naotoInventory[Item.steely.ordinal()].setAmount(50);
        naotoInventory[Item.alley.ordinal()].setAmount(50);
        
    }

    public static void saveGame(Game currentGame, String filePath) throws GameControlException {
        try(FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(currentGame);
            //todo may need to write other objects if they aren't connected directly to the game
        } 
        catch(IOException e) {
            throw new GameControlException(e.getMessage());
        }
    }

    public static void loadGame(String filePath) throws GameControlException {
        
        Game game = null;
        
        try(FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream output = new ObjectInputStream(fips);
            
            game = (Game) output.readObject(); //read game object from file.
        }
        catch(FileNotFoundException fnfe) {
            throw new GameControlException(fnfe.getMessage());
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
        //close the output file
        CitDavidJordan.setCurrentGame(game);
    }

    

    
    
}
