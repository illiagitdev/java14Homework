import components.Point;
import processing.AreaCalc;
import processing.PointsProcessing;
import processing.TrapezoidComponents;
import processing.Utils;

class Service {
    private Point spectator;
    private Point[] shape;
    private double fraction;
    private Point[] workingSetFar;
    private Point[] workingSetNear;
    private Point edges[][];
    private TrapezoidComponents[] trapezoids;

    Service(Point spectator, double fraction) {
        this.fraction = fraction;
        this.spectator = spectator;
        trapezoids=new TrapezoidComponents[3];
    }

    TrapezoidComponents[] areaCalculation() {
        TrapezoidComponents[] areaSet = new TrapezoidComponents[3];
        AreaCalc trapezoidArea = new AreaCalc();
        //------------------- by Far points
        TrapezoidComponents[] trapezoidAreasFar = trapezoidArea.getAreaTMP(spectator, shape, workingSetFar);
        if (trapezoidAreasFar.length > 1) {
            areaSet[0] = Utils.getMax(trapezoidAreasFar);
        } else {
            areaSet[0] = trapezoidAreasFar[0];
        }
        //------------------- by Near points
        TrapezoidComponents[] trapezoidAreasNear = trapezoidArea.getAreaTMP(spectator, shape, workingSetNear);
        if (trapezoidAreasFar.length > 1) {
            areaSet[1] = Utils.getMax(trapezoidAreasNear);
        } else {
            areaSet[1] = trapezoidAreasNear[0];
        }
//------------------- by MIX points
        TrapezoidComponents[] trapezoidAreasMix = trapezoidArea.getAreaTMPMix(spectator, workingSetFar, workingSetNear);
        if (trapezoidAreasMix.length > 1) {
            areaSet[2] = Utils.getMax(trapezoidAreasMix);
        } else {
            areaSet[2] = trapezoidAreasMix[0];
        }
        return areaSet;
    }

    public void operatePoints(String path, int index) {
        PointsProcessing points = new PointsProcessing();
        shape = Utils.readPoints(path);
        shape = points.preparePoints(shape);
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
