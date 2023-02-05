package model;

public class Timber extends AbstractForm {

    private final float length;
    private final float width;
    private final float height;

    public Timber(Wood wood, float length, float width, float height) {
        super(wood);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public float volume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return "Timber [wood=" + wood + ", length=" + length + ", width=" + width + ", height=" + height + ", volume()="
                + volume() + ", weight()=" + weight() + "]";
    }
}
