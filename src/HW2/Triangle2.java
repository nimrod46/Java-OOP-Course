package HW2;

public class Triangle2 extends TriangleBase {

    private Point leftPoint;
    private double lengthEdge;
    private boolean isUp;

    public Triangle2() {
        createDefault();
    }

    public Triangle2(Point leftPoint, double lengthEdge, boolean isUp) {
        if (lengthEdge <= 0) {
            createDefault();
            return;
        }
        this.leftPoint = leftPoint;
        this.lengthEdge = lengthEdge;
        this.isUp = isUp;
    }

    private void createDefault() {
        lengthEdge = 1;
        isUp = true;
        leftPoint = HW2Utils.getLeftPointFromCenterLengthEdge(new Point(), lengthEdge, isUp);
    }

    @Override
    public Point[] getVertices() {
        Point b = leftPoint.copy();
        b.moveHorizontal(getLengthEdge());
        Point c = getCenter().copy();
        c.setY(leftPoint.getY() + height() * (isUp ? 1 : -1));
        return new Point[]{leftPoint.copy(), b, c};
    }

    @Override
    public Point getCenter() {
        return HW2Utils.getCenterFromLeftPointLengthEdge(leftPoint, getLengthEdge(), isUp);
    }

    @Override
    public double height() {
        return HW2Utils.getHeightFromLengthEdge(getLengthEdge());
    }

    @Override
    public double getLengthEdge() {
        return lengthEdge;
    }

    @Override
    public boolean isUpTriangle() {
        return isUp;
    }

    @Override
    public void setCenter(Point p) {
        leftPoint = HW2Utils.getLeftPointFromCenterLengthEdge(p, lengthEdge, isUp);
    }

    @Override
    public void updateHeight(double height) {
        if (height <= 0) {
            return;
        }
        double lengthEdge = HW2Utils.getLengthEdgeFromHeight(height);
        this.leftPoint = HW2Utils.getLeftPointFromCenterLengthEdge(getCenter(), lengthEdge, isUp);
        this.lengthEdge = lengthEdge;
    }

    @Override
    public void inverse() {
        isUp = !isUp;
    }

    @Override
    public void updateLengthEdge(double lengthEdge) {
        if (lengthEdge <= 0) {
            return;
        }
        this.leftPoint = HW2Utils.getLeftPointFromCenterLengthEdge(getCenter(), lengthEdge, isUp);
        this.lengthEdge = lengthEdge;
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
