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
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import edu.utsa.cs443.gpacalculator.R;
import edu.utsa.cs443.gpacalculator.model.GradeFinder;

public class GradeNeededController extends AppCompatActivity implements View.OnClickListener {

    private Activity activity;
    private boolean isInt; //used to validate user input
    private String toastText;
    private EditText[] scoreInputFields;
    private GradeFinder gradeFinder;
    public GradeNeededController(Activity activity) {
        this.activity = activity;
    }

    /**
     * On User click, gets values from fields and passes to GradeFinder model, then updates
     * textfield on screen for user
     * If invalid input (empty or non-int input), sends toast to user
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        isInt = checkInputType();

        if (isInt) {

            Spinner spinner = (Spinner) activity.findViewById(R.id.spinnerGrades);
            gradeFinder.findGrade(spinner.getSelectedItem().toString(),
                    Integer.parseInt(scoreInputFields[0].getText().toString()),
                    Integer.parseInt(scoreInputFields[1].getText().toString()),
                    Integer.parseInt(scoreInputFields[2].getText().toString()),
                    Integer.parseInt(scoreInputFields[3].getText().toString()));

            updateGradeNeededText();

        }
        else {
            toastText = "Invalid input, only integers values are accepted";
            Toast.makeText(view.getContext(), toastText, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Checks if input fields contain either no input or non int
     *
     * @return boolean representing input type
     */
    private boolean checkInputType() {

        for (int i = 0; i < scoreInputFields.length; i++) {
            if (scoreInputFields[i].getText().toString().length() <= 0)
                return false;
            if (!(TextUtils.isDigitsOnly(scoreInputFields[i].getText()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Initializes screen for user view
     */
    public void initializeActivityObjects() {
        createGradeFinderObject();
        populateInputArray();
    }

    /**
     * Creates new gradeFinder object for model calculations
     */
    private void createGradeFinderObject() {
        gradeFinder = new GradeFinder(0.0);
    }

    /**
     * Creates array containing edit text ids
     */
    private void populateInputArray() {
        scoreInputFields = new EditText[4];
        scoreInputFields[0] = activity.findViewById(R.id.sumQuizInput);
        scoreInputFields[1] = activity.findViewById(R.id.sumLabInput);
        scoreInputFields[2] = activity.findViewById(R.id.sumProjectInput);
        scoreInputFields[3] = activity.findViewById(R.id.midtermInput);

    }

    /**
     * Updates text field displaying "Grade Needed" to current grade in model
     */
    private void updateGradeNeededText() {
        TextView gradeNeededText = (TextView) activity.findViewById(R.id.gradeNeededText);
        gradeNeededText.setText(gradeFinder.getGradeAsString());
    }

}
