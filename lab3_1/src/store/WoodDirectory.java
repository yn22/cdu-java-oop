package store;

import model.Wood;

public class WoodDirectory extends AbstractStore {

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

    @Override
    public String toString() {
        return "WoodDirectory [" + super.toString() + "]";
    }

}
