package store.functionaliti;

import goods.Goods;
import goods.categoris.Phone;
import store.Store;

public class Services {

    public int getItemByID(Store store) {
        System.out.println("Введіть ID товару:");
        int id = Utils.getInt();
        int count = 0;
        for (Goods x : store.getPhones()) {
            if (x.getId() == id) {
                System.out.println(x.show());
                count++;
            }
        }
        for (Goods x : store.getComputers()) {
            if (x.getId() == id) {
                System.out.println(x.show());
                count++;
            }
        }
        for (Goods x : store.getVegetables()) {
            if (x.getId() == id) {
                System.out.println(x.show());
                count++;
            }
        }
        for (Goods x : store.getSweets()) {
            if (x.getId() == id) {
                System.out.println(x.show());
                count++;
            }
        }
        for (Goods x : store.getFreshWaters()) {
            if (x.getId() == id) {
                System.out.println(x.show());
                count++;
            }
        }
        for (Goods x : store.getSweetWaters()) {
            if (x.getId() == id) {
                System.out.println(x.show());
                count++;
            }
        }
        for (Goods x : store.getClothes()) {
            if (x.getId() == id) {
                System.out.println(x.show());
                count++;
            }
        }
        if (count == 1) {
            return id;
        }
        return 0;
    }

    public void showByCategory(Store store) {
        switch (inCategory()) {
            case 1: {
                System.out.println("Вибрано: Смартфони.");
                for (Phone x : store.getPhones()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 2: {
                System.out.println("Вибрано: Комп'ютери.");
                for (Goods x : store.getComputers()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 3: {
                System.out.println("Вибрано: Овочі.");
                for (Goods x : store.getVegetables()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 4: {
                System.out.println("Вибрано: Солодощі.");
                for (Goods x : store.getSweets()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 5: {
                System.out.println("Вибрано: Вода.");
                for (Goods x : store.getFreshWaters()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 6: {
                System.out.println("Вибрано: Солодка вода.");
                for (Goods x : store.getSweetWaters()) {
                    System.out.println(x.show());
                }
                break;
            }
            case 7: {
                System.out.println("Вибрано: Одяг.");
                for (Goods x : store.getClothes()) {
                    System.out.println(x.show());
                }
                break;
            }
            default: {
                System.out.println("Категорії не існує.");
                break;
            }
        }
    }

    private void search(Goods x, String name) {
        if (x.getName().toLowerCase().contains(name)) {
            System.out.println("Знайдено: " + x.getId() + " " + x.getName());
        }
    }

    private int inCategory() {
        System.out.println("Категорії:\n\t1 - Смартфони\t\t2 - Комп'ютери" +
                "\n\t3 - Овочі\t\t4 - Солодощі" +
                "\n\t5 - Вода\t\t6 - Солодка вода" +
                "\n\t7 - Одяг");
        System.out.print("Введіть номер: ");
        return Utils.getInt();
    }

    public void getByName(Store store) {
        int in = inCategory();
        System.out.println("Введіть назву товару:");
        String name = Utils.getStr();
        switch (in) {
            case 1: {
                System.out.println("Вибрано: Смартфони.");
                for (Goods x : store.getPhones()) {
                    search(x, name);
                }
                break;
            }
            case 2: {
                System.out.println("Вибрано: Комп'ютери.");
                for (Goods x : store.getComputers()) {
                    search(x, name);
                }
                break;
            }
            case 3: {
                System.out.println("Вибрано: Овочі.");
                for (Goods x : store.getVegetables()) {
                    search(x, name);
                }
                break;
            }
            case 4: {
                System.out.println("Вибрано: Солодощі.");
                for (Goods x : store.getSweets()) {
                    search(x, name);
                }
                break;
            }
            case 5: {
                System.out.println("Вибрано: Вода.");
                for (Goods x : store.getFreshWaters()) {
                    search(x, name);
                }
                break;
            }
            case 6: {
                System.out.println("Вибрано: Солодка вода.");
                for (Goods x : store.getSweetWaters()) {
                    search(x, name);
                }
                break;
            }
            case 7: {
                System.out.println("Вибрано: Одяг.");
                for (Goods x : store.getClothes()) {
                    search(x, name);
                }
                break;
            }
            default: {
                System.out.println("Категорії не існує.");
                break;
            }
        }
    }

    public void addGoods(Store store) {
        int id = getItemByID(store);
        System.out.println("Додаємо старий або новий товар.");
        if (id == 1) {
            System.out.print("Скільки одиниць товару додаємо: ");
            int amount = Utils.getInt();
            setItemAmount(store, id, amount);
        } else {
            System.out.println("Товару в магазині немає.\nДодайте його вручну:");
            int newElementTo = inCategory();
            addElement(store, newElementTo);
        }
    }

    private void addElement(Store store, int newElementTo) {
        switch (newElementTo) {
            case 1: {
                addPhone(store);
                break;
            }
            case 2: {
                addComputer(store);
                break;
            }
            case 3: {
                addVegetables(store);
                break;
            }
            case 4: {
                addSweets(store);
                break;
            }
            case 5: {
                addFreshWater(store);
                break;
            }
            case 6: {
                addSweetWater(store);
                break;
            }
            case 7: {
                addClothes(store);
                break;
            }
            default: {
                System.out.println("Категорії не існує.");
                break;
            }
        }
    }

    private void addNewElement(Store store) {

    }

    private void addClothes(Store store) {
        addNewElement(store);
    }

    private void addSweetWater(Store store) {
        addNewElement(store);

    }

    private void addFreshWater(Store store) {
        addNewElement(store);

    }

    private void addSweets(Store store) {
        addNewElement(store);

    }

    private void addVegetables(Store store) {
        addNewElement(store);

    }

    private void addComputer(Store store) {
        addNewElement(store);

    }

    private void addPhone(Store store) {
        addNewElement(store);

    }

    public void setItemAmount(Store store, int id, int amount) {
        for (Goods x : store.getPhones()) {
            if (x.getId() == id) {
                System.out.println("Старе значення: " + x.getId() + " " + x.getAmount());
                x.setAmount(x.getAmount() + amount);
                System.out.println("Нове значення: " + x.getId() + " " + x.getAmount());
            }
        }
        for (Goods x : store.getComputers()) {
            if (x.getId() == id) {
                System.out.println("Старе значення: " + x.getId() + " " + x.getAmount());
                x.setAmount(x.getAmount() + amount);
                System.out.println("Нове значення: " + x.getId() + " " + x.getAmount());
            }
        }
        for (Goods x : store.getVegetables()) {
            if (x.getId() == id) {
                System.out.println("Старе значення: " + x.getId() + " " + x.getAmount());
                x.setAmount(x.getAmount() + amount);
                System.out.println("Нове значення: " + x.getId() + " " + x.getAmount());
            }
        }
        for (Goods x : store.getSweets()) {
            if (x.getId() == id) {
                System.out.println("Старе значення: " + x.getId() + " " + x.getAmount());
                x.setAmount(x.getAmount() + amount);
                System.out.println("Нове значення: " + x.getId() + " " + x.getAmount());
            }
        }
        for (Goods x : store.getFreshWaters()) {
            if (x.getId() == id) {
                System.out.println("Старе значення: " + x.getId() + " " + x.getAmount());
                x.setAmount(x.getAmount() + amount);
                System.out.println("Нове значення: " + x.getId() + " " + x.getAmount());
            }
        }
        for (Goods x : store.getSweetWaters()) {
            if (x.getId() == id) {
                System.out.println("Старе значення: " + x.getId() + " " + x.getAmount());
                x.setAmount(x.getAmount() + amount);
                System.out.println("Нове значення: " + x.getId() + " " + x.getAmount());
            }
        }
        for (Goods x : store.getClothes()) {
            if (x.getId() == id) {
                System.out.println("Старе значення: " + x.getId() + " " + x.getAmount());
                x.setAmount(x.getAmount() + amount);
                System.out.println("Нове значення: " + x.getId() + " " + x.getAmount());
            }
        }
    }
}
