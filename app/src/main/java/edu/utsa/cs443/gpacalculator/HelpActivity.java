/**
 * HelpActivity creates the view that informs user of how to use the GPA calculator
 *
 * @author Esteban Leal tei192
 * @author Georgy Vinogradov klr151
 * UTSA CS 3443 - GPA Calculator
 * Spring 2023
 */
package edu.utsa.cs443.gpacalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs443.gpacalculator.R;

public class HelpActivity extends AppCompatActivity {

    /**
     * Creates view that contains text on how to use app
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_activity);
    }
}
