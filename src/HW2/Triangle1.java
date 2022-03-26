package HW2;

public class Triangle1 extends TriangleBase {

    private Point center;
    private double height;

    public Triangle1() {
        createDefault();
    }

    public Triangle1(Point center, int height) {
        if (height == 0) {
            createDefault();
            return;
        }
        this.center = center;
        this.height = height;
    }

    private void createDefault() {
        center = new Point();
        height = HW2Utils.getHeightFromLengthEdge(1);
    }

    @Override
    public Point[] getVertices() {
        Point a = HW2Utils.getLeftPointFromCenterLengthEdge(center, getLengthEdge(), isUpTriangle());
        Point b = a.copy();
        b.moveHorizontal(getLengthEdge());
        Point c = center.copy();
        c.setY(a.getY() + height);
        return new Point[]{a, b, c};
    }

    @Override
    public Point getCenter() {
        return center.copy();
    }

    @Override
    public double height() {
        return Math.abs(height);
    }

    @Override
    public double getLengthEdge() {
        return HW2Utils.getLengthEdgeFromHeight(height());
    }

    @Override
    public boolean isUpTriangle() {
        return height > 0;
    }

    @Override
    public void setCenter(Point p) {
        center = p.copy();
    }

    @Override
    public void updateHeight(double height) {
        if (height <= 0) {
            return;
        }
        this.height = Math.signum(height) * height;
    }

    @Override
    public void inverse() {
        height *= -1;
    }

    @Override
    public void updateLengthEdge( double lengthEdge) {
        double newHeight = HW2Utils.getHeightFromLengthEdge(lengthEdge);
        if(Math.signum(newHeight) != Math.signum(height)) {
            return;
        }
        height = newHeight;
    }

    @Override
    public void moveVertical(final double delta) {

    }

    @Override
    public void moveHorizontal(final double delta) {

    }

    @Override
    public void move(final Point delta) {

    }

    @Override
    public boolean contains(final Point p) {
        return false;
    }

    @Override
    public boolean contains(final Triangle triangle) {
        return false;
    }
}
