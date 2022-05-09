package Lab08;

public class Product {

    private final String name;
    private final int maxStock;

    public Product(String name, int maxStock) {
        this.name = name;
        this.maxStock = maxStock;
    }

    public String getName() {
        return name;
    }

    public int getMaxStock() {
        return maxStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", maxStock=" + maxStock +
                '}';
    }
}
