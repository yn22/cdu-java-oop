package com.example.lab8.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
@Entity
@DiscriminatorValue("CYLINDER")
public class Cylinder extends AbstractForm implements Serializable {
    private float length;
    private float diameter;

    public Cylinder(Wood wood, float length, float diameter) throws Exception {
        super(wood);
        this.validateData(length, diameter);
        this.length = length;
        this.diameter = diameter;
    }

    public Cylinder(float length, float diameter) {

        this.length = length;
        this.diameter = diameter;
    }

    public Cylinder() {
        this.length = 0;
        this.diameter = 0;
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

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public String getType() {
        return "CYLINDER";
    }

    public void setType(String type) {
        // do nothing
    }

    @Override
    public String toString() {
        return "Cylinder [wood=" + wood + ", length=" + length + ", diameter=" + diameter + ", volume()="
                + volume() + ", weight()=" + weight() + "]";
    }
}
