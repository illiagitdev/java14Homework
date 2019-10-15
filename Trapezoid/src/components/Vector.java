package components;

public class Vector {
    private double x;
    private double y;

    /**
     * Creates zero-vector
     */
    public Vector() {
        this(0.0, 0.0);
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates vector based on start and end points
     */
    public Vector(double startX, double startY, double endX, double endY) {
        x = endX-startX;
        y = endY-startY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Returns vector: sum of two vectors
     */
    public Vector addVector(Vector b) {
        return new Vector(x + b.x, y + b.y);
    }

    public Vector dotByValue(double value) {
        return new Vector(x * value, y * value);
    }

    public Vector unitVector(Vector a) {
        double module = length();
        return new Vector(x / module, y / module);
    }

    public double length() {
        return Math.sqrt(x * x + y * y );
    }

    public double dotProduct(Vector b) {
        return (this.x * b.x + this.y * b.y);
    }

    public double crossProductZ(Vector a) {
        return (a.x * this.y - a.y * this.x);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
