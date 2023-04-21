package edu.utsa.cs443.gpacalculator.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AssignEditController extends AppCompatActivity implements View.OnClickListener{

    private Activity activity;
    private static String assignKey = "assign_id";

    public AssignEditController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        //on button click, validate fields for proper user input
    }

}
