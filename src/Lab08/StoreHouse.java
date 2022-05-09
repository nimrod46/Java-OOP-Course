package Lab08;

import java.util.HashMap;
import java.util.Map;

public class StoreHouse {

    private final Map<Product, Integer> quantityByProducts;

    public StoreHouse() {
        this.quantityByProducts = new HashMap<>();
    }


    public void order(Product product, int quantity) throws OverStockException {
        int currentQuantity = 0;

        if (quantityByProducts.containsKey(product)) {
            currentQuantity = quantityByProducts.get(product);
        }

        if (product.getMaxStock() < quantity + currentQuantity) {
            throw new OverStockException(product, quantity);
        }

        quantityByProducts.put(product, quantity + currentQuantity);
    }

    public void supply(Product product, int quantity) throws OutOfStockException {
        if (!quantityByProducts.containsKey(product) || quantityByProducts.get(product) < quantity) {
            throw new OutOfStockException(product, quantity);
        }
        quantityByProducts.put(product, quantityByProducts.get(product) - quantity);
    }

    @Override
    public String toString() {
        String str = "StoreHouse: \n";
        int i = 1;
        for (Product key : quantityByProducts.keySet()) {
            str += "\t" + i+ ". " + key.getName() + " - " + quantityByProducts.get(key) + "\n";
            i++;
        }
        return str + "end of list";
    }
}
