package categories;

import properties.WarrantyTerms;
import properties.techspecification.Processor;
import properties.techspecification.OperationalSystem;
import properties.techspecification.Ram;
import properties.techspecification.TechSpesification;

import java.util.Calendar;

public class SmartPhone extends Goods {
    public TechSpesification[] smartphoneTechnical={new OperationalSystem(),new Ram(),new Processor()};
    public WarrantyTerms warrantyPeriod;//days

    public SmartPhone(int id, String name, int amount, String description, float price) {
        super(id, name, amount, description, price);
    }

    public SmartPhone(int id, String name, int amount, String description, float price, String operational,
                      double ramAmount, String ramType, int coreNumber, double coreFrequency, double diagonal, int batteryLifeTime, WarrantyTerms varrantyPeriod) {
        super(id, name, amount, description, price);
        this.warrantyPeriod = varrantyPeriod;
    }

    public SmartPhone() {
    }

    @Override
    public String show() {
        return "смартфон:{\n" + super.show() + toString();
    }

//    @Override
//    public String toString() {
//        return "\n\tтех. спецификация:" +
//                "\n\t\tоперационная система\t\t" + operational + "\n" +
//                "\t\tоперативная память\n" +
//                "\t\t\tобъем\t\t\t\t\t" + ramAmount + "\n" +
//                "\t\t\tтип памяти\t\t\t\t" + ramType + "\n" +
//                "\t\tпроцессор\n" +
//                "\t\t\tкол-во ядер\t\t\t\t" + coreNumber + "\n" +
//                "\t\t\tтактовая частота ядра\t" + coreFrequency + "\n" +
//                "\t\tдиагональ экрана\t\t\t" + diagonal + "\n" +
//                "\t\tвремя работы от батареи\t\t" + batteryLifeTime + "\n" +
//                "\tгарантийный срок\t\t\t\t" + warrantyPeriod + "\n" +
//                '}';
//    }
}
