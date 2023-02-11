package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Wood implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private float density;

    public Wood(String name, float density) {
        this.name = name;
        this.density = density;
    }

    public Wood() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public float getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return "Wood [id=" + id + ", name=" + name + ", density=" + density + "]";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
