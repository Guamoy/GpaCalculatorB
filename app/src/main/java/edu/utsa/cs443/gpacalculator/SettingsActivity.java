package edu.utsa.cs443.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import edu.utsa.cs443.gpacalculator.R;
import edu.utsa.cs443.gpacalculator.controller.SettingsController;

public class SettingsActivity extends AppCompatActivity {

    private SettingsController settingsController;
    private Switch themeSwitch;

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
    }

    private void saveSettingsToFile() {
        // Get the current state of the notification checkbox and theme switch
        boolean notificationsEnabled = ((CheckBox) findViewById(R.id.notification_checkbox)).isChecked();
        boolean isDarkTheme = ((Switch) findViewById(R.id.theme_switch)).isChecked();

        // Write the settings to a file
        try {
            FileOutputStream fileOutputStream = openFileOutput("settings.txt", MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(notificationsEnabled + "," + isDarkTheme);
            outputStreamWriter.close();
            Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error saving settings", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public Switch getThemeSwitch() {
        if (themeSwitch == null) {
            themeSwitch = findViewById(R.id.theme_switch);
        }
        return themeSwitch;
    }
}

