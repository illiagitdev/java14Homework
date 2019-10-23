package goods.categoris;

import goods.Goods;
import goods.components.Warranty;

public class Vegetable extends Goods {
    private Warranty warranty;

    @Override
    public String show() {
        return super.show() + toString();
    }

    @Override
    public String toString() {
        return "\nVegetable{" +
                "warranty=" + warranty +
                '}';
    }
}
