package goods.categoris;

import goods.Goods;
import goods.components.ExpirationTime;

import java.util.Calendar;

public class Sweets extends Goods {
    private ExpirationTime expirationTime;

    public Sweets(int id, String name, int amount, String description, float price) {
        super(id, name, amount, description, price);
        expirationTime = new ExpirationTime();
    }

    public Sweets() {
    }

    public void setExpirationTime(ExpirationTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    public ExpirationTime getExpirationTime() {
        return expirationTime;
    }

    @Override
    public String show() {
        return "Солодощі:" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\nВиготовлено:\t\t" + expirationTime.getProductionDate().get(Calendar.DAY_OF_MONTH) + "/" +
                expirationTime.getProductionDate().get(Calendar.MONTH) + "/" + expirationTime.getProductionDate().get(Calendar.YEAR) +
                "\nТемп. зберігання:\t" + expirationTime.getSaveTemperature() +
                "\nВжити до:\t\t\t" + expirationTime.getExpirationTime().get(Calendar.DAY_OF_MONTH) + "/" +
                expirationTime.getExpirationTime().get(Calendar.MONTH) + "/" + expirationTime.getExpirationTime().get(Calendar.YEAR) +
                '\n';
    }
}
