public class Item {
    private String name;
    private double price;

    //constructor for item class
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //gets name of item
    public String getName() {
        return name;
    }

    //gets price of item
    public double getPrice() {
        return price;
    }
}