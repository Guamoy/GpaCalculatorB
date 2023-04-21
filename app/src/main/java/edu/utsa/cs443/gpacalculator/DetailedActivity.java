package edu.utsa.cs443.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.utsa.cs443.gpacalculator.controller.DetailedController;
import edu.utsa.cs443.gpacalculator.controller.MainController;

public class DetailedActivity extends AppCompatActivity {

    private DetailedController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        //Create new button programmatically for every additional class box

        controller = new DetailedController(this);
        findViewById(R.id.editSem).setOnClickListener(controller);

    }
}