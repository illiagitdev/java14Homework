package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

import java.time.LocalTime;

public class GGA implements GpsMessages {
    public String[] array=new String[15];


        private LocalTime timeUTC = Utils.getTimeS(array[0]);//22:54:44 UTC

        private int latitudeDegree = Utils.returnInteger(array[1].substring(0, array[1].indexOf('.') - 2));
        private double latitudeMin = Utils.returnDouble(array[1].substring(array[1].indexOf('.') - 2));
        private Character indicatorNS = Utils.getChar0(array[2]);
        private int longitudeDegree = Utils.returnInteger(array[3].substring(0, array[3].indexOf('.') - 2));
        private  double longitudeMin = Utils.returnDouble(array[3].substring(array[3].indexOf('.') - 2));
        private Character indicatorEW = Utils.getChar0(array[4]);

        private  int qualityIndicator = Utils.returnInteger(array[5]);
        private int satellitesUsed = Utils.returnInteger(array[6]);
        private  double HDOP = Utils.returnDouble(array[7]);
        private  double altitude = Utils.returnDouble(array[8]);
        private  Character altitudeIndex = Utils.getChar0(array[9]);
        private  double geoidalSeparation = Utils.returnDouble(array[10]);
        private Character geoidalSeparationIndex =Utils.getChar0(array[11]);
        private  int alignmentDGPS = Utils.returnInteger(array[12]);//Age of Differential GPS data (seconds)
        private  int refStation = Utils.returnInteger(array[13]);

        public void show() {
        System.out.println("GGA - Global Positioning System Fix Data\n\n" +
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
                refStation + " - (Integer) DGPS reference station ID");
    }
}
