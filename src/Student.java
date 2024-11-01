import java.util.ArrayList;

public class Student {
    private final int studentId;
    private String name;
    private int age;
    private String course;

    public Student(int studentId, String name, int age, String course) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public static void displayAllStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No student data, please create one.\n");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println("Student Id: " + students.get(i).getStudentId());
            System.out.println("Name: " + students.get(i).getName());
            System.out.println("Age: " + students.get(i).getAge());
            System.out.println("Course: " + students.get(i).getCourse());
            System.out.println();
        }
    }
}
