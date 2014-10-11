/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.model;

import java.io.Serializable;

/**
 *
 * @author Deann_2
 */
public class Player implements Serializable { 
    private String name;
    private int marbleTotal;

    public Player() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getMarbleTotal() {
        return marbleTotal;
    }
    
    public void setMarbleTotal(int marbleTotal) {
        this.marbleTotal = marbleTotal;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", marbleTotal=" + marbleTotal + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.marbleTotal;
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.marbleTotal != other.marbleTotal) {
            return false;
        }
        return true;
    }    
}