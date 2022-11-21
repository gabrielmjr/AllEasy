package com.GabrielMJr.Twaire.AllEasy.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyMainActivity;
import com.GabrielMJr.Twaire.AllEasy.app.Settings;
import com.GabrielMJr.Twaire.AllEasy.databaseManager.DataManager;
import com.GabrielMJr.Twaire.AllEasy.math.Arranjos;
import com.GabrielMJr.Twaire.AllEasy.math.Combination;
import com.GabrielMJr.Twaire.AllEasy.math.FSG;
import com.GabrielMJr.Twaire.AllEasy.math.Fatorial;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.Kinematic_ActivityMain;
import com.GabrielMJr.Twaire.AllEasy.physic.vaz.FluidFlow_ActivityMain;
import com.GabrielMJr.Twaire.AllEasy.tools.DialogAlertData;
import java.util.Locale;
//import android.app.AlertDialog;


public class MainActivity extends MyMainActivity
{

    // Atributes
    private static CardView arranjos;
    private static CardView comb;
    private static CardView fat;
    private static CardView fsg;
    private static CardView vaz;
    private static CardView kinematic;
    private static TextView welcome;
    private static Toolbar toolbar;

    private static String title;
    private static String message;
    private static final String DB_NAME = "app_info";
    private static final String TB_NAME = "version_info";
    private static int updaterStatus;
    private static int lastChoosenTheme;
    private static String lastChoosenLang;

    private static DataManager DM;
    private static DialogAlertData dialogAlertData;
    private static Drawable icon;
    private static int versionCode;
    private static PackageInfo packageInfo;
    private static Handler handler;
    private final Context context = this;
    // private static MyActivity activity;
    private static Settings settings;
    private static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
                @Override
                public void run()
                {
                    settings = new Settings();
                    //settings.loadTheme();

                    //Loading theme
                    sharedPreferences = getSharedPreferences(settings.SHARED_PREFERENCES_CONFIG_NAME, 0);                
                    lastChoosenTheme = sharedPreferences.getInt(settings.THEME_ID, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    if (AppCompatDelegate.getDefaultNightMode() != lastChoosenTheme)
                    {
                        AppCompatDelegate.setDefaultNightMode(lastChoosenTheme);
                        //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        recreate();
                    }
                    
                    // Loading language
                    sharedPreferences = getSharedPreferences(settings.SHARED_PREFERENCES_CONFIG_LANG_NAME, 0);
                    lastChoosenLang = sharedPreferences.getString(settings.LANG_ID, null);
                    if (lastChoosenLang != null && lastChoosenLang != settings.getLang(getApplicationContext()))
                    {
                        // Set locale
                        Locale locale = new Locale(lastChoosenLang);
                        locale.setDefault(locale);

                        // Get resources
                        Resources resources = getResources();
                        Configuration config = resources.getConfiguration();

                        // Set configuration
                        config.setLocale(locale);

                        // And finally update resources
                        resources.updateConfiguration(config, resources.getDisplayMetrics());
                        
                      //  settings.restartApp(getApplicationContext());
                    }

                    setContentView(R.layout.splash_screen);


                    try
                    {
                        packageInfo = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
                        versionCode = packageInfo.versionCode;
                    }
                    catch (PackageManager.NameNotFoundException e)
                    {}

                    DM = new DataManager(getApplicationContext(), DB_NAME, TB_NAME);
                    updaterStatus = DM.initialize(versionCode);

                    if (updaterStatus == 2)
                    {
                        welcome = findViewById(R.id.welcome);
                        welcome.setText(R.string.welcome);
                    }
                    
                    dialogAlertData = new DialogAlertData(context);
                }
            }, 1);
            

            handler.postDelayed(new Runnable() {
                    @Override
                    public void run()
                    {
                        setTheme(R.style.AppTheme);
                        setContentView(R.layout.activity_main);
                        toolbar = findViewById(R.id.toolbar);
                        setSupportActionBar(toolbar);

                        arranjos = findViewById(R.id.arrj);
                        comb = findViewById(R.id.comb);
                        fat = findViewById(R.id.fat);
                        fsg = findViewById(R.id.fsg);
                        vaz = findViewById(R.id.vaz);
                        kinematic = findViewById(R.id.kinematic);

                        if (updaterStatus == -1)
                        {

                        }
                        else if (updaterStatus == 0)
                        {

                        }
                        else if (updaterStatus == 1)
                        {
                            title = (String)getText(R.string.update_title);
                            message = (String)getText(R.string.update_message);
                            icon = getDrawable(R.mipmap.ic_launcher);
                            dialogAlertData.alertDialog(title, message, icon).show();
                        }

                        // Abrir aba de "Arranjos" caso o botão arranjos for clicado
                        arranjos.setOnClickListener(
                            new OnClickListener() {
                                public void onClick(View view)
                                {
                                    startActivity(new Intent(getApplicationContext(), Arranjos.class));
                                }
                            });

                        // Abrir aba de "combinação" caso o botão comb for clicado
                        comb.setOnClickListener(
                            new OnClickListener() {
                                public void onClick(View view)
                                {
                                    startActivity(new Intent(getApplicationContext(), Combination.class));
                                }
                            });

                        // Abrir aba de "fatorial" caso o botão fat for clicado
                        fat.setOnClickListener(
                            new OnClickListener() {
                                public void onClick(View view)
                                {
                                    startActivity(new Intent(getApplicationContext(), Fatorial.class));
                                }
                            });

                        // Abrir aba de "Função de segundo grau" caso o botão fsg for clicado
                        fsg.setOnClickListener(
                            new OnClickListener() {
                                public void onClick(View view)
                                {
                                    startActivity(new Intent(getApplicationContext(), FSG.class));
                                }
                            });

                        // Abrir aba de "Vazão" caso  botão vaz for clicado;
                        vaz.setOnClickListener(
                            new OnClickListener(){
                                public void onClick(View view)
                                {
                                    startActivity(new Intent(getApplicationContext(), FluidFlow_ActivityMain.class));
                                }
                            });

                        // Abrir aba de "Cinemática" caso o botão kinematic for clicado
                        kinematic.setOnClickListener( 
                            new OnClickListener() {
                                @Override
                                public void onClick(View view)
                                {
                                    startActivity(new Intent(getApplicationContext(), Kinematic_ActivityMain.class));
                                }
                            });

                    }
                }, 2500);

    }

}
