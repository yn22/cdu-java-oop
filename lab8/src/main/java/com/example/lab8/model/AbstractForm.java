package com.example.lab8.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractForm implements IWeight, Serializable {
    @ManyToOne(optional = false)
    @JoinColumn(name = "wood_id")
    Wood wood;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public AbstractForm(Wood wood) {
        this.wood = wood;
    }

    public AbstractForm() {

    }
    public abstract float volume();

    @Override
    public float weight() {
        return volume() * wood.getDensity();
    }

    public float getWeight() {
        return weight();
    }

    public float getVolume() {
        return volume();
    }

    public Wood getWood() {
        return wood;
    }

    public float getLength() {
        return 0;
    }

    public float getWidth() {
        return 0;
    }

    public float getHeight() {
        return 0;
    }

    public float getDiameter() {
        return 0;
    }

    public abstract String getType();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
