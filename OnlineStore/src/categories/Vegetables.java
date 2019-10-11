package categories;

import java.time.LocalDate;

public class Vegetables extends Goods {
    private String kind;
    private String productionDate;
    private int saveTemperature;
    private /*LocalDate*/String  expirationTime;

    public Vegetables(int id, String name, int amount, String description, double price) {
        super(id, name, amount, description, price);
    }

    public Vegetables(int id, String name, int amount, String description, double price, String kind, String productionDate, int saveTemperature, String expirationTime) {
        super(id, name, amount, description, price);
        this.kind = kind;
        this.productionDate = productionDate;
        this.saveTemperature = saveTemperature;
        this.expirationTime = expirationTime;
    }

    @Override
    public String show() {
        return "овощи:{\n" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\n\tтип\t\t\t\t" + kind + "\n" +
                "\tсрок годности\n" +
                "\t\tдата производства\t\t\t\t\t" + productionDate + "\n" +
                "\t\tтемпература хранения\t\t\t\t" + saveTemperature + "\n" +
                "\t\tпродолжительность срока годности\t" + expirationTime + "\n" +
                '}';
    }
}
