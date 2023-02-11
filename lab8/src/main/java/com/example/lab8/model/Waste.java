package com.example.lab8.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Waste implements IWeight, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private float weight;

    public Waste(float weight) throws Exception {
        this.validateWeight(weight);
        this.weight = weight;
    }

    public Waste() {
        this.weight = 0;
    }

    private void validateWeight(float weight) throws Exception {
        return;
    }

    @Override
    public float weight() {
        return weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Waste [weight=" + weight + "]";
    }
}
