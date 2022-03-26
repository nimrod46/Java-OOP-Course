package HW2;

public abstract class TriangleBase implements Triangle {

    @Override
    public boolean isEqual(final Triangle triangle) {
        if (triangle == null) {
            return false;
        }

        return HW2Utils.areEqual(getLengthEdge(), triangle.getLengthEdge()) &&
                getCenter().equals(triangle.getCenter());
    }

    @Override
    public double getArea() {
        return height() * getLengthEdge() / 2;
    }

    @Override
    public double getPerimeter() {
        return getLengthEdge() * 3;
    }
}
