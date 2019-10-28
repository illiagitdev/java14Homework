package store.functionaliti;

import goods.Goods;
import store.Store;

public class Selling {
    private Store storeRef;

    public void sell(Store store) {
        storeRef = store;
        System.out.println("Панель продажи товаров.\nВиберіть категорію з якої буде продаватись товар");
        Services services = new Services();
        int category = services.inCategory();
        Goods[] items;

        switch (category) {
            case 1: {
                System.out.println("Вибрано: телефони.");
                items = store.getPhones();
                selector(items);
                break;
            }
            case 2: {
                System.out.println("Вибрано: комп'ютери.");
                items = store.getComputers();
                selector(items);
                break;
            }
            case 3: {
                System.out.println("Вибрано: овочі.");
                items = store.getVegetables();
                selector(items);
                break;
            }
            case 4: {
                System.out.println("Вибрано: солодощі.");
                items = store.getSweets();
                selector(items);
                break;
            }
            case 5: {
                System.out.println("Вибрано: мінеральна вода.");
                items = store.getFreshWaters();
                selector(items);
                break;
            }
            case 6: {
                System.out.println("Вибрано: солодка вода.");
                items = store.getSweetWaters();
                selector(items);
                break;
            }
            case 7: {
                System.out.println("Вибрано: одяг.");
                items = store.getClothes();
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

        System.out.println("переглянути товари - 1");
        int choice = Utils.getInt();
        if (choice == 1) {
            for (Goods x : items) {
                System.out.println("ID: " + x.getId() + "  назва: " + x.getName() + "\t\tціна: " + x.getPrice() +
                        "\nна складі: " + x.getAmount());
            }
        }
        System.out.print("Вкажіть ID товару для продажу ");
        int id = Utils.getInt();
        System.out.print("Кількість товару для продажу: ");
        int sellAmount = Utils.getInt();
        for (Goods x : items) {
            if (id == x.getId() && sellAmount <= x.getAmount()) {
                x.setAmount(x.getAmount() - sellAmount);
                storeRef.setBalance(storeRef.getBalance() + x.getPrice() * sellAmount);
                System.out.println("Успішно продано " + sellAmount + " одиниць товару на суму " + x.getPrice() * sellAmount);
            }
        }
    }
}
