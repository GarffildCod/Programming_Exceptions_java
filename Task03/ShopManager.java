package Shop;

import Shop.exceptions.InsufficientQuantityException;
import Shop.exceptions.ProductNotFoundException;

public class ShopManager {
    public double purchaseProduct(int productId, int quantity) throws ProductNotFoundException, InsufficientQuantityException {
        Product product = ProductDatabase.getProduct(productId);

        if (product == null) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found.");
        }

        if (quantity > product.getAvailableQuantity()) {
            throw new InsufficientQuantityException("Insufficient quantity of product: " + product.getName());
        }

        double totalPrice = product.getPrice() * quantity;
        return totalPrice;
    }
}