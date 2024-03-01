import java.util.Scanner;
import java.util.InputMismatchException;

public class UseDinnerParty {
    public static void main(String[] args) {
        DinnerParty dinnerParty = new DinnerParty();
        Party party = new Party();
        String userFood = "";

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number of guests for the party >> ");
            party.setNumGuests(scanner.nextInt());

            System.out.println("The party has " + party.getNumGuests() + " guests");
            dinnerParty.displayInvitation();
            System.out.println(" ");

            System.out.println("Enter number of guests for the dinner party >> ");
            dinnerParty.setNumGuests(scanner.nextInt());

            System.out.println("Enter the menu option --  \n- 1 for chicken \n- 2 for beef \n- 3 for veggie");
            dinnerParty.setDinnerChoice(scanner.nextInt());
            if (dinnerParty.getDinnerChoice() == 1) {
                userFood = " chicken ";
            } else if (dinnerParty.getDinnerChoice() == 2) {
                userFood = " beef ";
            } else if (dinnerParty.getDinnerChoice() == 3) {
                userFood = " veggie ";
            } else {
                System.out.println("You have typed an invalid input. Please try again");
                main(args);
            }

            System.out.println("The dinner party has " + dinnerParty.getNumGuests() + " guests\nYou will be served the" + userFood + "meal at dinner");
            dinnerParty.displayInvitation();
        }
        catch (InputMismatchException e) {
        System.out.println("You have typed an invalid input. Please try again");
        main(args);
        }
        catch (Exception e) {
            System.out.println("other error (should not happen");
        }
    }
}