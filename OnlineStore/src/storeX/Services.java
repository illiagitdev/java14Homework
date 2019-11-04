package storeX;

import goods.categoris.Phone;
import goods.components.Warranty;
import goods.components.tech.*;
import logger.LogType;
import logger.Logger;
import storeX.extentions.FieldsInItem;
import storeX.extentions.Operational;
import storeX.extentions.Pathes;
import storeX.extentions.Utils;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

public class Services {
    private StoreX storeX;
    private Operational operate = new Operational();

    public Services() {
        storeX = new StoreX();
        Logger.INSTANCE.log(LogType.INFO, "Initialising...");
        initializeStore();
    }

    public void open() {
        boolean leaveStoreX;
        do {
            listOptions();
            Logger.INSTANCE.log(LogType.INFO, "Введіть номер: ");
            System.out.print("Введіть номер: ");
            int choice = Utils.getInt();
            Logger.INSTANCE.log(LogType.INFO, "Вибрано пункт: " + choice);
            System.out.print("Вибрано пункт: " + choice + "\n");
            toDo(choice);
            leaveStoreX = stayOrLeave();
        } while (!leaveStoreX);
        close();
        Logger.INSTANCE.close();
    }

    private void toDo(int choice) {
        switch (choice) {
            case 1: {
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: 1 - Переглянути наявні товари по категорії.");
                System.out.println("Вибрано: 1 - Переглянути наявні товари по категорії.");
                operate.showCategory(storeX);
                break;
            }
            case 2: {
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: 2 - Пошук товару по назві в категорії.");
                System.out.println("Вибрано: 2 - Пошук товару по назві в категорії.");

                System.out.println("change balance");
                storeX.setBalance(Utils.getDouble());

//                    services.getByName(store);
                break;
            }
            case 3: {
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: 3 - Отримати нову поставку.");
                System.out.println("Вибрано: 3 - Отримати нову поставку.");
//                    services.addGoods(store);
                break;
            }
            case 4: {
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: 4 - Продати товар.");
                System.out.println("Вибрано: 4 - Продати товар.");
//                    Selling selling = new Selling();
//                    selling.sell(store);
                break;
            }
            default: {
                Logger.INSTANCE.log(LogType.INFO, "Невірний ввід(");
                System.out.println("Невірний ввід(");
                break;
            }
        }
    }

    private void listOptions() {
        Logger.INSTANCE.log(LogType.INFO, "Магазин \"Дрібнички\" відкрито.");
        System.out.print("Магазин \"Дрібнички\" відкрито.\n");
        Logger.INSTANCE.log(LogType.INFO, "Поточний баланс: " + storeX.getBalance() + " грн.");
        System.out.println("Поточний баланс: " + storeX.getBalance() + " грн.");
        Logger.INSTANCE.log(LogType.INFO, "1 - Переглянути наявні товари по категорії.");
        System.out.println("1 - Переглянути наявні товари по категорії.");
        Logger.INSTANCE.log(LogType.INFO, "2 - Пошук товару по назві.");
        System.out.println("2 - Пошук товару по назві.");
        Logger.INSTANCE.log(LogType.INFO, "3 - Отримати нову поставку.");
        System.out.println("3 - Отримати нову поставку.");
        Logger.INSTANCE.log(LogType.INFO, "4 - Продати товар.");
        System.out.println("4 - Продати товар.");
    }

    private boolean stayOrLeave() {
        System.out.println("Вийти з магазину: y/n");
        String str = Utils.getStr().toLowerCase();
        Logger.INSTANCE.log(LogType.INFO, "Вийти з магазину: y/n" + str);
        switch (str) {
            case "y": {
                Logger.INSTANCE.log(LogType.INFO, "Вихід з магазину.");
                System.out.println("Вихід з магазину.");
                return true;
            }
            case "n": {
                Logger.INSTANCE.log(LogType.INFO, "Продовжуємо роботу в магазині.");
                System.out.println("Продовжуємо роботу в магазині.\n");
                return false;
            }
            default: {
                System.out.println();
                stayOrLeave();
            }
        }
        return false;
    }

    /**
     * load data from files //todo:
     */
    private void initializeStore() {
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

    /**
     * save data to files   //todo:
     */
    private void close() {
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
                writer.write( phones[i].getId()+ "\n");
                writer.write( phones[i].getName()+ "\n");
                writer.write( phones[i].getAmount()+ "\n");
                writer.write( phones[i].getDescription()+ "\n");
                writer.write( phones[i].getPrice()+ "\n");
                writer.write( phones[i].getSystem()+ "\n");
                writer.write( phones[i].getRam().getMemorySize()+ "\n");
                writer.write( phones[i].getRam().getMemoryType()+ "\n");
                writer.write( phones[i].getCpu().getCoreNumber()+ "\n");
                writer.write( phones[i].getCpu().getFrequency()+ "\n");
                writer.write( phones[i].getDiagonal().getDiagonal()+ "\n");
                writer.write( phones[i].getWorkingTime().getWorkOnButtery()+ "\n");
                Calendar cal=Calendar.getInstance();
                cal=phones[i].getWarranty();
                writer.write( phones[i].getWarranty().+ "\n");
                writer.write( phones[i].getWarranty()+ "\n");
                writer.write( phones[i].getWarranty()+ "\n");
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
