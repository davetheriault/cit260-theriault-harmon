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
 * @author THERIAULT
 */
public class Path implements Serializable {
    
    //***attributes***
    private int pathNo;
    
    //***constructor function***
    public Path() {
    }
    
    //***getters and setters***
    public int getPathNo() {
        return pathNo;
    }

    public void setPathNo(int pathNo) {
        this.pathNo = pathNo;
    }

    @Override
    public String toString() {
        return "Path{" + "pathNo=" + pathNo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.pathNo;
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
        final Path other = (Path) obj;
        if (this.pathNo != other.pathNo) {
            return false;
        }
        return true;
    }
    
    
}
