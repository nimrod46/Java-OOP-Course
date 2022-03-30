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
    public Point getCenter() {
        return center.copy();
    }

    @Override
    public double height() {
        return Math.abs(height);
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
        this.height = Math.signum(this.height) * height;
    }

    @Override
    public void inverse() {
        var pointA = getVertices()[0];
        var pointC = getVertices()[2];
        pointA.setY(pointC.getY());
        height *= -1;
        center = HW2Utils.getCenterFromLeftPointLengthEdge(pointA, getLengthEdge(), isUpTriangle());
    }
}
