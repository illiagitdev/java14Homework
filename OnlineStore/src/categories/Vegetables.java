package categories;

import java.time.LocalDate;

public class Vegetables extends Goods {
    private String kind;
    private LocalDate productionDate;
    private int saveTemperature;
    private LocalDate expirationTime;

    public Vegetables(int id, String name, int amount, String description, double price) {
        super(id, name, amount, description, price);
    }

    @Override
    public String show() {
        return "овощи:{\n" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\tсорт\t" + kind + "\n" +
                "\tсрок годности\n" +
                "\t\tдата производства\t" + productionDate + "\n" +
                "\t\tтемпература хранения\t" + saveTemperature + "\n" +
                "\t\tпродолжительность срока годности\t" + expirationTime + '}';
    }
}
