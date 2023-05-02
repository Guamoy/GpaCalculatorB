package edu.utsa.cs443.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.utsa.cs443.gpacalculator.controller.MainController;

public class MainActivity extends AppCompatActivity {

    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(this);

        int[] buttonIDs = {R.id.simple, R.id.gradeNeededButton, R.id.settings};

        for (int buttonID : buttonIDs) {
            findViewById(buttonID).setOnClickListener(controller);
        }
    }

}