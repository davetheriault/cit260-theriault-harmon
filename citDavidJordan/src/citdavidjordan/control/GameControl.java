/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.model.Game;
import citdavidjordan.model.Player;

/**
 *
 * @author THERIAULT
 */
public class GameControl {

    public static Game createNewGame(Player player) {

        Game game = new Game();
        game.setPlayer(player);
        game.setBullyWatchYorN(false);
        game.setHomeworkCompleted(null);
        game.setTriviaCompleted(null);
        game.setSaveDate(null);
        
        CitDavidJordan.setCurrentGame(game);
        
        return game;    }
    
}
