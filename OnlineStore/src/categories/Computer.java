package categories;

import java.time.LocalDate;

public class Computer extends Goods {
    private double ramAmount;
    private String ramType;
    private int coreNumber;
    private int coreFrequency;
    private int videoCoreNumber;
    private int videoCoreFrequency;
    private double videoRamAmount;
    private String videoRamType;
    private LocalDate varrantyPeriod;

    public Computer(int id, String name, int amount, String description, double price) {
        super(id, name, amount, description, price);
    }

    @Override
    public String show() {
        return "компьютер:{\n" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\tтех. спецификация:" +
                "\t\tоперативная память\n" +
                "\t\t\tобъем\t" + ramAmount + "\n" +
                "\t\t\tтип памяти\t" + ramType + "\n" +
                "\t\tпроцессор\n" +
                "\t\t\tкол-во ядер\t" + coreNumber + "\n" +
                "\t\t\tтактовая частота ядра\t" + coreFrequency + "\n" +
                "\t\tвидео карта\n" +
                "\t\t\tкол-во ядер\t" + videoCoreNumber + "\n" +
                "\t\t\tтактовая частота ядра\t" + videoCoreFrequency + "\n" +
                "\t\t\tвидеопамять\n" +
                "\t\t\t\tобъем\t" + videoRamAmount + "\n" +
                "\t\t\t\tтип памяти\t" + videoRamType + "\n" +
                "\tгарантийный срок\t" + varrantyPeriod + '}';
    }
}
