package test;

import java.util.Scanner;

import model.Timber;
import model.Wood;
import store.ProductStore;
import store.WoodDirectory;

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
                case "1":
                    addWood(scanner);
                    System.out.println(wd);
                    break;
                case "2":
                    addProduct(scanner);
                    System.out.println(ps);
                    break;
                case "3":
                    showTotalWeight();
                    break;
                case "4":
                    System.out.println("Bye!");
                    scanner.close();
                    return;
                default:
                    if (choice != null && !choice.isEmpty())
                        System.out.println("Incorrect input");
            }

        }
    }

    private void addWood(Scanner scanner) {
        System.out.println("Please, input wood type and press Enter");
        String type = scanner.nextLine();
        System.out.println("Please, input density and press Enter");
        String density = scanner.nextLine();
        try {
            int id = wd.getArr().length + 1;
            wd.add(new Wood(id, type, Float.parseFloat(density)));
        } catch (NumberFormatException e) {
            System.out.println("Incorrect density");
        }
    }

    private void addProduct(Scanner scanner) {
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
