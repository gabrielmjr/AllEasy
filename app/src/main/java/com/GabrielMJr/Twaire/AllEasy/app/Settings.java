package com.GabrielMJr.Twaire.AllEasy.app;

// Important imports
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.support.v7.widget.Toolbar;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatDelegate;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.support.v7.app.AlertDialog;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.content.Intent;
import com.GabrielMJr.Twaire.AllEasy.app.MainActivity;

public class Settings extends MyActivity
{

    // Atributes
    private static SharedPreferences sharedPreferences = null;
    private static LinearLayout theme_changer;
    private static TextView cancel;
    private static AlertDialog.Builder builder;
    private static AlertDialog dialog;
    private static View view;
    private static RadioGroup radioGroup;
    private static RadioButton light_theme;
    private static RadioButton dark_theme;
    private static RadioButton set_by_system;
    private static String theme_mode;

    // Name of shared_preferences for app configuration
    public final String SHARED_PREFERENCES_CONFIG_NAME = "app_config";

    // Name of field for the name of theme
    public final String THEME_NAME = "theme_mode";

    // Night, set by system and Light mode final string
    public final String NIGHT_MODE = "night_mode";
    public final String LIGHT_MODE = "dark_mode";
    public final String SET_BY_SYSTEM = "set_by_system";

    // Id name of actual theme
    public final String THEME_ID = "theme_id";


    // Starting activity
    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));  
        theme_changer = findViewById(R.id.theme_changer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        initialize();

        // Starting shared_preference theme for the variables
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_CONFIG_NAME, 0);
        theme_mode = sharedPreferences.getString(THEME_NAME, SET_BY_SYSTEM);


        // For on click of theme changer field:
        theme_changer.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view_s)
                {
                    chooseThemebuilder();
                }
            });
    }

    // show alert dialog with choices
    private void chooseThemebuilder()
    {     
        builder = new AlertDialog.Builder(this);

        // Inflating another layout
        view = getLayoutInflater().inflate(R.layout.settings_choose_theme_dialog, null);

        radioGroup = view.findViewById(R.id.choose_theme);
        light_theme = view.findViewById(R.id.light_mode);
        dark_theme = view.findViewById(R.id.dark_mode);
        set_by_system = view.findViewById(R.id.system_auto);
        cancel = view.findViewById(R.id.cancel);

        builder.setTitle(R.string.choose_theme);
        builder.setView(view);

        dialog = builder.create();
        dialog.show();

        // Setting checked field for the actual theme
        // Set as checked the light button
        if (theme_mode.equals(NIGHT_MODE))
        {
            dark_theme.setChecked(true);

            // Set as checked the dark button
        }
        else if (theme_mode.equals(LIGHT_MODE))
        {
            light_theme.setChecked(true);

            // Set as checked the defined by system button
        }
        else if (theme_mode.equals(SET_BY_SYSTEM))
        {
            set_by_system.setChecked(true);
        }



        // Switch to light theme when the button is clicked
        light_theme.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                    // Update sharedpreferences on theme_config to light
                    SharedPreferences.Editor update = sharedPreferences.edit();
                    update.putString(THEME_NAME, LIGHT_MODE);
                    update.putInt(THEME_ID, AppCompatDelegate.MODE_NIGHT_NO);
                    update.commit();
                    dialog.dismiss();
                    onBackPressed();
                }
            });

        // Switch to dark mode when the dark button is clicked
        dark_theme.setOnClickListener(
            new OnClickListener() { 
                @Override
                public void onClick(View view)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                    // Update sharedpreferences on theme_config to dark
                    SharedPreferences.Editor update = sharedPreferences.edit();
                    update.putString(THEME_NAME, NIGHT_MODE);
                    update.putInt(THEME_ID, AppCompatDelegate.MODE_NIGHT_YES);
                    update.commit();
                    dialog.dismiss();
                    onBackPressed();                              
                }
            });

        // Switch to set by system
        set_by_system.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

                    // Update sharedpreferences on theme_config to set by system
                    SharedPreferences.Editor update = sharedPreferences.edit();
                    update.putString(THEME_NAME, SET_BY_SYSTEM);
                    update.putInt(THEME_ID, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    update.commit();
                    dialog.dismiss();
                    onBackPressed();
                }
            });
    }

}
