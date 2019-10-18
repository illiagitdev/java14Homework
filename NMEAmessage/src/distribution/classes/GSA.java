package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

public class GSA implements GpsMessages {
    public String[] array=new String[15];


        private Character workMode = Utils.getChar0(array[0]);
        private   int fixType = Utils.returnInteger(array[1]);

        private int[] satelliteID = new int[12];
//        for (int i = 0; i < 12; i++) {
//            satelliteID[i] = Utils.returnInteger(array[2 + i]);
//        }

        private double PDOP = Utils.returnDouble(array[14]);
        private double HDOP = Utils.returnDouble(array[15]);
        private  double VDOP = Utils.returnDouble(array[16]);
    public void show() {

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
}
