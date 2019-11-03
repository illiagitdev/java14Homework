package storeX.extentions;

import goods.Goods;
import logger.LogType;
import logger.Logger;
import storeX.StoreX;

public class Operational {
    public void showCategory(StoreX storeX) {
        switch (displayCategories()) {
            case 1: {
                System.out.println("Вибрано: Смартфони.");
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: Смартфони.");
                for (Goods x : storeX.getPhones()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 2: {
                System.out.println("Вибрано: Комп'ютери.");
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: Комп'ютери.");
                for (Goods x : storeX.getComputers()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 3: {
                System.out.println("Вибрано: Овочі.");
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: Овочі.");
                for (Goods x : storeX.getVegetables()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 4: {
                System.out.println("Вибрано: Солодощі.");
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: Солодощі.");
                for (Goods x : storeX.getSweets()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 5: {
                System.out.println("Вибрано: Вода.");
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: Вода.");
                for (Goods x : storeX.getFreshWaters()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 6: {
                System.out.println("Вибрано: Солодка вода.");
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: Солодка вода.");
                for (Goods x : storeX.getSweetWaters()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 7: {
                System.out.println("Вибрано: Одяг.");
                Logger.INSTANCE.log(LogType.INFO, "Вибрано: Одяг.");
                for (Goods x : storeX.getClothes()) {
                    System.out.println(x.show());
                }
                break;
            }
            default: {
                System.out.println("Категорії не існує.");
                Logger.INSTANCE.log(LogType.INFO, "Категорії не існує.");
                break;
            }
        }
    }

    private int displayCategories() {
        System.out.println("Категорії:\n\t1 - Смартфони\t\t2 - Комп'ютери\n\t3 - Овочі\t\t4 - Солодощі" +
                "\n\t5 - Вода\t\t6 - Солодка вода\n\t7 - Одяг");
        Logger.INSTANCE.log(LogType.INFO, "Категорії:\n\t1 - Смартфони\t\t2 - Комп'ютери" +
                "\n\t3 - Овочі\t\t4 - Солодощі\n\t5 - Вода\t\t6 - Солодка вода\n\t7 - Одяг");
        System.out.print("Введіть номер: ");
        int res = Utils.getInt();
        Logger.INSTANCE.log(LogType.INFO, "Введіть номер: " + res);
        return res;
    }
}
