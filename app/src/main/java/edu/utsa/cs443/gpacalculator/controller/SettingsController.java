package edu.utsa.cs443.gpacalculator.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import edu.utsa.cs443.gpacalculator.AboutActivity;
import edu.utsa.cs443.gpacalculator.HelpActivity;
import edu.utsa.cs443.gpacalculator.R;
import edu.utsa.cs443.gpacalculator.SettingsActivity;

public class SettingsController implements View.OnClickListener {

    private final AppCompatActivity activity;
    private final Switch themeSwitch;
    private final Switch notificationSwitch;

    public SettingsController(AppCompatActivity activity) {
        this.activity = activity;

        // Set up the click listeners for the buttons and switches
        Button aboutButton = activity.findViewById(R.id.about_button);
        Button helpButton = activity.findViewById(R.id.help_button);
        themeSwitch = activity.findViewById(R.id.theme_switch);
        notificationSwitch = activity.findViewById(R.id.notification_checkbox);
        Button saveButton = activity.findViewById(R.id.save_button);

        aboutButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);
        themeSwitch.setOnClickListener(this);
        notificationSwitch.setOnClickListener(this);
        saveButton.setOnClickListener(this);

        // Set the initial state of the switches
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        boolean isDarkTheme = preferences.getBoolean("isDarkTheme", false);
        boolean isNotificationEnabled = preferences.getBoolean("isNotificationEnabled", true);
        themeSwitch.setChecked(isDarkTheme);
        notificationSwitch.setChecked(isNotificationEnabled);
        if (isDarkTheme) {
            activity.setTheme(R.style.DarkTheme_GpaCalculator);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_button:
                showAboutScreen();
                break;
            case R.id.help_button:
                showHelpScreen();
                break;
            case R.id.theme_switch:
                toggleTheme();
                break;
            case R.id.notification_checkbox:
                toggleNotification();
                break;
            case R.id.save_button:
                saveSettings();
                break;
        }
    }

    private void showAboutScreen() {
        Intent intent = new Intent(activity, AboutActivity.class);
        activity.startActivity(intent);
    }

    public void showHelpScreen() {
        Intent intent = new Intent(activity, HelpActivity.class);
        activity.startActivity(intent);
    }

    private void toggleTheme() {
        // Get the current theme from shared preferences
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        boolean isDarkTheme = preferences.getBoolean("isDarkTheme", false);

        // Set the opposite theme in shared preferences
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isDarkTheme", !isDarkTheme);
        editor.apply();

        // Apply the new theme
        if (!isDarkTheme) {
            activity.setTheme(R.style.DarkTheme_GpaCalculator);
        } else {
            activity.setTheme(R.style.Theme_GpaCalculator);
        }

        // Restart the activity to apply the new theme
        Intent intent = activity.getIntent();
        activity.finish();
        activity.startActivity(intent);
    }

    private void toggleNotification() {
        // Get the current notification setting from shared preferences
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        boolean isNotificationEnabled = preferences.getBoolean("isNotificationEnabled", true);

        // Set the opposite notification setting in shared preferences
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isNotificationEnabled", !isNotificationEnabled);
        editor.apply();

        // Show  a toast to inform the user of the new notification setting
        if (!isNotificationEnabled) {
            Toast.makeText(activity, "Notifications enabled", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(activity, "Notifications disabled", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveSettings() {
        // Get the current settings from the switches
        boolean isDarkTheme = themeSwitch.isChecked();
        boolean isNotificationEnabled = notificationSwitch.isChecked();

        // Save the settings to shared preferences
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isDarkTheme", isDarkTheme);
        editor.putBoolean("isNotificationEnabled", isNotificationEnabled);
        editor.apply();

        // Save the settings to a file
        try {
            FileOutputStream outputStream = activity.openFileOutput("settings.txt", Context.MODE_PRIVATE);
            outputStream.write(("Dark Theme: " + isDarkTheme + "\n").getBytes());
            outputStream.write(("Notifications: " + isNotificationEnabled + "\n").getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show a toast to inform the user that the settings have been saved
        Toast.makeText(activity, "Settings saved", Toast.LENGTH_SHORT).show();
    }
}
