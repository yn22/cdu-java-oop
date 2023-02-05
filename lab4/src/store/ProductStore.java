package store;

import model.IWeight;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductStore extends AbstractStore implements Serializable {

    public void add(IWeight newIWeight) {
        arr.add(newIWeight);
    }

    public void serialize() {
        super.serialize("productStore.object");
    }

    public void deserialize() {
        super.deserialize("productStore.object");
    }

    public void writeToFile(String fileName) {
        super.writeToFile(fileName);
    }

    @Override
    public String toString() {
        return "Вміст сховища продуктів \n:" + super.toString();
    }
}
