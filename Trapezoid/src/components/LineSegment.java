package components;

public class LineSegment {
    private double firstX;
    private double firstY;
    private double secondX;
    private double secondY;

    public LineSegment(double firstX, double firstY, double secondX, double secondY) {
        this.firstX = firstX;
        this.firstY = firstY;
        this.secondX = secondX;
        this.secondY = secondY;
    }

    public double getFirstX() {
        return firstX;
    }

    public double getFirstY() {
        return firstY;
    }

    public double getSecondX() {
        return secondX;
    }

    public double getSecondY() {
        return secondY;
    }

    public double segmentLength() {
        return segmentLength(firstX, firstY, secondX, secondY);
    }

    public double segmentLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2.) + Math.pow(y2 - y1, 2.));
    }

    @Override
    public String toString() {
        return "LineSegment{" +
                "Ax, Ay {" + firstX +
                " " + firstY +
                "} Bx, By {" + secondX +
                " " + secondY +
                "} }";
    }
}
