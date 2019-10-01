package components;

public class Vector {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Creates vector with determined values
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates zero-vector
     */
    public Vector() {
        this(0.0, 0.0);
    }

    /**
     * Creates vector based on start and end points
     */
    public Vector(Point a, Point b) {
        x = b.getX() - a.getX();
        y = b.getY() - a.getY();
    }

    /**
     * Returns vector: sum of two vectors
     */
    public Vector addVectors(Vector a, Vector b) {
        return new Vector(a.x + b.x, a.y + b.y);
    }

    /**
     * Returns dot multiplication of scalar on vector
     */
    public Vector dotByValue(Vector a, double value) {
        return new Vector(a.x * value, a.y * value);
    }

    /**
     * Returns length of the vector
     */
    public double length() {
        return Math.sqrt(x * x + y * y );
    }

    /**
     * Returns unit vector of the vector
     */
    public Vector unitVector() {
        double module = length();
        return new Vector(x / module, y / module);
    }

    /**
     * Returns scalar product
     */
    public double dotProduct(Vector b) {
        return (this.x * b.x + this.y * b.y);
    }

    /**
     * Returns Z- component of vector product
     */
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
