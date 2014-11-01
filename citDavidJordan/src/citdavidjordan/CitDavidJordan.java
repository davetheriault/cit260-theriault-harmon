/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan;

import citdavidjordan.model.Actor;
import citdavidjordan.model.Game;
import citdavidjordan.model.Location;
import citdavidjordan.model.Map;
import citdavidjordan.model.Path;
import citdavidjordan.model.Player;
import citdavidjordan.model.Response;
import citdavidjordan.model.Scene;
import citdavidjordan.view.StartProgramView;
import static citdavidjordan.view.StartProgramView.startProgramView;
import citdavidjordan.view.StartTriviaView;
import static citdavidjordan.view.StartTriviaView.startTriviaView;

/**
 *
 * @author Deann_2
 */
public class CitDavidJordan {
    
    private static Game currentGame = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        CitDavidJordan.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        CitDavidJordan.player = player;
    }
    private static Player player = null;
    
    public static void main(String[] args) {
        
        //***** TEST StartProgram() ********
        
        //remove this comment to run StartProgramView
        // StartProgramView.startProgramView = new StartProgramView();
        // startProgramView.startProgram();
        
        // *** test Response Class ***
        // Response responseOne = new Response();
        
        // responseOne.setResponse("A");
        
        // String responseInfo = responseOne.toString();
        // System.out.println(responseInfo);
        
        //***test Player class***
        /*Player playerOne = new Player();
        
        playerOne.setName("Steven Spielberg");
        playerOne.setMarbleTotal(10);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
        //***test Game Class*** by David
        Game gameOne = new Game();
        
        gameOne.setPlayer(playerOne);
        gameOne.setTriviaCompleted("testTrivia");
        gameOne.setHomeworkCompleted("testHomework");
        gameOne.setBullyWatchYorN(true);
        gameOne.setSaveDate("10/10/2014");
        
        String gameInfo = gameOne.toString();
        System.out.println(gameInfo);
        
        //***test Path Class*** by David
        Path pathOne = new Path();
        
        pathOne.setPathNo(4);
        
        String pathInfo = pathOne.toString();
        System.out.println(pathInfo);
        
         //***test Actor class*** by David
        Actor actorOne = new Actor();
        
        actorOne.setActorNo(1);
        
        String actorInfo = actorOne.toString();
        System.out.println(actorInfo);
        
        Map gameMap = new Map();
        
        gameMap.setMapDisplay("playerLocation");
        gameMap.setBrodyLocation("randomLocation");
        
        String mapInfo = gameMap.toString();
        System.out.println(mapInfo);
        
        Scene sceneOne = new Scene();
        
        sceneOne.setSceneNo(2);
        sceneOne.setType("testType");
        
        String sceneInfo = sceneOne.toString();
        System.out.println(sceneInfo);
        
        Location locationOne = new Location();
        
        locationOne.setLocationNo(3);
        
        String locationInfo = locationOne.toString();
        System.out.println(locationInfo); */
        
       StartTriviaView.startTriviaView = new StartTriviaView();
       startTriviaView.startTrivia();
        
    } 
    
}
