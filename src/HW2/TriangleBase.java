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
    public final void moveVertical(final double delta) {
        Point newCenter = getCenter();
        newCenter.moveVertical(delta);
        setCenter(newCenter);
    }

    @Override
    public final void moveHorizontal(final double delta) {
        Point newCenter = getCenter();
        newCenter.moveHorizontal(delta);
        setCenter(newCenter);
    }

    @Override
    public final void move(final Point delta) {
        Point newCenter = getCenter();
        newCenter.move(delta);
        setCenter(newCenter);
    }

    @Override
    public double getArea() {
        return height() * getLengthEdge() / 2;
    }

    @Override
    public double getPerimeter() {
        return getLengthEdge() * 3;
    }

    @Override
    public void scale(double scalePar) {
        if (scalePar <= 0) {
            return;
        }

        updateLengthEdge(getLengthEdge() * scalePar);
    }

    @Override
    public boolean contains(Point p) {
        if (p == null) {
            return false;
        }
        Point[] vertices = getVertices();
        if (getDistance(vertices[0], p) > getLengthEdge()) {
            return false;
        }
        if (getDistance(vertices[1], p) > getLengthEdge()) {
            return false;
        }
        return !(getDistance(vertices[2], p) > getLengthEdge());
    }

    @Override
    public boolean contains(Triangle triangle) {
        Point[] otherVertices = triangle.getVertices();
        if (!contains(otherVertices[0])) {
            return false;
        }
        if (!contains(otherVertices[1])) {
            return false;
        }
        return contains(otherVertices[2]);
    }

    @Override
    public Point[] getVertices() {
        Point a = HW2Utils.getLeftPointFromCenterLengthEdge(getCenter(), getLengthEdge(), isUpTriangle());
        Point b = a.copy();
        b.moveHorizontal(getLengthEdge());
        Point c = getCenter();
        c.setY(a.getY() + height() * (isUpTriangle() ? 1 : -1));
        return new Point[]{a, b, c};
    }

    @Override
    public double getLengthEdge() {
        return HW2Utils.getLengthEdgeFromHeight(height());
    }

    @Override
    public void updateLengthEdge(double lengthEdge) {
        if (lengthEdge <= 0) {
            return;
        }
        double newHeight = HW2Utils.getHeightFromLengthEdge(lengthEdge);
        updateHeight(newHeight);
    }

    private static double getDistance(Point p1, Point p2) {
        double distance = Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2);
        distance = Math.sqrt(distance);
        return distance;
    }
}
