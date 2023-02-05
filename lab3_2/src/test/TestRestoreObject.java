package test;

import store.WoodDirectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestRestoreObject {
    public static void main(String[] args) {
        TestRestoreObject app = new TestRestoreObject();
        app.startApp();
    }

    private void startApp() {
        File f = new File("wd.object");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            WoodDirectory wd = (WoodDirectory) ois.readObject();
            ois.close();

            System.out.println(wd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
