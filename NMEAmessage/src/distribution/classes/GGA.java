package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

import java.time.LocalTime;

public class GGA implements GpsMessages {
    private String text;

    @Override
    public void getDescription(String[] input) {
        LocalTime timeUTC = Utils.getTimeS(input[0]);//22:54:44 UTC

        int latitudeDegree = Utils.returnInteger(input[1].substring(0, input[1].indexOf('.') - 2));
        double latitudeMin = Utils.returnDouble(input[1].substring(input[1].indexOf('.') - 2));
        Character indicatorNS = Utils.getChar0(input[2]);
        int longitudeDegree = Utils.returnInteger(input[3].substring(0, input[3].indexOf('.') - 2));
        double longitudeMin = Utils.returnDouble(input[3].substring(input[3].indexOf('.') - 2));
        Character indicatorEW = Utils.getChar0(input[4]);

        int qualityIndicator = Utils.returnInteger(input[5]);
        int satellitesUsed = Utils.returnInteger(input[6]);
        double HDOP = Utils.returnDouble(input[7]);
        double altitude = Utils.returnDouble(input[8]);
        Character altitudeIndex = Utils.getChar0(input[9]);
        double geoidalSeparation = Utils.returnDouble(input[10]);
        Character geoidalSeparationIndex = Utils.getChar0(input[11]);
        int alignmentDGPS = Utils.returnInteger(input[12]);//Age of Differential GPS data (seconds)
        int refStation = Utils.returnInteger(input[13]);

        text = "GGA - Global Positioning System Fix Data\n\n" +
                timeUTC + " - (String) UTC of position\n" +
                latitudeDegree + " deg. " + latitudeMin + " min. - (Integer,Double) Latitude of position\n" +
                indicatorNS + " - (Character) ‘N’ = North, ‘S’ = South\n" +
                longitudeDegree + " deg. " + longitudeMin + " min. - (Integer,Double) Longitude of position\n" +
                indicatorEW + " - (Character) ‘E’ = East, ‘W’ = West\n" +
                qualityIndicator + " - (Integer) GPS quality indicator: 0 - invalid, 1 - GPS fix, 2 - DGPD fix\n" +
                satellitesUsed + " - (Integer) Number of Satellites\n" +
                HDOP + " - (Double) HDOP\n" +
                altitude + " meters - (Double) Mean sea level altitude\n" +
                altitudeIndex + " - (Character) units of antenna altitude, meters\n" +
                geoidalSeparation + " meters - (Double) Geoidal Separation\n" +
                geoidalSeparationIndex + " - (Character) units of geoidal separation, meters\n" +
                alignmentDGPS + " seconds - (Integer) Age of Differential GPS data (seconds)\n" +
                refStation + " - (Integer) DGPS reference station ID";
    }

    @Override
    public String toString() {
        return text;
    }
}
