package model;

public class Waste implements IWeight {
    private float weight;

    public Waste(float weight) {
        this.weight = weight;
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
