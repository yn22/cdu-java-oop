package model;

public class Cylinder extends AbstractForm{
    private final float length;
    private final float diameter;

    public Cylinder(Wood wood, float length, float diameter) {
        super(wood);
        this.length = length;
        this.diameter = diameter;
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
