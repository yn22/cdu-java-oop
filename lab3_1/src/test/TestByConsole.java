package test;

import java.util.Scanner;

import model.Cylinder;
import model.Timber;
import model.Waste;
import model.Wood;
import store.ProductStore;
import store.WoodDirectory;

import javax.swing.*;

public class TestByConsole {
    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    public static void main(String[] args) {
        TestByConsole app = new TestByConsole();
        app.startApp();
    }

    private void startApp() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please, input command number and press Enter");
            System.out.println("1 - Add wood");
            System.out.println("2 - Add product");
            System.out.println("3 - Show total weight");
            System.out.println("4 - Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    addWood(scanner);
                    System.out.println(wd);
                }
                case "2" -> {
                    addProduct(scanner);
                    System.out.println(ps);
                }
                case "3" -> showTotalWeight();
                case "4" -> {
                    System.out.println("Bye!");
                    scanner.close();
                    return;
                }
                default -> {
                    if (!choice.isEmpty())
                        System.out.println("Incorrect input");
                }
            }

        }
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

    private void addProduct(Scanner scanner) {
        System.out.println("Please, input product type and press Enter");
        System.out.println("1 - Timber");
        System.out.println("2 - Cylinder");
        System.out.println("3 - Waste");
        String type = scanner.nextLine();
        try {
            switch (type) {
                case "1" -> addTimber(scanner);
                case "2" -> addCylinder(scanner);
                case "3" -> addWaste(scanner);
                default -> {
                    if (!type.isEmpty())
                        System.out.println("Incorrect input");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addCylinder(Scanner scanner) throws Exception {
        System.out.println("Please, input cylinder length and press Enter");
        String length = scanner.nextLine();
        System.out.println("Please, input cylinder diameter and press Enter");
        String diameter = scanner.nextLine();
        System.out.println("Please, input cylinder wood Id and press Enter");
        String woodId = scanner.nextLine();

        try {
            ps.add(new Cylinder(wd.get(Integer.parseInt(woodId)), Float.parseFloat(length), Float.parseFloat(diameter)));
        } catch (NullPointerException e) {
            System.out.println("Incorrect wood type");

        } catch (NumberFormatException e) {
            System.out.println("Incorrect input");
        }
    }

    private void addWaste(Scanner scanner) {
        System.out.println("Please, input waste weight and press Enter");
        String weight = scanner.nextLine();
        try {
            ps.add(new Waste(Float.parseFloat(weight)));
        } catch (Exception e) {
            System.out.println("Incorrect weight");
        }
    }

    private void addTimber(Scanner scanner) throws Exception {
        System.out.println("Please, input timber length and press Enter");
        String length = scanner.nextLine();
        System.out.println("Please, input timber width and press Enter");
        String width = scanner.nextLine();
        System.out.println("Please, input timber height and press Enter");
        String height = scanner.nextLine();
        System.out.println("Please, input timber wood Id and press Enter");
        String woodId = scanner.nextLine();
        try {
            ps.add(new Timber(wd.get(Integer.parseInt(woodId)), Float.parseFloat(length), Float.parseFloat(width),
                    Float.parseFloat(height)));
        } catch (NullPointerException e) {
            System.out.println("Incorrect wood type");

        } catch (NumberFormatException e) {
            System.out.println("Incorrect length, width or height");
        }
    }

    private void showTotalWeight() {
        System.out.println("Total weight: " + ps.calcWeight());
    }
}
