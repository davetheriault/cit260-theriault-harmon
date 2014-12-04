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
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author THERIAULT
 */
public class MapControl {
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();

    static Map createMap() {
        
        Map map = new Map(3, 3);
        
        Scene[] scenes = createScenes();
        
        CitDavidJordan.getCurrentGame().setScenes(scenes);
        GameControl.assignScenesToLocations(map, scenes);
        
        
        return map;
        
       }

    static void moveToStartingLocation(Map map) {
        System.out.println("*** called a function called moveToStartingLocation ***");
        
    }

    private static Scene[] createScenes() {
        
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
        
        Scene dodgeballCourtScene = new Scene();
        dodgeballCourtScene.setDescription("Insert Text Here");
        scenes[SceneType.dodgeballcourt.ordinal()] = dodgeballCourtScene;
        
        Scene stepsScene = new Scene();
        stepsScene.setDescription("Insert Text Here");
        scenes[SceneType.steps.ordinal()] = stepsScene;
        
        Scene hopscotchScene = new Scene();
        hopscotchScene.setDescription("Insert Text Here");
        scenes[SceneType.hopscotch.ordinal()] = hopscotchScene;
        
        Scene soccerFieldScene = new Scene();
        soccerFieldScene.setDescription("Insert Text Here");
        scenes[SceneType.soccerfield.ordinal()] = soccerFieldScene;
        
        Scene brodyEncounterScene = new Scene();
        brodyEncounterScene.setDescription("Insert Text Here");
        scenes[SceneType.brodyencounter.ordinal()] = brodyEncounterScene;
        
        return scenes;
        
    }
    
}
