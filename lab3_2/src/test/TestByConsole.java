package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.*;
import store.ProductStore;
import store.WoodDirectory;

import javax.swing.*;

public class TestByConsole {
    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    private BufferedWriter writer;

    public static void main(String[] args) {
        TestByConsole app = new TestByConsole();
        app.startApp();
    }

    private void startApp() {
        Scanner scanner = new Scanner(System.in);

        String userName = requestUserCredentials(scanner);
        logUserLogin(userName);

        while (true) {
            System.out.println("Please, input command number and press Enter");
            System.out.println("1 - Add wood");
            System.out.println("2 - Add product");
            System.out.println("3 - Serialize Wood catalog");
            System.out.println("4 - Serialize Product catalog");
            System.out.println("5 - Deserialize Wood catalog");
            System.out.println("6 - Deserialize Product catalog");
            System.out.println("7 - Show total weight");
            System.out.println("8 - Write products to file");
            System.out.println("9 - Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    addWood(scanner);
                    System.out.println(wd);
                }
                case "2" -> {
                    IWeight prod = addProduct(scanner);
                    writeStringToFile(prod.toString());
                    System.out.println(ps);
                }
                case "3" -> wd.serialize();
                case "4" -> ps.serialize();
                case "5" -> {
                    wd.deserialize();
                    System.out.println(wd);
                }
                case "6" -> {
                    ps.deserialize();
                    System.out.println(ps);
                }
                case "7" -> showTotalWeight();
                case "8" -> ps.writeToFile("sentProducts.txt");
                case "9" -> {
                    System.out.println("Bye!");
                    scanner.close();
                    closeWriter(userName);
                    return;
                }
                default -> {
                    if (!choice.isEmpty())
                        System.out.println("Incorrect input");
                }
            }

        }
    }

    private void closeWriter(String userName) {
        try {
            writeStringToFile(String.format("%s logged out", userName));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String requestUserCredentials(Scanner scanner) {
        System.out.println("Please, input your name and press Enter");

        return scanner.nextLine();
    }

    private void logUserLogin(String userName) {
        String log = String.format("%s logged in ", userName);

        writeStringToFile(log);
    }

    private void addWood(Scanner scanner) {
        System.out.println("Please, input wood type and press Enter");
        String type = scanner.nextLine();
        System.out.println("Please, input density and press Enter");
        String density = scanner.nextLine();
        try {
            int id = wd.getArr().size() + 1;
            wd.add(new Wood(id, type, Float.parseFloat(density)));
        } catch (NumberFormatException e) {
            System.out.println("Incorrect density");
        }
    }

    private IWeight addProduct(Scanner scanner) {
        System.out.println("Please, input product type and press Enter");
        System.out.println("1 - Timber");
        System.out.println("2 - Cylinder");
        System.out.println("3 - Waste");
        String type = scanner.nextLine();
        IWeight product = null;
        try {
            switch (type) {
                case "1" -> product = addTimber(scanner);
                case "2" -> product = addCylinder(scanner);
                case "3" -> product = addWaste(scanner);
                default -> {
                    if (!type.isEmpty())
                        System.out.println("Incorrect input");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        return product;
    }

    private IWeight addCylinder(Scanner scanner) throws Exception {
        System.out.println("Please, input cylinder length and press Enter");
        String length = scanner.nextLine();
        System.out.println("Please, input cylinder diameter and press Enter");
        String diameter = scanner.nextLine();
        System.out.println("Please, input cylinder wood Id and press Enter");
        String woodId = scanner.nextLine();
        IWeight product = null;
        try {
            product = new Cylinder(wd.get(Integer.parseInt(woodId)), Float.parseFloat(length), Float.parseFloat(diameter));
            ps.add(product);
        } catch (NullPointerException e) {
            System.out.println("Incorrect wood type");

        } catch (NumberFormatException e) {
            System.out.println("Incorrect input");
        }

        return product;
    }

    private IWeight addWaste(Scanner scanner) {
        System.out.println("Please, input waste weight and press Enter");
        String weight = scanner.nextLine();
        IWeight product = null;
        try {
            product = new Waste(Float.parseFloat(weight));
            ps.add(product);
        } catch (Exception e) {
            System.out.println("Incorrect weight");
        }

        return product;
    }

    private IWeight addTimber(Scanner scanner) throws Exception {
        System.out.println("Please, input timber length and press Enter");
        String length = scanner.nextLine();
        System.out.println("Please, input timber width and press Enter");
        String width = scanner.nextLine();
        System.out.println("Please, input timber height and press Enter");
        String height = scanner.nextLine();
        System.out.println("Please, input timber wood Id and press Enter");
        String woodId = scanner.nextLine();
        IWeight product = null;
        try {
            product = new Timber(wd.get(Integer.parseInt(woodId)), Float.parseFloat(length), Float.parseFloat(width),
                    Float.parseFloat(height));
            ps.add(product);
        } catch (NullPointerException e) {
            System.out.println("Incorrect wood type");

        } catch (NumberFormatException e) {
            System.out.println("Incorrect length, width or height");
        }

        return product;
    }

    private void showTotalWeight() {
        System.out.println("Total weight: " + ps.calcWeight());
    }

    private void writeStringToFile(String str) {
        try {
            if (writer == null) {
                writer = new BufferedWriter(new FileWriter("Log.txt"));
            }
            Date today = new Date();
            Time now = new Time(today.getTime());
            String formattedDate = new SimpleDateFormat("dd.MM.yyyy").format(today);
            String prefix = formattedDate + " " + now + " ";

            writer.write(prefix + str);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
