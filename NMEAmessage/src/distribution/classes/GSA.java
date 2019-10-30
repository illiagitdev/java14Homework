package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

public class GSA implements GpsMessages {
    private String text;

    @Override
    public void getDescription(String[] input) {
        Character workMode = Utils.getChar0(input[0]);
        int fixType = Utils.returnInteger(input[1]);
        double PDOP = Utils.returnDouble(input[14]);
        double HDOP = Utils.returnDouble(input[15]);
        double VDOP = Utils.returnDouble(input[16]);

        text = "GSA - GNSS DOP and Active Satellites\n\n" +
                workMode + " - (Character) Mode: ‘M’ = Manual, ‘A’ = Automatic\n" +
                fixType + " - (Integer) Fix type: 1 = Fix not available, 2 = 2D, 3 = 3D\n";

        for (int i = 2; i < 14; i++) {
            text += Utils.returnDouble(input[i]) + " - (Integer) ID = " + (i - 1) + ", Satellite ID used in position fix\n";
        }

        text += PDOP + " - (Double) Position dilution of precision (00.0 to 99.9)\n" +
                HDOP + " - (Double) Horizontal dilution of precision (00.0 to 99.9)\n" +
                VDOP + " - (Double) Vertical dilution of precision (00.0 to 99.9)";
    }

    @Override
    public void show() {
        System.out.println(text);
    }
}
