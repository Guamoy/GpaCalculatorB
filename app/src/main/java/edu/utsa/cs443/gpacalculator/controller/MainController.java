/**
 * Main Controller handles user activity on main menu, simply directing user to activities
 * based on button pressed
 *
 * @author Esteban Leal tei192
 * @author Georgy Vinogradov klr151
 * UTSA CS 3443 - GPA Calculator
 * Spring 2023
 */
package edu.utsa.cs443.gpacalculator.controller;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs443.gpacalculator.GradeNeededActivity;
import edu.utsa.cs443.gpacalculator.R;
import edu.utsa.cs443.gpacalculator.SettingsActivity;
import edu.utsa.cs443.gpacalculator.SimpleActivity;

public class MainController extends AppCompatActivity implements View.OnClickListener {

    private Activity activity;

    public MainController(Activity activity) {
        this.activity = activity;
    }

    /**
     * On user click of 3 possible buttons, app is directed to activity corresponding to button
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.simple) {
            Log.d("Simple pressed", "Starting Simple Activity");
            Intent intent = new Intent(activity, SimpleActivity.class);
            activity.startActivity(intent);
        }
        else if (view.getId() == R.id.gradeNeededButton) {
            Log.d("GradeNeeded Pressed", "Starting GradeNeeded Activity");
            Intent intent = new Intent(activity, GradeNeededActivity.class);
            activity.startActivity(intent);
        }
        else if (view.getId() == R.id.settings) {
            Log.d("Settings Pressed", "Starting Settings Activity");
            Intent intent = new Intent(activity, SettingsActivity.class);
            activity.startActivity(intent);
        }
    }

}
