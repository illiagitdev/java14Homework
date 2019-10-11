package categories;

public class SmartPhone extends Goods {
    private String operational;
    private double ramAmount;
    private String ramType;
    private int coreNumber;
    private double coreFrequency;
    private double diagonal;
    private /*LocalTime*/int batteryLifeTime;
    private /*LocalDate*/int varrantyPeriod;

    public SmartPhone(int id, String name, int amount, String description, double price) {
        super(id, name, amount, description, price);
    }

    public SmartPhone(int id, String name, int amount, String description, double price, String operational,
                      double ramAmount, String ramType, int coreNumber, double coreFrequency, double diagonal, int batteryLifeTime, int varrantyPeriod) {
        super(id, name, amount, description, price);
        this.operational = operational;
        this.ramAmount = ramAmount;
        this.ramType = ramType;
        this.coreNumber = coreNumber;
        this.coreFrequency = coreFrequency;
        this.diagonal = diagonal;
        this.batteryLifeTime = batteryLifeTime;
        this.varrantyPeriod = varrantyPeriod;
    }

    @Override
    public String show() {
        return "смартфон:{\n" + super.show() + toString();
    }

    @Override
    public String toString() {
        return "\n\tтех. спецификация:" +
                "\n\t\tоперационная система\t\t" + operational + "\n" +
                "\t\tоперативная память\n" +
                "\t\t\tобъем\t\t\t\t\t" + ramAmount + "\n" +
                "\t\t\tтип памяти\t\t\t\t" + ramType + "\n" +
                "\t\tпроцессор\n" +
                "\t\t\tкол-во ядер\t\t\t\t" + coreNumber + "\n" +
                "\t\t\tтактовая частота ядра\t" + coreFrequency + "\n" +
                "\t\tдиагональ экрана\t\t\t" + diagonal + "\n" +
                "\t\tвремя работы от батареи\t\t" + batteryLifeTime + "\n" +
                "\tгарантийный срок\t\t\t\t" + varrantyPeriod + "\n" +
                '}';
    }
}
