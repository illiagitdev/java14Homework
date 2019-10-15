package processing;

import components.Line;
import components.LineSegment;
import components.Point;

public class AreaCalc {
    private Line[] lines;
    private LineSegment[] segments;


    /**
     * Returns array of areas of trapezoids
     */
    public double[] getAreaTMP(Point spectator, Point[] shape, Point[] workingSet) {
        lines = new Line[shape.length];
        segments = new LineSegment[shape.length];
        initialiseLineSegment(shape);
        int[] crossCount = new int[workingSet.length];
        crossCounter(crossCount, spectator, workingSet);
        Point[][] set = new Point[workingSet.length][];
        getPoints(spectator, crossCount, workingSet, set);
        Utils.writeFile(set);

        double[] areas;
        areas = trueTrapezoidArea(set);
        return areas;
    }

    private double[] trueTrapezoidArea(Point[][] set) {
        double[] temporary = new double[Utils.summm(set.length)];
        int q = 0;
        try {
            for (int i = 0; i < set.length-1; i++) {
                if (set[i] != null) {
                    for (int j = 1; j < set.length; j++) {
                        if (set[j] != null) {
                            temporary[q] = getEdges(set[i], set[j]);
                            q++;
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Empty point " + e.getStackTrace());
        }
        return temporary;
    }

    /**
     * returns trapezoid Edges, fix one edge so it become trapezoid
     */
    private double getEdges(Point[] in1, Point[] in2) {
        Point[] set1, set2;
        set1 = in1;
        set2 = in2;
        Line baseB = new Line(set1[0].getX(), set1[0].getY(), set2[0].getX(), set2[0].getY());
        double d1, d2;
        d1 = baseB.distanceToPoint(set1[1].getX(), set1[1].getY());
        d2 = baseB.distanceToPoint(set2[1].getX(), set2[1].getY());
        if (d1 < d2) {
            set2[1] = newCrossPoint(baseB, set1[1], set2);
        } else if (d2 < d1) {
            set1[1] = newCrossPoint(baseB, set2[1], set1);
        }

        return trapezoidArea(set1, set2);
    }

    /**
     * trapezoid area by 4-points, base a(set1[0], set2[0]) & base b(set1[1], set2[1])
     */
    private double trapezoidArea(Point[] set1, Point[] set2) {
        double a, b, c, d, s;
        a = (new LineSegment(set1[0].getX(), set1[0].getY(), set2[0].getX(), set2[0].getY())).segmentLength();
        b = (new LineSegment(set1[1].getX(), set1[1].getY(), set2[1].getX(), set2[1].getY())).segmentLength();
        c = (new LineSegment(set1[0].getX(), set1[0].getY(), set1[1].getX(), set1[1].getY())).segmentLength();
        d = (new LineSegment(set2[0].getX(), set2[0].getY(), set2[1].getX(), set2[1].getY())).segmentLength();
        s = (a + b + c + d) / 2;
        double area = ((a + b) / Math.abs(b - a) * Math.sqrt((s - b) * (s - a) * (s - b - c) * (s - b - d)));
        return area;
    }

    private Point newCrossPoint(Line baseB, Point point, Point[] set) {
        Line baseA = new Line(baseB.getA(), baseB.getB(), (-baseB.getA() * point.getX() - baseB.getA() * point.getY()));
        Line cross = new Line(set[0].getX(), set[0].getY(), set[1].getX(), set[1].getY());
        double x = baseA.crossLineX(cross);
        double y = baseA.crossLineY(cross);
        return new Point(x, y);
    }

    private void getPoints(Point spectator, int[] crossCount, Point[] workingSet, Point[][] set) {
        int q = 0;
        for (int i = 0; i < crossCount.length; i++) {
            if (crossCount[i] == 2) {
                set[q] = crossPoints(spectator, workingSet[i]);
                q++;
            }
        }
    }

    private Point[] crossPoints(Point spectator, Point point) {
        Line line = new Line(spectator.getX(), spectator.getY(), point.getX(), point.getY());
        Point[] tmp = new Point[2];
        int q = 0;
        try {
            for (int j = 0; j < lines.length; j++) {
                if (lines[j].hasCross(line) && (counterSegments(segments[j], line, lines[j]) == 1)) {//sout to console
                    tmp[q] = setCrossPoint(segments[j], line, lines[j]);
                    q++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Null exception " + e.fillInStackTrace());
        }
        double one, two;
        one = (new LineSegment(spectator.getX(), spectator.getY(), tmp[0].getX(), tmp[0].getY()).segmentLength());
        two = (new LineSegment(spectator.getX(), spectator.getY(), tmp[1].getX(), tmp[1].getY()).segmentLength());
        if (one > two) {
            return tmp;
        } else {
            Point z = tmp[0];
            tmp[0] = tmp[1];
            tmp[1] = z;
        }
        return tmp;
    }

    private Point setCrossPoint(LineSegment segments, Line test, Line lines) {
        double x, y;
        x = test.crossLineX(lines);
        y = test.crossLineY(lines);
        return new Point(x, y);
    }

    //workingset I == crossCount I
    private void crossCounter(int[] array, Point spectator, Point[] workingSet) {
        int q = 0;
        for (int i = 0; i < workingSet.length; i++) {
            Line test = new Line(spectator.getX(), spectator.getY(), workingSet[i].getX(), workingSet[i].getY());
            for (int j = 0; j < lines.length; j++) {
                if (lines[j].hasCross(test)) {
                    q += counterSegments(segments[j], test, lines[j]);
                }
            }
            array[i] = q;
            q = 0;
        }
    }

    private int counterSegments(LineSegment segment, Line test, Line line) {
        double x, y;
        x = test.crossLineX(line);
//        y = test.crossLineY(line);
        if (segment.getFirstX() <= x && segment.getSecondX() >= x) {
            return 1;
        } else if (segment.getFirstX() >= x && segment.getSecondX() <= x) {
            return 1;
        }
        return 0;
    }

    private void initialiseLineSegment(Point[] shape) {
        Point tmp = shape[shape.length - 1];
        for (int i = 0; i < shape.length; i++) {
            lines[i] = new Line(tmp.getX(), tmp.getY(), shape[i].getX(), shape[i].getY());
            segments[i] = new LineSegment(tmp.getX(), tmp.getY(), shape[i].getX(), shape[i].getY());
            tmp = shape[i];
        }
    }
}
