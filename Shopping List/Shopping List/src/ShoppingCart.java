import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    private String userInput;
    private ArrayList<ItemOrder> cart;

    // constructor for shoppingCart
    public ShoppingCart() {
        this.cart = new ArrayList<ItemOrder>();
    }

    // adds itemOrder to cart
    public void addItemOrder(ItemOrder itemOrder) {
        cart.add(itemOrder);
    }

    // removes items from cart
    public void removeItemOrder(ItemOrder itemOrderToRemove) {
        // loops through itemOrders in cart
        for (ItemOrder itemOrder : cart) {
            // if the item is the one wanting to be removed
            if (itemOrder.getItem().getName().equals(itemOrderToRemove.getItem().getName())) {
                // if there are enough items in cart to be removed
                if (itemOrder.getQuantity() >= itemOrderToRemove.getQuantity()) {
                    int remainingQuantity = itemOrder.getQuantity() - itemOrderToRemove.getQuantity();
                    // if there are no items left of item, remove it from cart
                    if (remainingQuantity == 0) {
                        cart.remove(itemOrder);
                        // if there are more items left after they are removed, set quantity to remaining
                    } else {
                        itemOrder.setQuantity(remainingQuantity);
                    }
                    System.out.println("\nItem removed successfully");
                    return;
                    // if the quantity requested to be removed was too high
                } else {
                    System.out.println("Requested quantity exceeds the quantity in the cart");
                    return;
                }
            }
        }
        // item not found in for loop (not in cart)
        System.out.println("Item not found in the cart");
    }

    // prints the total price of all items in cart
    public void getTotalPrice() {
        double totalPrice = 0;
        for (ItemOrder item : cart) {
            totalPrice += item.getTotalPrice();
        }
        System.out.println("Total Price: $" + totalPrice);
    }

    // prints the available items (items that can be bought)
    public void displayAvailableItems(ArrayList<Item> items) {
        System.out.println("\nAvailable Items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ") " + items.get(i).getName() + " - $" + items.get(i).getPrice() + " each");
        }
    }

    // adds item and quantity to cart
    public ItemOrder selectItemOrder(ArrayList<Item> items) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the item you want to add/remove: ");
        int itemIndex = scanner.nextInt();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();

        if (itemIndex < 1 || itemIndex > items.size()) {
            System.out.println("Invalid item number.");
            return null;
        }

        Item selected = items.get(itemIndex - 1);
        return new ItemOrder(selected, quantity);
    }

    // prints the items in cart
    public void displayCart() {
        System.out.println("\nItems in Cart:");
        for (int i = 0; i < cart.size(); i++) {
            ItemOrder itemOrder = cart.get(i);
            Item item = itemOrder.getItem();
            int quantity = itemOrder.getQuantity();
            System.out.println((i + 1) + ") " + item.getName() + " - $" + item.getPrice() + " each, Quantity: " + quantity);
        }
    }

    // main
    public static void main(String[] args) {
        //creates shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();

        //creates items able to be bought
        ArrayList<Item> list = new ArrayList<>();
        Item apple = new Item("Apples", 1);
        list.add(apple);
        Item orange = new Item("Oranges", 2);
        list.add(orange);
        Item pineapple = new Item("Pineapples", 5);
        list.add(pineapple);
        Item bagOfChips = new Item("Bag Of Chips", 3);
        list.add(bagOfChips);
        Item cookie = new Item("Cookies", 1);
        list.add(cookie);
        Item milk = new Item("Carton of Milk", 5);
        list.add(milk);
        Item egg = new Item("Eggs", 1);
        list.add(egg);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        //while loop for interface
        while (!exit) {
            System.out.println("\n[1] Add Item to Cart");
            System.out.println("[2] Remove Item from Cart");
            System.out.println("[3] View Cart and Total Price");
            System.out.println("[4] Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            //uses methods for each case
            switch (choice) {
                //add item to cart
                case 1:
                    shoppingCart.displayAvailableItems(list);
                    ItemOrder add = shoppingCart.selectItemOrder(list);
                    shoppingCart.addItemOrder(add);
                    break;

                    //remove item from cart
                case 2:
                    shoppingCart.displayAvailableItems(list);
                    ItemOrder remove = shoppingCart.selectItemOrder(list);
                    shoppingCart.removeItemOrder(remove);
                    break;

                    //view cart and price
                case 3:
                    shoppingCart.displayCart();
                    shoppingCart.getTotalPrice();
                    break;

                    //exit
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4");
            }
        }
    }
}
