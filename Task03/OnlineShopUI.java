package Shop;
import Shop.ShopManager;
import Shop.exceptions.InsufficientQuantityException;
import Shop.exceptions.ProductNotFoundException;

import java.util.Scanner;

public class OnlineShopUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        try {
            ShopManager shopManager = new ShopManager();
            double totalPrice = shopManager.purchaseProduct(productId, quantity);
            System.out.println("Total price: $" + totalPrice);
        } catch (ProductNotFoundException e) {
            System.out.println("Product not found: " + e.getMessage());
        } catch (InsufficientQuantityException e) {
            System.out.println("Insufficient quantity: " + e.getMessage());
        }
    }
}