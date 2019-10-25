package goods.categoris;

import goods.Goods;
import goods.components.ExpirationTime;

public class Vegetable extends Goods {
    private String type;
    private ExpirationTime expirationTime;

    public Vegetable(int id, String name, int amount, String description, float price) {
        super(id, name, amount, description, price);
        expirationTime = new ExpirationTime();
    }

    public Vegetable() {
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExpirationTime(ExpirationTime expirationTime) {
        this.expirationTime = expirationTime;
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
