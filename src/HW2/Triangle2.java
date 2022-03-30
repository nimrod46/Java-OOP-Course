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
    public Point getCenter() {
        return HW2Utils.getCenterFromLeftPointLengthEdge(leftPoint, lengthEdge, isUp);
    }

    @Override
    public double height() {
        return HW2Utils.getHeightFromLengthEdge(lengthEdge);
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
}
