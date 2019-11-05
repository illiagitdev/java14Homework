package storeX.extentions;

import goods.Goods;
import goods.categoris.Computer;
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
    private String[] content;

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
        storeX.setComputers(readComputers(new File(Pathes.COMPUTERS)));
    }

    private Computer[] readComputers(File path) {
        content = fileContent(path, FieldsInItem.COMPUTER.index);
        for (int i = 0; i < content.length; i++) {
            System.out.println("i = " + i + "  ::  " + content[i]);
        }
        Computer[] fromFile = new Computer[Integer.parseInt(content[0])];
        VideoCard videoCard;
        for (int i = 0, j; i < fromFile.length; i++) {
            j = !(i == 0) ? (FieldsInItem.COMPUTER.index * i + 1) : 1;
            Logger.INSTANCE.log(LogType.SYSTEM, "read file: new Phone(Integer.parseInt(content[j]), content" +
                    "[1 + j], Integer.parseInt(content[2 + j]),content[3 + j], Float.parseFloat(content[4 + j])):\t\t"
                    + content[j] + ", " + content[1 + j] + ", " + content[2 + j] + ", " + content[3 + j] + ", " + content[4 + j]);
            fromFile[i] = new Computer(Integer.parseInt(content[j]), content[1 + j], Integer.parseInt(content[2 + j]),
                    content[3 + j], Float.parseFloat(content[4 + j]));
            Logger.INSTANCE.log(LogType.SYSTEM, "read file: new RAM(Float.parseFloat(content[5 + j]), content[6 + j]):\t\t"
                    + content[5 + j] + ", " + content[6 + j]);
            fromFile[i].setRam(new RAM(Float.parseFloat(content[5 + j]), content[6 + j]));
            Logger.INSTANCE.log(LogType.SYSTEM, "read file: new CPU(Integer.parseInt(content[7 + j]), Float.parseFloat(content[8 + j])):\t\t"
                    + content[7 + j] + ", " + content[8 + j]);
            fromFile[i].setCpu(new CPU(Integer.parseInt(content[7 + j]), Float.parseFloat(content[8 + j])));

            Logger.INSTANCE.log(LogType.SYSTEM, "read file: new CPU(Integer.parseInt(content[9 + j]), Float." +
                    "parseFloat(content[10 + j])),new VideoRAM(Float.parseFloat(content[11 + j]), content[12 + j]):\t\t"
                    + content[9 + j] + ", " + content[10 + j]+ ", " + content[11 + j]+ ", " + content[12 + j]);
            videoCard = new VideoCard(new CPU(Integer.parseInt(content[9 + j]), Float.parseFloat(content[10 + j])),
                    new VideoRAM(Float.parseFloat(content[11 + j]), content[12 + j]));
            fromFile[i].setVideoCard(videoCard);
            Calendar warranty = Calendar.getInstance();
            Logger.INSTANCE.log(LogType.SYSTEM, "read file:warranty.set(Integer.parseInt(content[15 + j]), " +
                    "Integer.parseInt(content[14 + j]), Integer.parseInt(content[13 + j])):\t\t" + content[15 + j] + ", " +
                    content[14 + j] + ", " + content[13 + j]);
            warranty.set(Integer.parseInt(content[15 + j]), Integer.parseInt(content[14 + j]), Integer.parseInt(content[13 + j]));
            fromFile[i].setWarranty(new Warranty(warranty));
        }
        return fromFile;
    }

    private Phone[] readPhones(File path) {
        content = fileContent(path, FieldsInItem.PHONE.index);
        Phone[] fromFile = new Phone[Integer.parseInt(content[0])];
        Calendar warranty = Calendar.getInstance();
        for (int i = 0, j; i < fromFile.length; i++) {
            j = !(i == 0) ? (FieldsInItem.PHONE.index * i + 1) : 1;
            Logger.INSTANCE.log(LogType.SYSTEM, "read file: new Phone(Integer.parseInt(content[j]), content" +
                    "[1 + j], Integer.parseInt(content[2 + j]),content[3 + j], Float.parseFloat(content[4 + j])):\t\t"
                    + content[j] + ", " + content[1 + j] + ", " + content[2 + j] + ", " + content[3 + j] + ", " + content[4 + j]);
            fromFile[i] = new Phone(Integer.parseInt(content[j]), content[1 + j], Integer.parseInt(content[2 + j]),
                    content[3 + j], Float.parseFloat(content[4 + j]));
            Logger.INSTANCE.log(LogType.SYSTEM, "read file: new OperatingSystem(content[5 + j]) :\t\t" + content[5 + j]);
            fromFile[i].setSystem(new OperatingSystem(content[5 + j]));
            Logger.INSTANCE.log(LogType.SYSTEM, "read file: new RAM(Float.parseFloat(content[6 + j]), content[7 + j]):\t\t"
                    + content[6 + j] + ", " + content[7 + j]);
            fromFile[i].setRam(new RAM(Float.parseFloat(content[6 + j]), content[7 + j]));
            Logger.INSTANCE.log(LogType.SYSTEM, "read file: new CPU(Integer.parseInt(content[8 + j]), Float.:\t\t" +
                    "parseFloat(content[9 + j])" + content[8 + j] + ", " + content[9 + j]);
            fromFile[i].setCpu(new CPU(Integer.parseInt(content[8 + j]), Float.parseFloat(content[9 + j])));
            Logger.INSTANCE.log(LogType.SYSTEM, "read file: new ScreenDiagonal(Float.parseFloat(content[10 + j])):\t\t"
                    + content[10 + j]);
            fromFile[i].setDiagonal(new ScreenDiagonal(Float.parseFloat(content[10 + j])));
            Logger.INSTANCE.log(LogType.SYSTEM, "read file: new WorkingTime(Float.parseFloat(content[11 + j])):\t\t"
                    + content[11 + j]);
            fromFile[i].setWorkingTime(new WorkingTime(Float.parseFloat(content[11 + j])));
            Logger.INSTANCE.log(LogType.SYSTEM, "read file:warranty.set(Integer.parseInt(content[14 + j]), " +
                    "Integer.parseInt(content[13 + j]), Integer.parseInt(content[12 + j])):\t\t" + content[14 + j] + ", " +
                    content[13 + j] + ", " + content[12 + j]);
            warranty.set(Integer.parseInt(content[14 + j]), Integer.parseInt(content[13 + j]), Integer.parseInt(content[12 + j]));
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
                    Logger.INSTANCE.log(LogType.SYSTEM, "read file: content[" + i + "]  " + content[i]);
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
