package edu.utsa.cs443.gpacalculator.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs443.gpacalculator.AssignEditActivity;

public class ClassEditController extends AppCompatActivity implements View.OnClickListener {

    private Activity activity;
    private static String classKey = "class_identification";
    private static String assignKey = "assign_id";

    public ClassEditController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        Intent intent = new Intent(activity, AssignEditActivity.class);
        //intent.putExtra(assignKey,  //pass assignment id
        activity.startActivity(intent);
    }
}
