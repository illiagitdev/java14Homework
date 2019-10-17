package processing;

import components.Line;
import components.LineSegment;
import components.Point;

import java.util.Arrays;

public class AreaCalc {
    private Line[] lines;
    private LineSegment[] segments;

    /**
     * Returns array of areas of trapezoids by one FAR and one NEAR point
     */
    public double[] getAreaTMPMix(Point spectator, Point[] shape, Point[] workingSetFar, Point[] workingSetNear) {
        int[] crossCountFar = new int[workingSetFar.length];
        int[] crossCountNear = new int[workingSetNear.length];
        crossCounter(crossCountFar, spectator, workingSetFar);
        crossCounter(crossCountNear, spectator, workingSetNear);

        Point[][] setFar = new Point[workingSetFar.length][];
        Point[][] setNear = new Point[workingSetNear.length][];
        getPoints(spectator, crossCountFar, workingSetFar, setFar);
        getPoints(spectator, crossCountNear, workingSetNear, setNear);

        double[] areas;//=new double[3];
        areas = trueTrapezoidArea(setFar, setNear);

        return areas;
    }

    private double[] trueTrapezoidArea(Point[][] setFar, Point[][] setNear) {
        System.out.println("trueTrapezoidArea by NEAR & FAR points - start");
        double[] temporary = new double[setFar.length * setNear.length];
        int q = 0;
        try {
            for (int i = 0; i < setFar.length; i++) {
                if (setFar[i] != null) {
                    for (int j = 0; j < setNear.length; j++) {
                        if (setNear[j] != null) {
                            temporary[q] = getEdges(setFar[i], setNear[j]);
//                            System.out.println("temporary area " + temporary[q]);
                            q++;
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Empty point " + Arrays.toString(e.getStackTrace()));
        }
        System.out.println("trueTrapezoidArea by NEAR & FAR points - end");
        return temporary;
//        return new double[0];
    }

    /**
     * Returns array of areas of trapezoids by FAR or NEAR points
     */
    public double[] getAreaTMP(Point spectator, Point[] shape, Point[] workingSet) {
        lines = new Line[shape.length];
        segments = new LineSegment[shape.length];
        initialiseLineSegment(shape);
        {//sout to console
            System.out.println("\n\tSet of lines and segments areas");
            for (int i = 0; i < shape.length; i++) {
                System.out.println("line '" + i + "' : " + lines[i].toString());
                System.out.println("segment '" + i + "' : " + segments[i].toString());
            }
        }

        int[] crossCount = new int[workingSet.length];
        crossCounter(crossCount, spectator, workingSet);
        {//sout to console
            System.out.println("\n\tCross counter areas");
            int q = 0;
            for (int x : crossCount) {
                System.out.println(x + " i= " + (++q));
            }
        }

        Point[][] set = new Point[workingSet.length][];
        getPoints(spectator, crossCount, workingSet, set);
        {//sout to console
            System.out.println("\n\t41line/getAreaTmp/Set of trapezoid adjusted edges");
            for (int i = 0; i < set.length; i++) {
                System.out.println("set[" + i + "] point ");
                if (set[i] != null) {
                    for (int j = 0; j < set[i].length; j++) {
                        System.out.println(j + " == " + set[i][j].toString());
                    }
                }
            }
        }
        Utils.writeFile(set);
        double[] areas;
        areas = trueTrapezoidArea(set);

        return areas;
    }

    private double[] trueTrapezoidArea(Point[][] set) {
//        System.out.println("trueTrapezoidArea - start");
        double[] temporary = new double[Utils.summm(set.length)];
        int q = 0;
        try {
            for (int i = 0; i < set.length - 1; i++) {
                if (set[i] != null) {
//                    System.out.println("trueTrapezoidArea set[i][0] " + set[i][0]);
                    for (int j = (i + 1); j < set.length; j++) {
                        if (set[j] != null) {
                            temporary[q] = getEdges(set[i], set[j]);
//                            System.out.println("temporary area " + temporary[q]);
                            q++;
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Empty point " + Arrays.toString(e.getStackTrace()));
        }
//        System.out.println("trueTrapezoidArea - end");
        return temporary;
    }

    /**
     * returns trapezoid Edges, fix one edge so it become trapezoid
     */
    private double getEdges(Point[] in1, Point[] in2) {
        Point[] set1, set2;
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
        return trapezoidArea(set1, set2);
    }

    /**
     * trapezoid area by 4-points, base a(set1[0], set2[0]) & base b(set1[1], set2[1])
     */
    private double trapezoidArea(Point[] set1, Point[] set2) {
        double a, b, c, d, s;//todo: why NaN???? add check for this
        b = (new LineSegment(set1[0].getX(), set1[0].getY(), set2[0].getX(), set2[0].getY())).segmentLength();
        a = (new LineSegment(set1[1].getX(), set1[1].getY(), set2[1].getX(), set2[1].getY())).segmentLength();
        c = (new LineSegment(set1[0].getX(), set1[0].getY(), set1[1].getX(), set1[1].getY())).segmentLength();
        d = (new LineSegment(set2[0].getX(), set2[0].getY(), set2[1].getX(), set2[1].getY())).segmentLength();
        s = (a + b + c + d) / 2;
        System.out.println("TEST (b-a)  " + Math.abs(b - a));
        double area = (((a + b) / Math.abs(b - a)) * Math.sqrt((s - b) * (s - a) * (s - b - c) * (s - b - d)));
        System.out.println("Trapezoid area:\n\ta = " + a + "\n\tb = " + b + "\n\tc = " + c + "\n\td = " + d
                + "\n\ts = " + s + "\n\tarea = " + area);
        return area;
    }

    private Point newCrossPoint(Line baseB, Point point, Point[] set) {
        Line baseA = new Line(baseB.getA(), baseB.getB(), (-baseB.getA() * point.getX() - baseB.getA() * point.getY()));
        Line cross = new Line(set[0].getX(), set[0].getY(), set[1].getX(), set[1].getY());
        double x = baseA.crossLineX(cross);
        double y = baseA.crossLineY(cross);
        return new Point(x, y);
    }

    //витягнути дві точки які
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
        System.out.println("75line/AreaCalc/method: crossPoint() start");
        Line line;
        line = new Line(spectator.getX(), spectator.getY(), point.getX(), point.getY());
        {//sout to console
            System.out.println("\n\t78line/AreaCalc/Specific line " + line.toString());
        }
        Point[] tmp = new Point[2];
        int q = 0;
        try {
            for (int j = 0; j < lines.length; j++) {
                System.out.println("84line/AreaCalc/testttt " + setCrossPoint(line, lines[j]));
                System.out.println("85line/AreaCalc/segments[j] " + segments[j].toString() + "  lines[j] " + lines[j].toString());
                if (lines[j].hasCross(line) && (counterSegments(segments[j], line, lines[j]) == 1)) {//sout to console
                    tmp[q] = setCrossPoint(line, lines[j]);
                    System.out.println("88line/AreaCalc/Working point " + tmp[q].toString());
                    q++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("92line/AreaCalc/ Null exception " + e.fillInStackTrace());
        }

        double one, two;
        one = (new LineSegment(spectator.getX(), spectator.getY(), tmp[0].getX(), tmp[0].getY()).segmentLength());
        two = (new LineSegment(spectator.getX(), spectator.getY(), tmp[1].getX(), tmp[1].getY()).segmentLength());
        {//sout to console
            System.out.println("\n\t101line/AreaCalc/Distance to first point " + one);
            System.out.println("\n\t102line/AreaCalc/Distance to second point " + two);
        }
        if (one > two) {
            {//sout to console
                System.out.println("\n\tone > two");
            }
            return tmp;
        } else {
            {//sout to console
                System.out.println("\n\tone < two");
            }
            Point z = tmp[0];
            tmp[0] = tmp[1];
            tmp[1] = z;
        }
        System.out.println("method: crossPoint() end");
        return tmp;
    }

    private Point setCrossPoint(Line test, Line lines) {
        System.out.println("method: setCrossPoint() start");
        double x, y;
        x = test.crossLineX(lines);
        y = test.crossLineY(lines);
        System.out.println("\t\tx, y =  " + x + "  " + y);
        System.out.println("method: setCrossPoint() end");
        return new Point(x, y);
    }

    //workingset I == crossCount I
    private void crossCounter(int[] array, Point spectator, Point[] workingSet) {
        int q = 0;
        System.out.println("lines.length " + lines.length);
        for (int i = 0; i < workingSet.length; i++) {
            Line test = new Line(spectator.getX(), spectator.getY(), workingSet[i].getX(), workingSet[i].getY());
            for (int j = 0; j < lines.length; j++) {
                if (lines[j].hasCross(test)) {//sout to console
                    q += counterSegments(segments[j], test, lines[j]);
                    //System.out.println("has cross, q = "+q);
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
        if (xRight && yRight) {
            return 1;
        } else if (xReverse && yReverse) {
            return 1;
        } else if (xRight && yReverse) {
            return 1;
        } else if (xReverse && yRight) {
            return 1;
        }
        return 0;
    }

    private void initialiseLineSegment(Point[] shape) {
        Point tmp = shape[shape.length - 1];
        System.out.println("shape.length = " + shape.length);
        for (int i = 0; i < shape.length; i++) {
            lines[i] = new Line(tmp.getX(), tmp.getY(), shape[i].getX(), shape[i].getY());
            segments[i] = new LineSegment(tmp.getX(), tmp.getY(), shape[i].getX(), shape[i].getY());
            tmp = shape[i];
        }
    }
}
