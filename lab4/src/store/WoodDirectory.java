package store;

import model.Wood;

import java.io.Serializable;

public class WoodDirectory extends AbstractStore implements Serializable {

    public Wood get(int id) {
        for (Object rawObj : arr) {
            Wood obj = (Wood) rawObj;
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    public boolean add(Wood newWood) {
        if (this.get(newWood.getId()) != null) {
            return false;
        }
        super.add(newWood);
        return true;
    }

    public void serialize() {
        super.serialize("woodDirectory.object");
    }

    public void deserialize() {
        super.deserialize("woodDirectory.object");
    }

    @Override
    public String toString() {
        return "WoodDirectory [" + super.toString() + "]";
    }

}
