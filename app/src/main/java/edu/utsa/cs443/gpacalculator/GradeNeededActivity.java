/**
 * Grade Needed Activity creates view and initializes values contained in spinner
 *
 * @author Esteban Leal tei192
 * @author Georgy Vinogradov klr151
 * UTSA CS 3443 - GPA Calculator
 * Spring 2023
 */
package edu.utsa.cs443.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import edu.utsa.cs443.gpacalculator.controller.GradeNeededController;

public class GradeNeededActivity extends AppCompatActivity {

    private GradeNeededController controller;

    /**
     * Creates view and sets onClickListener for single button "calculate"
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_needed);

        controller = new GradeNeededController(this);

        findViewById(R.id.calculateButton).setOnClickListener(controller);
        controller.initializeActivityObjects();
        initializeSpinner();

    }

    /**
     * Populates Spinner values with letter grades
     */
    private void initializeSpinner() {
        List<String> spinnerList = new ArrayList<>();
        spinnerList.add("A+");
        spinnerList.add("A");
        spinnerList.add("A-");
        spinnerList.add("B");
        spinnerList.add("B+");
        spinnerList.add("B-");
        spinnerList.add("C");
        spinnerList.add("C+");
        spinnerList.add("C-");
        spinnerList.add("D");
        spinnerList.add("D+");
        spinnerList.add("D-");
        spinnerList.add("F");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinnerGrades);
        sItems.setAdapter(adapter);

    }

}