package edu.utsa.cs443.gpacalculator.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs443.gpacalculator.SemesterEditActivity;

public class DetailedController extends AppCompatActivity implements View.OnClickListener {

    private Activity activity;
    private static String classKey = "class_identifier";

    public DetailedController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        Intent intent = new Intent(activity, SemesterEditActivity.class);
        //intent.putExtra(classKey, ???); -- pass info containing class identifier to next activity
        activity.startActivity(intent);
    }
}
