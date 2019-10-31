package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class RMC implements GpsMessages {
    private String text;

    @Override
    public void getDescription(String[] input) {
        LocalTime timeUTC = Utils.getTimeSS(input[0]);
        Character statusIndicator = Utils.getChar0(input[1]);

        int latitudeDegree = Utils.returnInteger(input[2].substring(0, input[2].indexOf('.') - 2));
        double latitudeMin = Utils.returnDouble(input[2].substring(input[2].indexOf('.') - 2));
        Character indicatorNS = Utils.getChar0(input[3]);
        int longitudeDegree = Utils.returnInteger(input[4].substring(0, input[4].indexOf('.') - 2));
        double longitudeMin = Utils.returnDouble(input[4].substring(input[4].indexOf('.') - 2));
        Character indicatorEW = Utils.getChar0(input[5]);

        double speedKnots = Utils.returnDouble(input[6]);
        double heading = Utils.returnDouble(input[7]);
        LocalDate timeUTCfix = Utils.getDate(input[8]);
        double magneticVar = Utils.returnDouble(input[9]);
        Character magneticVarID = Utils.getChar0(input[10]);

        text = "RMC -  Recommended Minimum Specific GNSS Data\n\n" +
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
                magneticVarID + " - (Character) direction of magnetic variation. Either E=East or W=West\n";
    }

    @Override
    public String toString() {
        return text;
    }
}
