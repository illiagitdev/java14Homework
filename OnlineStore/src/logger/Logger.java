package logger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public enum Logger {
    INSTANCE;

    enum WorkMode {
        RELEASE, DEBUG;
    }

    final WorkMode workMode;
    private File[] logFiles;
    private FileOutputStream[] fosArr;

    Logger() {
        File file = new File("logConf.ini");
        WorkMode temp = WorkMode.RELEASE;
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                byte[] byteArr = new byte[fis.available()];
                fis.read(byteArr);
                String str = new String(byteArr);
                if ("debug".equals(str.toLowerCase())) {
                    temp = WorkMode.DEBUG;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        workMode = temp;
        fileInitializer();
        fileOutputStreamsInitializer();
    }

    private void fileInitializer() {
        LogType[] types = LogType.values();
        Date currentDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dateStr = format.format(currentDate);
        File path=new File("log/"+dateStr+"/");
        logFiles = new File[types.length + 1];
        for (int i = 0; i < logFiles.length - 1; i++) {
            logFiles[i] = new File("log/"+dateStr+"/" + types[i] + "_" + "_log.log");
            if (!path.isDirectory()&&!logFiles[i].exists()) {
                try {
                    path.mkdirs();
                    logFiles[i].createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        logFiles[logFiles.length - 1] = new File("log/"+dateStr+"/"+"all_"  + "_log.log");
        if (!logFiles[logFiles.length - 1].exists()) {
            try {
                logFiles[logFiles.length - 1].createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void fileOutputStreamsInitializer() {
        fosArr = new FileOutputStream[logFiles.length];
        for (int i = 0; i < fosArr.length; i++) {
            try {
                fosArr[i] = new FileOutputStream(logFiles[i],true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void log(LogType logType, String message) {
        byte index = getIndex(logType);
        if (index == -1) {
            return;
        }
        try {
            fosArr[index].write(messageFormaliser(logType,message).getBytes());
            fosArr[fosArr.length - 1].write(messageFormaliser(logType,message).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte getIndex(LogType logType) {
        LogType logTypes[] = LogType.values();
        for (byte i = 0; i < logTypes.length; i++) {
            if (logTypes[i].equals(logType))
                return i;
        }
        return -1;
    }

    private String messageFormaliser(LogType type, String message) {
        LocalTime currTime =LocalTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss  ");
        return currTime.format(formatter)+type+" "+message+"\n";
    }

    public void close() {
        for (FileOutputStream stream : fosArr) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

