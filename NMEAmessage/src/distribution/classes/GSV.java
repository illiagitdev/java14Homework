package distribution.classes;

import distribution.GpsMessages;
import distribution.Utils;

public class GSV implements GpsMessages {
    private String text;

    @Override
    public void getDescription(String[] input) {
        String[] content = input;

        int messagesN = Utils.returnInteger(content[0]);
        int messageNumber = Utils.returnInteger(content[1]);
        int satellites = Utils.returnInteger(content[2]);

        int satellitID1 = Utils.returnInteger(content[3]);
        int satElevation1 = Utils.returnInteger(content[4]);
        int satAzimuth1 = Utils.returnInteger(content[5]);
        int signalToNoise1 = Utils.returnInteger(content[6]);

        int satellitID2 = Utils.returnInteger(content[7]);
        int satElevation2 = Utils.returnInteger(content[8]);
        int satAzimuth2 = Utils.returnInteger(content[9]);
        int signalToNoise2 = Utils.returnInteger(content[10]);

        int satellitID3 = Utils.returnInteger(content[11]);
        int satElevation3 = Utils.returnInteger(content[12]);
        int satAzimuth3 = Utils.returnInteger(content[13]);
        int signalToNoise3 = Utils.returnInteger(content[14]);

        text = "GSV - GNSS DOP and Active Satellites\n\n" +
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
                signalToNoise3 + " - (Integer) Signal-to-noise ration (C/No) 00-99 dB-Hz";
    }

    @Override
    public void show() {
        System.out.println(text);
    }
}
