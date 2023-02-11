package model;

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

    @Override
    public String toString() {
        return "Waste [weight=" + weight + "]";
    }
}
