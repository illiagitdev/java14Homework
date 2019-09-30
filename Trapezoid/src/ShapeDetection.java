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

        Vector[] shapeVectors = new Vector[shape.length];
        defineVectors(shapeVectors, shape);

        validateShape(shapeVectors);
    }

    private static void validateShape(Vector[] shapeVectors) {
        double[] vectorCross = new double[shapeVectors.length];
        int plus=0, minus=0;
        Vector tmp = shapeVectors[shapeVectors.length - 1];
        for (int i = 0; i < shapeVectors.length; i++) {
            // vector cross multiplication
            vectorCross[i]=shapeVectors[i].crossProductZ(tmp);
                if(vectorCross[i]>0){
                    plus++;
                }else if (vectorCross[i]<0){
                    minus++;
                }
                System.out.println("[AxB] = " + vectorCross[i]);
                tmp = shapeVectors[i];
            }
            if(plus==0 ||minus==0){
                System.out.println("All good with shape");
            }else {
                System.out.println("We have mismatch point(s)");
            }
    }

    /**
     * Returns vectors on given points
     *
     * @param shapeVectors
     * @param shape
     */
    private static void defineVectors(Vector[] shapeVectors, Point[] shape) {
        Point tmp = shape[shape.length - 1];
        for (int i = 0; i < shape.length; i++) {
            shapeVectors[i] = new Vector(tmp, shape[i]);
            tmp = shape[i];
        }
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
