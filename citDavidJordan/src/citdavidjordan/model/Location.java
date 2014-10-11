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
public class Location implements Serializable{
    private int locationNo;

    public Location() {
    }

    public int getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(int locationNo) {
        this.locationNo = locationNo;
    }

    @Override
    public String toString() {
        return "Location{" + "location=" + locationNo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.locationNo);
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.locationNo, other.locationNo)) {
            return false;
        }
        return true;
    }
}
