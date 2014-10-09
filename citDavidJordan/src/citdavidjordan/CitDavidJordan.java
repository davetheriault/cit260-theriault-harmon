/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan;

import citdavidjordan.model.Player;

/**
 *
 * @author Deann_2
 */
public class CitDavidJordan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Steven Spielberg");
        playerOne.setMarbleTotal(10);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    } 
}
