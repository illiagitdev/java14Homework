import components.Point;

public class Trapezoid {
    public static void main(String[] args) {
        Point spectator = new Point(1.111, 11.800);
        String pathToFile = "files/set2.txt";

        Service service = new Service(pathToFile, spectator, 15, 0.35);

        double[] area = service.areaCalculation();
        System.out.println("Trapezoid MAX area by FAR point is = " + area[0]);
        System.out.println("Trapezoid MAX area by NEAR point is = " + area[1]);
        System.out.println("Trapezoid MAX area by MIX point is = " + area[2]);
    }
}
