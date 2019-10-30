import distribution.Distribution;

public class MainNMEA {
    public static void main(String[] args) {
        Distribution messageAnaliser=new Distribution();
        String[] messages = {"$GNGGA,165114.005,5601.0318,N,01211.3504,E,1,07,1.2,22.6,M,41.6,M,,0000*62",
                "$GNGLL,4916.45,N,12311.12,W,225444,A,*31",
                "$GNGSA,A,3,05,17,22,09,14,04,30,,,,,,1.8,1.2,1.3*32",
                "$GPGSV,3,3,11,04,07,102,30,29,02,170,09,18,02,243,*42",
                "$GNRMC,165111.98,A,5601.0318,N,01211.3503,E,0.08,43.53,190706,,*3E",
                "$GNRMC,123519.00,A,4807.038,N,01131.000,E,022.4,084.4,231194,003.1,W*6A",
                "$GPRMC,113650.00,A,5548.607,N,03739.387,E,000.01,255.6,210403,08.7,E*69",
                "$GNVTG,45.67,T,,M,0.08,N,0.1,K*59"
        };

        int index=(int)(Math.random()*55%8);
        messageAnaliser.getDescription(messages[index]);
    }
}