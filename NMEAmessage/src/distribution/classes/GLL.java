package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

import java.time.LocalTime;

public class GLL implements GpsMessages {
    public String[] array=new String[15];


        private int latitudeDegree = Utils.returnInteger(array[0].substring(0, array[0].indexOf('.') - 2));
        private double latitudeMin = Utils.returnDouble(array[0].substring(array[0].indexOf('.') - 2));
        private Character indicatorNS = Utils.getChar0(array[1]);
        private int longitudeDegree = Utils.returnInteger(array[2].substring(0, array[2].indexOf('.') - 2));
        private double longitudeMin = Utils.returnDouble(array[2].substring(array[2].indexOf('.') - 2));
        private Character indicatorEW = Utils.getChar0(array[3]);

        private LocalTime timeUTC = Utils.getTime(array[4]);// 22:54:44 UTC
        private Character status = Utils.getChar0(array[5]);
        private Character mode = Utils.getChar0(array[6]);

    public void show() {

        System.out.println("GLL - Geographic Position – Latitude/Longitude\n\n" +
                latitudeDegree + " deg. " + latitudeMin + " min. - (Integer,Double) Latitude of position\n" +
                indicatorNS + " - (Character) ‘N’ = North, ‘S’ = South\n" +
                longitudeDegree + " deg. " + longitudeMin + " min. - (Integer,Double) Longitude of position\n" +
                indicatorEW + " - (Character) ‘E’ = East, ‘W’ = West\n" +
                timeUTC + " - (String) UTC time of the fix\n" +
                status + " - (Character) Status indicator. A = valid; V = invalid\n" +
                mode + " - (Character) Mode indicator. A = autonomous; N = data not valid");
    }
}
