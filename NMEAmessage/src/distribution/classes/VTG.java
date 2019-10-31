package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

public class VTG implements GpsMessages {
    private String text;

    @Override
    public void getDescription(String[] input) {

        double courseTrue = Utils.returnDouble(input[0]);
        Character courseTrueID = Utils.getChar0(input[1]);
        double courseMagnetic = Utils.returnDouble(input[2]);
        Character courseMagneticID = Utils.getChar0(input[3]);
        double speedKnots = Utils.returnDouble(input[4]);
        Character speedKnotsID = Utils.getChar0(input[5]);
        double speedKpH = Utils.returnDouble(input[6]);
        Character speedKpHID = Utils.getChar0(input[7]);

        text = "VTG - Course Over Ground and Ground Speed\n\n" +
                courseTrue + " - (Double) Course over ground, degrees True\n" +
                courseTrueID + " - (Character) 'T' indicates that track made good\n" +
                courseMagnetic + " - (Double) Course over ground, degrees Magnetic\n" +
                courseMagneticID + " - (Character) 'M' indicates that magnetic track made good\n" +
                speedKnots + " knots - (Double) Speed over ground in knots\n" +
                speedKnotsID + " - (Character) 'N' indicates that speed over ground in knots\n" +
                speedKpH + " km/hour - (Double) Speed over ground in kilometers per hour\n" +
                speedKpHID + " - (Character) 'K' indicates that speed over ground is in kilometers/hour";
    }

    @Override
    public String toString() {
        return text;
    }
}
