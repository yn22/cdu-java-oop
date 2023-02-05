package store;

import model.IWeight;

import java.util.ArrayList;

public class ProductStore extends AbstractStore {

    public void add(IWeight newIWeight) {
        arr.add(newIWeight);
    }

    @Override
    public String toString() {
        return "Вміст сховища продуктів \n:" + super.toString();
    }
}
