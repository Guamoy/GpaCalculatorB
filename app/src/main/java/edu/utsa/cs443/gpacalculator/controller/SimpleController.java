/**
 * Grade Needed Controller contains onClick method and directs activity based on user input
 *
 * @author Esteban Leal tei192
 * @author Georgy Vinogradov klr151
 * UTSA CS 3443 - GPA Calculator
 * Spring 2023
 */
package edu.utsa.cs443.gpacalculator.controller;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs443.gpacalculator.R;
import edu.utsa.cs443.gpacalculator.model.SimpleGrades;

public class SimpleController extends AppCompatActivity implements View.OnClickListener{

    private Activity activity;
    private SimpleGrades grades;

    public SimpleController(Activity activity) {
        this.activity = activity;
    }

    /**
     * On user click, credit hours will be incremented by -1 or +1, or letter grade is input
     * into SimpleGrades model
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if (clickedButton.getText().toString().equals("Credit +1")) {
            updateCreditHours(1);
        }
        else if (clickedButton.getText().toString().equals("Credit -1")) {
            updateCreditHours(-1);
        }
        else {
            TextView creditText = activity.findViewById(R.id.creditsSimple);
            grades.addLetterGrade(clickedButton.getText().toString(),
                    Integer.parseInt(creditText.getText().toString()));
            updateGPA();
            updateInputLog(clickedButton.getText().toString());
        }
    }

    /**
     * Creates SimpleGrades model and calls to set initial display values
     */
    public void createModel() {
        grades = new SimpleGrades(0.0, 0);
        initializeDisplays();
    }

    /**
     * Sets current GPA text on screen to initial GPA of 0.0
     */
    private void initializeDisplays() {
        TextView gpaText = activity.findViewById(R.id.simple_GPA_display);
        gpaText.setText(Double.toString(grades.getGPA()));
        //ideally GPA should be truncated to 2 decimal places in getGPA()
    }

    /**
     * Sets GPA displayed on screen to GPA stored in SimpleGrades Model
     */
    private void updateGPA() {
        TextView gpaText = activity.findViewById(R.id.simple_GPA_display);
        gpaText.setText(grades.getGPAAsString());
    }

    /**
     * Updates credit hours displayed on screen by +1 or -1 depending on button pressed
     * @param change
     */
    private void updateCreditHours(int change) {
        TextView creditText = activity.findViewById(R.id.creditsSimple);
        int newValue = Integer.parseInt(creditText.getText().toString()) + change;
        creditText.setText(Integer.toString(newValue));
    }

    /**
     * also maybe show value of Letter Grade as well (A+ - 4.0, C - 2.0)
     * @param input
     */
    private void updateInputLog(String input) {
        TextView inputLog = activity.findViewById(R.id.inputGrades);
        TextView creditText = activity.findViewById(R.id.creditsSimple);
        String creditHours = creditText.getText().toString();
        inputLog.setText(input + " - " + creditHours + " Credit Hours\n" + inputLog.getText().toString());
        //above is slightly cursed way of appending to beginning of text view
        //inputLog.append("\n" + input);
    }

}
