package storeX.extentions;

import goods.categoris.Computer;
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

    public static IOWriteFiles getInstance() {
        if (instance == null) {
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
        wrightComputers(storeX.getComputers(), new File(Pathes.COMPUTERS));
    }

    private void wrightComputers(Computer[] computers, File path) {
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
            writer.write(computers.length + "\n");
            for (int i = 0; i < computers.length; i++) {
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getId() =" + computers[i].getId());
                writer.write(computers[i].getId() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getName() =" + computers[i].getName());
                writer.write(computers[i].getName() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getAmount() =" + computers[i].getAmount());
                writer.write(computers[i].getAmount() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getDescription() =" + computers[i].getDescription());
                writer.write(computers[i].getDescription() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getPrice() =" + computers[i].getPrice());
                writer.write(computers[i].getPrice() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getRam().getMemorySize() =" + computers[i].getRam().getMemorySize());
                writer.write(computers[i].getRam().getMemorySize() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getRam().getMemoryType() =" + computers[i].getRam().getMemoryType());
                writer.write(computers[i].getRam().getMemoryType() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getCpu().getCoreNumber() =" + computers[i].getCpu().getCoreNumber());
                writer.write(computers[i].getCpu().getCoreNumber() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getCpu().getFrequency() =" + computers[i].getCpu().getFrequency());
                writer.write(computers[i].getCpu().getFrequency() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers[i].getVideoCard().getGpu().getCoreNumber() =" + computers[i].getVideoCard().getGpu().getCoreNumber());
                writer.write(computers[i].getVideoCard().getGpu().getCoreNumber() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers[i].getVideoCard().getGpu().getFrequency() =" + computers[i].getVideoCard().getGpu().getFrequency());
                writer.write(computers[i].getVideoCard().getGpu().getFrequency() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers[i].getVideoCard().getVideoRAM().getMemorySize() =" + computers[i].getVideoCard().getVideoRAM().getMemorySize());
                writer.write(computers[i].getVideoCard().getVideoRAM().getMemorySize() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers[i].getVideoCard().getVideoRAM().getMemoryType() =" + computers[i].getVideoCard().getVideoRAM().getMemoryType());
                writer.write(computers[i].getVideoCard().getVideoRAM().getMemoryType() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getWarranty().getWarranty().get(Calendar.YEAR) =" + computers[i].getWarranty().getWarranty().get(Calendar.YEAR));
                writer.write(computers[i].getWarranty().getWarranty().get(Calendar.YEAR) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getWarranty().getWarranty().get(Calendar.MONTH) =" + computers[i].getWarranty().getWarranty().get(Calendar.MONTH));
                writer.write(computers[i].getWarranty().getWarranty().get(Calendar.MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getWarranty().getWarranty().get(Calendar.DAY_OF_MONTH) =" + computers[i].getWarranty().getWarranty().get(Calendar.DAY_OF_MONTH));
                writer.write(computers[i].getWarranty().getWarranty().get(Calendar.DAY_OF_MONTH) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }
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
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getId() =" + phones[i].getId());
                writer.write(phones[i].getId() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getName() =" + phones[i].getName());
                writer.write(phones[i].getName() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getAmount() =" + phones[i].getAmount());
                writer.write(phones[i].getAmount() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getDescription() =" + phones[i].getDescription());
                writer.write(phones[i].getDescription() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getPrice() =" + phones[i].getPrice());
                writer.write(phones[i].getPrice() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getSystem().getOperatingSystem() =" + phones[i].getSystem().getOperatingSystem());
                writer.write(phones[i].getSystem().getOperatingSystem() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getRam().getMemorySize() =" + phones[i].getRam().getMemorySize());
                writer.write(phones[i].getRam().getMemorySize() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getRam().getMemoryType() =" + phones[i].getRam().getMemoryType());
                writer.write(phones[i].getRam().getMemoryType() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getCpu().getCoreNumber() =" + phones[i].getCpu().getCoreNumber());
                writer.write(phones[i].getCpu().getCoreNumber() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getCpu().getFrequency() =" + phones[i].getCpu().getFrequency());
                writer.write(phones[i].getCpu().getFrequency() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getDiagonal().getDiagonal() =" + phones[i].getDiagonal().getDiagonal());
                writer.write(phones[i].getDiagonal().getDiagonal() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getWorkingTime().getWorkOnButtery() =" + phones[i].getWorkingTime().getWorkOnButtery());
                writer.write(phones[i].getWorkingTime().getWorkOnButtery() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getWarranty().getWarranty().get(Calendar.YEAR) =" + phones[i].getWarranty().getWarranty().get(Calendar.YEAR));
                writer.write(phones[i].getWarranty().getWarranty().get(Calendar.YEAR) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getWarranty().getWarranty().get(Calendar.MONTH) =" + phones[i].getWarranty().getWarranty().get(Calendar.MONTH));
                writer.write(phones[i].getWarranty().getWarranty().get(Calendar.MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones[i].getWarranty().getWarranty().get(Calendar.DAY_OF_MONTH) =" + phones[i].getWarranty().getWarranty().get(Calendar.DAY_OF_MONTH));
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
            Logger.INSTANCE.log(LogType.SYSTEM, "write file: balance =" + balance);
            writer.write(balance + "\n");
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }
    }
}
