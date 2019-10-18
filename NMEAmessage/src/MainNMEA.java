import distribution.Distribution;

import java.util.Scanner;

public class MainNMEA {
    public static void main(String[] args) {
        Distribution nessageAnalizer=new Distribution();

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
        int mNumber=0;

        while (flag) {
            System.out.print("Select NMEA message from 0 to 5: ");
            mNumber = scan.nextInt();
            if (mNumber <= 5 && mNumber >= 0) {
                flag = false;
            }
        }
    }
}
