public class Student {
    private String name;
    private int age;
    private String major;
    private int gradYear;

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    public int getGradYear() {
        return gradYear;
    }

    public Student(String name, int age, String major, int gradYear){
        this.name = name;
        this.age = age;
        this.major = major;
        this.gradYear = gradYear;
    }

    public String getName() {
        return name;
    }

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