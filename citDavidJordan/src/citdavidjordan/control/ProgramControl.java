/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.model.Player;
import citdavidjordan.model.Response;

/**
 *
 * @author THERIAULT
 */
public class ProgramControl {

    public static Player createPlayer(String playerName) {
        
        Player player = new Player();
        player.setName(playerName);
        
        CitDavidJordan.setPlayer(player);
        
        return player;
    }

    public static Response logResponse(String playerResponse) {
        System.out.println("**** Here is where we log the player's responses *** ");
        return null;
    }
    
}