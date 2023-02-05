package model;

public class Wood {
    private int id;
    private String name;
    private float density;

    public Wood(int id, String name, float density) {
        this.id = id;
        this.name = name;
        this.density = density;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return "Wood [id=" + id + ", name=" + name + ", density=" + density + "]";
    }
}
