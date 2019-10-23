package goods.categoris;

import goods.Goods;
import goods.components.ExpirationTime;
import goods.components.Warranty;

public class Vegetable extends Goods {
    private ExpirationTime expirationTime;

    public Vegetable() {
        expirationTime = new ExpirationTime();
    }

    @Override
    public String show() {
        return "Овочі:" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\nВиготовлено:\t\t" + expirationTime.getProductionDate() +
                "\nТемп. зберігання:\t" + expirationTime.getSaveTemperature() +
                "\nВжити до:\t\t\t" + expirationTime.getExpirationTime()
                + '\n';
    }
}
