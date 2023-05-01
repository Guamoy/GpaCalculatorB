package edu.utsa.cs443.gpacalculator.model;

import java.util.HashMap;

public class SimpleGrades {

    public double GPA; // 100% we get floating point precision errors here
    public int weightGPA;
    private HashMap<String, Double> gradeValues;


    /**
     * SimpleGrades Constructor
     * @param GPA
     * @param weightGPA - interchangeable with creditHours
     */
    public SimpleGrades(double GPA, int weightGPA) {
        this.GPA = GPA;
        this.weightGPA = weightGPA;
        gradeValues = new HashMap<>();
        gradeValues.put("A+", 4.0);
        gradeValues.put("A", 4.0);
        gradeValues.put("A-", 3.67);
        gradeValues.put("B+", 3.33);
        gradeValues.put("B", 3.0);
        gradeValues.put("B-", 2.67);
        gradeValues.put("C+", 2.33);
        gradeValues.put("C", 2.0);
        gradeValues.put("C-", 1.67);
        gradeValues.put("D+", 1.33);
        gradeValues.put("D", 1.0);
        gradeValues.put("D-", .67);
        gradeValues.put("F", 0.0);
    }

    public String getGPAAsString() {
        String sToReturn = String.format("%.2f", getGPA());
        return sToReturn;
    }

    /**public int getWeightInt() {
        return (int)weightGPA;
    }**/
    /**
     * Returns current GPA
     * TODO truncate and round GPA to 2 decimal places
     * @return double GPA
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * Sets GPA value
     * @param GPA
     */
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    /**
     * Gets weight / total credit hours of GPA
     * @return double weightGPA
     */
    public int getWeightGPA() {
        return weightGPA;
    }

    /**
     * Sets weight / total credit hours of GPA
     * @param weightGPA
     */
    public void setWeightGPA(int weightGPA) {
        this.weightGPA = weightGPA;
    }

    /**
     * Increases credit hours of GPA
     * @param countToIncrease
     */
    public void increaseWeightGPA(int countToIncrease) {
        this.weightGPA += countToIncrease;
    }

    /**
     * Converts user input to double and adds to GPA
     *
     * @param letterGrade
     */
    public void addLetterGrade(String letterGrade, int creditHours) {
        if (this.weightGPA == 0) { //avoids multiplying by zero on first usage
            setGPA(this.GPA + gradeValues.get(letterGrade));
        }
        else {
            setGPA((this.GPA * this.weightGPA + gradeValues.get(letterGrade) * creditHours)
                    / (this.weightGPA + creditHours));
        }
        increaseWeightGPA(creditHours);
    }
}
