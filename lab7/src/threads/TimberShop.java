package threads;

import model.IWeight;
import model.Timber;
import model.Wood;
import store.ProductStore;
import store.WoodDirectory;

import java.util.Random;

public class TimberShop extends WoodShop {

    public TimberShop(String name, WoodDirectory wd, ProductStore ps, int n) {
        super(name, wd, ps, n);
    }

    IWeight createProduct() {
        int woodId = rnd.nextInt(wd.getArr().size());
        Wood wood = wd.get(woodId);
        float length = 1 + rnd.nextFloat() * 10;
        float height = 0.1f + rnd.nextFloat();
        float width = 0.1f + rnd.nextFloat();
        Timber timber;
        try {
            timber = new Timber(wood, length, width, height);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return timber;
    }

}
