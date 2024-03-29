public class Patient {
    private String idNumber = "0";
    private String age = "0";
    private String userBloodTypeInfo = "O";
    private String userRhFactorInfo = "POS";

    //constructor for no input
    public Patient(){
        this.idNumber = "0";
        this.age = "0";

        //creates blood object with no input
        BloodData newBloodData = new BloodData();
    }

    //constructor if input
    public Patient(String idNumber, String age, String userBloodTypeInfo, String userRhFactorInfo){
        this.idNumber = idNumber;
        this.age = age;
        this.userBloodTypeInfo = userBloodTypeInfo;
        this.userRhFactorInfo = userRhFactorInfo;

        // creates blood object and hands it blood info
        BloodData newBloodData = new BloodData(userBloodTypeInfo, userRhFactorInfo);
    }

    // getters
    public String getIdNumber() {
        return idNumber;
    }
    public String getAge() {
        return age;
    }
    public String getUserBloodTypeInfo() {
        return userBloodTypeInfo;
    }
    public String getUserRhFactorInfo() {
        return userRhFactorInfo;
    }

    // toString
    public String toString() {
        return "\nidNumber: " + idNumber +
                "\nage: " + age +
                "\nuserBloodTypeInfo: " + userBloodTypeInfo +
                "\nuserRhFactorInfo: " + userRhFactorInfo;
    }
}
