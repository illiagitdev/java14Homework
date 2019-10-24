import store.Store;
import store.functionaliti.Utils;

import java.io.Console;

public class Operational {
    Store store = new Store();

    public void run() {

        store.open();
        boolean leaveStore = false;
        while (!leaveStore) {
            whatToDo();
            toDo();

            leaveStore = stayOrLeave(leaveStore);
        }

        store.close();
    }

    private boolean stayOrLeave(boolean leaveStore) {
        System.out.println("Продовжити/вийти з магазину: y/n");
        String str = Utils.getStr().toLowerCase();
        switch (str) {
            case "y": {
                System.out.println("Вихід з магазину.");
                leaveStore = true;
                store.close();
                break;
            }
            case "n": {
                System.out.println("Продовжуємо роботу в магазині.");
                break;
            }
            default: {
                System.out.println("");
                stayOrLeave(leaveStore);
            }
        }
        return leaveStore;
    }

    private void toDo() {
        System.out.print("Введіть номер: ");
        int choice = Utils.getInt();
        System.out.print("Вибрано пункт: " + choice + "\n");

        switch (choice) {
            case 1:
                System.out.println("Вибрано: 1 - Перевірити наявні товари.");

                break;
            case 2:
                System.out.println("Вибрано: 2 - Вся інформація про товар по id.");

                break;
            case 3:
                System.out.println("Вибрано: 3 - Пошук товару по назві.");

                break;
            case 4:
                System.out.println("Вибрано: 4 - Фільтр по ціні:");

                break;
            case 5:
                System.out.println("Вибрано: 5 - Отримати нову поставку.");

                break;
            case 6:
                System.out.println("Вибрано: 6 - Продати товар.");

                break;
            default: {
                System.out.println("невірний ввід(");
                break;
            }
        }
    }

    private void whatToDo() {
        System.out.println("Магазин \"Дрібнички\" відкрито.");
        System.out.println("1 - Перевірити наявні товари.");
        System.out.println("2 - Вся інформація про товар по id.");
        System.out.println("3 - Пошук товару по назві.");
        System.out.println("4 - Фільтр по ціні:");
        System.out.println("\ta - Ціна вища від:");
        System.out.println("\tb - Ціна нижча від:");
        System.out.println("5 - Отримати нову поставку.");
        System.out.println("6 - Продати товар.");
    }

}
