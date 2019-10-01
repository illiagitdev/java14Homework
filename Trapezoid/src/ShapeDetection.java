import components.Point;
import components.Vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShapeDetection {
    public static void main(String[] args) throws FileNotFoundException {
        // spectator point
        Point spectator = new Point(1.111, 11.800);
        Point[] shape = readPoints("files/set2.txt");
        Vector[] shapeVectors;
        shapeVectors = defineVectors(shape);

        // checking if it good or bad to use this shape
        validateShape(shape, shapeVectors);

        //shows results: POINTS
//        for (Point x : shape) {
//            System.out.println(x.toString());
//        }
        // VECTORS
//        for (Vector x : shapeVectors) {
//            System.out.println(x.toString());
//        }
    }

    /**
     * Returns new set of points and vectors if condition met - all cross products either > or < '0'
     * clears next incapable point and check again
     *
     * @param shape        - reference to points list
     * @param shapeVectors - reference to vectors list
     * @return
     */
    private static void validateShape(Point[] shape, Vector[] shapeVectors) {
        // vector cross multiplication
        double[] vectorCross = new double[shapeVectors.length];
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
                //for visual verification only
//                System.out.println("[AxB] = " + vectorCross[i] +
//                 "\tteta = " + Math.toDegrees(Math.asin(vectorCross[i] / (tmp.length() * shapeVectors[i].length()))));
                tmp = shapeVectors[i];
            }
            //detecting bad points
            if (positive == 0 || negative == 0) {
                System.out.println("All good with shape");
                flag = false;
            } else if (positive < negative) {
                System.out.println("We have mismatch point(s)");
                for (int i = 0; i < vectorCross.length; i++) {
                    if (vectorCross[i] > 0) {
                        //System.out.println("Point to delete: "+ shape[i==0?shape.length-1:i-1].toString());//todo:this
                        shape = resizeShapes(shape, i);
                        shapeVectors = defineVectors(shape);
                        validateShape(shape, shapeVectors);// recursion
                        flag = false;
                        break;
                    }
                }
            } else {
                System.out.println("We have mismatch point(s)");
                for (int i = 0; i < vectorCross.length; i++) {
                    if (vectorCross[i] < 0) {
                        //System.out.println("Point to delete: "+ shape[i].toString());todo:this
                        shape = resizeShapes(shape, i);
                        shapeVectors = defineVectors(shape);
                        validateShape(shape, shapeVectors);// recursion
                        flag = false;
                        break;
                    }
                }
            }
        }

    }

    /**
     * returns resized set of points and vectors, each iteration do '-1'
     *
     * @param shape
     * @param i
     */
    private static Point[] resizeShapes(Point[] shape, int i) {
        Point[] newShape = new Point[shape.length - 1];
        int k = 0;
        for (int j = 0; j < shape.length; j++) {
            if (i != j) {
                newShape[k] = shape[j];
                k++;
            }
        }
        return newShape;
    }

    /**
     * Returns vectors on given points
     *
     * @param shape
     */
    private static Vector[] defineVectors(Point[] shape) {
        Vector[] shapeVectors = new Vector[shape.length];
        Point tmp = shape[shape.length - 1];
        for (int i = 0; i < shape.length; i++) {
            shapeVectors[i] = new Vector(tmp, shape[i]);
            tmp = shape[i];
        }
        return shapeVectors;
    }

    /**
     * Returns array of points readed from external file, like: A(x,y)
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     */
    static private Point[] readPoints(String path) throws FileNotFoundException {
        Scanner file = new Scanner(new File(path));
        String[] lines;
        int counter = 0;
        while (file.hasNext()) {
            file.next();
            counter++;
        }
        file.close();

        file = new Scanner(new File(path));
        System.out.println(counter);
        Point[] list = new Point[counter];
        counter = 0;
        while (file.hasNext()) {
            lines = file.next().split(",");
            list[counter] = new Point(Double.valueOf(lines[0]), Double.valueOf(lines[1]));
            counter++;
        }
        file.close();
        return list;
    }

}
