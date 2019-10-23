package goods.categoris;

import goods.Goods;
import goods.components.ExpirationTime;

public class Sweets extends Goods {
    private ExpirationTime expirationTime;

    @Override
    public String show() {
        return super.show() + toString();
    }

    @Override
    public String toString() {
        return "\nSweets{" +
                "expirationTime=" + expirationTime +
                '}';
    }
}
