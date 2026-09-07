package org.anudip.sms.controler;

import java.util.Scanner;
import org.anudip.sms.dao.Productdao;
import org.anudip.sms.model.Product;

public class Productcontroller {

    // Make sure your variables are declared here inside the class!
    Scanner scanner = new Scanner(System.in);
    Productdao productdao = new Productdao();

public void displayMenu() {
        System.out.println("\n--- Product Management ---");
        System.out.println("1. Add New Product");
        System.out.println("2. View All Products");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        if (choice == 1) {
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter stock quantity: ");
            int quantity = scanner.nextInt();

            Product product = new Product(0, name, price, quantity);
            if (productdao.addProduct(product)) {
                System.out.println("Product added successfully!");
            } else {
                System.out.println("Failed to add product.");
            }
            
        } else if (choice == 2) {
            // Fetch the list from DAO and print it here
            java.util.List<Product> list = productdao.viewProducts();
            if (list.isEmpty()) {
                System.out.println("No products found in the system.");
            } else {
                System.out.println("\n--- Product List ---");
                for (Product p : list) {
                    System.out.println("ID: " + p.getId() + " | Name: " + p.getName() + " | Price: " + p.getPrice() + " | Stock: " + p.getStockQuantity());
                }
            }
        }
            
        else if (choice == 3) {
            // Choice 3: Update an existing product
            System.out.print("Enter product ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            System.out.print("Enter new product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter new stock quantity: ");
            int quantity = scanner.nextInt();

            Product product = new Product(id, name, price, quantity);
            if (productdao.updateProduct(product)) {
                System.out.println("Product updated successfully!");
            } else {
                System.out.println("Failed to update product.");
            }
            
        } else if (choice == 4) {
            // Choice 4: Delete a product
            System.out.print("Enter product ID to delete: ");
            int id = scanner.nextInt();
            
            if (productdao.deleteProduct(id)) {
                System.out.println("Product deleted successfully!");
            } else {
                System.out.println("Failed to delete product.");
            }
        }
}
    }