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
    
    Jerry("Jerry is what you might call a \"super nerd\". \nHe likes to spend his time challenging the knowledge of the other kids. \nHe enjoys the feeling of superiority it gives him when he knows something that others don't. \nHe will wager marbles that you can't answer his simple trivia questions correctly.", "Jerry's Trivia Challenge"),
    Sally("Sally is kind of different from other kids. Maybe it's from always \nhanging upside down from the monkeybars at school. ", "Sally's Guess-A-Number Challenge"),
    Sheldon("...", "Sheldon's Shell Game"),
    Rocky("Rocky is a 4th grader who is obssessed \nwith the game 'Rock Paper Scissors'. \nHe spends his lunch hours challenging other kids to play against him for marbles.", "Rocky's Rock-Paper-Scissors"),
    Johnny("... Steps", "Help Johnny with Homework"),
    Lucy("... hopscotch", "Lucy's Bully-Watch"),
    Brody("Brody is a bully. \nHe was held back from last year and now he's in your class. \nYou are the main target of his bullying.", ""),
    Brock("Brock is a big dumb brute in the 6th grade. \nHe is undoubtedly the oldest kid in school... by far. \nBrock has noticed your problem with Brody, and he has offered to take care of Brody for you. \nIn return, he requires a payment of 20 alley marbles.", "Buy Protection from Brock"), //todo specify number of marbles <--
    Naoto("Naoto is a Japanese kid...", "Trade Marbles with Naoto")
    ;
    
    
    
    //***attributes***
    private final String description;
    private Location location;
    private final String gameName;
    
    //***constructor function***
    Actor(String description, String gameName) {
        this.description = description;
        this.gameName = gameName;
        location = null;
    }
    
    //***getters and setters***

    
    public String getDescription() {
        return description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getGameName() {
        return gameName;
    }

    

      
}
    
    
    

