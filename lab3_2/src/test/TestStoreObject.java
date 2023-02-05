package test;

import model.Wood;
import store.WoodDirectory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class TestStoreObject {
    public static void main(String[] args) {
        TestStoreObject app = new TestStoreObject();
        app.startApp();
    }

    private void startApp() {
        WoodDirectory wd = new WoodDirectory();
        wd.add(new Wood(1, "Дуб", 0.7f));

        File f = new File("wood.object");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(wd);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
