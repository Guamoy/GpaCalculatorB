/**
 * Settings Activity contains settings view, which allows user to change theme and enable/disable
 * notifications. Additional buttons allow navigation to help and about screens.
 *
 * @author Esteban Leal tei192
 * @author Georgy Vinogradov klr151
 * UTSA CS 3443 - GPA Calculator
 * Spring 2023
 */
package edu.utsa.cs443.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import edu.utsa.cs443.gpacalculator.R;
import edu.utsa.cs443.gpacalculator.controller.SettingsController;


public class SettingsActivity extends AppCompatActivity {

    private SettingsController settingsController;
    private Switch themeSwitch;

    /**
     * Creates settings view and sets onClickListeners
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    /**
     * Reads the settings from the file and updates the UI accordingly
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        settingsController = new SettingsController(this);

        // Find the Save button and set a click listener to save the settings to a file
        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSettingsToFile();
            }
        });

        // Load the settings from the file and update the UI
        readSettingsFromFile();
    }


    /**
     * Reads the settings from the file and updates the UI accordingly
     */


    /**
     * On click of save button press, current settings are written to file
     */

    private void readSettingsFromFile() {
        try {
            FileInputStream fileInputStream = openFileInput("settings.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Read the settings from the file and split the lines
            String settingsString = bufferedReader.readLine();

            // Get the notification checkbox and theme switch views
            CheckBox notificationCheckbox = findViewById(R.id.notification_checkbox);
            themeSwitch = findViewById(R.id.theme_switch); // update themeSwitch variable

            // Update the notification checkbox based on the settings
            if (settingsString.contains("Notifications: On")) {
                notificationCheckbox.setChecked(true);
            } else {
                notificationCheckbox.setChecked(false);
            }

            // Update the theme switch based on the settings
            if (settingsString.contains("Dark Theme: On")) {
                themeSwitch.setChecked(true);
            } else {
                themeSwitch.setChecked(false);
            }

            bufferedReader.close();
            Toast.makeText(this, "Settings loaded", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error loading settings", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    private void saveSettingsToFile() {
        // Get the current state of the notification checkbox and theme switch
        boolean notificationsEnabled = ((CheckBox) findViewById(R.id.notification_checkbox)).isChecked();
        boolean isDarkTheme = ((Switch) findViewById(R.id.theme_switch)).isChecked();

        // Create a string that represents the current settings
        String settingsString = "Notifications: " + (notificationsEnabled ? "On" : "Off") + "\n"
                + "Dark Theme: " + (isDarkTheme ? "On" : "Off");

        // Write the settings to a file
        try {
            FileOutputStream fileOutputStream = openFileOutput("settings.txt", MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(settingsString);
            outputStreamWriter.close();
            Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error saving settings", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    /**
     * Returns Switch corresponding to app theme option
     * @return Switch themeSwitch
     */
    public Switch getThemeSwitch() {
        if (themeSwitch == null) {
            themeSwitch = findViewById(R.id.theme_switch);
        }
        return themeSwitch;
    }
}

