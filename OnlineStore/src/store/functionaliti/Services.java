package store.functionaliti;

import goods.Goods;
import goods.categoris.Phone;
import store.Store;

public class Services {

    public void getItemByID(Store store) {
        System.out.println("Введіть ID товару:");
        int id = Utils.getInt();
        for (Goods x:store.getPhones()) {
            if (x.getId() == id) {
                System.out.println(x.show());
            }
        }
        for (Goods x:store.getComputers()) {
            if (x.getId() == id) {
                System.out.println(x.show());
            }
        }
        for (Goods x:store.getVegetables()) {
            if (x.getId() == id) {
                System.out.println(x.show());
            }
        }
        for (Goods x:store.getSweets()) {
            if (x.getId() == id) {
                System.out.println(x.show());
            }
        }
        for (Goods x:store.getFreshWaters()) {
            if (x.getId() == id) {
                System.out.println(x.show());
            }
        }
        for (Goods x:store.getSweetWaters()) {
            if (x.getId() == id) {
                System.out.println(x.show());
            }
        }
        for (Goods x:store.getClothes()) {
            if (x.getId() == id) {
                System.out.println(x.show());
            }
        }
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
        int in=inCategory();
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
}
