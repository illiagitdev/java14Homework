package storeX.extentions;

import goods.Goods;
import goods.categoris.*;
import goods.components.Brend;
import goods.components.ExpirationTime;
import goods.components.Warranty;
import goods.components.tech.*;
import logger.LogType;
import logger.Logger;
import storeX.StoreX;

import java.util.Arrays;

public class Operational {
    private StoreX storeX;
    private static final String[] categories = {"Смартфони", "Комп'ютери", "Овочі", "Солодощі", "Вода"
            , "Солодка вода", "Одяг"};
    private Goods[][] list = new Goods[7][];

    public Operational(StoreX store) {
        this.storeX=store;
        list[0] = storeX.getPhones();
        list[1] = storeX.getComputers();
        list[2] = storeX.getVegetables();
        list[3] = storeX.getSweets();
        list[4] = storeX.getFreshWaters();
        list[5] = storeX.getSweetWaters();
        list[6] = storeX.getClothes();
    }

    public void showCategory() {
        int index = displayCategories();
        if (index > 0 && index <= list.length) {
            System.out.println("Вибрано: " + categories[index - 1] + ".");
            Logger.INSTANCE.log(LogType.INFO, "Вибрано: " + categories[index - 1] + ".");
            for (Goods x : list[index - 1]) {
                System.out.println(x.show());
            }
        } else {
            System.out.println("Категорії не існує.");
            Logger.INSTANCE.log(LogType.INFO, "Категорії не існує.");
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

    public void getByName() {
        int index = displayCategories();
        System.out.println("Введіть назву товару:");
        String name = Utils.getStr();
        Logger.INSTANCE.log(LogType.INFO, "Введіть назву товару:" + name);
        if (index > 0 && index <= list.length) {
            search(name, list[index - 1]);
        }
    }

    private void search(String name, Goods[] goods) {
        for (Goods x : goods) {
            if (x.getName().toLowerCase().contains(name.toLowerCase())) {
                Logger.INSTANCE.log(LogType.INFO, "Знайдено: " + x.getId() + " " + x.getName());
                System.out.println("Знайдено: " + x.getId() + " " + x.getName());
            }
        }
    }

    public void addGoods() {
        Logger.INSTANCE.log(LogType.INFO, "Виберіть категорію товару для додавання товару.");
        System.out.println("Виберіть категорію товару для додавання товару.");
        int index = displayCategories();
        System.out.println("Вибрано: " + categories[index - 1] + ".");
        Logger.INSTANCE.log(LogType.INFO, "Вибрано: " + categories[index - 1] + ".");
        if (index <= list.length) {
            Logger.INSTANCE.log(LogType.INFO, "Додати існуючий товар чи новий?\t1 - існуючий\t2 - новий");
            System.out.println("Додати існуючий товар чи новий?\n\t1 - існуючий\n\t2 - новий");
            switch (Utils.getInt()) {
                case 1: {
                    for (Goods x : list[index - 1]) {
                        System.out.println("ID: " + x.getId()+x.getName());
                    }
                    setNewAmount(list[index - 1]);
                    break;
                }
                case 2: {
                    addNewElement(list[index - 1], index);
                    break;
                }
                default: {
                    Logger.INSTANCE.log(LogType.INFO, "Невірний ввід.");
                    System.out.println("Невірний ввід.");
                }
            }
        } else {
            System.out.println("Категорії не існує.");
            Logger.INSTANCE.log(LogType.INFO, "Категорії не існує.");
        }
    }

    private void setNewAmount(Goods[] goods) {
        System.out.println("Введіть ID товару:");
        int id = Utils.getInt();
        Logger.INSTANCE.log(LogType.INFO, "Введіть ID товару:" + id);
        System.out.print("Скільки одиниць товару додаємо: ");
        int amount = Utils.getInt();
        Logger.INSTANCE.log(LogType.INFO, "Скільки одиниць товару додаємо: " + amount);
        for (Goods x : goods) {
            if (amount >= 0 && x.getId() == id) {
                Logger.INSTANCE.log(LogType.INFO, "Старе значення: " + x.getId() + " " + x.getAmount());
                System.out.println("Старе значення: " + x.getId() + " " + x.getAmount());
                x.setAmount(x.getAmount() + amount);
                Logger.INSTANCE.log(LogType.INFO, "Нове значення: " + x.getId() + " " + x.getAmount());
                System.out.println("Нове значення: " + x.getId() + " " + x.getAmount());
            }
        }
    }

    private void addNewElement(Goods[] goods, int index) {
        switch (index) {
            case 1: {
//                addPhone(goods);
                break;
            }
            case 2: {
//                addComputer(goods);
                break;
            }
            case 3: {
//                addVegetables(goods);
                break;
            }
            case 4: {
//                addSweets(goods);
                break;
            }
            case 5: {
//                addFreshWater(goods);
                break;
            }
            case 6: {
//                addSweetWater(goods);
                break;
            }
            case 7: {
                addClothes((Clothes[]) goods);
                break;
            }
            default: {
                System.out.println("Категорії не існує.");
                break;
            }
        }
    }

    private void addClothes(Clothes[] goods) {
        Clothes[] tempGoods = Arrays.copyOf(goods,goods.length+1);
        int id = tempGoods[tempGoods.length - 2].getId() + 1;
        Logger.INSTANCE.log(LogType.INFO, "ID нового товару: " + id);
        System.out.println("ID нового товару: " + id);
        tempGoods[tempGoods.length - 1] = new Clothes(id, getName(), getAmount(), getDescription(), getPrice());

        System.out.print("Вкажіть рік заснування бренду: ");
        int brandFoundationYear = store.functionaliti.Utils.getInt();
        System.out.print("Вкажіть назву бренду: ");
        String brandName = store.functionaliti.Utils.getStr();
        System.out.print("Вкажіть кількість працівників: ");
        int brandEmployeesNumber = store.functionaliti.Utils.getInt();
        System.out.print("Вкажіть кількість країн в яких продається бренд: ");
        int brandSellCountiesNumber = store.functionaliti.Utils.getInt();
        Brend brend = new Brend(brandFoundationYear, brandName, brandEmployeesNumber, brandSellCountiesNumber);
        tempGoods[tempGoods.length - 1].setBrend(brend);
//        storeX.setClothes(tempGoods);
        goods=tempGoods;
        for (Goods x:goods             ) {
            x.show();
        }
    }

//    private void addSweetWater(Store store) {
//        SweetWater[] addSweetWater = Arrays.copyOf(store.getSweetWaters(),store.getSweetWaters().length+1);
//        int id = addSweetWater[addSweetWater.length - 2].getId() + 1;
//        System.out.println("ID нового товару: " + id);
//        addSweetWater[addSweetWater.length - 1] = new SweetWater(id, getName(), getAmount(), getDescription(), getPrice());
//
//        ExpirationTime expirationTime = getExpireDate();
//        addSweetWater[addSweetWater.length - 1].setExpirationTime(expirationTime);
//        store.setSweetWaters(addSweetWater);
//        System.out.println(store.getSweetWaters()[addSweetWater.length - 1].show());
//    }
//
//    private void addFreshWater(Store store) {
//        FreshWater[] addFreshWater = Arrays.copyOf(store.getFreshWaters(),store.getFreshWaters().length+1);
//        int id = addFreshWater[addFreshWater.length - 2].getId() + 1;
//        System.out.println("ID нового товару: " + id);
//        addFreshWater[addFreshWater.length - 1] = new FreshWater(id, getName(), getAmount(), getDescription(), getPrice());
//        store.setFreshWaters(addFreshWater);
//        System.out.println(store.getFreshWaters()[addFreshWater.length - 1].show());
//    }
//
//    private void addSweets(Store store) {
//        Sweets[] addSweets = Arrays.copyOf(store.getSweets(),store.getSweets().length+1);
//        int id = addSweets[addSweets.length - 2].getId() + 1;
//        System.out.println("ID нового товару: " + id);
//        addSweets[addSweets.length - 1] = new Sweets(id, getName(), getAmount(), getDescription(), getPrice());
//
//        ExpirationTime expirationTime = getExpireDate();
//        addSweets[addSweets.length - 1].setExpirationTime(expirationTime);
//        store.setSweets(addSweets);
//        System.out.println(store.getSweets()[addSweets.length - 1].show());
//    }
//
//    private void addVegetables(Store store) {
//        Vegetable[] addVegetable = Arrays.copyOf(store.getVegetables(),store.getVegetables().length+1);
//        int id = addVegetable[store.getVegetables().length - 1].getId() + 1;
//        System.out.println("ID нового товару: " + id);
//        addVegetable[addVegetable.length - 1] = new Vegetable(id, getName(), getAmount(), getDescription(), getPrice());
//
//        System.out.print("Вкажіть тип продукту ");
//        String type = store.functionaliti.Utils.getStr();
//        ExpirationTime expirationTime = getExpireDate();
//        addVegetable[addVegetable.length - 1].setType(type);
//        addVegetable[addVegetable.length - 1].setExpirationTime(expirationTime);
//        store.setVegetables(addVegetable);
//        System.out.println(store.getVegetables()[addVegetable.length - 1].show());
//    }
//
//    private void addComputer(Store store) {
//        Computer[] addComputer = Arrays.copyOf(store.getComputers(),store.getComputers().length+1);
//        int id = addComputer[addComputer.length - 2].getId() + 1;
//        System.out.println("ID нового товару: " + id);
//        addComputer[addComputer.length - 1] = new Computer(id, getName(), getAmount(), getDescription(), getPrice());
//
//        System.out.print("Вкажіть характеристики відеокарти: ");
//        System.out.print("Вкажіть кількість ядер GPU: ");
//        int coreNumber = store.functionaliti.Utils.getInt();
//        System.out.print("Вкажіть частоту процесора GPU (ГГц): ");
//        float frequency = store.functionaliti.Utils.getFloat();
//        CPU gpu = new CPU(coreNumber, frequency);
//        System.out.print("Вкажіть розмір мамяті(GB): ");
//        float memorySize = store.functionaliti.Utils.getFloat();
//        System.out.print("Вкажіть тип пам'яті(DDRx): ");
//        String memoryType = store.functionaliti.Utils.getStr();
//        VideoRAM videoRAM = new VideoRAM(memorySize, memoryType);
//        VideoCard videoCard = new VideoCard(gpu, videoRAM);
//        System.out.print("Вкажіть гарантійний термін товару: ");
//        Warranty warranty = new Warranty(getDate());
//        addComputer[addComputer.length - 1].setRam(setRAM());
//        addComputer[addComputer.length - 1].setCpu(setCPU());
//        addComputer[addComputer.length - 1].setVideoCard(videoCard);
//        addComputer[addComputer.length - 1].setWarranty(warranty);
//        store.setComputers(addComputer);
//        System.out.println(store.getComputers()[addComputer.length - 1].show());
//    }
//
//    private void addPhone(Store store) {
//        Phone[] addPhone = Arrays.copyOf(store.getPhones(),store.getPhones().length+1);
//        int id = addPhone[addPhone.length - 2].getId() + 1;
//        System.out.println("ID нового товару: " + id);
//        addPhone[addPhone.length - 1] = new Phone(id, getName(), getAmount(), getDescription(), getPrice());
//
//        System.out.println("Вкажіть тип операційної системи: ");
//        String operational = store.functionaliti.Utils.getStr();
//        OperatingSystem system = new OperatingSystem(operational);
//        System.out.print("Вкажіть діагональ екрану: ");
//        ScreenDiagonal diagonal = new ScreenDiagonal(store.functionaliti.Utils.getInt());
//        System.out.print("Вкажіть ас роботи від батареї (годин): ");
//        WorkingTime workingTime = new WorkingTime(store.functionaliti.Utils.getFloat());
//        System.out.print("Вкажіть гарантійний термін товару: ");
//        Warranty warranty = new Warranty(getDate());
//        addPhone[addPhone.length - 1].setSystem(system);
//        addPhone[addPhone.length - 1].setRam(setRAM());
//        addPhone[addPhone.length - 1].setCpu(setCPU());
//        addPhone[addPhone.length - 1].setDiagonal(diagonal);
//        addPhone[addPhone.length - 1].setWorkingTime(workingTime);
//        addPhone[addPhone.length - 1].setWarranty(warranty);
//        store.setPhones(addPhone);
//        System.out.println(store.getPhones()[addPhone.length - 1].show());
//    }
//
//    private RAM setRAM() {
//        System.out.println("Вкажіть характеристики оперативноъ пам'яті: ");
//        System.out.print("Вкажіть розмір мамяті(GB): ");
//        float memorySize = store.functionaliti.Utils.getFloat();
//        System.out.print("Вкажіть тип пам'яті(DDRx): ");
//        String memoryType = store.functionaliti.Utils.getStr();
//        return new RAM(memorySize, memoryType);
//    }
//
//    private CPU setCPU() {
//        System.out.println("Вкажіть характеристики процесора: ");
//        System.out.print("Вкажіть кількість ядер: ");
//        int coreNumber = store.functionaliti.Utils.getInt();
//        System.out.print("Вкажіть частоту процесора (ГГц): ");
//        float frequency = store.functionaliti.Utils.getFloat();
//        return new CPU(coreNumber, frequency);
//    }
//
//    private ExpirationTime getExpireDate() {
//        System.out.print("Вкажіть дату виготовлення.");
//        Calendar productionDate = getDate();
//        System.out.print("Вкажіть температуру зберігання: ");
//        int saveTemperature = store.functionaliti.Utils.getInt();
//        System.out.print("Вкажіть термін придатності.");
//        Calendar expireDate = getDate();
//        return new ExpirationTime(productionDate, saveTemperature, expireDate);
//    }
//
//    private Calendar getDate() {
//        System.out.println("День: ");
//        int day = store.functionaliti.Utils.getInt();
//        System.out.print("місяць: ");
//        int month = store.functionaliti.Utils.getInt();
//        System.out.print("рік: ");
//        int year = store.functionaliti.Utils.getInt();
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, day);
//        return calendar;
//    }

    private float getPrice() {
        System.out.print("Вкажіть вартість товару: ");
        return Utils.getFloat();
    }

    private String getDescription() {
        System.out.print("Введіть опис товару: ");
        return Utils.getStrLine();
    }

    private int getAmount() {
        System.out.print("Введіть кількість товару в поставці: ");
        return Utils.getInt();
    }

    private String getName() {
        System.out.print("Введіть назву товару ");
        return Utils.getStrLine();
    }
}
