package categories;

import java.time.LocalDate;

public class Sweets extends Goods {
    private /*LocalDaet*/String  productionDate;
    private int saveTemperature;
    private /*LocalDate*/String  expirationTime;

    public Sweets(int id, String name, int amount, String description, double price) {
        super(id, name, amount, description, price);
    }

    public Sweets(int id, String name, int amount, String description, double price, String productionDate, int saveTemperature, String expirationTime) {
        super(id, name, amount, description, price);
        this.productionDate = productionDate;
        this.saveTemperature = saveTemperature;
        this.expirationTime = expirationTime;
    }

    @Override
    public String show() {
        return "сладости:{\n" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\n\tсрок годности\n" +
                "\t\tдата производства\t\t\t\t\t" + productionDate + "\n" +
                "\t\tтемпература хранения\t\t\t\t" + saveTemperature + "\n" +
                "\t\tпродолжительность срока годности\t" + expirationTime + "\n" +
                '}';
    }
}
