import java.util.Date;
import java.util.Scanner;

public class NMEAmessages {
    public static void main(String[] args) {
        /**
         * set of NMEA messages
         */
        String[] messages = {"$GPGSV,3,3,11,04,07,102,30,29,02,170,09,18,02,243,*42",
                "$GPGLL,6012.5674,N,02449.6545,E,072022.000,A,A*50",
                "$GPRMC,114353.000,A,6016.3245,N,02458.3270,E,0.01,0.00,121009,,,A*69",
                "$GPVTG,45.67,T,,M,0.08,N,0.1,K*59",
                "$GPGGA,165114.000,5601.0318,N,01211.3504,E,1,07,1.2,22.6,M,41.6,M,,0000*62",
                "$GPGSA,A,3,05,17,22,09,14,04,30,,,,,,1.8,1.2,1.3*32"
        };

        Boolean flag = true;
        Scanner scan = new Scanner(System.in);
        int mNumber;
        String message="";

        while (flag) {
            System.out.print("Select NMEA message from 0 to 5: ");
            mNumber = scan.nextInt();
            if (mNumber <= 5 && mNumber >= 0) {
                flag = !flag;
                message = messages[mNumber];
            }
        }

        //int messageChecksum = Integer.parseInt(message.substring(message.indexOf("*") + 1), 16);
        String head = message.substring(1, message.indexOf(","));
        String mesageType = head.substring(2);

        String[] array = message.substring(message.indexOf(",") + 1).split(",");
        array[array.length - 1] = array[array.length - 1].substring(0, array[array.length - 1].indexOf('*'));//deleting checksum

        // to check an output
        showArray(array);

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
    private static void decodeGSA(String[] array) {
        Character workMode = array[0].charAt(0);
        int fixType = returnInteger(array[1]);

        int[] satelliteID = new int[12];
        for (int i = 0; i < 12; i++) {
            satelliteID[i] = returnInteger(array[2 + i]);
        }

        double PDOP = returnDouble(array[14]);
        double HDOP = returnDouble(array[15]);
        double VDOP = returnDouble(array[16]);

        System.out.println("GSA - GNSS DOP and Active Satellites\n\n"+
                workMode+" - (Character) Mode: ‘M’ = Manual, ‘A’ = Automatic\n"+
                fixType+" - (Integer) Fix type: 1 = Fix not available, 2 = 2D, 3 = 3D");

        for (int i = 0; i < 12; i++) {
            System.out.println(satelliteID[i]+" - (Integer) ID = "+(i+1)+", Satellite ID used in position fix" );
        }

        System.out.println(PDOP+" - (Double) Position dilution of precision (00.0 to 99.9)\n"+
                HDOP+" - (Double) Horizontal dilution of precision (00.0 to 99.9)\n"+
                VDOP+" - (Double) Vertical dilution of precision (00.0 to 99.9)");
    }

    /**
     * shows GGA fields
     */
    private static void decodeGGA(String[] array) {
        Date timeUTC = new Date((long) (returnDouble(array[0]) * 1000));//todo: formats;
        double latitude = returnDouble(array[1]);//todo: formats;
        Character indicatorNS = array[2].charAt(0);
        double longitude = returnDouble(array[3]);//todo: formats;
        Character indicatorEW = array[4].charAt(0);
        int qualityIndicator = returnInteger(array[5]);
        int satellitesUsed = returnInteger(array[6]);
        double HDOP = returnDouble(array[7]);
        double altitude = returnDouble(array[8]);
        Character altitudeIndex = array[9].charAt(0);
        double geoidalSeparation = returnDouble(array[10]);
        Character geoidalSeparationIndex = array[11].charAt(0);
        Date alignmentDGPS = new Date((long) (returnDouble(array[12]) * 1000));//todo: formats;
        int refStation = returnInteger(array[13]);

        System.out.println("GGA - Global Positioning System Fix Data\n\n"+
                timeUTC+" - (Date) UTC of position\n"+
                latitude+" - (Double) Latitude of position\n"+
                indicatorNS+" - (Character) ‘N’ = North, ‘S’ = South\n"+
                longitude+" - (Double) Longitude of position\n"+
                indicatorEW+" - (Character) ‘E’ = East, ‘W’ = West\n"+
                qualityIndicator+" - (Integer) GPS quality indicator: 0 - invalid, 1 - GPS fix, 2 - DGPD fix\n"+
                satellitesUsed+" - (Integer) Number of Satellites\n"+
                HDOP+" - (Double) HDOP\n"+
                altitude+" meters - (Double) Mean sea level altitude\n"+
                altitudeIndex+" - (Character) units of antenna altitude, meters\n"+
                geoidalSeparation+" meters - (Double) Geoidal Separation\n"+
                geoidalSeparationIndex+" - (Character) units of geoidal separation, meters\n"+
                alignmentDGPS+" seconds - (Date) Age of Differential GPS data (seconds)\n"+
                refStation+" - (Integer) DGPS reference station ID");
    }

    /**
     * shows GVT fields
     */
    private static void decodeVTG(String[] array) {
        double courseTrue = returnDouble(array[0]);
        Character courseTrueID = array[1].charAt(0);
        double courseMagnetic = returnDouble(array[2]);
        Character courseMagneticID = array[3].charAt(0);
        double speedKnots = returnDouble(array[4]);
        Character speedKnotsID = array[5].charAt(0);
        double speedKpH = returnDouble(array[6]);
        Character speedKpHID = array[7].charAt(0);

        System.out.println("VTG - Course Over Ground and Ground Speed\n\n"+
                courseTrue+" - (Double) Course over ground, degrees True\n"+
                courseTrueID+" - (Character) 'T' indicates that track made good\n"+
                courseMagnetic+" - (Double) Course over ground, degrees Magnetic\n"+
                courseMagneticID+" - (Character) 'M' indicates that magnetic track made good\n"+
                speedKnots+" knots - (Double) Speed over ground in knots\n"+
                speedKnotsID+" - (Character) 'N' indicates that speed over ground in knots\n"+
                speedKpH+" km/hour - (Double) Speed over ground in kilometers per hour\n"+
                speedKpHID+" - (Character) 'K' indicates that speed over ground is in kilometers/hour");
    }

    /**
     * shows RMC fields
     */
    private static void decodeRMC(String[] array) {
        Date timeUTC = new Date((long) (returnDouble(array[0]) * 1000));
        String statusIndicator = array[1];
        double latitude = returnDouble(array[2]);
        String direction = array[3];
        double longitude = returnDouble(array[4]);
        String directionEW = array[5];
        double speedKnots = returnDouble(array[6]);
        double heading = returnDouble(array[7]);
        Date timeUTCfix = new Date((long) (returnDouble(array[8])));
        double magneticVar = returnDouble(array[9]);
        String letter = array[10];
        String modeIndicator = array[11];

        System.out.println("RMC -  Recommended Minimum Specific GNSS Data");

        System.out.println("UTC time of the fix. " + timeUTC);
        System.out.println("Status indicator.\n" +
                "A=valid; V=invalid " + statusIndicator);
        System.out.println("Latitude coordinate. " + latitude);
        System.out.println("Character denoting either N=North or S=South " + direction);
        System.out.println("Longitude coordinate. " + longitude);
        System.out.println("Character denoting either E=East or W=West " + directionEW);
        System.out.println("Speed in knots " + speedKnots);
        System.out.println("Heading " + heading);
        System.out.println("UTC Date of the fix. " + timeUTCfix);
        System.out.println("Magnetic variation in degrees, not supported " + magneticVar);
        System.out.println("Letter denoting direction of magnetic variation. Either E=East or W=West. " + letter);
        System.out.println("Mode indicator\n" +
                "A=autonomous; N=data not valid " + modeIndicator);
    }

    private static void decodeGLL(String[] array) {
        double latitude = returnDouble(array[0]);
        String denotionNS = array[1];
        double longitude = returnDouble(array[2]);
        String denotionEW = array[3];
        Date timeUTC = new Date((long) (returnDouble(array[4]) * 1000));
        String status = array[5];
        String mode = array[6];

        System.out.println("GLL - Geographic Position – Latitude/Longitude");

        System.out.println("Latitude coordinate. " + latitude);
        System.out.println("Character denoting either N=North or S=South. " + denotionNS);
        System.out.println("Longitude coordinate. " + longitude);
        System.out.println("Character denoting either E=East or W=West " + denotionEW);
        System.out.println("UTC time of the fix. " + timeUTC);
        System.out.println("Status indicator.\n" +
                "A=valid; V=invalid " + status);
        System.out.println("Mode indicator.\n" +
                "A=autonomous; N=data not valid " + mode);
    }

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

        System.out.println("GSV - GNSS DOP and Active Satellites");

        System.out.println("Total number of messages, 1 to 9 " + messagesN);
        System.out.println("Message number, 1 to 9 " + messageNumber);
        System.out.println("Total number of satellites in view " + satellites);

        System.out.println("Satellite ID (PRN) number " + satellitID1);
        System.out.println("Satellite elevation, degrees 90 max " + satElevation1);
        System.out.println("Satellite azimuth, degrees True, 000 to 359 " + satAzimuth1);
        System.out.println("Signal-to-noise ration (C/No) 00-99 dB-Hz. Value of zero means that the satellite is predicted to\n" +
                "be on the visible sky but it isn't being tracked. " + signalToNoise1);

        System.out.println("Satellite ID (PRN) number " + satellitID2);
        System.out.println("Satellite elevation, degrees 90 max " + satElevation2);
        System.out.println("Satellite azimuth, degrees True, 000 to 359 " + satAzimuth2);
        System.out.println("Signal-to-noise ration (C/No) 00-99 dB-Hz. Value of zero means that the satellite is predicted to\n" +
                "be on the visible sky but it isn't being tracked. " + signalToNoise2);

        System.out.println("Satellite ID (PRN) number " + satellitID3);
        System.out.println("Satellite elevation, degrees 90 max " + satElevation3);
        System.out.println("Satellite azimuth, degrees True, 000 to 359 " + satAzimuth3);
        System.out.println("Signal-to-noise ration (C/No) 00-99 dB-Hz. Value of zero means that the satellite is predicted to\n" +
                "be on the visible sky but it isn't being tracked. " + signalToNoise3);
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
}
