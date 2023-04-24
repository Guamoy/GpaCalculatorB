package edu.utsa.cs443.gpacalculator.controller;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs443.gpacalculator.DetailedActivity;
import edu.utsa.cs443.gpacalculator.GradeNeededActivity;
import edu.utsa.cs443.gpacalculator.R;
import edu.utsa.cs443.gpacalculator.SettingsActivity;
import edu.utsa.cs443.gpacalculator.SimpleActivity;

public class MainController extends AppCompatActivity implements View.OnClickListener {

    private Activity activity;

    public MainController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.simple) {
            Log.d("Simple pressed", "Starting Simple Activity");
            Intent intent = new Intent(activity, SimpleActivity.class);
            activity.startActivity(intent);
        }
        else if (view.getId() == R.id.detailed) {
            Log.d("Detailed Pressed", "Starting Detailed Activity");
            Intent intent = new Intent(activity, DetailedActivity.class);
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
