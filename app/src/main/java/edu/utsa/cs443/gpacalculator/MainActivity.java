/**
 * Main Activity creates view that acts as hub which allows user to navigate between screen
 *
 * @author Esteban Leal tei192
 * @author Georgy Vinogradov klr151
 * UTSA CS 3443 - GPA Calculator
 * Spring 2023
 */
package edu.utsa.cs443.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.utsa.cs443.gpacalculator.controller.MainController;

public class MainActivity extends AppCompatActivity {

    private MainController controller;

    /**
     * Creates hub screen and sets onClickListeners on 3 navigation buttons
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
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