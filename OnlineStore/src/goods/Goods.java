package goods;


public class Goods {
    private int id;
    private String name;
    private int amount;
    private String description;
    private float price;

    public Goods() {
    }

    public Goods(int id, String name, int amount, String description, float price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount > 0) {
            this.amount = amount;
        }
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }


    public String show() {
        return "\nID\t\t\t" + id + "\n" +
                "назва\t\t" + name + "\n" +
                "кількість\t" + amount + " одиниць\n" +
                "писання\t\t{" + description + "}\n" +
                "ціна\t\t" + price + " грн.";
    }
}
