package categories;

import java.time.LocalDate;

public class Sweets extends Goods {
    private LocalDate productionDate;
    private int saveTemperature;
    private LocalDate expirationTime;

    public Sweets(int id, String name, int amount, String description, double price) {
        super(id, name, amount, description, price);
    }

    @Override
    public String show() {
        return "сладости:{\n" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\tсрок годности\n" +
                "\t\tдата производства\t" + productionDate + "\n" +
                "\t\tтемпература хранения\t" + saveTemperature + "\n" +
                "\t\tпродолжительность срока годности\t" + expirationTime + '}';
    }
}
