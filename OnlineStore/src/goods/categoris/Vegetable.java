package goods.categoris;

import goods.Goods;
import goods.components.ExpirationTime;

import java.util.Calendar;

public class Vegetable extends Goods {
    private String type;
    private ExpirationTime expirationTime;

    public Vegetable(int id, String name, int amount, String description, float price) {
        super(id, name, amount, description, price);
        expirationTime = new ExpirationTime();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExpirationTime(ExpirationTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getType() {
        return type;
    }

    public ExpirationTime getExpirationTime() {
        return expirationTime;
    }

    @Override
    public String show() {
        return "Овочі:" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\nВиготовлено:\t\t" + expirationTime.getProductionDate().get(Calendar.DAY_OF_MONTH) + "/" +
                expirationTime.getProductionDate().get(Calendar.MONTH) + "/" + expirationTime.getProductionDate().get(Calendar.YEAR) +
                "\nТемп. зберігання:\t" + expirationTime.getSaveTemperature() +
                "\nВжити до:\t\t\t" + expirationTime.getExpirationTime().get(Calendar.DAY_OF_MONTH) + "/" +
                expirationTime.getExpirationTime().get(Calendar.MONTH) + "/" + expirationTime.getExpirationTime().get(Calendar.YEAR) +
                +'\n';
    }
}
