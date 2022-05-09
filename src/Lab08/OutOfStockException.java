package Lab08;

public class OutOfStockException extends Exception {

    private final Product product;
    private final int quantity;

    public OutOfStockException(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OutOfStockException{" + super.toString() +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
