package processing;

import components.LineSegment;
import components.Point;
import components.Vector;

public class PointsProcessing {

    public Point[] preparePoints(Point[] shape) {
        shape = validateShape(shape);
        return shape;
    }

    public Point[] extentPointsSet(Point[] shape, int index) {
        LineSegment[] segments = setSegments(shape);
        return addPoints(segments, shape, index);
    }

    public double[] distance(Point from, Point[] to) {
        double[] distances = new double[to.length];
        for (int i = 0; i < to.length; i++) {
            distances[i] = (new LineSegment(from.getX(), from.getY(), to[i].getX(), to[i].getY())).segmentLength();
        }
        return distances;
    }

    public Point[] pointsForWorkFar(double[] distances, Point[] extendedShapes, double fraction) {
        int newLength = 0, startPoint = 0;
        double limit = distances[0] + (distances[distances.length - 1] - distances[0]) * (1 - fraction);
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] > limit) {
                startPoint = i;
                newLength = distances.length - startPoint - 1;
                break;
            }
        }
        Point[] tempPoint = new Point[newLength];
        for (int i = startPoint, k = 0; i < distances.length && k < newLength; i++, k++) {
            tempPoint[k] = new Point(extendedShapes[i].getX(), extendedShapes[i].getY());
        }
        return tempPoint;
    }

    public Point[] pointsForWorkNear(double[] distances, Point[] extendedShapes, double fraction) {
        int newLength = 0;
        double limit = distances[0] + (distances[distances.length - 1] - distances[0]) * fraction;
        int k = 0;
        while (distances[k] < limit) {
            newLength = k++;
        }
        Point[] tempPoint = new Point[newLength];
        for (int i = 0; i < newLength; i++) {
            tempPoint[i] = new Point(extendedShapes[i].getX(), extendedShapes[i].getY());
        }
        return tempPoint;
    }

    private Vector[] defineVectors(Point[] shape) {
        Vector[] shapeVectors = new Vector[shape.length];
        Point tmp = shape[shape.length - 1];
        for (int i = 0; i < shape.length; i++) {
            shapeVectors[i]=new Vector();
            shapeVectors[i].setX(shape[i].getX() - tmp.getX());
            shapeVectors[i].setY(shape[i].getY() - tmp.getY());
            tmp = shape[i];
        }
        return shapeVectors;
    }

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

    private Point[] resizePointsArray(Point[] shape, int i) {
        Point[] newShape = new Point[shape.length - 1];
        int k = 0;
        {
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

    private Point[] addPoints(LineSegment[] segment, Point[] pull, int index) {
        Point[] newPoints = new Point[pull.length * (index + 1)];
        Point[] tmp;
        for (int i = 0; i < pull.length; i++) {
            newPoints[i] = pull[i];
            tmp = addPoint(segment[i], index);
            for (int j = 0; j < tmp.length; j++) {
                newPoints[pull.length + i * index + j] = tmp[j];
            }
        }
        return newPoints;
    }

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
