public class ScholarStudent extends Student {
    private double scholarshipAmount;

    public ScholarStudent(int studentId, String name, double marks, String section, double scholarshipAmount) throws InvalidMarksException {
        super(studentId, name, marks, section);
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public String calculateGrade() {
        double boostedMarks = getMarks() + 5;
        if (boostedMarks > 100) boostedMarks = 100;

        if (boostedMarks >= 90) return "A";
        else if (boostedMarks >= 75) return "B";
        else if (boostedMarks >= 60) return "C";
        else if (boostedMarks >= 40) return "D";
        else return "F";
    }

    @Override
    public String getType() {
        return "Scholar Student";
    }
}