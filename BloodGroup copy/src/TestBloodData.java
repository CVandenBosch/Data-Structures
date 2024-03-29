import java.util.Scanner;

public class TestBloodData{
    //main
    public static void main(String[] args) {
        String userBloodType = "";
        String userRhFactor = "";

        //scanner stuff
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Blood Type:");
        String userCombinedBloodType = userInput.nextLine();

        //splits input into blood type and rh factor
        userBloodType = userCombinedBloodType.substring(0, userCombinedBloodType.length()-1);
        userRhFactor = userCombinedBloodType.substring(userCombinedBloodType.length()-1);

        //changes input to POS or NEG for enums use
        if (userRhFactor.equals("+")) {
            userRhFactor = "POS";
        } else {
            userRhFactor = "NEG";
        }

        //creates objects
        BloodData StandardBlood = new BloodData();
        BloodData UserBlood = new BloodData(userBloodType, userRhFactor);

        //print statements
        System.out.println("Default Blood Data:\n" + StandardBlood + "\n\nUser values:\n" + UserBlood);
        StandardBlood = UserBlood;
        System.out.println("\nUpdated User Blood Data:\n" + StandardBlood);
    }
}