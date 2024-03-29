public class BloodData {
    public String BloodType;
    public String RhFactor;

    public enum BloodStuff {

        //Enum values
        A("A"), B("B"), AB("AB"), O("O"), POS("+"), NEG("-");

        private String s;

        //Constructor for enums
        private BloodStuff(String s)
        {
            this.s = s;
        }

        //toString for enums
        public String toString()
        {
            return this.s;
        }
    }

    // getters and setters
    public String getBloodType() {
        return BloodType;
    }
    public String getRhFactor() {
        return RhFactor;
    }
    public void setBloodType(String bloodType) {
        BloodType = bloodType;
    }
    public void setRhFactor(String rhFactor) {
        RhFactor = rhFactor;
    }

    // constructor for no input
    public BloodData() {
        this.BloodType = "O";
        this.RhFactor = "POS";
    }

    // constructor for if there is an input
    public BloodData(String BloodType, String RhFactor) {
        BloodStuff.valueOf(BloodType);
        BloodStuff.valueOf(RhFactor);
        this.BloodType = BloodType;
        this.RhFactor = RhFactor;
    }

    // toString for class
    public String toString() {
        return "User Blood Type: " + BloodStuff.valueOf(BloodType).toString() + "\nUser Rh Factor: " + BloodStuff.valueOf(RhFactor).toString();
    }
}