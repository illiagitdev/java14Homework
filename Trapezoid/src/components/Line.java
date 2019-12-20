package components;

public class Line {
    private double a;
    private double b;
    private double c;

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Line(double startPointX, double startPointY, double endPointX, double endPointY) {
        a = startPointY - endPointY;
        b = endPointX - startPointX;
        c = (startPointX * endPointY) - (endPointX * startPointY);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public boolean hasCross(Line z) {
        return a / z.getA() != b / z.getB() && b / z.getB() != c / z.getC();
    }

    public double crossLineX(Line z) {
        double base = a * z.getB() - z.getA() * b;
        if (base != 0) {
            return (b * z.getC() - z.getB() * c) / base;
        }
        return 0;
    }

    public double crossLineY(Line z) {
        double base = a * z.getB() - z.getA() * b;
        if (base != 0) {
            return (c * z.getA() - z.getC() * a) / base;
        }
        return 0;
    }

    public double distanceToPoint(double coordinateX, double coordinateY) {
        return Math.abs(a * coordinateX + b * coordinateY + c) / Math.sqrt(a * a + b * b);
    }

    @Override
    public String toString() {
        return "Line{" + a +
                "*x + " + b +
                "*y + " + c +
                '}';
    }
}
