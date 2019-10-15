import components.Point;
import processing.AreaCalc;
import processing.PointsProcessing;
import processing.Utils;

public class Service {
    private Point spectator;
    private Point[] shape;
    private double fraction;
    private Point[] workingSet;


    public Service(String pathToFile, Point spectator, int index, double fraction) {
        this.fraction = fraction;
        this.spectator = spectator;
        operatePoints(pathToFile, index);

    }

    public double areaCalculation() {
        AreaCalc trapezoidArea = new AreaCalc();
        double[] trapezoidAreas = trapezoidArea.getAreaTMP(spectator, shape, workingSet);
        return Utils.getMax(trapezoidAreas);
    }

    private void operatePoints(String path, int index) {
        PointsProcessing points = new PointsProcessing();
        shape = Utils.readPoints(path);// read from file
        shape = points.preparePoints(shape);//returns valid points
        Utils.writeFile(shape);
        Point[] extendedShapes = points.extentPointsSet(shape, index);
        Utils.writeFile(extendedShapes);
        double[] distances = points.distance(spectator, extendedShapes);
        Utils.shakerSorting(distances, extendedShapes);
        // only for sorted by distance
        workingSet = points.pointsForWork(distances, extendedShapes, fraction);//todo: returns incorrect set of points
        Utils.writeFile(workingSet);
    }
}
