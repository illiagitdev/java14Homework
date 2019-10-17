import components.Point;
import processing.AreaCalc;
import processing.PointsProcessing;
import processing.Utils;

class Service {
    private Point spectator;
    private Point[] shape;
    private double fraction;
    private Point[] workingSetFar;
    private Point[] workingSetNear;


    Service(String pathToFile, Point spectator, int index, double fraction) {
        this.fraction = fraction;
        this.spectator = spectator;
        operatePoints(pathToFile, index);
    }

    double[] areaCalculation() {
        double[] areaSet = new double[3];
        AreaCalc trapezoidArea = new AreaCalc();
        //------------------- by Far points
        double[] trapezoidAreasFar = trapezoidArea.getAreaTMP(spectator, shape, workingSetFar);
        if (trapezoidAreasFar.length > 1) {
            areaSet[0] = Utils.getMax(trapezoidAreasFar);
        } else {
            areaSet[0] = trapezoidAreasFar[0];
        }
        //------------------- by Near points
        double[] trapezoidAreasNear = trapezoidArea.getAreaTMP(spectator, shape, workingSetNear);
        if (trapezoidAreasFar.length > 1) {
            areaSet[1] = Utils.getMax(trapezoidAreasNear);
        } else {
            areaSet[1] = trapezoidAreasNear[0];
        }
//------------------- by MIX points
        double[] trapezoidAreasMix = trapezoidArea.getAreaTMPMix(spectator, shape, workingSetFar, workingSetNear);
        if (trapezoidAreasMix.length > 1) {
            areaSet[2] = Utils.getMax(trapezoidAreasMix);
        } else {
            areaSet[2] = trapezoidAreasMix[0];
        }
        return areaSet;
    }

    private void operatePoints(String path, int index) {
        PointsProcessing points = new PointsProcessing();
        shape = Utils.readPoints(path);
        shape = points.preparePoints(shape);
        Utils.writeFile(shape, "for shape points");
        Point[] extendedShapes = points.extentPointsSet(shape, index);
        Utils.writeFile(extendedShapes, "for extendedShapes points");
        double[] distances = points.distance(spectator, extendedShapes);
        Utils.shakerSorting(distances, extendedShapes);
        // only for sorted by distance
        workingSetFar = points.pointsForWorkFar(distances, extendedShapes, fraction);
        Utils.writeFile(workingSetFar, "for FAR points");
        workingSetNear = points.pointsForWorkNear(distances, extendedShapes, fraction);
        Utils.writeFile(workingSetNear, "for NEAR points");
    }
}
