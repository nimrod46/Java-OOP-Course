package Lab08;

@SuppressWarnings("serial")
public class OverStockException extends Exception {

    private final Product product;
    private final int quantity;

    public OverStockException(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OverStockException{" + super.toString() +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
