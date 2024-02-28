import java.util.Scanner;
public class TestWedding {
    private static Wedding weddingObject;

    public static void main(String[] args) {
        try {
            Scanner askUser = new Scanner(System.in);

            // BrideName
            System.out.println("Enter first and lastname of bride (with a space in between): ");
            String strBrideName = askUser.nextLine();
            String[] splitBrideName = strBrideName.split(" ");
            String strBrideFirstName = splitBrideName[0];
            String strBrideLastName = splitBrideName[1];

            // GroomName
            System.out.println("Enter first and lastname of groom (with a space in between): ");
            String strGroomName = askUser.nextLine();
            String[] splitGroomName = strGroomName.split(" ");
            String strGroomFirstName = splitGroomName[0];
            String strGroomLastName = splitGroomName[1];

            // Location
            System.out.println("Please enter the location of the wedding");
            String strLocation = askUser.nextLine();

            // Date
            System.out.println("Please enter the date of the wedding");
            String strDate = askUser.nextLine();

            weddingObject = new Wedding(new Couple(new Person(strBrideFirstName, strBrideLastName), new Person(strGroomFirstName, strGroomLastName)), strDate, strLocation);

            System.out.println(weddingObject.toString() + strBrideFirstName + " " + strGroomLastName + ")");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid data type entered.");
            main(args);
        }
        catch(Exception e){
            System.out.println("Catch All");
        }
    }
}