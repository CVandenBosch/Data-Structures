public class Student {
    private String name;
    private int age;
    private String major;
    private int gradYear;

    //gets age
    public int getAge() {
        return age;
    }

    //gets major
    public String getMajor() {
        return major;
    }

    //gets grad year
    public int getGradYear() {
        return gradYear;
    }

    // constructs student
    public Student(String name, int age, String major, int gradYear){
        this.name = name;
        this.age = age;
        this.major = major;
        this.gradYear = gradYear;
    }

    // gets name
    public String getName() {
        return name;
    }

    //to string
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", gradYear=" + gradYear +
                '}';
    }
}