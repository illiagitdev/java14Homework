package processing;

import components.Line;
import components.LineSegment;
import components.Point;

import java.util.Arrays;

public class AreaCalc {
    private Line[] lines;
    private LineSegment[] segments;
    private Point[][] edges;

    public TrapezoidComponents[] getAreaTMPMix(Point spectator, Point[] workingSetFar, Point[] workingSetNear) {
        int[] crossCountFar = new int[workingSetFar.length];
        int[] crossCountNear = new int[workingSetNear.length];
        crossCounter(crossCountFar, spectator, workingSetFar);
        crossCounter(crossCountNear, spectator, workingSetNear);
        Point[][] setFar = new Point[workingSetFar.length][];
        Point[][] setNear = new Point[workingSetNear.length][];
        getPoints(spectator, crossCountFar, workingSetFar, setFar);
        getPoints(spectator, crossCountNear, workingSetNear, setNear);
        TrapezoidComponents[] areas;
        areas = trueTrapezoidArea(setFar, setNear);
        return areas;
    }

    private TrapezoidComponents[]  trueTrapezoidArea(Point[][] setFar, Point[][] setNear) {
        TrapezoidComponents[] temporary = new TrapezoidComponents[setFar.length * setNear.length];
        int q = 0;
        try {
            for (int i = 0; i < setFar.length; i++) {
                if (setFar[i] != null) {
                    for (int j = 0; j < setNear.length; j++) {
                        if (setNear[j] != null) {
                            temporary[q] = getEdges(setFar[i], setNear[j]);
                            q++;
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Empty point " + Arrays.toString(e.getStackTrace()));
        }
        return temporary;
    }

    public TrapezoidComponents[] getAreaTMP(Point spectator, Point[] shape, Point[] workingSet) {
        lines = new Line[shape.length];
        segments = new LineSegment[shape.length];
        initialiseLineSegment(shape);
        int[] crossCount = new int[workingSet.length];
        crossCounter(crossCount, spectator, workingSet);
        Point[][] set = new Point[workingSet.length][];
        edges = new Point[Utils.summm(set.length)][4];
        getPoints(spectator, crossCount, workingSet, set);
        Utils.writeFile(set);
        TrapezoidComponents[] areas = trueTrapezoidArea(set);
        return areas;
    }

    private TrapezoidComponents[] trueTrapezoidArea(Point[][] set) {
        TrapezoidComponents[] temporary = new TrapezoidComponents[Utils.summm(set.length)];
        int q = 0;
        try {
            for (int i = 0; i < set.length - 1; i++) {
                if (set[i] != null) {
                    for (int j = (i + 1); j < set.length; j++) {
                        if (set[j] != null) {
                            temporary[q] = getEdges(set[i], set[j]);
                            q++;
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Empty point " + Arrays.toString(e.getStackTrace()));
        }
        return temporary;
    }

    private TrapezoidComponents getEdges(Point[] in1, Point[] in2) {
        Point[] set1, set2, out = new Point[4];
        set1 = in1.clone();
        set2 = in2.clone();
        Line baseB = new Line(set1[0].getX(), set1[0].getY(), set2[0].getX(), set2[0].getY());
        double d1, d2;
        d1 = baseB.distanceToPoint(set1[1].getX(), set1[1].getY());
        d2 = baseB.distanceToPoint(set2[1].getX(), set2[1].getY());
        if (d1 < d2) {
            set2[1] = newCrossPoint(baseB, set1[1], set2);
        } else if (d2 < d1) {
            set1[1] = newCrossPoint(baseB, set2[1], set1);
        }
        for (int i = 0; i < set1.length; i++) {
            out[i] = set1[i];
            out[2 + i] = set2[i];
        }
        TrapezoidComponents output = new TrapezoidComponents();
        output.setTrapezEdges(out);
        double area = trapezoidArea(set1, set2);
        output.setArea(area);
        return output;
    }

    private double trapezoidArea(Point[] set1, Point[] set2) {
        double a, b, c, d, s;
        b = (new LineSegment(set1[0].getX(), set1[0].getY(), set2[0].getX(), set2[0].getY())).segmentLength();
        a = (new LineSegment(set1[1].getX(), set1[1].getY(), set2[1].getX(), set2[1].getY())).segmentLength();
        c = (new LineSegment(set1[0].getX(), set1[0].getY(), set1[1].getX(), set1[1].getY())).segmentLength();
        d = (new LineSegment(set2[0].getX(), set2[0].getY(), set2[1].getX(), set2[1].getY())).segmentLength();
        s = (a + b + c + d) / 2;
        double area = Math.sqrt((s - b) * (s - a) * (s - b - c) * (s - b - d)) * ((a + b) / Math.abs(b - a));
        if (area > 0) {
            return area;
        }
        return 0;
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
        Line line;
        line = new Line(spectator.getX(), spectator.getY(), point.getX(), point.getY());
        Point[] tmp = new Point[2];
        int q = 0;
        try {
            for (int j = 0; j < lines.length; j++) {
                if (lines[j].hasCross(line) && (counterSegments(segments[j], line, lines[j]) == 1)) {//sout to console
                    tmp[q] = setCrossPoint(line, lines[j]);
                    q++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Null exception " + e.fillInStackTrace());
        }
        double[] segment = new double[2];
        for (int i = 0; i < tmp.length; i++) {
            segment[i] = (new LineSegment(spectator.getX(), spectator.getY(), tmp[i].getX(), tmp[i].getY()).segmentLength());
        }
        if (segment[0] > segment[1]) {
            return tmp;
        } else {
            Point z = tmp[0];
            tmp[0] = tmp[1];
            tmp[1] = z;
        }
        return tmp;
    }

    private Point setCrossPoint(Line test, Line lines) {
        double x, y;
        x = test.crossLineX(lines);
        y = test.crossLineY(lines);
        return new Point(x, y);
    }

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
        y = test.crossLineY(line);
        boolean xRight, xReverse, yRight, yReverse;
        xRight = segment.getFirstX() <= x && segment.getSecondX() >= x;
        xReverse = segment.getFirstX() >= x && segment.getSecondX() <= x;
        yRight = segment.getFirstY() <= y && segment.getSecondY() >= y;
        yReverse = segment.getFirstY() >= y && segment.getSecondY() <= y;
        if (xRight && yRight || (xReverse && yReverse) || (xRight && yReverse) || (xReverse && yRight)) {
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
