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
public class Scene implements Serializable{
    private int sceneNo;
    private String type;

    public Scene() {
    }

    public int getSceneNo() {
        return sceneNo;
    }

    public void setSceneNo(int sceneNo) {
        this.sceneNo = sceneNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Scene{" + "sceneNo=" + sceneNo + ", type=" + type + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.sceneNo);
        hash = 97 * hash + Objects.hashCode(this.type);
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
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.sceneNo, other.sceneNo)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }
}
