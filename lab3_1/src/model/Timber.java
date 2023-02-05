package model;

public class Timber extends AbstractForm {

    private final float length;
    private final float width;
    private final float height;

    public Timber(Wood wood, float length, float width, float height) throws Exception {
        super(wood);
        this.validateData(length, width, height);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    private void validateData(float length, float width, float height) throws Exception {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new Exception("Length, width and height must be greater than 0.");
        }
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
