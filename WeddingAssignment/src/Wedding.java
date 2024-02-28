public class Wedding {
    private String location;
    private String date;
    private Couple coupleObject;

    public Wedding(Couple weddingCouple, String date, String location) {
        this.date = date;
        this.location = location;
        this.coupleObject = weddingCouple;
    }
    public String toString() {
        return coupleObject.toString() + "This consumation will take place on " + date + " at " + location + ". \nThe world will be a better place with these two lovely lives intertwined. \n(By the way, the bride's new name will be ";
    }
}