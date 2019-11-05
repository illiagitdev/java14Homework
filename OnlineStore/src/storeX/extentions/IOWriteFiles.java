package storeX.extentions;

import goods.categoris.Phone;
import logger.LogType;
import logger.Logger;
import storeX.StoreX;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class IOWriteFiles {
    private static IOWriteFiles instance;

    public static IOWriteFiles getInstance(){
        if (instance==null){
            return new IOWriteFiles();
        }
        return instance;
    }

    /**
     * save data to files   //todo:
     */
    public void close(StoreX storeX) {
        wrightBalance(storeX.getBalance(), new File(Pathes.BALANCE));
        wrightPhones(storeX.getPhones(), new File(Pathes.PHONES));
    }

    private void wrightPhones(Phone[] phones, File path) {
        if (!path.exists() & path.canWrite()) {
            try {
                path.createNewFile();
            } catch (IOException e) {
                Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(phones.length + "\n");
            for (int i = 0; i < phones.length; i++) {
                writer.write(phones[i].getId() + "\n");
                writer.write(phones[i].getName() + "\n");
                writer.write(phones[i].getAmount() + "\n");
                writer.write(phones[i].getDescription() + "\n");
                writer.write(phones[i].getPrice() + "\n");
                writer.write(phones[i].getSystem().getOperatingSystem() + "\n");
                writer.write(phones[i].getRam().getMemorySize() + "\n");
                writer.write(phones[i].getRam().getMemoryType() + "\n");
                writer.write(phones[i].getCpu().getCoreNumber() + "\n");
                writer.write(phones[i].getCpu().getFrequency() + "\n");
                writer.write(phones[i].getDiagonal().getDiagonal() + "\n");
                writer.write(phones[i].getWorkingTime().getWorkOnButtery() + "\n");
                 writer.write(phones[i].getWarranty().getWarranty().get(Calendar.YEAR) + "\n");
                writer.write(phones[i].getWarranty().getWarranty().get(Calendar.MONTH) + "\n");
                writer.write(phones[i].getWarranty().getWarranty().get(Calendar.DAY_OF_MONTH) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }

    }

    private void wrightBalance(double balance, File file) {
        if (!file.exists() & file.canWrite()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(file);
            writer.flush();
            writer.write(balance + "\n");
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }
    }
}
