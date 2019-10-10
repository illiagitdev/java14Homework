import components.Point;
import processing.PointsProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Service {
    private Point spectator;
    private double fraction;

    public Service(String pathToFile, Point spectator, int index, double fraction) {
        this.fraction = fraction;
        this.spectator = spectator;
        operatePoints(pathToFile, index);
    }

    private PointsProcessing points = new PointsProcessing();

    public void operatePoints(String path, int index) {
        Point[] shape = readPoints(path);// read from file
        shape = points.preparePoints(shape);//returns valid points
        Point[] extendedShapes = points.extentPointsSet(shape, index);
        writeFile(extendedShapes);
        double[] distances = points.distance(spectator, extendedShapes);
        shakerSorting(distances, extendedShapes);
        // only for sorted by distance
        Point[] workingSet = points.pointsForWork(distances, extendedShapes, fraction);
        writeFile(workingSet);
    }

    /**
     * Returns array of points read from external file, like: x, y
     */
    private Point[] readPoints(String path) {
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

    private void writeFile(Point[] shape) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd+HH-mm-ss-SSS");
        String path = "files/output/points" + time.format(formatter) + ".csv";
        try {
            FileWriter writer = new FileWriter(path);
            for (Point point : shape) {
                writer.write(point.wrightToFile() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: file hasn't been written!" + e.toString());
        }
    }

    private void shakerSorting(double[] distance, Point[] extendedShapes) {
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
}
