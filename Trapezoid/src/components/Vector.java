package components;

public class Vector {
    private double x;
    private double y;

    public Vector(double startX, double startY, double endX, double endY) {
        x = endX-startX;
        y = endY-startY;
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
