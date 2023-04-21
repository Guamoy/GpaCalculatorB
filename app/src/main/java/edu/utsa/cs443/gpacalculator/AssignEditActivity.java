package edu.utsa.cs443.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.utsa.cs443.gpacalculator.controller.AssignEditController;

public class AssignEditActivity extends AppCompatActivity {

    private AssignEditController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_edit);

        controller = new AssignEditController(this);
        findViewById(R.id.addAssign).setOnClickListener(controller);
    }
}