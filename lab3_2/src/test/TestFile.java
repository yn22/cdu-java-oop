package test;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        TestFile app = new TestFile();
        app.startApp();
    }

    private void startApp() {
        File f = openFile();
        if (f == null) {
            return;
        }
        writeRandomNumbersToFile(f);
        readNumbersFromFile(f);
    }

    private File openFile() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFileChooser dialog = new JFileChooser();
        dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dialog.setDialogTitle("Назаренко Ярослав. Група КН-19");
        dialog.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f == null) {
                    return false;
                }
                return f.getName().toLowerCase().endsWith(".txt") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Текстові файли (*.txt)";
            }
        });
        dialog.showOpenDialog(null);

        File f = dialog.getSelectedFile();

        if (f == null) {
            System.out.println("Неправильний тип файлу");
            return null;
        }

        System.out.println(f.getName());
        System.out.println(f.getAbsolutePath());

        return f;
    }

    private void writeRandomNumbersToFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file));
            for (int i = 0; i < 10; i++) {
                writer.write((int) (Math.random() * 100) + " ");
            }
            writer.write("Назаренко Ярослав. Група КН-19");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void readNumbersFromFile(File f) {
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(f));
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
