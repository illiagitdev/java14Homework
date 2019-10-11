package categories;

import java.time.LocalDate;

public class Wear extends Goods {
    private LocalDate brandFoundationYeat;
    private String brandName;
    private int brandEmploeesNumber;
    private int brandSellCountiesNumber;

    public Wear(int id, String name, int amount, String description, double price) {
        super(id, name, amount, description, price);
    }

    @Override
    public String show() {
        return "сладкие напитки:{\n" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\tбренд" +
                "\t\tгод основания\t" + brandFoundationYeat + "\n" +
                "\t\tназвание\t" + brandName + "\n" +
                "\t\tкол-во работников\t" + brandEmploeesNumber + "\n" +
                "\t\tкол-во стран в котором продаются товары\t" + brandSellCountiesNumber + '}';
    }
}
