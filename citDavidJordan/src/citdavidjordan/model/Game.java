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
public class Game implements Serializable {
    
    //***attributes***
    private double totalTime;
    private Player player;
    private Map map;
    private Location[] location;
    private Actor[] actors;
    private InventoryItem[] inventory;
    private InventoryItem[] naotosInventory;
    private Scene[] scenes;

    private String triviaCompleted;
    private String homeworkCompleted;
    private boolean bullyWatchYorN;
    private String saveDate;

    //***constructor function***
    public Game() {
    }
    
    //***getters and setters***

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Location[] getLocation() {
        return location;
    }

    public void setLocation(Location[] location) {
        this.location = location;
    }

    public Actor[] getActors() {
        return actors;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getTriviaCompleted() {
        return triviaCompleted;
    }

    public void setTriviaCompleted(String triviaCompleted) {
        this.triviaCompleted = triviaCompleted;
    }

    public String getHomeworkCompleted() {
        return homeworkCompleted;
    }

    public void setHomeworkCompleted(String homeworkCompleted) {
        this.homeworkCompleted = homeworkCompleted;
    }

    public boolean isBullyWatchYorN() {
        return bullyWatchYorN;
    }

    public void setBullyWatchYorN(boolean bullyWatchYorN) {
        this.bullyWatchYorN = bullyWatchYorN;
    }

    public String getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(String saveDate) {
        this.saveDate = saveDate;
    }

    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }

    public InventoryItem[] getNaotosInventory() {
        return naotosInventory;
    }

    public void setNaotosInventory(InventoryItem[] naotosInventory) {
        this.naotosInventory = naotosInventory;
    }

    public Scene[] getScenes() {
        return scenes;
    }

    public void setScenes(Scene[] scenes) {
        this.scenes = scenes;
    }


   
    
    @Override
    public String toString() {
        return "Game{" + "player=" + player + ", triviaCompleted=" + triviaCompleted + ", homeworkCompleted=" + homeworkCompleted + ", bullyWatchYorN=" + bullyWatchYorN + ", saveDate=" + saveDate + '}';
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.player);
        hash = 53 * hash + Objects.hashCode(this.triviaCompleted);
        hash = 53 * hash + Objects.hashCode(this.homeworkCompleted);
        hash = 53 * hash + (this.bullyWatchYorN ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.saveDate);
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.triviaCompleted, other.triviaCompleted)) {
            return false;
        }
        if (!Objects.equals(this.homeworkCompleted, other.homeworkCompleted)) {
            return false;
        }
        if (this.bullyWatchYorN != other.bullyWatchYorN) {
            return false;
        }
        if (!Objects.equals(this.saveDate, other.saveDate)) {
            return false;
        }
        return true;
    }
    
    
}
