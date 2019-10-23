package goods.categoris;

import goods.Goods;
import goods.components.ExpirationTime;

public class Sweets extends Goods {
    private ExpirationTime expirationTime;

    public Sweets() {
        expirationTime = new ExpirationTime();
    }

    @Override
    public String show() {
        return "Солодощі:" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\nВиготовлено:\t\t" + expirationTime.getProductionDate() +
                "\nТемп. зберігання:\t" + expirationTime.getSaveTemperature() +
                "\nВжити до:\t\t\t" + expirationTime.getExpirationTime() +
                '\n';
    }
}