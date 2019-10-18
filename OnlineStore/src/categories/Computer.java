package categories;

import properties.techspecification.*;

import java.util.Calendar;

public class Computer extends Goods {
    public TechSpesification[] computerSpecification= {new Ram(), new Processor(),new VideoCard() };

    private Calendar warrantyPeriod;

    public Computer() {
    }

    public Computer(int id, String name, int amount, String description, float price) {
        super(id, name, amount, description, price);
    }

    public Computer(int id, String name, int amount, String description, float price, double ramAmount, String ramType,
                    int coreNumber, double coreFrequency, int videoCoreNumber, double videoCoreFrequency, double videoRamAmount,
                    String videoRamType, Calendar varrantyPeriod) {
        super(id, name, amount, description, price);
        this.warrantyPeriod = varrantyPeriod;
    }

    @Override
    public String show() {
        return "компьютер:{\n" + super.show() + toString();
    }

//    @Override
//    public String toString() {
//        return "\n\tтех. спецификация:" +
//                "\n\t\tоперативная память\n" +
//                "\t\t\tобъем\t\t\t\t\t" + ramAmount + "\n" +
//                "\t\t\tтип памяти\t\t\t\t" + ramType + "\n" +
//                "\t\tпроцессор\n" +
//                "\t\t\tкол-во ядер\t\t\t\t" + coreNumber + "\n" +
//                "\t\t\tтактовая частота ядра\t" + coreFrequency + "\n" +
//                "\t\tвидео карта\n" +
//                "\t\t\tкол-во ядер\t\t\t\t" + videoCoreNumber + "\n" +
//                "\t\t\tтактовая частота ядра\t" + videoCoreFrequency + "\n" +
//                "\t\t\tвидеопамять\n" +
//                "\t\t\t\tобъем\t\t\t\t" + videoRamAmount + "\n" +
//                "\t\t\t\tтип памяти\t\t\t" + videoRamType + "\n" +
//                "\tгарантийный срок\t\t\t\t" + warrantyPeriod + "\n" +
//                '}';
//    }
}
