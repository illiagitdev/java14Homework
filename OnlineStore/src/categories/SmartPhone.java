package categories;

import java.time.LocalDate;
import java.time.LocalTime;

public class SmartPhone extends Goods {
    private String operational;
    private double ramAmount;
    private String ramType;
    private int coreNumber;
    private int coreFrequency;
    private double diagonal;
    private LocalTime batteryLifeTime;
    private LocalDate varrantyPeriod;

    public SmartPhone(int id, String name, int amount, String description, double price) {
        super(id, name, amount, description, price);
    }

    @Override
    public String show() {
        return "смартфон:{\n" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\tтех. спецификация:" +
                "\t\tоперационная система\t" + operational + "\n" +
                "\t\tоперативная память\n" +
                "\t\t\tобъем\t" + ramAmount + "\n" +
                "\t\t\tтип памяти\t" + ramType + "\n" +
                "\t\tпроцессор\n" +
                "\t\t\tкол-во ядер\t" + coreNumber + "\n" +
                "\t\t\tтактовая частота ядра\t" + coreFrequency + "\n" +
                "\t\tдиагональ экрана\t" + diagonal + "\n" +
                "\t\tвремя работы от батареи\t" + batteryLifeTime + "\n" +
                "\tгарантийный срок\t" + varrantyPeriod + '}';
    }
}
