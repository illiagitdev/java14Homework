package distribution;

import java.util.Scanner;

public class Distribution {





    //int messageChecksum = Integer.parseInt(message.substring(message.indexOf("*") + 1), 16);
    String head = messages[mNumber].substring(1, messages[mNumber].indexOf(","));
    String messageType = head.substring(2);

    String[] array = messages[mNumber].substring(messages[mNumber].indexOf(",") + 1).split(",");
    array[array.length - 1] = array[array.length - 1].substring(0, array[array.length - 1].indexOf('*'));//deleting checksum

        switch (messageType) {
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
