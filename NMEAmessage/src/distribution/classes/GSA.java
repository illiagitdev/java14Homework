package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

public class GSA implements GpsMessages {
    @Override
    public void getDescription(String[] input) {
        String[] content = input;
        Character workMode = Utils.getChar0(content[0]);
        int fixType = Utils.returnInteger(content[1]);
        int[] satelliteID = new int[12];
        double PDOP = Utils.returnDouble(content[14]);
        double HDOP = Utils.returnDouble(content[15]);
        double VDOP = Utils.returnDouble(content[16]);

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
