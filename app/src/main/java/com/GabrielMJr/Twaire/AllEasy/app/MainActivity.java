package com.GabrielMJr.Twaire.AllEasy.app;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.math.Arranjos;
import com.GabrielMJr.Twaire.AllEasy.math.Combination;
import com.GabrielMJr.Twaire.AllEasy.math.Fatorial;
import com.GabrielMJr.Twaire.AllEasy.math.FSG;
import com.GabrielMJr.Twaire.AllEasy.physic.vaz.FluidFlow_ActivityMain;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.Kinematic_ActivityMain;
import com.GabrielMJr.Twaire.AllEasy.databaseManager.DataManager;
import com.GabrielMJr.Twaire.AllEasy.tools.DialogAlertData;
import com.GabrielMJr.Twaire.AllEasy.app.MyMainActivity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.content.Context;
import android.support.v7.widget.Toolbar;

public class MainActivity extends MyMainActivity
    {

        // Atributes
        private static TextView arranjos;
        private static TextView comb;
        private static TextView fat;
        private static TextView fsg;
        private static TextView vaz;
        private static TextView kinematic;
        private static TextView welcome;
        private static Toolbar toolbar;

        private static DataManager DM;
        private static DialogAlertData dialogAlertData;
        private static final String DB_NAME = "app_info";
        private static final String TB_NAME = "version_info";
        private static String title;
        private static String message;
        private static Drawable icon;
        private static int versionCode;
        private static PackageInfo packageInfo;
        private static Handler handler;
        private static int updaterStatus;
        private final Context context = this;

        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setTheme(R.style.BlackField);
                setContentView(R.layout.splash_screen);

                handler = new Handler();
                handler.postDelayed(new Runnable() {
                            @Override
                            public void run()
                                {
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
