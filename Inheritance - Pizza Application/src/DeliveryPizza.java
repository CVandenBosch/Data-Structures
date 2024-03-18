public class DeliveryPizza extends Pizza {
    int deliveryFee;
    String deliveryAddress;

    //Constructor for the delivery pizza subclass
    public DeliveryPizza(String[] arrayPizzaToppings, String deliveryAddress, int numPizzaToppings) {
        super(arrayPizzaToppings, numPizzaToppings);
        // handles the delivery fee
        if (intPrice > 18) {
            deliveryFee = 3;
        } else {
            deliveryFee = 5;
        }
        // adds delivery fee to price and updates string price
        intPrice += deliveryFee;
        stringPrice = "$" + intPrice;

        this.deliveryAddress = deliveryAddress;
    }
    // overridden toString
    @Override
    public String toString() {
        //gets details from pizza class
        String pizzaDetails = super.toString();
        //adds the delivery address to details
        return pizzaDetails + "\nDelivery Address: " + deliveryAddress;
    }
}