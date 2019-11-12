package storeX.extentions;

import goods.Goods;
import logger.LogType;
import logger.Logger;
import storeX.StoreX;

public class Selling {
    private StoreX storeRef;

    public void sell(StoreX storeX, Operational operate) {
        storeRef = storeX;
        System.out.println("Панель продажи товаров.\nВиберіть категорію з якої буде продаватись товар");
        Logger.INSTANCE.log(LogType.INFO, "Панель продажи товаров. Виберіть категорію з якої буде продаватись товар");
        int index = operate.displayCategories();
        Goods[] items;
        switch (index) {
            case 1: {
                System.out.println("Вибрано: телефони.");
                items = storeX.getPhones();
                selector(items);
                break;
            }
            case 2: {
                System.out.println("Вибрано: комп'ютери.");
                items = storeX.getComputers();
                selector(items);
                break;
            }
            case 3: {
                System.out.println("Вибрано: овочі.");
                items = storeX.getVegetables();
                selector(items);
                break;
            }
            case 4: {
                System.out.println("Вибрано: солодощі.");
                items = storeX.getSweets();
                selector(items);
                break;
            }
            case 5: {
                System.out.println("Вибрано: мінеральна вода.");
                items = storeX.getFreshWaters();
                selector(items);
                break;
            }
            case 6: {
                System.out.println("Вибрано: солодка вода.");
                items = storeX.getSweetWaters();
                selector(items);
                break;
            }
            case 7: {
                System.out.println("Вибрано: одяг.");
                items = storeX.getClothes();
                selector(items);
                break;
            }
            default: {
                System.out.println("невірний ввід(");
                break;
            }
        }
    }

    private void selector(Goods[] items) {

        System.out.println("Список товарів:");
        for (Goods x : items) {
            System.out.println("ID: " + x.getId() + "  назва: " + x.getName() + "\t\tціна: " + x.getPrice() +
                    "\nна складі: " + x.getAmount());
        }
        System.out.print("Вкажіть ID товару для продажу ");
        int id = Utils.getInt();
        System.out.print("Кількість товару для продажу: ");
        int sellAmount = Utils.getInt();
        for (Goods x : items) {
            if (id == x.getId() && sellAmount <= x.getAmount()) {
                x.setAmount(x.getAmount() - sellAmount);
                storeRef.setBalance(storeRef.getBalance() + x.getPrice() * sellAmount);
                Logger.INSTANCE.log(LogType.INFO, "Успішно продано " + sellAmount + " одиниць товару на суму " + x.getPrice() * sellAmount);
                System.out.println("Успішно продано " + sellAmount + " одиниць товару на суму " + x.getPrice() * sellAmount);
            }
        }
    }
}
