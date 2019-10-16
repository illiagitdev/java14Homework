import components.Point;

public class Trapezoid {
    public static void main(String[] args) {
        // spectator position
        Point spectator = new Point(1.111, 11.800);
        String pathToFile = "files/set2.txt";

        Service service = new Service(pathToFile, spectator, 3, 0.75);

        double area = service.areaCalculation();
        System.out.println("Trapezoid MAX area is = " + area);
    }
}
