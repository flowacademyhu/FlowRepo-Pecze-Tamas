import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int yearOfBirth;
    private double success;

    public Student(String name, int yearOfBirth, double success) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.success = success;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", success=" + success +
                '}';
    }
}
