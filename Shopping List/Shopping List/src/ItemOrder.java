public class ItemOrder {
    private Item item;
    private int quantity;

    // constructor for itemOrder
    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // gets item
    public Item getItem() {
        return item;
    }

    // gets quantity of order
    public int getQuantity() {
        return quantity;
    }

    // gets total price of itemOrder
    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

    // sets quantity for item
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
