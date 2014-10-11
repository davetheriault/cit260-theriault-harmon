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
public class Actor implements Serializable {
    
    //***attributes***
    private int actorNo;
    
    //***constructor function***
    public Actor() {
    }
    
    //***getters and setters***

    public int getActorNo() {
        return actorNo;
    }

    public void setActorNo(int actorNo) {
        this.actorNo = actorNo;
    }

    @Override
    public String toString() {
        return "Actor{" + "actorNo=" + actorNo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.actorNo;
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
        final Actor other = (Actor) obj;
        if (this.actorNo != other.actorNo) {
            return false;
        }
        return true;
    }
    
    
    
}
