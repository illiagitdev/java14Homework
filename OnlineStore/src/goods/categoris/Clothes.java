package goods.categoris;

import goods.Goods;
import goods.components.Brend;

public class Clothes extends Goods {
    private Brend brend;

    @Override
    public String show() {
        return super.show() + toString();
    }

    @Override
    public String toString() {
        return "\nClothes{" +
                "brend=" + brend +
                '}';
    }
}
