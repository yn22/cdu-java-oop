package com.example.lab8.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
@Entity
@DiscriminatorValue("TIMBER")
public class Timber extends AbstractForm implements Serializable {
    private float length;
    private float width;
    private float height;

    public Timber(Wood wood, float length, float width, float height) throws Exception {
        super(wood);
        this.validateData(length, width, height);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Timber() {
        this.length = 0;
        this.width = 0;
        this.height = 0;
    }

    private void validateData(float length, float width, float height) throws Exception {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new Exception("Length, width and height must be greater than 0.");
        }
    }

    public float volume() {
        return length * width * height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String getType() {
        return "TIMBER";
    }

    public void setType(String type) {
        // do nothing
    }

    @Override
    public String toString() {
        return "Timber [wood=" + wood + ", length=" + length + ", width=" + width + ", height=" + height + ", volume()="
                + volume() + ", weight()=" + weight() + "]";
    }
}
