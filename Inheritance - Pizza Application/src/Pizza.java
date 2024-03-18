public class Pizza {
    String[] arrayPizzaToppings = new String[10];
    String stringPrice = "$";
    int intPrice = 14;
    int numPizzaToppings;
    String stringPizzaToppings;

    // Constructor for pizza object
    public Pizza(String[] arrayPizzaToppings, int numPizzaToppings) {
            // creates string builder for later
            StringBuilder stringPizzaToppingsBuilder = new StringBuilder();
            // updates numPizzaToppings
            this.numPizzaToppings = numPizzaToppings;
            // for loop that adds the toppings to a string with a comma after. It also adds 2 to the price for each topping
            for (int i = 0; i < numPizzaToppings; i++) {
                    stringPizzaToppingsBuilder.append(arrayPizzaToppings[i]);
                    intPrice += 2;
                    if (i < numPizzaToppings - 1) {
                            stringPizzaToppingsBuilder.append(", ");
                    }
            }
            // updates string variables so they can be used in toString
            stringPizzaToppings = stringPizzaToppingsBuilder.toString();
            stringPrice += String.valueOf(intPrice);
    }
    // toString that makes the text (if the pizza only has one topping, it prints different message with correct english)
    public String toString() {
        if (numPizzaToppings > 1) {
            return "This pizza has " + String.valueOf(numPizzaToppings) + " toppings.\nThey are: " + stringPizzaToppings + ".\nThe pizza will cost " + stringPrice;
        } else {
            return "This pizza has 1 topping.\nIt is " + stringPizzaToppings + ".\nThe pizza will cost " + stringPrice;
        }
    }
    // test main function
    public static void main(String[] args) {
            String[] toppings = {"Cheese", "Tomato", "Mushroom"};
            Pizza pizza = new Pizza(toppings, toppings.length);
        System.out.println(pizza);
    }
}