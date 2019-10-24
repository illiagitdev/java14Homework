package store.functionaliti;

import goods.Goods;
import goods.categoris.*;
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
            return count;
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
        int count = getItemByID(store);
        if (count == 1) {
            System.out.println("Додаємо старий товар.");
            System.out.println("Введіть ID товару:");
            int id = Utils.getInt();
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

    private void addClothes(Store store) {
        Clothes[] addClothes = new Clothes[store.getPhones().length + 1];
        for (int i = 0; i < addClothes.length - 1; i++) {
            addClothes[i] = store.getClothes()[i];
        }

        int id = addClothes[addClothes.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);
        System.out.print("Введіть назву одягу ");
        String name = Utils.getStr();
        System.out.print("Введіть кількість товару в поставці: ");
        int amount = Utils.getInt();
        System.out.print("Введіть опис товару: ");
        String description = Utils.getStr();
        System.out.print("Вкажіть вартість товару: ");
        float price = Utils.getFloat();

        addClothes[addClothes.length - 1] = new Clothes(id, name, amount, description, price);
        store.setClothes(addClothes);
        System.out.println(store.getClothes()[addClothes.length - 1].show());
    }

    private void addSweetWater(Store store) {
        SweetWater[] addSweetWater = new SweetWater[store.getPhones().length + 1];
        for (int i = 0; i < addSweetWater.length - 1; i++) {
            addSweetWater[i] = store.getSweetWaters()[i];
        }

        int id = addSweetWater[addSweetWater.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);
        System.out.print("Введіть назву Солодкої води ");
        String name = Utils.getStr();
        System.out.print("Введіть кількість товару в поставці: ");
        int amount = Utils.getInt();
        System.out.print("Введіть опис товару: ");
        String description = Utils.getStr();
        System.out.print("Вкажіть вартість товару: ");
        float price = Utils.getFloat();

        addSweetWater[addSweetWater.length - 1] = new SweetWater(id, name, amount, description, price);
        store.setSweetWaters(addSweetWater);
        System.out.println(store.getSweetWaters()[addSweetWater.length - 1].show());
    }

    private void addFreshWater(Store store) {
        FreshWater[] addFreshWater = new FreshWater[store.getPhones().length + 1];
        for (int i = 0; i < addFreshWater.length - 1; i++) {
            addFreshWater[i] = store.getFreshWaters()[i];
        }

        int id = addFreshWater[addFreshWater.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);
        System.out.print("Введіть назву води ");
        String name = Utils.getStr();
        System.out.print("Введіть кількість товару в поставці: ");
        int amount = Utils.getInt();
        System.out.print("Введіть опис товару: ");
        String description = Utils.getStr();
        System.out.print("Вкажіть вартість товару: ");
        float price = Utils.getFloat();

        addFreshWater[addFreshWater.length - 1] = new FreshWater(id, name, amount, description, price);
        store.setFreshWaters(addFreshWater);
        System.out.println(store.getFreshWaters()[addFreshWater.length - 1].show());
    }

    private void addSweets(Store store) {
        Sweets[] addSweets = new Sweets[store.getPhones().length + 1];
        for (int i = 0; i < addSweets.length - 1; i++) {
            addSweets[i] = store.getSweets()[i];
        }

        int id = addSweets[addSweets.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);
        System.out.print("Введіть назву солодощів ");
        String name = Utils.getStr();
        System.out.print("Введіть кількість товару в поставці: ");
        int amount = Utils.getInt();
        System.out.print("Введіть опис товару: ");
        String description = Utils.getStr();
        System.out.print("Вкажіть вартість товару: ");
        float price = Utils.getFloat();

        addSweets[addSweets.length - 1] = new Sweets(id, name, amount, description, price);
        store.setSweets(addSweets);
        System.out.println(store.getSweets()[addSweets.length - 1].show());
    }

    private void addVegetables(Store store) {
        Vegetable[] addVegetable = new Vegetable[store.getPhones().length + 1];
        for (int i = 0; i < addVegetable.length - 1; i++) {
            addVegetable[i] = store.getVegetables()[i];
        }

        int id = addVegetable[addVegetable.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);
        System.out.print("Введіть назву овочів ");
        String name = Utils.getStr();
        System.out.print("Введіть кількість товару в поставці: ");
        int amount = Utils.getInt();
        System.out.print("Введіть опис товару: ");
        String description = Utils.getStr();
        System.out.print("Вкажіть вартість товару: ");
        float price = Utils.getFloat();

        addVegetable[addVegetable.length - 1] = new Vegetable(id, name, amount, description, price);
        store.setVegetables(addVegetable);
        System.out.println(store.getVegetables()[addVegetable.length - 1].show());
    }

    private void addComputer(Store store) {
        Computer[] addComputer = new Computer[store.getPhones().length + 1];
        for (int i = 0; i < addComputer.length - 1; i++) {
            addComputer[i] = store.getComputers()[i];
        }

        int id = addComputer[addComputer.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);
        System.out.print("Введіть назву комп'ютер ");
        String name = Utils.getStr();
        System.out.print("Введіть кількість товару в поставці: ");
        int amount = Utils.getInt();
        System.out.print("Введіть опис товару: ");
        String description = Utils.getStr();
        System.out.print("Вкажіть вартість товару: ");
        float price = Utils.getFloat();

        addComputer[addComputer.length - 1] = new Computer(id, name, amount, description, price);
        store.setComputers(addComputer);
        System.out.println(store.getComputers()[addComputer.length - 1].show());
    }

    private void addPhone(Store store) {
        Phone[] addPhone = new Phone[store.getPhones().length + 1];
        for (int i = 0; i < addPhone.length - 1; i++) {
            addPhone[i] = store.getPhones()[i];
        }

        int id = addPhone[addPhone.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);
        System.out.print("Введіть назву телефону ");
        String name = Utils.getStr();
        System.out.print("Введіть кількість товару в поставці: ");
        int amount = Utils.getInt();
        System.out.print("Введіть опис товару: ");
        String description = Utils.getStr();
        System.out.print("Вкажіть вартість товару: ");
        float price = Utils.getFloat();

        addPhone[addPhone.length - 1] = new Phone(id, name, amount, description, price);
        store.setPhones(addPhone);
        System.out.println(store.getPhones()[addPhone.length - 1].show());
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
