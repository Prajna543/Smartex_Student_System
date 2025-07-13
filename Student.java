import java.util.*;

public class Student extends Record implements PersonInfo {
    private int studentId;
    private String name;
    private double marks;
    private String section;
    private boolean isPassed;
    private StringBuffer remarks;
    private static int studentCount = 0;
    public static final String INSTITUTE_NAME = "Smartex Institute";

    public Student() {
        this.studentId = 0;
        this.name = "";
        this.marks = 0;
        this.section = "";
        this.isPassed = false;
        this.remarks = new StringBuffer();
        studentCount++;
    }

    public Student(int studentId, String name, double marks, String section) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks should be between 0 and 100.");
        }
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        this.section = section;
        this.isPassed = marks >= 40;
        this.remarks = new StringBuffer();
        studentCount++;
    }

    public Student(Student other) {
        this.studentId = other.studentId;
        this.name = other.name;
        this.marks = other.marks;
        this.section = other.section;
        this.isPassed = other.isPassed;
        this.remarks = new StringBuffer(other.remarks.toString());
        studentCount++;
    }

    public void printDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Section: " + section);
        System.out.println("Passed: " + isPassed);
        System.out.println("Remarks: " + (remarks.length() == 0 ? "None" : remarks));
    }

    public String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }

    public void appendRemarks(String remark) {
        remarks.append(remark).append(" ");
    }

    public void compareNames(String otherName) {
        System.out.println("Comparison using ==: " + (name == otherName));
        System.out.println("Comparison using equals(): " + name.equals(otherName));
        System.out.println("Comparison using equalsIgnoreCase(): " + name.equalsIgnoreCase(otherName));
    }

    public static int getTotalStudents() {
        return studentCount;
    }

    public final void finalizeRecord() {
        System.out.println("Record finalized for " + name);
    }

    public void displayBasicInfo() {
        System.out.println("ID: " + studentId + ", Name: " + name);
    }

    public String getType() {
        return "Regular Student";
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
    public String getSection() { return section; }
    public boolean getIsPassed() { return isPassed; }
    public void setMarks(double marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) throw new InvalidMarksException("Invalid marks!");
        this.marks = marks;
        this.isPassed = marks >= 40;
    }
}