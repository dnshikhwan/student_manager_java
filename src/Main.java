/*
1. Add a new student with details such as name, id, age, and course [X]
2. remove an existing student by student id [X]
3. view all students with their details [X]
4. search for student by name or student id [X]
5. update student details, such as age or course [X]
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // initialize student list
        ArrayList<Student> students = new ArrayList<>();

        boolean flag = true;
        while (flag) {

            // menu creation
            printMenu();
            int command = 0;

            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("---INVALID INPUT---");
            }

            switch (command) {
                case 1:
                    System.out.println("\n---ADD A NEW STUDENT---");

                    // request input
                    System.out.println("Enter student's name: ");
                    String name = scanner.nextLine();

                    Random random = new Random();
                    // recreate random if id already exists
                    int studentId = Math.abs(random.nextInt());

                    // age validation
                    int age = 0;

                    boolean isAgeOkay = false;
                    while (!isAgeOkay) {
                        try {
                            System.out.println("Enter student's age: ");
                            age = Integer.parseInt(scanner.nextLine());

                            if (age > 0) {
                                isAgeOkay = true;
                            } else {
                                System.out.println("Age must be positive number");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("---INVALID INPUT---");
                        }
                    }

                    System.out.println("Enter student's course: ");
                    String course = scanner.nextLine();

                    // create student object
                    Student student = new Student(studentId, name, age, course);

                    // add student object into student list
                    students.add(student);

                    System.out.println("---STUDENT CREATED---\n");
                    break;
                case 2:
                    System.out.println("\n---REMOVE EXISTING STUDENT---");

                    if (!students.isEmpty()) {
                        Student.displayAllStudents(students);
                        int id = 0;

                        boolean isIdOkay = false;
                        while (!isIdOkay) {
                            try {
                                System.out.println("Enter student's id: ");
                                id = Integer.parseInt(scanner.nextLine());
                                isIdOkay = true;
                            } catch (NumberFormatException e) {
                                System.out.println("---INVALID INPUT---");
                            }
                        }

                        boolean isRemove = false;

                        // find student with that id
                        for (int i = 0; i < students.size(); i++) {
                            if (id == students.get(i).getStudentId()) {
                                students.remove(i);
                                isRemove = true;
                            }
                        }

                        if (isRemove) {
                            System.out.println("---STUDENT REMOVED---\n");

                            System.out.println("---UPDATED STUDENT LIST---");
                            Student.displayAllStudents(students);
                        } else {
                            System.out.println("---STUDENT NOT FOUND---\n");
                        }

                    } else {
                        System.out.println("No student data, please create one.\n");
                    }

                    break;
                case 3:
                    System.out.println("\n---VIEW ALL STUDENTS---");
                    Student.displayAllStudents(students);
                    break;
                case 4:
                    System.out.println("\n---SEARCH FOR STUDENT---");

                    if (!students.isEmpty()) {

                        boolean isChoiceOkay = false;
                        int choice = 0;
                        while (!isChoiceOkay) {
                            try {
                                System.out.println("Search by (1. Name, 2. Student Id) : ");
                                choice = Integer.parseInt(scanner.nextLine());
                                isChoiceOkay = true;
                            } catch (NumberFormatException e) {
                                System.out.println("---INVALID INPUT---");
                            }
                        }

                        if (choice == 1) {
                            System.out.println("Enter student's name: ");
                            name = scanner.nextLine();

                            boolean found = false;

                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getName().equalsIgnoreCase(name)) {
                                    System.out.println("Student Id: " + students.get(i).getStudentId());
                                    System.out.println("Name: " + students.get(i).getName());
                                    System.out.println("Age: " + students.get(i).getAge());
                                    System.out.println("Course: " + students.get(i).getCourse());
                                    System.out.println();
                                    found = true;
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("---STUDENT NOT FOUND---\n");
                            }
                        } else if (choice == 2) {

                            studentId = 0;
                            boolean isIdOkay = false;
                            while (!isIdOkay) {
                                System.out.println("Enter student's id: ");
                                try {
                                    studentId = Integer.parseInt(scanner.nextLine());
                                    isIdOkay = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("---INVALID INPUT---");
                                }
                            }

                            boolean found = false;

                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getStudentId() == studentId) {
                                    System.out.println("Student Id: " + students.get(i).getStudentId());
                                    System.out.println("Name: " + students.get(i).getName());
                                    System.out.println("Age: " + students.get(i).getAge());
                                    System.out.println("Course: " + students.get(i).getCourse());
                                    System.out.println();
                                    found = true;
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("---STUDENT NOT FOUND---\n");
                            }

                        } else {
                            System.out.println("---INVALID INPUT---\n");
                        }

                    } else {
                        System.out.println("No student data, please create one.\n");
                    }

                    break;
                case 5:
                    System.out.println("\n---UPDATE STUDENT DETAILS---");

                    if (!students.isEmpty()) {

                        boolean isChoiceOkay = false;
                        int choice = 0;
                        while (!isChoiceOkay) {
                            try {
                                System.out.println("Update student details by (1. Name, 2. Age, 3. Course) : ");
                                choice = Integer.parseInt(scanner.nextLine());
                                isChoiceOkay = true;
                            } catch (NumberFormatException e) {
                                System.out.println("---INVALID INPUT---");
                            }
                        }

                        if (choice == 1) {
                            System.out.println("Enter student's name: ");
                            name = scanner.nextLine();

                            boolean found = false;
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getName().equalsIgnoreCase(name)) {
                                    found = true;

                                    System.out.println("Update student's name to: ");
                                    String updatedName = scanner.nextLine();
                                    students.get(i).setName(updatedName);

                                    System.out.println("---UPDATED STUDENT DETAILS---");
                                    System.out.println("Student Id: " + students.get(i).getStudentId());
                                    System.out.println("Name: " + students.get(i).getName());
                                    System.out.println("Age: " + students.get(i).getAge());
                                    System.out.println("Course: " + students.get(i).getCourse());
                                    System.out.println();

                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("---STUDENT NOT FOUND---\n");
                            }

                        } else if (choice == 2) {
                            System.out.println("Enter student's name: ");
                            name = scanner.nextLine();

                            boolean found = false;
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getName().equalsIgnoreCase(name)) {
                                    found = true;

                                    age = 0;

                                    isAgeOkay = false;
                                    while (!isAgeOkay) {
                                        try {
                                            System.out.println("Update student's age to: ");
                                            age = Integer.parseInt(scanner.nextLine());

                                            if (age > 0) {
                                                isAgeOkay = true;
                                            } else {
                                                System.out.println("Age must be positive number");
                                            }

                                        } catch (NumberFormatException e) {
                                            System.out.println("---INVALID INPUT---");
                                        }
                                    }

                                    students.get(i).setAge(age);

                                    System.out.println("---UPDATED STUDENT DETAILS---");
                                    System.out.println("Student Id: " + students.get(i).getStudentId());
                                    System.out.println("Name: " + students.get(i).getName());
                                    System.out.println("Age: " + students.get(i).getAge());
                                    System.out.println("Course: " + students.get(i).getCourse());
                                    System.out.println();

                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("---STUDENT NOT FOUND---\n");
                            }

                        } else if (choice == 3) {
                            System.out.println("Enter student's name: ");
                            name = scanner.nextLine();

                            boolean found = false;
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getName().equalsIgnoreCase(name)) {
                                    found = true;

                                    System.out.println("Update student's course to: ");
                                    course = scanner.nextLine();
                                    students.get(i).setCourse(course);

                                    System.out.println("---UPDATED STUDENT DETAILS---");
                                    System.out.println("Student Id: " + students.get(i).getStudentId());
                                    System.out.println("Name: " + students.get(i).getName());
                                    System.out.println("Age: " + students.get(i).getAge());
                                    System.out.println("Course: " + students.get(i).getCourse());
                                    System.out.println();

                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("---STUDENT NOT FOUND---\n");
                            }
                        } else {
                            System.out.println("---INVALID INPUT---\n");
                        }


                    } else {
                        System.out.println("No student data, please create one.\n");
                    }

                    break;
                case 6:
                    System.out.println("\n---GOODBYE---");
                    flag = false;
                    break;
                default:
                    System.out.println("\n---INVALID INPUT---\n");
                    break;
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Please choose a command:");
        System.out.println("1. Add a new student");
        System.out.println("2. Remove existing student");
        System.out.println("3. View all students");
        System.out.println("4. Search for student");
        System.out.println("5. Update student details");
        System.out.println("6. Exit");
    }
}