package categories;

import properties.WarrantyTerms;

import java.time.LocalDate;

public class SweetWater extends Goods {
    public WarrantyTerms expirationTime;

    public SweetWater(int id, String name, int amount, String description, float price) {
        super(id, name, amount, description, price);
    }

    public SweetWater(int id, String name, int amount, String description, float price, String productionDate, int saveTemperature, String expirationTime) {
        super(id, name, amount, description, price);
    }

    @Override
    public String show() {
        return "сладкие напитки:{\n" + super.show() + toString();
    }

//    @Override
//    public String toString() {
//        return "\n\tсрок годности\n" +
//                "\t\tдата производства\t\t\t\t\t" + productionDate + "\n" +
//                "\t\tтемпература хранения\t\t\t\t" + saveTemperature + "\n" +
//                "\t\tпродолжительность срока годности\t" + expirationTime + "\n" +
//                '}';
//    }
}
