package categories;

public class Goods {
    public int id;
    public String name;
    public int amount;
    public String description;
    public float price;

    public Goods() {
    }

    public Goods(int id, String name, int amount, String description, float price) {
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
