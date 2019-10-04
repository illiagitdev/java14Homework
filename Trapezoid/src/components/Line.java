package components;

public class Line {
    // equation of the line: a*x + b*y + c = 0
    private double a = 0;
    private double b = 0;
    private double c = 0;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Line(double startPointX, double startPointY, double endPointX, double endPointY) {
        a = startPointY - endPointY;
        b = endPointX - startPointX;
        c = startPointX * endPointY - endPointX * startPointY;
    }

    /**
     * Returns X coordinate of crossing two lines
     */
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

    /**
     * Returns X point
     */
    public double closestPointOnLineX(double coordinateX, double coordinateY) {
        return (b * (b * coordinateX - a * coordinateY) - a * c) / (a * a + b * b);
    }

    public double closestPointOnLineY(double coordinateX, double coordinateY) {
        return (a * (-b * coordinateX + a * coordinateY) - b * c) / (a * a + b * b);
    }

    @Override
    public String toString() {
        return "Line{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
