package test;

import model.Cylinder;
import model.Timber;
import model.Waste;
import model.Wood;
import store.ProductStore;
import store.WoodDirectory;

public class TestApp {
    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    public static void main(String[] args) throws Exception {
        TestApp app = new TestApp();
        app.startApp();
    }

    private void startApp() {
        wd.add(new Wood(1, "Дуб", 0.7f));
        wd.add(new Wood(2, "Сосна", 0.4f));
        wd.add(new Wood(3, "Береза", 0.5f));


        ps.add(new Timber(wd.get(1), 5.2f, 0.3f, 0.02f));
        ps.add(new Timber(wd.get(2), 4.5f, 0.1f, 0.02f));
        ps.add(new Timber(wd.get(3), 3.2f, 0.2f, 0.02f));

        ps.add(new Cylinder(wd.get(1), 10.4f, 1f));
        ps.add(new Cylinder(wd.get(2), 10.5f, 2f));
        ps.add(new Cylinder(wd.get(3), 10.6f, 3f));

        ps.add(new Waste(10.0f));
        ps.add(new Waste(20.0f));
        ps.add(new Waste(30.0f));

        System.out.println(wd);
        System.out.println(ps);

        System.out.println("Загальна вага: " + ps.calcWeight());
    }
}
