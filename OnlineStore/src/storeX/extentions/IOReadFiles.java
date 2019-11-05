package storeX.extentions;

import goods.categoris.Phone;
import goods.components.Warranty;
import goods.components.tech.*;
import logger.LogType;
import logger.Logger;
import storeX.StoreX;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class IOReadFiles {
    private static IOReadFiles instance;

    public static IOReadFiles getInstance() {
        if (instance == null) {
            return new IOReadFiles();
        }
        return instance;
    }

    /**
     * load data from files //todo:
     */
    public void initializeStore(StoreX storeX) {
        storeX.setBalance(readBalance(new File(Pathes.BALANCE)));
        storeX.setPhones(readPhones(new File(Pathes.PHONES)));

    }

    private Phone[] readPhones(File path) {
        String[] content = fileContent(path, FieldsInItem.PHONE.index);
        for (int i = 0; i < content.length; i++) {
            System.out.println("i = " + i + "  ::  " + content[i]);
        }
        Phone[] fromFile = new Phone[Integer.parseInt(content[0])];
        for (int i = 0, j; i < fromFile.length; i++) {
            j = !(i == 0) ? (FieldsInItem.PHONE.index * i + 1) : 1;
            fromFile[i] = new Phone(Integer.parseInt(content[j]), content[1 + j], Integer.parseInt(content[2 + j]),
                    content[3 + j], Float.parseFloat(content[4 + j]));
            fromFile[i].setSystem(new OperatingSystem(content[5 + j]));
            fromFile[i].setRam(new RAM(Float.parseFloat(content[6 + j]), content[7 + j]));
            fromFile[i].setCpu(new CPU(Integer.parseInt(content[8 + j]), Float.parseFloat(content[9 + j])));
            fromFile[i].setDiagonal(new ScreenDiagonal(Float.parseFloat(content[10 + j])));
            fromFile[i].setWorkingTime(new WorkingTime(Float.parseFloat(content[11 + j])));
            Calendar warranty = Calendar.getInstance();
            warranty.set(Integer.parseInt(content[12 + j]), Integer.parseInt(content[13 + j]), Integer.parseInt(content[14 + j]));
            fromFile[i].setWarranty(new Warranty(warranty));
        }
        return fromFile;
    }

    private double readBalance(File path) {
        double balance = 0;
        if (!path.exists()) {
            Logger.INSTANCE.log(LogType.WARNING, "Файл не знайдено!");
            System.out.println("Файл не знайдено!");
        } else {
            try {
                Scanner input = new Scanner(path);
                balance = input.hasNextDouble() ? input.nextDouble() : 0;
            } catch (FileNotFoundException e) {
                Logger.INSTANCE.log(LogType.WARNING, "Exception: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }
        return balance;
    }

    private String[] fileContent(File file, int fields) {
        String[] content = new String[0];
        int length = 0;
        if (!file.exists()) {
            Logger.INSTANCE.log(LogType.WARNING, "Файл не знайдено!");
            System.out.println("Файл не знайдено!");
        } else {
            try {
                Scanner input = new Scanner(file);
                length = input.hasNextInt() ? (Integer.valueOf(input.nextLine())) : 0;
                content = new String[1 + fields * length];
                content[0] = Integer.toString(length);
                for (int i = 1; i < content.length; i++) {
                    content[i] = input.nextLine();
                }
            } catch (FileNotFoundException e) {
                Logger.INSTANCE.log(LogType.WARNING, "Exception: Файл не знайдено! " + e);
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e) {
                Logger.INSTANCE.log(LogType.WARNING, "IndexOutOfBoundsException! " + e);
                e.printStackTrace();
            }
        }
        return content;
    }

}
