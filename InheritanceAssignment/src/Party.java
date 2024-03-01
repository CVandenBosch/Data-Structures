public class Party {
    private int numGuests;
    public int getNumGuests() {
        return numGuests;
    }
    public void setNumGuests(int newNumGuests) {
        this.numGuests = newNumGuests;
    }
    public void displayInvitation() {
        System.out.println("Please come to my party!");
    }
}