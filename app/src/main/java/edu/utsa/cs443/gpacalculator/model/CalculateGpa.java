public class CalculateGpa{

    private AddProjectGrade projectGrade;
    private AddMidtermTest midtermGrade;
    private AddHwGrade hwGrade;
    private AddFinalExam finalExamGrade;
    private AddClass course;

    public CalculateGpa(AddProjectGrade projectGrade, AddMidtermTest midtermGrade, AddHwGrade hwGrade,
                         AddFinalExam finalExamGrade, AddClass course) {
        this.projectGrade = projectGrade;
        this.midtermGrade = midtermGrade;
        this.hwGrade = hwGrade;
        this.finalExamGrade = finalExamGrade;
        this.course = course;
    }

    public double calculateGPA() {
        double hwWeight = 0.15;
        double projectWeight = 0.30;
        double midtermWeight = 0.30;
        double finalExamWeight = 0.25;

        double weightedHwGrade = hwGrade.getHwGrade() * hwWeight;
        double weightedProjectGrade = projectGrade.getProjectGrade() * projectWeight;
        double weightedMidtermGrade = midtermGrade.getMidtermGrade() * midtermWeight;
        double weightedFinalExamGrade = finalExamGrade.getFinalExamGrade() * finalExamWeight;

        double totalWeightedGrade = weightedHwGrade + weightedProjectGrade + weightedMidtermGrade + weightedFinalExamGrade;
        double totalCredits = course.getCreditHours();

        double gpa = totalWeightedGrade / totalCredits;
        return gpa;
    }
}
