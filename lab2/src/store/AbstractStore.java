package store;

import model.IWeight;

import java.util.ArrayList;

public class AbstractStore {
    protected final ArrayList<Object> arr = new ArrayList<>();

    public ArrayList<Object> getArr() {
        return arr;
    }

    protected void add(Object newIWeight) {
        arr.add(newIWeight);
    }

    public float calcWeight() {
        float fullWeight = 0;
        for (Object rawObj: arr) {
            IWeight obj = (IWeight) rawObj;
            fullWeight += obj.weight();
        }
        return fullWeight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Каталог продукції:\n");
        for (Object obj : arr) {
            sb.append(obj).append("\n");
        }
        return sb.toString();
    }

}
