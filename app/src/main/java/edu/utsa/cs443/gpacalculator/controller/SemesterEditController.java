package edu.utsa.cs443.gpacalculator.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs443.gpacalculator.ClassEditActivity;

public class SemesterEditController extends AppCompatActivity implements View.OnClickListener {

    private String classKey = "class_identifier";
    private Activity activity;

    public SemesterEditController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        Intent intent = new Intent(activity, ClassEditActivity.class);
        //intent.putExtra the class identifier
        activity.startActivity(intent);
    }
}
