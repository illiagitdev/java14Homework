package components;

public class LineSegment {
    private double firstX;
    private double firstY;
    private double secondX;
    private double secondY;

    public LineSegment() {
        this(0, 0, 0, 0);
    }

    public LineSegment(double firstX, double firstY, double secondX, double secondY) {
        this.firstX = firstX;
        this.firstY = firstY;
        this.secondX = secondX;
        this.secondY = secondY;
    }

    public double getFirstX() {
        return firstX;
    }

    public void setFirstX(double firstX) {
        this.firstX = firstX;
    }

    public double getFirstY() {
        return firstY;
    }

    public void setFirstY(double firstY) {
        this.firstY = firstY;
    }

    public double getSecondX() {
        return secondX;
    }

    public void setSecondX(double secondX) {
        this.secondX = secondX;
    }

    public double getSecondY() {
        return secondY;
    }

    public void setSecondY(double secondY) {
        this.secondY = secondY;
    }

    public double segmentLength() {
        return segmentLength(firstX, firstY, secondX, secondY);
    }

    public double segmentLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public boolean pointOnSegment(double x, double y) {
        double segment, piece1, piece2;
        segment = Math.round(segmentLength() * 1000) / 1000;
        piece1 = Math.round(segmentLength(firstX, firstY, x, y) * 1000) / 1000;
        piece2 = Math.round(segmentLength(secondX, secondY, x, y) * 1000) / 1000;
        return segment == (piece1 + piece2);
    }
}
