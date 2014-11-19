/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.model.Actor;
import citdavidjordan.model.Location;
import citdavidjordan.model.Map;
import java.util.Arrays;

/**
 *
 * @author THERIAULT
 */
class ActorControl {

    static void assignActorsToLocations(Map map, Actor[] actorList) {
        
        Location[][] location = map.getLocations();
        Actor.Jerry.setLocation(location[0][0]);
        Actor.Sally.setLocation(location[0][1]);
        Actor.Sheldon.setLocation(location[0][2]);
        Actor.Rocky.setLocation(location[1][0]);
        Actor.Johnny.setLocation(location[1][1]);
        Actor.Lucy.setLocation(location[1][2]);
        Actor.Brock.setLocation(location[2][0]);
        Actor.Naoto.setLocation(location[2][1]);
        Actor.Brody.setLocation(null);
        
        
    }
    
    
    
}
