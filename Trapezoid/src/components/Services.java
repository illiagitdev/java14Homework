package components;

import java.io.*;
import java.util.Scanner;

public class Services {
    private Point[] shape;
    private Vector[] shapeVectors;

    public void preparePoints(String pathToFile) {
        shape = readPoints(pathToFile);
        shapeVectors = defineVectors(shape);

        shape = validateShape(shape, shapeVectors);

        writeFile(shape);
    }

    /**
     * Returns array of points read from external file, like: x, y
     */
    static private Point[] readPoints(String path) {
        String[] lines;
        Point[] list = null;
        int length = 0;
        try {
            Scanner file = new Scanner(new File(path));
            while (file.hasNext()) {
                file.next();
                length++;
            }
            file.close();

            file = new Scanner(new File(path));
            list = new Point[length];
            length = 0;
            while (file.hasNext()) {
                lines = file.next().split(",");
                list[length] = new Point(Double.valueOf(lines[0]), Double.valueOf(lines[1]));
                length++;
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("error: File not found!");
        }
        return list;
    }

    /**
     * Returns vectors on given points
     */
    private static Vector[] defineVectors(Point[] shape) {
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
    private static Point[] validateShape(Point[] shape, Vector[] shapeVectors) {
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
                tmp = shapeVectors[i];
            }
            if (positive == 0 || negative == 0) {
                flag = false;
            } else if (positive < negative) {
                for (int i = 0; i < vectorCross.length; i++) {
                    if (vectorCross[i] > 0) {
                        shape = resizePointsArray(shape, i);
                        shapeVectors = defineVectors(shape);
                        shape = validateShape(shape, shapeVectors);
                        flag = false; break;
                    }
                }
            } else {
                for (int i = 0; i < vectorCross.length; i++) {
                    if (vectorCross[i] < 0) {
                        shape = resizePointsArray(shape, i);
                        shapeVectors = defineVectors(shape);
                        shape = validateShape(shape, shapeVectors);
                        flag = false; break;
                    }
                }
            }
        }
        return shape;
    }

    /**
     * returns resized set of points and vectors, each iteration do '-1'
     */
    private static Point[] resizePointsArray(Point[] shape, int i) {
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

    private static void writeFile(Point[] shape) {
        try {
            FileWriter writer= new FileWriter("files/out.dat");
            writer.flush();
            for (Point point : shape) {
                writer.write(point.wrightToFile() + "\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println("Error: file hasn't been written!");
        }
    }
}
