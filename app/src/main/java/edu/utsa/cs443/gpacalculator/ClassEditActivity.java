package edu.utsa.cs443.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.utsa.cs443.gpacalculator.controller.ClassEditController;

public class ClassEditActivity extends AppCompatActivity {

    private ClassEditController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_edit);

        controller = new ClassEditController(this);
        findViewById(R.id.editAssignment).setOnClickListener(controller);

    }
}