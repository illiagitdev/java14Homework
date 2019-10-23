package goods;

public abstract class Goods {
    private int id;
    private String name;
    private int amount;
    private String description;
    private float price;

    public int getAmount() {
        return amount;
    }

    public String show() {
        return "\tID\t\t\t\t" + id + "\n" +
                "\tназвание\t\t" + name + "\n" +
                "\tкол-во\t\t\t" + amount + "\n" +
                "\tописание\t\t{" + description + "}\n" +
                "\tцена\t\t\t" + price + "$";
    }
}
