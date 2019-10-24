import store.Store;
import store.functionaliti.Services;
import store.functionaliti.Utils;

public class Operational {
    private Store store;

    public void setStore(Store store) {
        this.store = store;
    }

    public void run() {
        boolean leaveStore = false;
        while (!leaveStore) {
            whatToDo(store);
            toDo();

            leaveStore = stayOrLeave(leaveStore);
        }

    }

    private boolean stayOrLeave(boolean leaveStore) {
        System.out.println("Вийти з магазину: y/n");
        String str = Utils.getStr().toLowerCase();
        switch (str) {
            case "y": {
                System.out.println("Вихід з магазину.");
                leaveStore = true;
                break;
            }
            case "n": {
                System.out.println("Продовжуємо роботу в магазині.");
                break;
            }
            default: {
                System.out.println();
                stayOrLeave(leaveStore);
            }
        }
        return leaveStore;
    }

    private void toDo() {
        System.out.print("Введіть номер: ");
        int choice = Utils.getInt();
        System.out.print("Вибрано пункт: " + choice + "\n");
        Services services = new Services();

        switch (choice) {
            case 1: {
                System.out.println("Вибрано: 1 - Перевірити наявні товари.");
                services.showByCategory(store);
                break;
            }
            case 2: {
                System.out.println("Вибрано: 2 - Вся інформація про товар по id.");
                services.getItemByID(store);
                break;
            }
            case 3: {
                System.out.println("Вибрано: 3 - Пошук товару по назві.");
                services.getByName(store);
                break;
            }
            case 4: {
                System.out.println("Вибрано: 4 - Отримати нову поставку.");
                services.addGoods(store);
                break;
            }
            case 5: {
                System.out.println("Вибрано: 5 - Продати товар.");

                break;
            }
            default: {
                System.out.println("невірний ввід(");
                break;
            }
        }
    }

    private void whatToDo(Store store) {
        System.out.print("Магазин \"Дрібнички\" відкрито.");
        System.out.println("Поточний баланс: " + store.getBalance());
        System.out.println("1 - Перевірити наявні товари.");
        System.out.println("2 - Вся інформація про товар по id.");
        System.out.println("3 - Пошук товару по назві.");
        System.out.println("4 - Отримати нову поставку.");
        System.out.println("5 - Продати товар.");
    }

}
