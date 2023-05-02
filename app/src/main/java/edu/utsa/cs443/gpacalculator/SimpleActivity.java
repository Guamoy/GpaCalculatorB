/**
 * Simple Activity that creates view where user can calculate GPA with button presses
 *
 * @author Esteban Leal tei192
 * @author Georgy Vinogradov klr151
 * UTSA CS 3443 - GPA Calculator
 * Spring 2023
 */
package edu.utsa.cs443.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.utsa.cs443.gpacalculator.controller.SimpleController;

public class SimpleActivity extends AppCompatActivity {

    private SimpleController controller;

    /**
     * Creates simple gpa calculator, sets onclick listeners on button interface
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        int[] buttonIDs = {R.id.aplus, R.id.A, R.id.aminus, R.id.bplus, R.id.B, R.id.bminus,
                R.id.cplus, R.id.C, R.id.cminus, R.id.dplus, R.id.D, R.id.dminus, R.id.F
                , R.id.creditDecrement, R.id.creditIncrement};

        controller = new SimpleController(this);
        for (int buttonID: buttonIDs) {
            findViewById(buttonID).setOnClickListener(controller);
        }
        controller.createModel();
    }
}