import java.util.Scanner;  // Import the Scanner class

class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter amount:"); // Prompts the user to enter input
        String string_amount = myObj.nextLine();  // Read user input

        /// Don't accept an input that does not have a $ at the start
        String first_char;
        first_char = string_amount.substring(0,1);
        if (!first_char.equals("$")) {
            System.out.println("Invalid Input, Try Again (Please enter in '$X.XX' format)");
            main(args);
        } else {
            /// Turns the input string in format $X.XX into double type
            string_amount = string_amount.replace("$", "");
            double int_amount = Double.parseDouble(string_amount);

            /// Quarters
            double cents = int_amount * 100;
            double Remain_From_Quarters = cents % 25;
            double Num_Quarters;
            if (Remain_From_Quarters == 0) {
                Num_Quarters = cents / 25;
            } else {
                Num_Quarters = (cents - Remain_From_Quarters) / 25;
            }

            /// Dimes
            double Remain_From_Dimes = Remain_From_Quarters % 10;
            double Num_Dimes;
            if (Remain_From_Dimes == 0) {
                Num_Dimes = Remain_From_Quarters / 10;
            } else {
                Num_Dimes = (Remain_From_Quarters - Remain_From_Dimes) / 10;
            }

            /// Nickels
            double Remain_From_Nickels = Remain_From_Dimes % 5;
            double Num_Nickels;
            if (Remain_From_Nickels == 0) {
                Num_Nickels = Remain_From_Dimes / 5;
            } else {
                Num_Nickels = (Remain_From_Dimes - Remain_From_Nickels) / 5;
            }

            /// Pennies
            double Num_Pennies;
            Num_Pennies = Remain_From_Nickels;

            /// Making doubles into ints so they don't have .0 at the end
            int pennies = (int) Num_Pennies;
            int nickels = (int) Num_Nickels;
            int dimes = (int) Num_Dimes;
            int quarters = (int) Num_Quarters;

            /// Making it so if there is one of any type, it makes the print statement print the non-plural version.)
            String quarters_s1 = "There are ";
            String quarters_s2 = " quarters, ";
            String dimes_string = " dimes, ";
            String nickels_string = " nickels, and ";
            String pennies_string = " pennies.";

            if (quarters == 1) {
                quarters_s1 = "There is ";
                quarters_s2 = " quarter, ";
            }
            if (dimes == 1) {
                dimes_string = " dime, ";
            }
            if (nickels == 1) {
                nickels_string = " nickel, and ";
            }
            if (pennies == 1) {
                pennies_string = " penny.";
            }

            ///Print statement combining all variables (strings, ints)
            System.out.println(quarters_s1 + quarters + quarters_s2 + dimes + dimes_string + nickels + nickels_string + pennies + pennies_string);
        }
    }
}