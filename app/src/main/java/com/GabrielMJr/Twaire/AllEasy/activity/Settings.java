package com.GabrielMJr.Twaire.AllEasy.activity;

// Important imports
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.About;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;
import com.GabrielMJr.Twaire.AllEasy.activity.SendMailActivity;
import java.util.Locale;

public class Settings extends BaseActivity {

    // Atributes
    
    // Shared preferences names
    private SharedPreferences themeSharedPreferences = null;
    private SharedPreferences langSharedPreferences = null;
    
    // Locales codes
    public final String EN_CODE = "en";
    public final String PT_CODE = "pt";

    private LinearLayout theme_changer;
    private LinearLayout language_changer;
    private LinearLayout sendMail; 
    private LinearLayout about;
    
    private TextView cancelTheme;
    private TextView cancelLang;
    private TextView about_text;
    
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    
    private View viewTheme;
    private View viewLang;
    
    // Theme changer
    private RadioGroup radioGroup;
    private RadioButton light_theme;
    private RadioButton dark_theme;
    private RadioButton set_by_system;
    
    // Language changer
    private RadioGroup choose_lang;
    private RadioButton lang_pt;
    private RadioButton lang_en;
    private RadioButton lang_follow_sys;

    private String theme_mode;
    
    private String lang;

    // Name of shared_preferences for app configuration
    public final String SHARED_PREFERENCES_CONFIG_NAME = "app_config";
    
    // Name of sh for app lang
    public final String SHARED_PREFERENCES_CONFIG_LANG_NAME = "lang";

    // Shared preferences editor
    private SharedPreferences.Editor update;
    
    // Name of field for the name of theme
    public final String THEME_NAME = "theme_mode";
    
    // Name of field for the name of lang
    public final String LANG_NAME = "lang";

    // Night, set by system and Light mode final string
    public final String NIGHT_MODE = "night_mode";
    public final String LIGHT_MODE = "dark_mode";
    
    // Lang
    public final String PT = "portuguese";
    public final String EN = "english";
    
    public final String SET_BY_SYSTEM = "set_by_system";

    // Id name of actual theme
    public final String THEME_ID = "theme_id";

    // Id of actual lang
    public final String LANG_ID = "lang_id";
    
    // Locale variable
    private Locale locale;
    
    // Resources variable
    private Resources resources;
    
    // Configurations variable
    private Configuration config;
    
    // Starting activity
    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));  
        theme_changer = findViewById(R.id.theme_changer);
        language_changer = findViewById(R.id.language_changer);
        about_text = findViewById(R.id.about_text);

        // Inflating another layout
        viewTheme = getLayoutInflater().inflate(R.layout.settings_choose_theme_dialog, null);
        viewLang = getLayoutInflater().inflate(R.layout.settings_choose_language_dialog, null);
        
        radioGroup = viewTheme.findViewById(R.id.choose_theme);
        light_theme = viewTheme.findViewById(R.id.light_mode);
        dark_theme = viewTheme.findViewById(R.id.dark_mode);
        set_by_system = viewTheme.findViewById(R.id.system_auto);
        
        cancelTheme = viewTheme.findViewById(R.id.cancel);
        cancelLang = viewLang.findViewById(R.id.cancel);
        
        choose_lang = viewLang.findViewById(R.id.choose_lang);
        lang_pt = viewLang.findViewById(R.id.lang_pt);
        lang_en = viewLang.findViewById(R.id.lang_en);
        lang_follow_sys = viewLang.findViewById(R.id.lang_follow_sys);
        
        sendMail = findViewById(R.id.sendMail);
        about_text.setText(getText(R.string.about) + " " + getString(R.string.app_name));
        sendMail = findViewById(R.id.sendMail);
        about = findViewById(R.id.about);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        initialize();

        // Initializing shared_preference theme
        themeSharedPreferences = getSharedPreferences(SHARED_PREFERENCES_CONFIG_NAME, 0);
        theme_mode = themeSharedPreferences.getString(THEME_NAME, SET_BY_SYSTEM);

        // Initializing SP language
        langSharedPreferences = getSharedPreferences(SHARED_PREFERENCES_CONFIG_LANG_NAME, 0);
        lang = langSharedPreferences.getString(LANG_NAME, SET_BY_SYSTEM);
        
        // For on click of theme changer field:
        theme_changer.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view_s)
                {
                    chooseThemebuilder();
                }
            });
            
         // For on click of language changer field
         language_changer.setOnClickListener(
             new OnClickListener()
             
{
                 @Override
                 public void onClick(View vjew)
                 {
                     chooseLanguageBuilder();
                 }
             });

        // Send email activity
        sendMail.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), SendMailActivity.class));
                }
            });

        // About the app activity
        about.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View vjew)
                {
                    startActivity(new Intent(getApplicationContext(), About.class));
                }
            });
    }

    // show alert dialog with choices
    private void chooseThemebuilder()
    {     
        builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.choose_theme);
        builder.setView(viewTheme);

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
                    SharedPreferences.Editor update = themeSharedPreferences.edit();
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
                    SharedPreferences.Editor update = themeSharedPreferences.edit();
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
                    SharedPreferences.Editor update = themeSharedPreferences.edit();
                    update.putString(THEME_NAME, SET_BY_SYSTEM);
                    update.putInt(THEME_ID, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    update.commit();
                    dialog.dismiss();
                    onBackPressed();
                }
            });
            
        // Cancel button
        cancelTheme.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View View)
                {
                    dialog.dismiss();
                }    
            });
    }
    
    // Choose language builder
    private void chooseLanguageBuilder()
    {
        builder = new AlertDialog.Builder(this);
        builder.setTitle(getText(R.string.choose_language));
        builder.setView(viewLang);
        
        dialog = builder.create();
        dialog.show();
        
        // Setting checked field for the actual theme
        // Set as checked the english lang button
        if (lang.equals(EN))
        {
            lang_en.setChecked(true);

            // Set as checked the dark button
        }
        else if (lang.equals(PT))
        {
            lang_pt.setChecked(true);

            // Set as checked the defined by system button
        }
        else if (lang.equals(SET_BY_SYSTEM))
        {
            lang_follow_sys.setChecked(true);
        }
        
        // Switch to en lang when the button is clicked
        lang_en.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    // Update language
                    setLang(EN_CODE, getApplicationContext());
                    
                    update = langSharedPreferences.edit();
                    
                    // Save into sharedPreferences
                    update.putString(LANG_NAME, EN);
                    update.putString(LANG_ID, EN_CODE);
                    update.commit();
                    dialog.dismiss();
                    restartApp(getApplicationContext());
                }
            });

        // Switch to portuguese language when the button is clicked
        lang_pt.setOnClickListener(
            new OnClickListener() { 
                @Override
                public void onClick(View view)
                {
                    // Update language
                    setLang(PT_CODE, getApplicationContext());

                    update = langSharedPreferences.edit();

                    // Save into sharedPreferences
                    update.putString(LANG_NAME, PT);
                    update.putString(LANG_ID, PT_CODE);
                    update.commit();
                    dialog.dismiss();
                    restartApp(getApplicationContext());                      
                }
            });

        // Switch to set by system
        lang_follow_sys.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                   // Update language
                    setLang(EN_CODE, getApplicationContext());

                    update = langSharedPreferences.edit();
                    
                   // Save into sharedPreferences
                    
                    update.clear();
                    update.commit();
                    dialog.dismiss();
                    restartApp(getApplicationContext());
                }
            });
    }

    // Set language method
    public void setLang(String langCode, Context context)
    {
        // Set locale
        locale = new Locale(langCode);
        locale.setDefault(locale);
        
        // Get resources
        resources = getResources();
        config = resources.getConfiguration();
        
        // Set configuration
        config.setLocale(locale);
        
        // And finally update resources
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
    
    // Restart app method
    public void restartApp(Context context) 
    {
        Process.killProcess(Process.myPid());
        finishAndRemoveTask();
        startActivity(getIntent());
    }
    
    // Get actual language method
    public String getLang(Context context)
    {
         return context.getResources().getConfiguration().locale.getLanguage();
    }
}
