package goods.categoris;

import goods.Goods;

public class FreshWater extends Goods {

    public FreshWater(int id, String name, int amount, String description, float price) {
        super(id, name, amount, description, price);
    }

    public FreshWater() {
    }

    @Override
    public String show() {
        return "Мінеральна вода:"+super.show()+'\n';
    }
}
