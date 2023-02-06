package test;

import model.*;
import store.ProductStore;
import store.WoodDirectory;
import threads.TimberShop;
import threads.WoodShop;

import javax.swing.*;
import java.io.Console;
import java.util.Iterator;
import java.util.function.Predicate;

public class TestApp {
    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    public static void main(String[] args) throws Exception {
        TestApp app = new TestApp();
        app.startApp();
    }

    private void startApp() {
        wd.add(new Wood(0, "Oak", 0.3f));
        wd.add(new Wood(1, "Birch", 0.2f));
        wd.add(new Wood(2, "Pine", 0.1f));

        int n = 100;

        WoodShop tShop1 = new TimberShop("Shop 1", wd, ps, n);
        WoodShop tShop2 = new TimberShop("Shop 2", wd, ps, n);

        Thread t1 = new Thread(tShop1);
        Thread t2 = new Thread(tShop2);

        (new Thread(() -> {
            try {
                t1.join();
                t2.join();
                System.out.println("Total count: " + ps.getCount());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        })).start();


        t1.start();
        t2.start();
    }
}
