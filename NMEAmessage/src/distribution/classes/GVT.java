package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

public class GVT implements GpsMessages {
    public String[] array=new String[15];


    private double courseTrue = Utils.returnDouble(array[0]);
    private Character courseTrueID = Utils.getChar0(array[1]);
    private double courseMagnetic = Utils.returnDouble(array[2]);
    private Character courseMagneticID = Utils.getChar0(array[3]);
    private double speedKnots = Utils.returnDouble(array[4]);
    private Character speedKnotsID = Utils.getChar0(array[5]);
    private double speedKpH = Utils.returnDouble(array[6]);
    private Character speedKpHID = Utils.getChar0(array[7]);

    public void show() {

        System.out.println("VTG - Course Over Ground and Ground Speed\n\n"+
    courseTrue +" - (Double) Course over ground, degrees True\n"+
    courseTrueID +" - (Character) 'T' indicates that track made good\n"+
    courseMagnetic +" - (Double) Course over ground, degrees Magnetic\n"+
    courseMagneticID +" - (Character) 'M' indicates that magnetic track made good\n"+
    speedKnots +" knots - (Double) Speed over ground in knots\n"+
    speedKnotsID +" - (Character) 'N' indicates that speed over ground in knots\n"+
    speedKpH +" km/hour - (Double) Speed over ground in kilometers per hour\n"+
    speedKpHID +" - (Character) 'K' indicates that speed over ground is in kilometers/hour");
}
}
