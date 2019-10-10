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

    public void show(){
        System.out.println("Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}');
    }
}
