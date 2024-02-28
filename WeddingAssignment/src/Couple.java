
public class Couple {
    private Person bride;
    private Person groom;

    public Couple(Person bride, Person groom) {
        this.bride = bride;
        this.groom = groom;
    }
    public String toString() {
        return "The lucky bride is " + bride.toString() + " and she will be marrying " + groom.toString() + ". \n";
    }
}