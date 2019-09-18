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

    private static void decodeGGA(String[] array) {
        Date timeUTC = new Date((long) (returnDouble(array[0]) * 1000));//todo: fix formats;
        double latitude = returnDouble(array[1]);
        String indicatorNS = array[2];
        double longitude = returnDouble(array[3]);
        String indicatorEW = array[4];
        int qualityIndicator = returnInteger(array[5]);
        int satellitesUsed = returnInteger(array[6]);
        double HDOP = returnDouble(array[7]);
        double altitude = returnDouble(array[8]);
        String altitudeIndex = array[9];
        double geoidalSeparation = returnDouble(array[10]);
        String geoidalSeparationIndex = array[11];
        Date alignmentDGPS = new Date((long) (returnDouble(array[12]) * 1000));
        int refStation = returnInteger(array[13]);

        System.out.println("GGA - Global Positioning System Fix Data");

        System.out.println("UTC of position in hhmmss.sss format, (000000.000 ~ 235959.999): " + timeUTC);
        System.out.println("Latitude in ddmm.mmmm format. Leading zeros are inserted. " + latitude);
        System.out.println("‘N’ = North, ‘S’ = South " + indicatorNS);
        System.out.println("Longitude in dddmm.mmmm format. Leading zeros are inserted. " + longitude);
        System.out.println("‘E’ = East, ‘W’ = West" + indicatorEW);
        System.out.println("GPS quality indicator\n" +
                "0: position fix unavailable\n" +
                "1: valid position fix, SPS mode\n" +
                "2: valid position fix, differential GPS mode " + qualityIndicator);
        System.out.println("Number of satellites in use, (00 ~ 24) " + satellitesUsed);
        System.out.println("Horizontal dilution of precision, (00.0 ~ 99.9) " + HDOP);
        System.out.println("Mean sea level altitude (-9999.9 ~ 17999.9) in meter " + altitude);
        System.out.println("altitudeIndex " + altitudeIndex);
        System.out.println("Geoidal Separation(meters) " + geoidalSeparation);
        System.out.println("geoidalSeparationIndex " + geoidalSeparationIndex);
        System.out.println("DGPS alignment " + alignmentDGPS);
        System.out.println("Differential reference station ID, 0000 ~ 1023\n" +
                "NULL when DGPS not used " + refStation);
    }

    private static void decodeVTG(String[] array) {
        double courseTrue = returnDouble(array[0]);
        String courseTrueID = array[1];
        double courseMagnetic = returnDouble(array[2]);
        String courseMagneticID = array[3];
        double speedKnots = returnDouble(array[4]);
        String speedKnotsID = array[5];
        double speedKpH = returnDouble(array[6]);
        String speedKpHID = array[7];


        System.out.println("VTG - Course Over Ground and Ground Speed");

        System.out.println("Course over ground, degrees True (000.0 ~ 359.9) " + courseTrue);
        System.out.println("courseTrue " + courseTrueID);
        System.out.println("Course over ground, degrees Magnetic (000.0 ~ 359.9) " + courseMagnetic);
        System.out.println("courseMagnetic " + courseMagneticID);
        System.out.println("Speed over ground in knots (000.0 ~ 999.9) " + speedKnots);
        System.out.println("speedKnots " + speedKnotsID);
        System.out.println("Speed over ground in kilometers per hour (0000.0 ~ 1800.0) " + speedKpH);
        System.out.println("speedKpH " + speedKpHID);
    }

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
