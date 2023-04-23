package edu.utsa.cs443.gpacalculator.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs443.gpacalculator.R;
import edu.utsa.cs443.gpacalculator.HelpActivity;

public class SettingsController implements View.OnClickListener {

    private final AppCompatActivity activity;
    private final Switch themeSwitch;

    public SettingsController(AppCompatActivity activity) {
        this.activity = activity;

        // Set up the click listeners for the buttons and switches
        Button aboutButton = activity.findViewById(R.id.about_button);
        Button helpButton = activity.findViewById(R.id.help_button);
        themeSwitch = activity.findViewById(R.id.theme_switch);

        aboutButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);
        themeSwitch.setOnClickListener(this);

        // Set the initial state of the theme switch
        SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
        boolean isDarkTheme = preferences.getBoolean("isDarkTheme", false);
        themeSwitch.setChecked(isDarkTheme);
        if (isDarkTheme) {
            activity.setTheme(R.style.DarkTheme_GpaCalculator);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_button:
                showAbout();
                break;
            case R.id.help_button:
                showHelpScreen();
                break;
            case R.id.theme_switch:
                toggleTheme();
                break;
        }
    }


    private void showAbout() {
        // Display the "about" message
        String message = "This app was created by Group 8 consisting of Diego Ayala, Esteban Leal, and Georgy Vinogradov, to help and simplify the hassle of calculating ones GPA";
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
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
}
