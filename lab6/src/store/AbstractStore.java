package store;

import model.IWeight;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AbstractStore implements Serializable, Iterable<Object> {
    protected final ArrayList<Object> arr = new ArrayList<>();

    @Override
    public Iterator<Object> iterator() {
        return new StoreIterator();
    }
    public ListIterator<Object> listIterator() {
        return new ListStoreIterator();
    }

    public ArrayList<Object> getArr() {
        return arr;
    }

    protected void add(Object newIWeight) {
        arr.add(newIWeight);
    }

    public void remove(Predicate<Object> predicate) {
        Iterator<Object> iterator = this.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (predicate.test(obj)) {
                iterator.remove();
            }
        }
    }

    public void doForAll(Consumer<Object> consumer) {
        for (Object obj : this) {
            consumer.accept(obj);
        }
    }

    public void doOnlyFor(Consumer<Object> consumer, Predicate<Object> predicate) {
        for (Object obj : this) {
            if (predicate.test(obj)) {
                consumer.accept(obj);
            }
        }
    }

    public float calcWeight() {
        float fullWeight = 0;
        for (Object rawObj : arr) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String fileName) {
        try {
            java.io.PrintWriter pw = new java.io.PrintWriter(fileName);
            pw.println(this);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Каталог продукції:\n");
        for (Object obj : this) {
            sb.append(obj).append("\n");
        }
        return sb.toString();
    }

    private class StoreIterator implements Iterator<Object> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < arr.size();
        }

        @Override
        public Object next() {
            return arr.get(index++);
        }

        @Override
        public void remove() {
            arr.remove(index);
        }
    }

    private class ListStoreIterator extends StoreIterator implements ListIterator<Object> {
        private int index = 0;

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public Object previous() {
            return arr.get(index--);
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void set(Object o) {
            arr.set(index, o);
        }

        @Override
        public void add(Object o) {
            arr.add(index, o);
        }
    }
}
