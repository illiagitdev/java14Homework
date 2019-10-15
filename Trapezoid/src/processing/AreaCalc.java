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
        int range = Utils.summm(workingSet.length - 1);

        double[] areas = new double[range];
        //areas=trueTrapezoidArea(set);
        return areas;
    }

    private void getPoints(Point spectator, int[] crossCount, Point[] workingSet, Point[][] set) {
        int q = 0;
        for (int i = 0; i < crossCount.length; i++) {
            if (crossCount[i] == 2) {
                set[q++] = crossPoints(spectator, workingSet[i]);
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
                Point z=tmp[0];
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
