package goods;

public class Goods {
    private int id;
    private String name;
    private int amount;
    private String description;
    private float price;

    public int getAmount() {
        return amount;
    }

    public String show() {
        return "\nID\t\t\t" + id + "\n" +
                "назва\t\t" + name + "\n" +
                "кількість\t" + amount + " одиниць\n" +
                "писання\t\t{" + description + "}\n" +
                "ціна\t\t" + price + " грн.";
    }
}
