package threads;

import model.IWeight;
import store.ProductStore;
import store.WoodDirectory;

import java.util.Random;

public abstract class WoodShop implements Runnable {
    WoodDirectory wd;
    ProductStore ps;
    Random rnd = new Random();
    int n;
    String name;

    public WoodShop(String name, WoodDirectory wd, ProductStore ps, int n) {
        super();
        this.name = name;
        this.wd = wd;
        this.ps = ps;
        this.n = n;
    }

    public String getName() {
        return name;
    }

    public void run() {
        for (int i = 0; i < this.n; i++) {
//            sleep(this.n);
            IWeight timber = createProduct();
            if (timber != null) {
                ps.add(timber);
//                System.out.println(this.getName() + " created " + timber);
            }
        }
    }

    abstract IWeight createProduct();

    void sleep(int seconds) {
        try {
            Thread.sleep((seconds + rnd.nextInt(5)) * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
