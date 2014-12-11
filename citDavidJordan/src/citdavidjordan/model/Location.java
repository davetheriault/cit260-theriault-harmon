/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Deann_2
 */
public class Location implements Serializable{
    
    /*playground("Jerry's Trivia Challenge", "Playground"),
    monkeyBars("Sally's Guess-A-Number Challenge", "Monkey Bars"),
    treeStump("Sheldon's Shell Game", "Tree Stump"),
    dodgeballCourt("Rocky's Rock-Paper-Scissors", "Dodgeball Court"),
    steps("Help Johnny with Homework", "Steps"),
    hopscotch("Lucy's Bully-Watch", "Hopscotch"),
    soccerField("Buy Protection from Brock", "Soccer Field");
    */
    
    
    private String locationName;
    private String description;
    private int row;
    private int column;
    private boolean visited;
    private Scene scene;
    private ArrayList<Actor> actors;

    public Location(/*String description, String locationName*/) {
        //this.description = description;
        //this.locationName = locationName;
    }
    
    
    
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDescription() {
        return description;
    }

    //getters and setters
    public void setDescription(String description) {
        this.description = description;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }
    
    
}
