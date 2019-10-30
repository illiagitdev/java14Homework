package store.functionaliti;

import goods.Goods;
import goods.categoris.*;
import goods.components.Brend;
import goods.components.ExpirationTime;
import goods.components.Warranty;
import goods.components.tech.*;
import store.Store;

import java.util.Calendar;

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

    public int inCategory() {
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
        Clothes[] addClothes = new Clothes[store.getClothes().length + 1];
        for (int i = 0; i < addClothes.length - 1; i++) {
            addClothes[i] = store.getClothes()[i];
        }

        int id = addClothes[addClothes.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);
        System.out.print("Вкажіть рік заснування бренду: ");
        int brandFoundationYear = Utils.getInt();
        System.out.print("Вкажіть назву бренду: ");
        String brandName = Utils.getStr();
        System.out.print("Вкажіть кількість працівників: ");
        int brandEmployeesNumber = Utils.getInt();
        System.out.print("Вкажіть кількість країн в яких продається бренд: ");
        int brandSellCountiesNumber = Utils.getInt();

        Brend brend = new Brend(brandFoundationYear, brandName, brandEmployeesNumber, brandSellCountiesNumber);
        addClothes[addClothes.length - 1] = new Clothes(id, getName(), getAmount(), getDescription(), getPrice());
        addClothes[addClothes.length - 1].setBrend(brend);
        store.setClothes(addClothes);
        System.out.println(store.getClothes()[addClothes.length - 1].show());
    }

    private void addSweetWater(Store store) {
        SweetWater[] addSweetWater = new SweetWater[store.getSweetWaters().length + 1];
        for (int i = 0; i < addSweetWater.length - 1; i++) {
            addSweetWater[i] = store.getSweetWaters()[i];
        }

        int id = addSweetWater[addSweetWater.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);

        ExpirationTime expirationTime = getExpireDate();
        addSweetWater[addSweetWater.length - 1] = new SweetWater(id, getName(), getAmount(), getDescription(), getPrice());
        addSweetWater[addSweetWater.length - 1].setExpirationTime(expirationTime);
        store.setSweetWaters(addSweetWater);
        System.out.println(store.getSweetWaters()[addSweetWater.length - 1].show());
    }

    private void addFreshWater(Store store) {
        FreshWater[] addFreshWater = new FreshWater[store.getFreshWaters().length + 1];
        for (int i = 0; i < addFreshWater.length - 1; i++) {
            addFreshWater[i] = store.getFreshWaters()[i];
        }

        int id = addFreshWater[addFreshWater.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);

        addFreshWater[addFreshWater.length - 1] = new FreshWater(id, getName(), getAmount(), getDescription(), getPrice());
        store.setFreshWaters(addFreshWater);
        System.out.println(store.getFreshWaters()[addFreshWater.length - 1].show());
    }

    private void addSweets(Store store) {
        Sweets[] addSweets = new Sweets[store.getSweets().length + 1];
        for (int i = 0; i < addSweets.length - 1; i++) {
            addSweets[i] = store.getSweets()[i];
        }

        int id = addSweets[addSweets.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);

        ExpirationTime expirationTime = getExpireDate();
        addSweets[addSweets.length - 1] = new Sweets(id, getName(), getAmount(), getDescription(), getPrice());
        addSweets[addSweets.length - 1].setExpirationTime(expirationTime);
        store.setSweets(addSweets);
        System.out.println(store.getSweets()[addSweets.length - 1].show());
    }

    private void addVegetables(Store store) {
        Vegetable[] addVegetable = new Vegetable[store.getVegetables().length + 1];
        for (int i = 0; i < addVegetable.length - 1; i++) {
            addVegetable[i] = store.getVegetables()[i];
        }

        int id = addVegetable[store.getVegetables().length - 1].getId() + 1;
        System.out.println("ID нового товару: " + id);
        System.out.print("Вкажіть тип продукту ");
        String type = Utils.getStr();

        ExpirationTime expirationTime = getExpireDate();
        addVegetable[addVegetable.length - 1] = new Vegetable(id, getName(), getAmount(), getDescription(), getPrice());
        addVegetable[addVegetable.length - 1].setType(type);
        addVegetable[addVegetable.length - 1].setExpirationTime(expirationTime);
        store.setVegetables(addVegetable);
        System.out.println(store.getVegetables()[addVegetable.length - 1].show());
    }

    private void addComputer(Store store) {
        Computer[] addComputer = new Computer[store.getComputers().length + 1];
        for (int i = 0; i < addComputer.length - 1; i++) {
            addComputer[i] = store.getComputers()[i];
        }

        int id = addComputer[addComputer.length - 2].getId() + 1;
        System.out.println("ID нового товару: " + id);

        System.out.print("Вкажіть характеристики відеокарти: ");
        System.out.print("Вкажіть кількість ядер GPU: ");
        int coreNumber = Utils.getInt();
        System.out.print("Вкажіть частоту процесора GPU (ГГц): ");
        float frequency = Utils.getFloat();
        CPU gpu = new CPU(coreNumber, frequency);

        System.out.print("Вкажіть розмір мамяті(GB): ");
        float memorySize = Utils.getFloat();
        System.out.print("Вкажіть тип пам'яті(DDRx): ");
        String memoryType = Utils.getStr();
        VideoRAM videoRAM = new VideoRAM(memorySize, memoryType);
        VideoCard videoCard = new VideoCard(gpu, videoRAM);

        System.out.print("Вкажіть гарантійний термін товару: ");
        Warranty warranty = new Warranty(getDate());

        addComputer[addComputer.length - 1] = new Computer(id, getName(), getAmount(), getDescription(), getPrice());
        addComputer[addComputer.length - 1].setRam(setRAM());
        addComputer[addComputer.length - 1].setCpu(setCPU());
        addComputer[addComputer.length - 1].setVideoCard(videoCard);
        addComputer[addComputer.length - 1].setWarranty(warranty);
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
        System.out.println("Вкажіть тип операційної системи: ");
        String operational = Utils.getStr();
        OperatingSystem system = new OperatingSystem(operational);

        System.out.print("Вкажіть діагональ екрану: ");
        ScreenDiagonal diagonal = new ScreenDiagonal(Utils.getInt());
        System.out.print("Вкажіть ас роботи від батареї (годин): ");
        WorkingTime workingTime = new WorkingTime(Utils.getFloat());

        System.out.print("Вкажіть гарантійний термін товару: ");
        Warranty warranty = new Warranty(getDate());

        addPhone[addPhone.length - 1] = new Phone(id, getName(), getAmount(), getDescription(), getPrice());
        addPhone[addPhone.length - 1].setSystem(system);
        addPhone[addPhone.length - 1].setRam(setRAM());
        addPhone[addPhone.length - 1].setCpu(setCPU());
        addPhone[addPhone.length - 1].setDiagonal(diagonal);
        addPhone[addPhone.length - 1].setWorkingTime(workingTime);
        addPhone[addPhone.length - 1].setWarranty(warranty);

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

    private RAM setRAM() {
        System.out.println("Вкажіть характеристики оперативноъ пам'яті: ");
        System.out.print("Вкажіть розмір мамяті(GB): ");
        float memorySize = Utils.getFloat();
        System.out.print("Вкажіть тип пам'яті(DDRx): ");
        String memoryType = Utils.getStr();
        return new RAM(memorySize, memoryType);
    }

    private CPU setCPU() {
        System.out.println("Вкажіть характеристики процесора: ");
        System.out.print("Вкажіть кількість ядер: ");
        int coreNumber = Utils.getInt();
        System.out.print("Вкажіть частоту процесора (ГГц): ");
        float frequency = Utils.getFloat();
        return new CPU(coreNumber, frequency);
    }

    private ExpirationTime getExpireDate() {
        System.out.print("Вкажіть дату виготовлення.");
        Calendar productionDate = getDate();
        System.out.print("Вкажіть температуру зберігання: ");
        int saveTemperature = Utils.getInt();
        System.out.print("Вкажіть термін придатності.");
        Calendar expireDate = getDate();
        return new ExpirationTime(productionDate, saveTemperature, expireDate);
    }

    private Calendar getDate() {
        System.out.println("День: ");
        int day = Utils.getInt();
        System.out.print("місяць: ");
        int month = Utils.getInt();
        System.out.print("рік: ");
        int year = Utils.getInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar;
    }

    private float getPrice() {
        System.out.print("Вкажіть вартість товару: ");
        return Utils.getFloat();
    }

    private String getDescription() {
        System.out.print("Введіть опис товару: ");
        return Utils.getStr();
    }

    private int getAmount() {
        System.out.print("Введіть кількість товару в поставці: ");
        return Utils.getInt();
    }

    private String getName() {
        System.out.print("Введіть назву товару ");
        return Utils.getStr();
    }
}
