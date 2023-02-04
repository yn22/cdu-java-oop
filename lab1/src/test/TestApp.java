package test;

import model.Timber;
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
        ps.add(new Timber(wd.get(1), 5.2f, 0.3f, 0.02f));
        ps.add(new Timber(wd.get(2), 4.5f, 0.1f, 0.02f));
        ps.add(new Timber(wd.get(3), 3.2f, 0.2f, 0.02f));

        System.out.println(wd);
        System.out.println(ps);

        System.out.println("Загальна вага: " + ps.calcWeight());
    }
}
