/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.model.Game;
import citdavidjordan.model.Map;
import citdavidjordan.model.Scene;
import citdavidjordan.model.SceneType;

/**
 *
 * @author THERIAULT
 */
public class MapControl {

    static Map createMap() throws MapControlException {
        
        Map map = new Map(3, 3);
        
        Scene[] scenes = createScenes();
        
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
        
       }

    static void moveToStartingLocation(Map map) {
        System.out.println("*** called a function called moveToStartingLocation ***");
        
    }

    private static Scene[] createScenes() throws MapControlException {
        
        Game game = CitDavidJordan.getCurrentGame();
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene startingScene = new Scene();
        startingScene.setDescription("Insert Text Here");
        scenes[SceneType.start.ordinal()] = startingScene;
        
        Scene playgroundScene = new Scene();
        playgroundScene.setDescription("Insert Text Here");
        scenes[SceneType.playground.ordinal()] = playgroundScene;
        
        Scene monkeyBarsScene = new Scene();
        monkeyBarsScene.setDescription("Insert Text Here");
        scenes[SceneType.monkeybars.ordinal()] = monkeyBarsScene;
        
        Scene treeStumpScene = new Scene();
        treeStumpScene.setDescription("Insert Text Here");
        scenes[SceneType.treestump.ordinal()] = treeStumpScene;
        
        System.out.println("*** called a function called createScenes ***");
        return null;
    }
    
}
