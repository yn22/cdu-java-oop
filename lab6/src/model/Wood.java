package model;

import java.io.Serializable;

public class Wood implements Serializable {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(density);
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = true;
        result = obj instanceof Wood
                && this.id == ((Wood) obj).id
                && this.name.equals(((Wood) obj).name)
                && this.density == ((Wood) obj).density;

        return result;
    }

}
