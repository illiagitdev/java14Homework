package categories;

import java.time.LocalDate;

public class Computer extends Goods {
    private double ramAmount;
    private String ramType;
    private int coreNumber;
    private double coreFrequency;
    private int videoCoreNumber;
    private double videoCoreFrequency;
    private double videoRamAmount;
    private String videoRamType;
    private /*LocalDate*/int varrantyPeriod;

    public Computer(int id, String name, int amount, String description, double price) {
        super(id, name, amount, description, price);
    }

    public Computer(int id, String name, int amount, String description, double price, double ramAmount, String ramType,
                    int coreNumber, double coreFrequency, int videoCoreNumber, double videoCoreFrequency, double videoRamAmount,
                    String videoRamType, int varrantyPeriod) {
        super(id, name, amount, description, price);
        this.ramAmount = ramAmount;
        this.ramType = ramType;
        this.coreNumber = coreNumber;
        this.coreFrequency = coreFrequency;
        this.videoCoreNumber = videoCoreNumber;
        this.videoCoreFrequency = videoCoreFrequency;
        this.videoRamAmount = videoRamAmount;
        this.videoRamType = videoRamType;
        this.varrantyPeriod = varrantyPeriod;
    }

    @Override
    public String show() {
        return "компьютер:{\n" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\n\tтех. спецификация:" +
                "\n\t\tоперативная память\n" +
                "\t\t\tобъем\t\t\t\t\t" + ramAmount + "\n" +
                "\t\t\tтип памяти\t\t\t\t" + ramType + "\n" +
                "\t\tпроцессор\n" +
                "\t\t\tкол-во ядер\t\t\t\t" + coreNumber + "\n" +
                "\t\t\tтактовая частота ядра\t" + coreFrequency + "\n" +
                "\t\tвидео карта\n" +
                "\t\t\tкол-во ядер\t\t\t\t" + videoCoreNumber + "\n" +
                "\t\t\tтактовая частота ядра\t" + videoCoreFrequency + "\n" +
                "\t\t\tвидеопамять\n" +
                "\t\t\t\tобъем\t\t\t\t" + videoRamAmount + "\n" +
                "\t\t\t\tтип памяти\t\t\t" + videoRamType + "\n" +
                "\tгарантийный срок\t\t\t\t" + varrantyPeriod + "\n" +
                '}';
    }
}
