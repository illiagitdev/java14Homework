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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String show() {
        return "\tID=" + id + "\n" +
                "\tназвание\t'" + name + "\n" +
                "\tкол-во\t\t" + amount + "\n" +
                "\tdescription\t'" + description + "\n" +
                "\tprice\t\t" + price + "$";
    }
}
