package edu.utsa.cs443.gpacalculator.controller;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs443.gpacalculator.DetailedActivity;
import edu.utsa.cs443.gpacalculator.GradeNeededActivity;
import edu.utsa.cs443.gpacalculator.R;
import edu.utsa.cs443.gpacalculator.SimpleActivity;

public class MainController extends AppCompatActivity implements View.OnClickListener {

    private Activity activity;

    public MainController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.simple) {
            Log.d("Simple pressed", "Starting Simple Activity");
            Intent intent = new Intent(activity, SimpleActivity.class);
            activity.startActivity(intent);
        }
        else if (clickedButton.getId() == R.id.detailed) {
            Log.d("Detailed Pressed", "Starting Detailed Activity");
            Intent intent = new Intent(activity, DetailedActivity.class);
            activity.startActivity(intent);
        }
        else if (clickedButton.getId() == R.id.gradeNeededButton) {
            Log.d("GradeNeeded Pressed", "Starting GradeNeeded Activity");
            Intent intent = new Intent(activity, GradeNeededActivity.class);
            activity.startActivity(intent);
        }
    }
}
