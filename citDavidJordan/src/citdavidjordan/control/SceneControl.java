/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.model.Scene;
import citdavidjordan.model.SceneType;
import citdavidjordan.view.NumberGameView;
import citdavidjordan.view.RPSGameView;
import citdavidjordan.view.StartTriviaView;

/**
 *
 * @author THERIAULT
 */
public class SceneControl {
    
    static Scene[] scenes = CitDavidJordan.getCurrentGame().getScenes();
    public static void startSceneView(Scene scene) {
        
        if (scene == scenes[SceneType.playground.ordinal()]) {
            StartTriviaView triviaView = new StartTriviaView();
            triviaView.startTrivia();
        } 
        if (scene == scenes[SceneType.monkeybars.ordinal()]) {
            NumberGameView numGame = new NumberGameView();
            numGame.numberGame();
        }
        if (scene == scenes[SceneType.dodgeballcourt.ordinal()]) {
            RPSGameView rpsGame = new RPSGameView();
            rpsGame.startRPSGame();
        }
        
    }
    
}
