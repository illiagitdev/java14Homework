package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class RMC implements GpsMessages {
    public String[] array=new String[15];



    private LocalTime timeUTC = Utils.getTime(array[0]);// 22:54:46 UTC
    private Character statusIndicator = Utils.getChar0(array[1]);

    private int latitudeDegree = Utils.returnInteger(array[2].substring(0, array[2].indexOf('.') - 2));
    private double latitudeMin = Utils.returnDouble(array[2].substring(array[2].indexOf('.') - 2));
    private Character indicatorNS = Utils.getChar0(array[3]);
    private int longitudeDegree = Utils.returnInteger(array[4].substring(0, array[4].indexOf('.') - 2));
    private double longitudeMin = Utils.returnDouble(array[4].substring(array[4].indexOf('.') - 2));
    private Character indicatorEW = Utils.getChar0(array[5]);

    private double speedKnots = Utils.returnDouble(array[6]);
    private double heading = Utils.returnDouble(array[7]);
    private LocalDate timeUTCfix =Utils. getDate(array[8]);
    private double magneticVar = Utils.returnDouble(array[9]);
    private Character magneticVarID = Utils.getChar0(array[10]);

    public void show() {
        System.out.println("RMC -  Recommended Minimum Specific GNSS Data\n\n" +
                timeUTC + " - (String) UTC time of the fix\n" +
                statusIndicator + " - (Character) Status indicator. A=valid; V=invalid\n" +
                latitudeDegree + " deg. " + latitudeMin + " min. - (Integer,Double) Latitude of position\n" +
                indicatorNS + " - (Character) ‘N’ = North, ‘S’ = South\n" +
                longitudeDegree + " deg. " + longitudeMin + " min. - (Integer,Double) Longitude of position\n" +
                indicatorEW + " - (Character) ‘E’ = East, ‘W’ = West\n" +
                speedKnots + " knots - (Double) Speed over ground in knots\n" +
                heading + " - (Double) True course\n" +
                timeUTCfix + " - (Date) UTC Date of the fix\n" +
                magneticVar + " degree - (Double) Magnetic variation\n" +
                magneticVarID + " - (Character) direction of magnetic variation. Either E=East or W=West\n");
    }
}
