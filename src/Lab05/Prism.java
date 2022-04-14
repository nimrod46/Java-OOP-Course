package Lab05;

public class Prism {

    private final Shape2D base;
    private double height;

    public Prism() {
        this(1);
    }

    public Prism(double height) {
        this(new Square(), 1);
    }

    public Prism(Shape2D base, double height) {
        this.base = base;
        this.height = height;
    }

    public double volume() {
        return base.area() * height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(final double height) {
        this.height = height;
    }

    public Shape2D getBase() {
        return base;
    }

    @Override
    public String toString() {
        return "Prism{" +
                "height=" + height +
                ", base=" + base +
                '}';
    }
}
