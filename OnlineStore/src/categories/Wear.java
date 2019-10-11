package categories;

import java.time.LocalDate;

public class Wear extends Goods {
    private /*LocalDate*/int brandFoundationYeat;
    private String brandName;
    private int brandEmploeesNumber;
    private int brandSellCountiesNumber;

    public Wear(int id, String name, int amount, String description, double price) {
        super(id, name, amount, description, price);
    }

    public Wear(int id, String name, int amount, String description, double price, int brandFoundationYeat, String brandName, int brandEmploeesNumber, int brandSellCountiesNumber) {
        super(id, name, amount, description, price);
        this.brandFoundationYeat = brandFoundationYeat;
        this.brandName = brandName;
        this.brandEmploeesNumber = brandEmploeesNumber;
        this.brandSellCountiesNumber = brandSellCountiesNumber;
    }

    @Override
    public String show() {
        return "сладкие напитки:{\n" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\n\tбренд" +
                "\n\t\tгод основания\t\t\t\t\t\t\t" + brandFoundationYeat + "\n" +
                "\t\tназвание\t\t\t\t\t\t\t\t" + brandName + "\n" +
                "\t\tкол-во работников\t\t\t\t\t\t" + brandEmploeesNumber + "\n" +
                "\t\tкол-во стран в котором продаются товары\t" + brandSellCountiesNumber + "\n" +
                '}';
    }
}
