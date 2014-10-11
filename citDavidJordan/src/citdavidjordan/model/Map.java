/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Deann_2
 */
public class Map implements Serializable{
    private String mapDisplay;
    private String brodyLocation;

    public Map() {
    }

    public String getMapDisplay() {
        return mapDisplay;
    }

    public void setMapDisplay(String mapDisplay) {
        this.mapDisplay = mapDisplay;
    }

    public String getBrodyLocation() {
        return brodyLocation;
    }

    public void setBrodyLocation(String brodyLocation) {
        this.brodyLocation = brodyLocation;
    }

    @Override
    public String toString() {
        return "Map{" + "mapDisplay=" + mapDisplay + ", brodyLocation=" + brodyLocation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.mapDisplay);
        hash = 71 * hash + Objects.hashCode(this.brodyLocation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (!Objects.equals(this.mapDisplay, other.mapDisplay)) {
            return false;
        }
        if (!Objects.equals(this.brodyLocation, other.brodyLocation)) {
            return false;
        }
        return true;
    }
    
    
}
