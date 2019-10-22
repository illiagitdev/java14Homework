import components.Point;
import processing.TrapezoidComponents;

public class Trapezoid {
    public static void main(String[] args) {
        Point spectator = new Point(1.111, 11.800);
        String pathToFile = "files/set2.txt";
        String[] list = {"FAR", "NEAR", "MIX"};

        Service service = new Service(spectator, 0.35);
        service.operatePoints(pathToFile, 15);

        TrapezoidComponents[] area = service.areaCalculation();
        Point[] tmp;
        for (int i = 0; i < area.length; i++) {
            tmp=area[i].getTrapezEdges();
            System.out.println("Trapezoid MAX area by " + list[i] + " point is = " + area[i].getArea());
            for (int j = 0; j < area[i].getTrapezEdges().length; j++) {
                System.out.println("Trapezoid edges\n" + tmp[j].toString());
            }
        }
    }
}
