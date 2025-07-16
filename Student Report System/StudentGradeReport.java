import java.util.Scanner;
abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public abstract void displayInfo();
}
class Student extends Person {
    private String rollNumber;
    private int[] marks; 

    public Student(String name, int age, String rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
        this.marks = new int[5];
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public int[] getMarks() {
        return marks;
    }

    public void displayInfo() {
        System.out.println("Student Name : " + getName());
        System.out.println("Age          : " + getAge());
        System.out.println("Roll Number  : " + rollNumber);
    }
}
class ReportCard {
    public void generateReport(Student student) {
        int[] marks = student.getMarks();
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }

        double average = total / 5.0;
        String grade;
        boolean fail = false;

        for (int mark : marks) {
            if (mark < 35) {
                fail = true;
                break;
            }
        }

        if (fail) {
            grade = "Fail";
        } else if (average >= 90) {
            grade = "A+";
        } else if (average >= 75) {
            grade = "A";
        } else if (average >= 60) {
            grade = "B";
        } else {
            grade = "C";
        }

        System.out.println("\n------ Report Card ------");
        student.displayInfo();
        System.out.println("Total Marks : " + total + "/500");
        System.out.println("Average     : " + average);
        System.out.println("Grade       : " + grade);
        System.out.println("--------------------------");
    }
}

public class StudentGradeReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter roll number: ");
        String roll = sc.nextLine();
        Student student = new Student(name, age, roll);
        int[] marks = new int[5];
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        student.setMarks(marks);
        ReportCard reportCard = new ReportCard();
        reportCard.generateReport(student);
    }
}
