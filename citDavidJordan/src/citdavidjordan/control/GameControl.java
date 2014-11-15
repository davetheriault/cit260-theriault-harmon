/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.model.Actor;
import citdavidjordan.model.Game;
import citdavidjordan.model.Map;
import citdavidjordan.model.InventoryItem;
import citdavidjordan.model.Item;
import citdavidjordan.model.Location;
import citdavidjordan.model.Player;
import citdavidjordan.model.Scene;
import citdavidjordan.model.SceneType;

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
        
        MapControl.moveToStartingLocation(map);
        
        game.setBullyWatchYorN(false);
        game.setHomeworkCompleted(null);
        game.setTriviaCompleted(null);
        game.setSaveDate(null);
        
        
        
        return game;    }

    private static Actor[] createActorList() {
        System.out.println("**** Called createActorList function ***");
        return null;
    }

    private static InventoryItem[] createInventoryList() {
        
        // create array list of inventory marbles
        InventoryItem[] inventory = new InventoryItem[3];
        
        InventoryItem swirly = new InventoryItem();
        swirly.setDescription("Swirly");
        swirly.setAmount(0);
        swirly.setValue(1);
        inventory[Item.swirly.ordinal()] = swirly;
        
        InventoryItem steely = new InventoryItem();
        steely.setDescription("Steely");
        steely.setAmount(0);
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
        locations[2][1].setScene(scenes[SceneType.brodyencounter.ordinal()]);
        locations[2][2].setScene(null);
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

    
    
}
