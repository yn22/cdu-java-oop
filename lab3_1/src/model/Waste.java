package model;

public class Waste implements IWeight {
    private float weight;

    public Waste(float weight) throws Exception {
        this.validateWeight(weight);
        this.weight = weight;
    }

    private void validateWeight(float weight) throws Exception {
        if (weight <  0.02 || weight > 0.1) {
            throw new Exception(weight + " is not a valid weight for waste. It must be between 0.02 and 0.1.");
        }
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
