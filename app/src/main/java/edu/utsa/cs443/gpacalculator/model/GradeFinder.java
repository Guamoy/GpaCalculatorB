package edu.utsa.cs443.gpacalculator.model;

import java.util.HashMap;

public class GradeFinder {

    private HashMap<String, Double> gradeValues;
    public double gradeNeeded;

    /**
     * GradeFinder constructor
     * @param gradeNeeded
     */
    public GradeFinder(double gradeNeeded) {
        this.gradeNeeded = gradeNeeded;
        gradeValues = new HashMap<>();
        gradeValues.put("A+", .96);
        gradeValues.put("A", .93);
        gradeValues.put("A-", .9);
        gradeValues.put("B+", .87);
        gradeValues.put("B", .83);
        gradeValues.put("B-", .80);
        gradeValues.put("C+", .77);
        gradeValues.put("C", .73);
        gradeValues.put("C-", .7);
        gradeValues.put("D+", .67);
        gradeValues.put("D", .63);
        gradeValues.put("D-", .6);
        gradeValues.put("F", 0.0);
    }

    /**
     * return gradeNeeded value
     * @return double
     */
    public double getGradeNeeded() {
        return gradeNeeded;
    }

    /**
     * Sets gradeNeeded to parameter
     * @param gradeNeeded
     */
    public void setGradeNeeded(double gradeNeeded) {
        this.gradeNeeded = gradeNeeded;
    }

    /**
     * Converts double to String with a precision of 2
     * @return String representation of double with precision 2
     */

    public String getGradeAsString() {
        String sToReturn = String.format("%.2f", getGradeNeeded());
        return sToReturn;
    }

    /**
     * Normalizes input user scores to weight specified in CS 3443 syllabus
     *
     * @param quizzes
     * @param labScores
     * @param projectScores
     * @param midTerm
     * @return double normalizedScore
     */

    public double normalizeInputScores(int quizzes, int labScores, int projectScores, int midTerm) {
        double quizWeighted = (quizzes / 6.0) * .14;
        double labWeighted = (labScores / 5.0) * .36;
        double projectWeighted = (projectScores / 3.0) * .20;
        double midtermWeighted = midTerm * .15;

        //System.out.println("Quiz " + quizWeighted + " lab " + labWeighted + " project " + projectWeighted + "midterm " + midtermWeighted);

        return (quizWeighted + labWeighted + projectWeighted + midtermWeighted) / 100;

    }

    /**
     * Computes minimum necessary score to achieve desired letter grade
     * TODO Collect user blackboard scores for the four categories below
     *
     * Max score is calculated from following:
     * All assignments are 100 points on blackboard
     * 6 Quizzes - 14% weight
     * 5 Labs + 1 Extra Credit - 36% weight
     * 3 Team Project Assignments - 20% weight
     * 2 Exams - 30% Weight
     *
     * @param letterGrade
     * @param quizzes
     * @param labScores
     * @param projectScores
     * @param midTerm
     */

    public void findGrade(String letterGrade, int quizzes, int labScores, int projectScores, int midTerm) {
        double currentPoints;
        double minNecessaryScore;
        double scoreThreshold = gradeValues.get(letterGrade);
        currentPoints = normalizeInputScores(quizzes, labScores, projectScores, midTerm);

        //System.out.println("Current points: " + currentPoints + "scoreThreshold: " + scoreThreshold);

        minNecessaryScore = 100 * (scoreThreshold - currentPoints) * (20.0 / 3.0);
        setGradeNeeded(minNecessaryScore);

    }
}
