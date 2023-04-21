package edu.utsa.cs443.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.utsa.cs443.gpacalculator.controller.MainController;
import edu.utsa.cs443.gpacalculator.controller.SemesterEditController;

public class SemesterEditActivity extends AppCompatActivity {

    private SemesterEditController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_edit);

        controller = new SemesterEditController(this);
        findViewById(R.id.classEdit).setOnClickListener(controller);

    }
}