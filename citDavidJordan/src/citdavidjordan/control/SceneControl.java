/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.model.Scene;
import citdavidjordan.model.SceneType;
import citdavidjordan.view.Scene2NumberView;
import citdavidjordan.view.Scene4RPSView;
import citdavidjordan.view.Scene1TriviaView;
import citdavidjordan.view.Scene3ShellView;
import citdavidjordan.view.Scene5HomeworkView;
import citdavidjordan.view.Scene6BullyWatchView;
import citdavidjordan.view.Scene7PayBrockView;
import citdavidjordan.view.SceneBrodyEncounterView;
import java.io.IOException;

/**
 *
 * @author THERIAULT
 */
public class SceneControl {
    
    static Scene[] scenes = CitDavidJordan.getCurrentGame().getScenes();
    public static void startSceneView(Scene scene) throws Scene2NumberException, MarbleControlException, IOException {
        
        if (scene == scenes[SceneType.playground.ordinal()]) {
            Scene1TriviaView triviaView = new Scene1TriviaView();
            triviaView.start();
        } 
        if (scene == scenes[SceneType.monkeybars.ordinal()]) {
            Scene2NumberView numGame = new Scene2NumberView();
            numGame.start();
        }
        if (scene == scenes[SceneType.treestump.ordinal()]) {
            Scene3ShellView shellGame = new Scene3ShellView();
            shellGame.display();
        }
        if (scene == scenes[SceneType.dodgeballcourt.ordinal()]) {
            Scene4RPSView rpsGame = new Scene4RPSView();
            rpsGame.start();
        }
        if (scene == scenes[SceneType.steps.ordinal()]) {
            Scene5HomeworkView hhGame = new Scene5HomeworkView();
            hhGame.start();
        }
        if (scene == scenes[SceneType.hopscotch.ordinal()]) {
            Scene6BullyWatchView bWatch = new Scene6BullyWatchView();
            bWatch.display();
        }
        if (scene == scenes[SceneType.soccerfield.ordinal()]) {
            Scene7PayBrockView pBrock = new Scene7PayBrockView();
            pBrock.start();
        }
        if (scene == scenes[SceneType.brodyencounter.ordinal()]) {
            SceneBrodyEncounterView brodyE = new SceneBrodyEncounterView();
            brodyE.display();
        }
    }
    
}
