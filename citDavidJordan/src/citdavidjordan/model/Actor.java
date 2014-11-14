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
public enum Actor implements Serializable {
    
    Brody("Brody is a bully. \nHe was held back from last year and now he's in your class. \nYou are the main target of his bullying."),
    Brock("Brock is a big dumb brute in the 6th grade. \nHe is undoubtedly the oldest kid in school... by far. \nBrock has noticed your problem with Brody, and he has offered to take care of Brody for you. \nIn return, he requires a payment of X marbles."), //todo specify number of marbles <--
    Rocky("Rocky is a 4th grader who is obssessed \nwith the game 'Rock Paper Scissors'. \nHe spends his lunch hours challenging other kids to play against him for marbles."),
    Jerry("Jerry is what you might call a \"super nerd\". \nHe likes to spend his time challenging the knowledge of the other kids. \nHe enjoys the feeling of superiority it gives him when he knows something that others don't. \nHe will wager marbles that you can't answer his simple trivia questions correctly."),
    Sally("Sally is kind of different from other kids. Maybe it's from always \nhanging upside down from the monkeybars at school. ");
    
    
    
    //***attributes***
    private final int actorNo;
    private final String description;
    private final String location;
    
    //***constructor function***
    Actor(String description) {
        this.description = description;
        location = null;
    }
    
    //***getters and setters***

    public int getActorNo() {
        return actorNo;
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
