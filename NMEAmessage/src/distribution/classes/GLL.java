package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

import java.time.LocalTime;

public class GLL implements GpsMessages {
    private String text;

    @Override
    public void getDescription(String[] input) {
        int latitudeDegree = Utils.returnInteger(input[0].substring(0, input[0].indexOf('.') - 2));
        double latitudeMin = Utils.returnDouble(input[0].substring(input[0].indexOf('.') - 2));
        Character indicatorNS = Utils.getChar0(input[1]);
        int longitudeDegree = Utils.returnInteger(input[2].substring(0, input[2].indexOf('.') - 2));
        double longitudeMin = Utils.returnDouble(input[2].substring(input[2].indexOf('.') - 2));
        Character indicatorEW = Utils.getChar0(input[3]);

        LocalTime timeUTC = Utils.getTime(input[4]);// 22:54:44 UTC
        Character status = Utils.getChar0(input[5]);
        Character mode = Utils.getChar0(input[6]);

        text = "GLL - Geographic Position – Latitude/Longitude\n\n" +
                latitudeDegree + " deg. " + latitudeMin + " min. - (Integer,Double) Latitude of position\n" +
                indicatorNS + " - (Character) ‘N’ = North, ‘S’ = South\n" +
                longitudeDegree + " deg. " + longitudeMin + " min. - (Integer,Double) Longitude of position\n" +
                indicatorEW + " - (Character) ‘E’ = East, ‘W’ = West\n" +
                timeUTC + " - (String) UTC time of the fix\n" +
                status + " - (Character) Status indicator. A = valid; V = invalid\n" +
                mode + " - (Character) Mode indicator. A = autonomous; N = data not valid";
    }

    @Override
    public String toString() {
        return text;
    }
}
