import java.util.Scanner;
public class DemoPizza {
    public static void main(String[] args) {
        // scanner and intro stuff
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Pizza Ordering Application!\nEnter toppings you would like on your pizza (max 10, $2 extra for each).\nType 'QUIT' if you are done.");

        // creates array and variables
        String[] toppings = new String[10];
        int numToppings = 0;
        String input;

        // repeatedly asks the user for toppings until they have 10 or type QUIT
        while (numToppings < 10) {
        System.out.println("Enter topping (or 'QUIT' to finish): ");
        input = scanner.nextLine();
        if(input.equalsIgnoreCase("QUIT")) {
            break;
        }
        toppings[numToppings] = input;
        numToppings ++;
    }

    System.out.println("Do you want the pizza to be delivered? (yes/no): ");
    String deliveryChoice = scanner.nextLine();

    // handles if the pizza is delivery or not
    if(deliveryChoice.equalsIgnoreCase("yes")) {
        System.out.println("Enter delivery address: ");
        String deliveryAddress = scanner.nextLine();
        // creates new object to get details
        DeliveryPizza pizza = new DeliveryPizza(toppings, deliveryAddress, numToppings);
        System.out.println("Your delivery pizza details: ");
        System.out.println(pizza);
    } else {
        // creates new object to get details
        Pizza pizza = new Pizza(toppings, numToppings);
        System.out.println("Your pizza details: ");
        System.out.println(pizza);
    }
    }
}