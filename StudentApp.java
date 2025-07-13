import java.util.*;

public class StudentApp {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Welcome to Smartex Student System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student Details");
            System.out.println("3. Append Remarks");
            System.out.println("4. Calculate Grade");
            System.out.println("5. Compare Names");
            System.out.println("6. Simulate Exception");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: appendRemarks(); break;
                case 4: calculateGrades(); break;
                case 5: compareStudentNames(); break;
                case 6: simulateException(); break;
                case 7: System.out.println("Exiting system. Thank you!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 7);
    }

    static void addStudent() {
        try {
            System.out.print("Is this a Scholar Student? (yes/no): ");
            String scholar = sc.next();

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Name: ");
            sc.nextLine(); 
            String name = sc.nextLine();
            System.out.print("Enter Marks (0-100): ");
            double marks = sc.nextDouble();
            System.out.print("Enter Section (A/B/C): ");
            String section = sc.next();

            if (scholar.equalsIgnoreCase("yes")) {
                System.out.print("Enter Scholarship Amount: ");
                double amount = sc.nextDouble();
                students.add(new ScholarStudent(id, name, marks, section, amount));
            } else {
                students.add(new Student(id, name, marks, section));
            }

            System.out.println("Student added successfully!");

        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void displayStudents() {
        System.out.println("--- Display All Student Details ---");
        for (Student s : students) {
            s.printDetails();
        }
    }

    static void appendRemarks() {
        System.out.println("--- Append Remark ---");
        System.out.print("Enter Student ID to update remarks: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getStudentId() == id) {
                System.out.print("Enter your remark: ");
                sc.nextLine();
                String remark = sc.nextLine();
                s.appendRemarks(remark);
                System.out.println("Remark added successfully.");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    static void calculateGrades() {
        System.out.println("--- Calculate Grade ---");
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getStudentId() == id) {
                System.out.println("Grade: " + s.calculateGrade());
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    static void compareStudentNames() {
        System.out.println("--- Compare Names ---");
        System.out.print("Enter first student name: ");
        sc.nextLine();
        String name1 = sc.nextLine();
        System.out.print("Enter second student name: ");
        String name2 = sc.nextLine();

        System.out.println("Comparison using ==: " + (name1 == name2));
        System.out.println("Comparison using equals(): " + name1.equals(name2));
        System.out.println("Comparison using equalsIgnoreCase(): " + name1.equalsIgnoreCase(name2));
    }

    static void simulateException() {
        System.out.println("--- Simulate Exception ---");
        try {
            System.out.print("Enter number: ");
            int number = sc.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = sc.nextInt();
            int result = number / divisor;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            System.out.println("This is the finally block.");
        }
    }
}