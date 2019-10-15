package processing;

import components.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utils {
    /**
     * Returns array of points read from external file, like: x, y
     */
    public static Point[] readPoints(String path) {
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
                list[length] = new Point(Double.parseDouble(lines[0]), Double.parseDouble(lines[1]));
                length++;
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("error: File not found!" + e.toString());
        }
        return list;
    }

    public static void writeFile(Point[] shape) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd+HH-mm-ss-SSS");
        String path = "files/output/points" + time.format(formatter) + ".csv";
        try {
            FileWriter writer = new FileWriter(path);
            //writer.flush();
            for (Point point : shape) {
                writer.write(point.wrightToFile() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: file hasn't been written!" + e.toString());
        }
    }

    /**
     * Shaker sorting
     */
    public static void shakerSorting(double[] distance, Point[] extendedShapes) {
        double tmp;
        Point pointTmp;
        for (int i = 0; i < distance.length - 1; i++) {
            for (int j = i; j < distance.length - (i + 1); j++) {
                if (distance[j] > distance[j + 1]) {
                    tmp = distance[j];
                    distance[j] = distance[j + 1];
                    distance[j + 1] = tmp;
                    pointTmp = extendedShapes[j];
                    extendedShapes[j] = extendedShapes[j + 1];
                    extendedShapes[j + 1] = pointTmp;
                }
            }
            for (int j = distance.length - (i + 2); j > i; j--) {
                if (distance[j - 1] > distance[j]) {
                    tmp = distance[j];
                    distance[j] = distance[j - 1];
                    distance[j - 1] = tmp;
                    pointTmp = extendedShapes[j];
                    extendedShapes[j] = extendedShapes[j - 1];
                    extendedShapes[j - 1] = pointTmp;
                }
            }
        }
    }

    public static double getMax(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static int summm(int n) {
        if (n == 2) {
            return 1;
        }
        return n + summm(n - 1);
    }

    public static void writeFile(Point[][] set) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd+HH-mm-ss-SSS");
        String path = "files/output/edges" + time.format(formatter) + ".csv";
        try {
            FileWriter writer = new FileWriter(path);
            for (int i = 0; i < set.length; i++) {
                if (set[i]!=null){
                    for (Point point : set[i]) {
                        writer.write(point.wrightToFile() + "\n");
                    }
                }
            }
            writer.close();
        } catch (NullPointerException e){
            System.out.println("Error: no element in array !" + e.toString());
        } catch (IOException e) {
            System.out.println("Error: file hasn't been written!" + e.toString());
        }
    }
}
