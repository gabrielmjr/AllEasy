package com.mjr.twaire.app.alleasy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.AboutAppActivity;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;
import com.mjr.twaire.app.alleasy.activity.SendMailActivity;
import java.util.Locale;

public class SettingsActivity extends BaseActivity {
    private SharedPreferences themeSharedPreferences = null;
    private SharedPreferences langSharedPreferences = null;

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
    private RadioGroup radioGroup;
    private RadioButton light_theme;
    private RadioButton dark_theme;
    private RadioButton set_by_system;
    private RadioGroup choose_lang;
    private RadioButton lang_pt;
    private RadioButton lang_en;
    private RadioButton lang_follow_sys;

    private String theme_mode;
    private String lang;

    public final String SHARED_PREFERENCES_CONFIG_NAME = "app_config";
    public final String SHARED_PREFERENCES_CONFIG_LANG_NAME = "lang";

    private SharedPreferences.Editor update;

    public final String THEME_NAME = "theme_mode";
    public final String LANG_NAME = "lang";
    public final String NIGHT_MODE = "night_mode";
    public final String LIGHT_MODE = "dark_mode";
    public final String PT = "portuguese";
    public final String EN = "english";
    public final String SET_BY_SYSTEM = "set_by_system";
    public final String THEME_ID = "theme_id";
    public final String LANG_ID = "lang_id";

    private Locale locale;
    private Resources resources;
    private Configuration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*theme_changer.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view_s) {
                    chooseThemebuilder();
                }
            });

        language_changer.setOnClickListener(
            new OnClickListener()

            {
                @Override
                public void onClick(View vjew) {
                    chooseLanguageBuilder();
                }
            });

        sendMail.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), SendMailActivity.class));
                }
            });

        about.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View vjew) {
                    startActivity(new Intent(getApplicationContext(), AboutAppActivity.class));
                }
            });*/
    }

    @Override
    protected void initializeActivity() {
        setContentView(R.layout.settings);
    }

    @Override
    protected void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));  
        theme_changer = findViewById(R.id.theme_changer);
        language_changer = findViewById(R.id.language_changer);
        about_text = findViewById(R.id.about_text);

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
    protected void initializeAttributes() {
        themeSharedPreferences = getSharedPreferences(SHARED_PREFERENCES_CONFIG_NAME, 0);
        theme_mode = themeSharedPreferences.getString(THEME_NAME, SET_BY_SYSTEM);
        langSharedPreferences = getSharedPreferences(SHARED_PREFERENCES_CONFIG_LANG_NAME, 0);
        lang = langSharedPreferences.getString(LANG_NAME, SET_BY_SYSTEM);
        builder = new AlertDialog.Builder(this);
    }

    private void chooseThemebuilder() {     
        builder.setTitle(R.string.choose_theme);
        builder.setView(viewTheme);

        dialog = builder.create();
        dialog.show();

        if (theme_mode.equals(NIGHT_MODE)) {
            dark_theme.setChecked(true);
        } else if (theme_mode.equals(LIGHT_MODE)) {
            light_theme.setChecked(true);

        } else if (theme_mode.equals(SET_BY_SYSTEM)) {
            set_by_system.setChecked(true);
        }

        light_theme.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                    SharedPreferences.Editor update = themeSharedPreferences.edit();
                    update.putString(THEME_NAME, LIGHT_MODE);
                    update.putInt(THEME_ID, AppCompatDelegate.MODE_NIGHT_NO);
                    update.commit();
                    dialog.dismiss();
                    onBackPressed();
                }
            });

        dark_theme.setOnClickListener(
            new OnClickListener() { 
                @Override
                public void onClick(View view) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                    SharedPreferences.Editor update = themeSharedPreferences.edit();
                    update.putString(THEME_NAME, NIGHT_MODE);
                    update.putInt(THEME_ID, AppCompatDelegate.MODE_NIGHT_YES);
                    update.commit();
                    dialog.dismiss();
                    onBackPressed();                              
                }
            });

        set_by_system.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    SharedPreferences.Editor update = themeSharedPreferences.edit();
                    update.putString(THEME_NAME, SET_BY_SYSTEM);
                    update.putInt(THEME_ID, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    update.commit();
                    dialog.dismiss();
                    onBackPressed();
                }
            });

        cancelTheme.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View View) {
                    dialog.dismiss();
                }    
            });
    }

    private void chooseLanguageBuilder() {
        builder.setTitle(getText(R.string.choose_language));
        builder.setView(viewLang);

        dialog = builder.create();
        dialog.show();

        if (lang.equals(EN)) {
            lang_en.setChecked(true);
        } else if (lang.equals(PT)) {
            lang_pt.setChecked(true);
        } else if (lang.equals(SET_BY_SYSTEM)) {
            lang_follow_sys.setChecked(true);
        }
        lang_en.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    setLang(EN_CODE, getApplicationContext());

                    update = langSharedPreferences.edit();

                    update.putString(LANG_NAME, EN);
                    update.putString(LANG_ID, EN_CODE);
                    update.commit();
                    dialog.dismiss();
                    restartApp(getApplicationContext());
                }
            });

        lang_pt.setOnClickListener(
            new OnClickListener() { 
                @Override
                public void onClick(View view) {
                    setLang(PT_CODE, getApplicationContext());

                    update = langSharedPreferences.edit();

                    update.putString(LANG_NAME, PT);
                    update.putString(LANG_ID, PT_CODE);
                    update.commit();
                    dialog.dismiss();
                    restartApp(getApplicationContext());                      
                }
            });

        lang_follow_sys.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    setLang(EN_CODE, getApplicationContext());

                    update = langSharedPreferences.edit();

                    update.clear();
                    update.commit();
                    dialog.dismiss();
                    restartApp(getApplicationContext());
                }
            });
    }

    public void setLang(String langCode, Context context) {
        locale = new Locale(langCode);
        Locale.setDefault(locale);

        resources = getResources();
        config = resources.getConfiguration();

        //config.setLocale(locale);

        //resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

    public void restartApp(Context context) {
        Process.killProcess(Process.myPid());
       // finishAndRemoveTask();
        startActivity(getIntent());
    }

    public String getLang(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage();
    }
}
