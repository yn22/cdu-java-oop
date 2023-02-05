package model;

import java.io.Serializable;

public abstract class AbstractForm implements IWeight, Serializable {
    Wood wood;

    public AbstractForm(Wood wood) {
        this.wood = wood;
    }

    public abstract float volume();

    @Override
    public float weight() {
        return volume() * wood.getDensity();
    }
}
