package storeX;

import logger.LogType;
import logger.Logger;
import storeX.extentions.Operational;
import storeX.extentions.Pathes;
import storeX.extentions.Utils;

import java.io.*;
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

    }

    private double readBalance(File file) {
        int balance = 0;
        if (!file.exists()) {
            Logger.INSTANCE.log(LogType.WARNING, "Файл не знайдено!");
            System.out.println("Файл не знайдено!");
        } else {
            try {
                Scanner input = new Scanner(file);
                balance = input.hasNextInt() ? input.nextInt() : 0;
            } catch (FileNotFoundException e) {
                Logger.INSTANCE.log(LogType.WARNING, "Exception: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }
        return balance;
    }

    private String[] fileContent(File file, int index) {
        String[] str = new String[0];
        if (!file.exists()) {
            Logger.INSTANCE.log(LogType.WARNING, "Файл не знайдено!");
            System.out.println("Файл не знайдено!");
        } else {
            try {
                Scanner input = new Scanner(file);
                int length = input.hasNextInt() ? input.nextInt() : 0;
                str = new String[1 + index * length];
                for (int i = 1; i < str.length; i++) {
                    str[i] = input.nextLine();
                }
            } catch (FileNotFoundException e) {
                Logger.INSTANCE.log(LogType.WARNING, "Exception: Файл не знайдено! " + e);
                e.printStackTrace();
            } catch (IndexOutOfBoundsException ignored) {
                Logger.INSTANCE.log(LogType.WARNING, "IndexOutOfBoundsException! " + ignored);
                ignored.printStackTrace();
            }
        }
        return str;
    }

    /**
     * save data to files   //todo:
     */
    private void close() {
        wrightBalance(storeX.getBalance(), new File(Pathes.BALANCE));
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
