package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

public class GSV implements GpsMessages {
    public String[] array=new String[15];


    private int messagesN = Utils.returnInteger(array[0]);
    private int messageNumber = Utils.returnInteger(array[1]);
    private int satellites = Utils.returnInteger(array[2]);

    private int satellitID1 = Utils.returnInteger(array[3]);
    private int satElevation1 = Utils.returnInteger(array[4]);
    private int satAzimuth1 = Utils.returnInteger(array[5]);
    private int signalToNoise1 = Utils.returnInteger(array[6]);

    private int satellitID2 =Utils. returnInteger(array[7]);
    private int satElevation2 = Utils.returnInteger(array[8]);
    private int satAzimuth2 = Utils.returnInteger(array[9]);
    private int signalToNoise2 = Utils.returnInteger(array[10]);

    private  int satellitID3 = Utils.returnInteger(array[11]);
    private  int satElevation3 = Utils.returnInteger(array[12]);
    private int satAzimuth3 =Utils. returnInteger(array[13]);
    private int signalToNoise3 = Utils.returnInteger(array[14]);

    public void show() {
        System.out.println("GSV - GNSS DOP and Active Satellites\n\n" +
                messagesN + " - (Integer) Total number of messages\n" +
                messageNumber + " - (Integer) number of message\n" +
                satellites + " - (Integer) Total number of satellites in view\n" +
                satellitID1 + " - (Integer) Satellite ID\n" +
                satElevation1 + " - (Integer) Satellite elevation, degrees 90 max\n" +
                satAzimuth1 + " - (Integer) Satellite azimuth, degrees True, 000 to 359\n" +
                signalToNoise1 + " - (Integer) Signal-to-noise ration (C/No) 00-99 dB-Hz\n" +
                satellitID2 + " - (Integer) Satellite ID\n" +
                satElevation2 + " - (Integer) Satellite elevation, degrees 90 max\n" +
                satAzimuth2 + " - (Integer) Satellite azimuth, degrees True, 000 to 359\n" +
                signalToNoise2 + " - (Integer) Signal-to-noise ration (C/No) 00-99 dB-Hz\n" +
                satellitID3 + " - (Integer) Satellite ID\n" +
                satElevation3 + " - (Integer) Satellite elevation, degrees 90 max\n" +
                satAzimuth3 + " - (Integer) Satellite azimuth, degrees True, 000 to 359\n" +
                signalToNoise3 + " - (Integer) Signal-to-noise ration (C/No) 00-99 dB-Hz");
    }
}
