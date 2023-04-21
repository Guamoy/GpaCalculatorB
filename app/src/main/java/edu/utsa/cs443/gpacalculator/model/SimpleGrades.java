package edu.utsa.cs443.gpacalculator.model;

public class SimpleGrades {

    public double GPA; // 100% we get floating point precision errors here
    public double weightGPA;

    /**
     * SimpleGrades Constructor
     * @param GPA
     * @param weightGPA - interchangeable with creditHours
     */
    public SimpleGrades(double GPA, double weightGPA) {
        this.GPA = GPA;
        this.weightGPA = weightGPA;
    }

    /**
     * Returns current GPA
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
    public double getWeightGPA() {
        return weightGPA;
    }

    /**
     * Sets weight / total credit hours of GPA
     * @param weightGPA
     */
    public void setWeightGPA(double weightGPA) {
        this.weightGPA = weightGPA;
    }

    /**
     * Increases credit hours of GPA
     * @param countToIncrease
     */
    public void increaseWeightGPA(double countToIncrease) {
        this.weightGPA += countToIncrease;
    }

    /**
     * Converts user input to double and adds to GPA
     *
     * TODO ?? maybe convert to hashmap in <String lettergrade, GPAValue> pair instead of switch?
     * it would look much better in code but otherwise the impact is minimal
     *
     * @param letterGrade
     */
    public void addLetterGrade(String letterGrade) {
        if (this.weightGPA < 0) //avoid divide by 0
            this.weightGPA = 0;

        switch(letterGrade) {
            case "A+":
            case "A":
                this.GPA = (this.GPA * this.weightGPA + 4.0) / (this.weightGPA + 1);
                break;
            case "A-":
                this.GPA = (this.GPA * this.weightGPA + 3.67) / (this.weightGPA + 1);
                break;
            case "B+":
                this.GPA = (this.GPA * this.weightGPA + 3.33) / (this.weightGPA + 1);
                break;
            case "B":
                this.GPA = (this.GPA * this.weightGPA + 3.00) / (this.weightGPA + 1);
                break;
            case "B-":
                this.GPA = (this.GPA * this.weightGPA + 2.67) / (this.weightGPA + 1);
                break;
            case "C+":
                this.GPA = (this.GPA * this.weightGPA + 2.33) / (this.weightGPA + 1);
                break;
            case "C":
                this.GPA = (this.GPA * this.weightGPA + 2.0) / (this.weightGPA + 1);
                break;
            case "C-":
                this.GPA = (this.GPA * this.weightGPA + 1.67) / (this.weightGPA + 1);
                break;
            case "D+":
                this.GPA = (this.GPA * this.weightGPA + 1.33) / (this.weightGPA + 1);
                break;
            case "D":
                this.GPA = (this.GPA * this.weightGPA + 1.0) / (this.weightGPA + 1);
                break;
            case "D-":
                this.GPA = (this.GPA * this.weightGPA + .67) / (this.weightGPA + 1);
                break;
            case "F":
                this.GPA = (this.GPA * this.weightGPA + 0.0) / (this.weightGPA + 1);
                break;
        }
        increaseWeightGPA(1.0);
    }
}
