package goods.categoris;

import goods.Goods;

public class FreshWater extends Goods {

    @Override
    public String show() {
        return "Мінеральна вода:"+super.show()+'\n';
    }
}
