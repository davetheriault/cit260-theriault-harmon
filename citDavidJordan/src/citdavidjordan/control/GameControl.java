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
import citdavidjordan.model.Player;
import citdavidjordan.model.Scene;

/**
 *
 * @author THERIAULT
 */
public class GameControl {

    public static Game createNewGame(Player player) {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
