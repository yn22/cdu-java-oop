package test;

import model.*;
import store.ProductStore;
import store.WoodDirectory;

import javax.swing.*;
import java.io.Console;
import java.util.Iterator;

public class TestApp {
    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    public static void main(String[] args) throws Exception {
        TestApp app = new TestApp();
        app.startApp();
    }

    private void startApp() {
        try {
            wd.add(new Wood(1, "Дуб", 0.7f));
            wd.add(new Wood(2, "Сосна", 0.4f));
            wd.add(new Wood(3, "Береза", 0.5f));


            ps.add(new Timber(wd.get(1), 5.2f, 0.3f, 0.02f));
            ps.add(new Timber(wd.get(2), 4.5f, 0.1f, 0.02f));
            ps.add(new Timber(wd.get(3), 3.2f, 0.2f, 0.02f));

            ps.add(new Cylinder(wd.get(1), 10.4f, 1f));
            ps.add(new Cylinder(wd.get(2), 10.5f, 2f));
            ps.add(new Cylinder(wd.get(3), 10.6f, 3f));


            ps.add(new Waste(0.09f));
            ps.add(new Waste(0.05f));
            ps.add(new Waste(0.03f));

            System.out.println("ProductStore before remove:");
            System.out.println(ps);

            Iterator<Object> iter = ps.iterator();

            while (iter.hasNext()) {
                IWeight obj = (IWeight) iter.next();
                if (obj.weight() > 1.3) {
                    iter.remove();
                }
            }

            System.out.println("ProductStore after remove:");
            System.out.println(ps);

            Iterator<Object> iter2 = ps.listIterator();
            while (iter2.hasNext()) {
                IWeight obj = (IWeight) iter2.next();
                if (obj.weight() > 0.5) {
                    iter2.remove();
                }
            }

            System.out.println("ProductStore after remove using ListIterator:");
            System.out.println(ps);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }

//        System.out.println(wd);
//        System.out.println(ps);
//
//        System.out.println("Загальна вага: " + ps.calcWeight());
    }
}
