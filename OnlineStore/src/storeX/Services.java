package storeX;

import logger.LogType;
import logger.Logger;
import storeX.extentions.*;

public class Services {
    private StoreX storeX;
    private Operational operate;

    public Services() {
        storeX = StoreX.getInstance();
        Logger.INSTANCE.log(LogType.INFO, "Initialising...");
        IOReadFiles.getInstance().initializeStore(storeX);
        operate = new Operational(storeX);
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
        IOWriteFiles.getInstance().close(storeX);
        Logger.INSTANCE.close();
    }

    private void toDo(int choice) {
        switch (choice) {
            case 1: {
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: 1 - Переглянути наявні товари по категорії.");
                System.out.println("Вибрано: 1 - Переглянути наявні товари по категорії.");
                operate.showCategory();
                break;
            }
            case 2: {
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: 2 - Пошук товару по назві в категорії.");
                System.out.println("Вибрано: 2 - Пошук товару по назві в категорії.");
                operate.getByName();
                break;
            }
            case 3: {
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: 3 - Отримати нову поставку.");
                System.out.println("Вибрано: 3 - Отримати нову поставку.");
                operate.addGoods();
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


}
