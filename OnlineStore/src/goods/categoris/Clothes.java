package goods.categoris;

import goods.Goods;
import goods.components.Brend;

public class Clothes extends Goods {
    private Brend brend;

    public Clothes(int id, String name, int amount, String description, float price) {
        super(id, name, amount, description, price);
        brend = new Brend();
    }

    public Clothes() {
    }

    @Override
    public String show() {
        return "Одяг:" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\nЗаснування\t\t\t\t" + brend.getBrandFoundationYear() + " рік" +
                "\nназва:\t\t\t\t\t" + brend.getBrandName() +
                "\nпостійних працівників\t" + brend.getBrandEmploeesNumber() +
                "\nпродається в\t\t\t" + brend.getBrandSellCountiesNumber() + " країнах";
    }
}
