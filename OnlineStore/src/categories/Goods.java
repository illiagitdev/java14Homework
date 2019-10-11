package categories;

public class Goods {
    private int id;
    private String name;
    private int amount;
    private String description;
    private double price;

    public Goods(int id, String name, int amount, String description, double price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.price = price;
    }

    public String show() {
        return "\tID\t\t\t\t" + id + "\n" +
                "\tназвание\t\t" + name + "\n" +
                "\tкол-во\t\t\t" + amount + "\n" +
                "\tописание\t\t{" + description + "}\n" +
                "\tцена\t\t\t" + price + "$";
    }
}
