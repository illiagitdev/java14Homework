import components.Point;
import components.Services;

public class Trapezoid {
    public static void main(String[] args) {
        // spectator position
        Point spectator = new Point(1.111, 11.800);
        String pathToFile="files/set2.txt";

        Services service = new Services();
        service.preparePoints(pathToFile);
    }
}
