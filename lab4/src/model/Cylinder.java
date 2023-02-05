package model;

import java.io.Serializable;

public class Cylinder extends AbstractForm implements Serializable {
    private final float length;
    private final float diameter;

    public Cylinder(Wood wood, float length, float diameter) throws Exception {
        super(wood);
        this.validateData(length, diameter);
        this.length = length;
        this.diameter = diameter;
    }

    private void validateData(float length, float diameter) throws Exception {
        if (length <= 0 || diameter <= 0) {
            throw new IllegalArgumentException("Length and diameter must be greater than 0.");
        }
    }

    @Override
    public float volume() {
        return (float) (Math.PI * Math.pow(diameter / 2, 2) * length);
    }

    @Override
    public String toString() {
        return "Cylinder [wood=" + wood + ", length=" + length + ", diameter=" + diameter + ", volume()="
                + volume() + ", weight()=" + weight() + "]";
    }
}
