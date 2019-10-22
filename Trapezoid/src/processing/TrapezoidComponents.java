package processing;

import components.Point;

public class TrapezoidComponents {
    private double area;
    private Point[] trapezEdges;


    public double getArea() {
        return area;
    }

    public Point[] getTrapezEdges() {
        return trapezEdges;
    }

    public void setArea(double area) {
        if (area > 0) {
            this.area = area;
        }
    }

    public void setTrapezEdges(Point[] trapezEdges) {
        this.trapezEdges = trapezEdges;
    }
}
