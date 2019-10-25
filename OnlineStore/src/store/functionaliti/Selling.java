package store.functionaliti;

import goods.Goods;
import store.Store;

public class Selling {
    public void sell(Store store){
        System.out.println("Панель продажи товаров.\nВиберіть категорію з якої буде продаватись товар");
        Services services=new Services();
        int category=services.inCategory();
        System.out.print("Вкажіть ID товару для продажу ");
        int id =Utils.getInt();
        Goods[] items;

        switch (category) {
            case 1: {
                System.out.println("Вибрано: телефони.");
                items = store.getPhones();
                prepareToSell(items,id);
                break;
            }
            case 2: {
                System.out.println("Вибрано: комп'ютери.");
                items = store.getComputers();
                prepareToSell(items,id);
                break;
            }
            case 3: {
                System.out.println("Вибрано: овочі.");
                items = store.getVegetables();
                prepareToSell(items,id);
                break;
            }
            case 4: {
                System.out.println("Вибрано: солодощі.");
                items= store.getSweets();
                prepareToSell(items,id);
                break;
            }
            case 5: {
                System.out.println("Вибрано: мінеральна вода.");
                items = store.getFreshWaters();
                prepareToSell(items,id);
                break;
            }
            case 6: {
                System.out.println("Вибрано: солодка вода.");
                items = store.getSweetWaters();
                prepareToSell(items,id);
                break;
            }
            case 7: {
                System.out.println("Вибрано: одяг.");
                items = store.getClothes();
                prepareToSell(items,id);
                break;
            }
            default: {
                System.out.println("невірний ввід(");
                break;
            }
        }
    }

    private void prepareToSell(Goods[] items, int id) {

    }
}
