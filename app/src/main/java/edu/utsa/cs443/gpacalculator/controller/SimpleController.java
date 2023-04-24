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

    public void createModel() {
        grades = new SimpleGrades(0.0, 0);
        initializeDisplays();
    }

    private void initializeDisplays() {
        TextView gpaText = activity.findViewById(R.id.simple_GPA_display);
        gpaText.setText(Double.toString(grades.getGPA()));
        //ideally GPA should be truncated to 2 decimal places in getGPA()
    }

    private void updateGPA() {
        TextView gpaText = activity.findViewById(R.id.simple_GPA_display);
        gpaText.setText(grades.getGPAAsString());
    }

    private void updateCreditHours(int change) {
        TextView creditText = activity.findViewById(R.id.creditsSimple);
        int newValue = Integer.parseInt(creditText.getText().toString()) + change;
        creditText.setText(Integer.toString(newValue));
    }

    /**
     * TODO Change append method from new line on each input to more condensed method of display
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
