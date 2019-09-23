import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class NMEAmessages {
    public static void main(String[] args) {
        /*
         * set of NMEA messages
         */
        String[] messages = {"$GNGGA,165114.005,5601.0318,N,01211.3504,E,1,07,1.2,22.6,M,41.6,M,,0000*62",
                "$GNGLL,4916.45,N,12311.12,W,225444,A,*31",
                "$GNGSA,A,3,05,17,22,09,14,04,30,,,,,,1.8,1.2,1.3*32",
                "$GPGSV,3,3,11,04,07,102,30,29,02,170,09,18,02,243,*42",
//                "$GNRMC,165111.98,A,5601.0318,N,01211.3503,E,0.08,43.53,190706,,*3E",
                "$GNRMC,123519,A,4807.038,N,01131.000,E,022.4,084.4,231194,003.1,W*6A",
                "$GNVTG,45.67,T,,M,0.08,N,0.1,K*59"
        };

        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        int mNumber;
        String message = "";

        while (flag) {
            System.out.print("Select NMEA message from 0 to 5: ");
            mNumber = scan.nextInt();
            if (mNumber <= 5 && mNumber >= 0) {
                flag = false;
                message = messages[mNumber];
            }
        }

        //int messageChecksum = Integer.parseInt(message.substring(message.indexOf("*") + 1), 16);
        String head = message.substring(1, message.indexOf(","));
        String mesageType = head.substring(2);

        String[] array = message.substring(message.indexOf(",") + 1).split(",");
        array[array.length - 1] = array[array.length - 1].substring(0, array[array.length - 1].indexOf('*'));//deleting checksum

        // to check an output
//        showArray(array);

        switch (mesageType) {
            case "GSV": {
                decodeGSV(array);
                break;
            }
            case "GLL": {
                decodeGLL(array);
                break;
            }
            case "RMC": {
                decodeRMC(array);
                break;
            }
            case "VTG": {
                decodeVTG(array);
                break;
            }
            case "GGA": {
                decodeGGA(array);
                break;
            }
            case "GSA": {
                decodeGSA(array);
                break;
            }
            default: {
                System.out.println("Not NMEA message or no method to read it.");
                break;
            }
        }
    }

    /**
     * shows GGA fields
     */
    private static void decodeGGA(String[] array) {
        LocalTime timeUTC = getTimeS(array[0]);//22:54:44 UTC

        int latitudeDegree = returnInteger(array[1].substring(0, array[1].indexOf('.') - 2));
        double latitudeMin = returnDouble(array[1].substring(array[1].indexOf('.') - 2));
        Character indicatorNS = getChar0(array[2]);
        int longitudeDegree = returnInteger(array[3].substring(0, array[3].indexOf('.') - 2));
        double longitudeMin = returnDouble(array[3].substring(array[3].indexOf('.') - 2));
        Character indicatorEW = getChar0(array[4]);

        int qualityIndicator = returnInteger(array[5]);
        int satellitesUsed = returnInteger(array[6]);
        double HDOP = returnDouble(array[7]);
        double altitude = returnDouble(array[8]);
        Character altitudeIndex = getChar0(array[9]);
        double geoidalSeparation = returnDouble(array[10]);
        Character geoidalSeparationIndex = getChar0(array[11]);
        int alignmentDGPS = returnInteger(array[12]);//Age of Differential GPS data (seconds)
        int refStation = returnInteger(array[13]);

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

    /**
     * shows GLL fields
     */
    private static void decodeGLL(String[] array) {
        int latitudeDegree = returnInteger(array[0].substring(0, array[0].indexOf('.') - 2));
        double latitudeMin = returnDouble(array[0].substring(array[0].indexOf('.') - 2));
        Character indicatorNS = getChar0(array[1]);
        int longitudeDegree = returnInteger(array[2].substring(0, array[2].indexOf('.') - 2));
        double longitudeMin = returnDouble(array[2].substring(array[2].indexOf('.') - 2));
        Character indicatorEW = getChar0(array[3]);

        LocalTime timeUTC = getTime(array[4]);// 22:54:44 UTC
        Character status = getChar0(array[5]);
        Character mode = getChar0(array[6]);

        System.out.println("GLL - Geographic Position – Latitude/Longitude\n\n" +
                latitudeDegree + " deg. " + latitudeMin + " min. - (Integer,Double) Latitude of position\n" +
                indicatorNS + " - (Character) ‘N’ = North, ‘S’ = South\n" +
                longitudeDegree + " deg. " + longitudeMin + " min. - (Integer,Double) Longitude of position\n" +
                indicatorEW + " - (Character) ‘E’ = East, ‘W’ = West\n" +
                timeUTC + " - (String) UTC time of the fix\n" +
                status + " - (Character) Status indicator. A = valid; V = invalid\n" +
                mode + " - (Character) Mode indicator. A = autonomous; N = data not valid");
    }

    /**
     * shows GSA fields
     */
    private static void decodeGSA(String[] array) {
        Character workMode = getChar0(array[0]);
        int fixType = returnInteger(array[1]);

        int[] satelliteID = new int[12];
        for (int i = 0; i < 12; i++) {
            satelliteID[i] = returnInteger(array[2 + i]);
        }

        double PDOP = returnDouble(array[14]);
        double HDOP = returnDouble(array[15]);
        double VDOP = returnDouble(array[16]);

        System.out.println("GSA - GNSS DOP and Active Satellites\n\n" +
                workMode + " - (Character) Mode: ‘M’ = Manual, ‘A’ = Automatic\n" +
                fixType + " - (Integer) Fix type: 1 = Fix not available, 2 = 2D, 3 = 3D");

        for (int i = 0; i < 12; i++) {
            System.out.println(satelliteID[i] + " - (Integer) ID = " + (i + 1) + ", Satellite ID used in position fix");
        }

        System.out.println(PDOP + " - (Double) Position dilution of precision (00.0 to 99.9)\n" +
                HDOP + " - (Double) Horizontal dilution of precision (00.0 to 99.9)\n" +
                VDOP + " - (Double) Vertical dilution of precision (00.0 to 99.9)");
    }

    /**
     * shows GVT fields
     */
    private static void decodeVTG(String[] array) {
        double courseTrue = returnDouble(array[0]);
        Character courseTrueID = getChar0(array[1]);
        double courseMagnetic = returnDouble(array[2]);
        Character courseMagneticID = getChar0(array[3]);
        double speedKnots = returnDouble(array[4]);
        Character speedKnotsID = getChar0(array[5]);
        double speedKpH = returnDouble(array[6]);
        Character speedKpHID = getChar0(array[7]);

        System.out.println("VTG - Course Over Ground and Ground Speed\n\n" +
                courseTrue + " - (Double) Course over ground, degrees True\n" +
                courseTrueID + " - (Character) 'T' indicates that track made good\n" +
                courseMagnetic + " - (Double) Course over ground, degrees Magnetic\n" +
                courseMagneticID + " - (Character) 'M' indicates that magnetic track made good\n" +
                speedKnots + " knots - (Double) Speed over ground in knots\n" +
                speedKnotsID + " - (Character) 'N' indicates that speed over ground in knots\n" +
                speedKpH + " km/hour - (Double) Speed over ground in kilometers per hour\n" +
                speedKpHID + " - (Character) 'K' indicates that speed over ground is in kilometers/hour");
    }

    /**
     * shows RMC fields
     */
    private static void decodeRMC(String[] array) {
        LocalTime timeUTC = getTime(array[0]);// 22:54:46 UTC
        Character statusIndicator = getChar0(array[1]);

        int latitudeDegree = returnInteger(array[2].substring(0, array[2].indexOf('.') - 2));
        double latitudeMin = returnDouble(array[2].substring(array[2].indexOf('.') - 2));
        Character indicatorNS = getChar0(array[3]);
        int longitudeDegree = returnInteger(array[4].substring(0, array[4].indexOf('.') - 2));
        double longitudeMin = returnDouble(array[4].substring(array[4].indexOf('.') - 2));
        Character indicatorEW = getChar0(array[5]);

        double speedKnots = returnDouble(array[6]);
        double heading = returnDouble(array[7]);
        String timeUTCfix = getDate(array[8]);
        double magneticVar = returnDouble(array[9]);
        Character magneticVarID = getChar0(array[10]);

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

    /**
     * shows GSV fields
     */
    private static void decodeGSV(String[] array) {
        int messagesN = returnInteger(array[0]);
        int messageNumber = returnInteger(array[1]);
        int satellites = returnInteger(array[2]);
        int satellitID1 = returnInteger(array[3]);
        int satElevation1 = returnInteger(array[4]);
        int satAzimuth1 = returnInteger(array[5]);
        int signalToNoise1 = returnInteger(array[6]);

        int satellitID2 = returnInteger(array[7]);
        int satElevation2 = returnInteger(array[8]);
        int satAzimuth2 = returnInteger(array[9]);
        int signalToNoise2 = returnInteger(array[10]);

        int satellitID3 = returnInteger(array[11]);
        int satElevation3 = returnInteger(array[12]);
        int satAzimuth3 = returnInteger(array[13]);
        int signalToNoise3 = returnInteger(array[14]);

        System.out.println("GSV - GNSS DOP and Active Satellites\n\n" +
                messagesN + " - (Integer) Total number of messages\n" +
                messageNumber + " - (Integer) number of message\n" +
                satellites + " - (Integer) Total number of satellites in view\n" +
                satellitID1 + " - (Integer) Satellite ID\n" +
                satElevation1 + " - (Integer) Satellite elevation, degrees 90 max\n" +
                satAzimuth1 + " - (Integer) Satellite azimuth, degrees True, 000 to 359\n" +
                signalToNoise1 + " - (Integer) Signal-to-noise ration (C/No) 00-99 dB-Hz\n" +
                satellitID2 + " - (Integer) Satellite ID\n" +
                satElevation2 + " - (Integer) Satellite elevation, degrees 90 max\n" +
                satAzimuth2 + " - (Integer) Satellite azimuth, degrees True, 000 to 359\n" +
                signalToNoise2 + " - (Integer) Signal-to-noise ration (C/No) 00-99 dB-Hz\n" +
                satellitID3 + " - (Integer) Satellite ID\n" +
                satElevation3 + " - (Integer) Satellite elevation, degrees 90 max\n" +
                satAzimuth3 + " - (Integer) Satellite azimuth, degrees True, 000 to 359\n" +
                signalToNoise3 + " - (Integer) Signal-to-noise ration (C/No) 00-99 dB-Hz");
    }

    /**
     * Prints array
     */
    private static void showArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ": " + array[i] + " ");
        }
    }

    /**
     * returns double or 0.0 if empty
     */
    private static double returnDouble(String s) {
        return s.isEmpty() ? 0.0 : Double.valueOf(s);
    }

    /**
     * returns Integer or 0 if empty
     */
    private static int returnInteger(String s) {
        return s.isEmpty() ? 0 : Integer.valueOf(s);
    }

    /**
     * returns char at index = 0 or null
     */
    private static Character getChar0(String s) {
        return (s.isEmpty() || s.equals(" ")) ? null : s.charAt(0);
    }

    //with miliseconds
    private static LocalTime getTimeS(String s) {
            return LocalTime.parse(s,DateTimeFormatter.ofPattern("HHmmss.SSS"));
    }

    //without miliseconds
    private static LocalTime getTime(String s) {
            return LocalTime.parse(s,DateTimeFormatter.ofPattern("HHmmss"));
    }

    /* date */
    private static String getDate(String s) {
        Date date= null;
        try {
            date = new SimpleDateFormat("ddMMyy").parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("dd MMMM yyyy").format(date);
    }
}
