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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_needed);

        controller = new GradeNeededController(this);

        findViewById(R.id.calculateButton).setOnClickListener(controller);
        controller.initializeActivityObjects();
        initializeSpinner();

    }

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