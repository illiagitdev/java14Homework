package processing;

import components.LineSegment;
import components.Point;
import components.Vector;

public class PointsProcessing {

    // get points and fit so this set of points good for work
    public Point[] preparePoints(Point[] shape) {
        shape = validateShape(shape);
        return shape;
    }

    // extends shape with new points
    public Point[] extentPointsSet(Point[] shape, int index) {
        LineSegment[] segments = setSegments(shape);
        Point[] extendedShapes = addPoints(segments, shape, index);
        return extendedShapes;
    }

    public double[] distance(Point from, Point[] to){
        double[] distances = new double[to.length];
        for (int i = 0; i < to.length; i++) {
            distances[i] =(new LineSegment(from.getX(),from.getY(),to[i].getX(),to[i].getY())).segmentLength();
        }
        return distances;
    }

    /**
     * For input - sorted pair by distance with increase of distance
     */
    public Point[] pointsForWork(double[] distances, Point[] extendedShapes, double fraction) {
        int newLength = 0, startPoint = 0;
        double limit = distances[0] + (distances[distances.length - 1] - distances[0]) * fraction;
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] > limit) {
                startPoint = i;
                newLength = distances.length - startPoint - 1;
                break;
            }
        }
        double[] tempDistance = new double[newLength];
        Point[] tempPoint = new Point[newLength];
        for (int i = startPoint, k = 0; i < distances.length && k < newLength; i++, k++) {
            tempDistance[k] = distances[i];
            tempPoint[k] = new Point(extendedShapes[i].getX(), extendedShapes[i].getY());
        }
        return tempPoint;
    }

    /**
     * Returns vectors on given points
     */
    private Vector[] defineVectors(Point[] shape) {
        Vector[] shapeVectors = new Vector[shape.length];
        Point tmp = shape[shape.length - 1];
        for (int i = 0; i < shape.length; i++) {
            shapeVectors[i] = new Vector(tmp.getX(), tmp.getY(), shape[i].getX(), shape[i].getY());
            tmp = shape[i];
        }
        return shapeVectors;
    }

    /**
     * Returns new set of points and vectors if condition met - all cross products either > or < '0'
     * clears next incapable point and check again
     * double teta = " + Math.toDegrees(Math.asin(vectorCross[i] / (tmp.length() * shapeVectors[i].length())))
     */
    private Point[] validateShape(Point[] shape) {
        Vector[] shapeVectors = defineVectors(shape);
        double[] vectorCross = new double[shape.length];
        int positive = 0, negative = 0;
        boolean flag = true;
        Vector tmp = shapeVectors[shapeVectors.length - 1];

        while (flag) {
            for (int i = 0; i < shapeVectors.length; i++) {
                vectorCross[i] = shapeVectors[i].crossProductZ(tmp);
                if (vectorCross[i] > 0) {
                    positive++;
                } else if (vectorCross[i] < 0) {
                    negative++;
                }
                tmp = shapeVectors[i];
            }
            if (positive == 0 || negative == 0) {
                flag = false;
            } else if (positive < negative) {
                for (int i = 0; i < vectorCross.length; i++) {
                    if (vectorCross[i] > 0) {
                        shape = resizePointsArray(shape, i);
                        shapeVectors = defineVectors(shape);
                        shape = validateShape(shape);
                        flag = false;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < vectorCross.length; i++) {
                    if (vectorCross[i] < 0) {
                        shape = resizePointsArray(shape, i);
                        shapeVectors = defineVectors(shape);
                        shape = validateShape(shape);
                        flag = false;
                        break;
                    }
                }
            }
        }
        return shape;
    }

    /**
     * returns resized set of points and vectors, each iteration do '-1'
     */
    private Point[] resizePointsArray(Point[] shape, int i) {
        Point[] newShape = new Point[shape.length - 1];
        int k = 0;
        {//sout kicked point
            System.out.println("\n\tKicked point i = " + i + " point = " + shape[i].toString());
        }
        for (int j = 0; j < shape.length; j++) {
            if (i != j) {
                newShape[k] = shape[j];
                k++;
            }
        }
        return newShape;
    }

    private LineSegment[] setSegments(Point[] shape) {
        LineSegment[] segments = new LineSegment[shape.length];
        Point tmp = shape[shape.length - 1];
        for (int i = 0; i < shape.length; i++) {
            segments[i] = new LineSegment(tmp.getX(), tmp.getY(), shape[i].getX(), shape[i].getY());
            tmp = shape[i];
        }
        return segments;
    }

    // wrights new points from the end of old set of points
    private Point[] addPoints(LineSegment[] segment, Point[] pull, int index) {
        Point[] newPoints = new Point[pull.length * (index + 1)];
        Point[] tmp; // todo: fix - adding points in correct order
        for (int i = 0; i < pull.length; i++) {
            newPoints[i] = pull[i];
            tmp = addPoint(segment[i], index);
            for (int j = 0; j < tmp.length; j++) {
                newPoints[pull.length + i * index + j] = tmp[j];
            }
        }
        return newPoints;
    }

    /**
     * Adding new points to the end of current pull of poins
     */
    private Point[] addPoint(LineSegment segment, int index) {
        double dx = (segment.getSecondX() - segment.getFirstX()) / (index + 1);
        double dy = (segment.getSecondY() - segment.getFirstY()) / (index + 1);
        Point[] points = new Point[index];
        for (int i = 0; i < index; i++) {
            points[i] = new Point(segment.getFirstX() + dx * (i + 1), segment.getFirstY() + dy * (i + 1));
        }
        return points;
    }
}
