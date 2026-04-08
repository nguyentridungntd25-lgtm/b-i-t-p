package session16;

import java.util.HashMap;
import java.util.Scanner;

public class Ex16_1 {
    static HashMap<Integer, Product> products = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n Product Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    filterProducts();
                    break;
                case 6:
                    totalValue();
                    break;
                case 0:
                    System.out.println("Exit!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addProduct() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        products.put(id, new Product(id, name, price));
        System.out.println("Product added successfully.");
    }

    static void editProduct() {
        System.out.print("Enter Product ID to edit: ");
        int id = sc.nextInt();

        if (products.containsKey(id)) {
            sc.nextLine();
            System.out.print("Enter new Name: ");
            String name = sc.nextLine();
            System.out.print("Enter new Price: ");
            double price = sc.nextDouble();
            Product p = products.get(id);
            p.setName(name);
            p.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }
    static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        if (products.remove(id) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }
    static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products");
            return;
        }
        products.values().forEach(System.out::println);
    }
    static void filterProducts() {
        System.out.println("Products with price > 100:");
        products.values().stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);
    }
    static void totalValue() {
        double total = products.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Total value: " + total);
    }
}