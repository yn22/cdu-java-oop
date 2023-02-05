package store;

import model.IWeight;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AbstractStore implements Serializable {
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

    public void serialize(String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deserialize(String fileName) {
        try {
            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(
                    new java.io.FileInputStream(fileName));
            AbstractStore obj = (AbstractStore) ois.readObject();
            ois.close();
            this.arr.clear();
            this.arr.addAll(obj.arr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String fileName) {
        try {
            java.io.PrintWriter pw = new java.io.PrintWriter(fileName);
            pw.println(this);
            pw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
