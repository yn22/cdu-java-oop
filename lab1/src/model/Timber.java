package model;

public class Timber {
    private Wood wood;
    private float length;
    private float width;
    private float height;

    public Timber(Wood wood, float length, float width, float height) {
        this.wood = wood;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public float volume() {
        return length * width * height;
    }

    public float weight() {
        return volume() * wood.getDensity();
    }

    @Override
    public String toString() {
        return "Timber [wood=" + wood + ", length=" + length + ", width=" + width + ", height=" + height + ", volume()="
                + volume() + ", weight()=" + weight() + "]";
    }
}
