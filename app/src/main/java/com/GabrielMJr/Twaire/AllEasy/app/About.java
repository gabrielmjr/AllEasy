package com.GabrielMJr.Twaire.AllEasy.app;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.GabrielMJr.Twaire.AllEasy.databaseManager.DateNormalizer;

public class About extends MyActivity
{
    
    // Attributes
    private static TextView app_name;
    private static TextView app_version;
    private static TextView copyright;
    private static Button license;
    
   // About the app activity
   @Override
   protected void onCreate(Bundle savedInstanceStatus)
   {
       super.onCreate(savedInstanceStatus);
       setContentView(R.layout.about);
       setToolBar((Toolbar)findViewById(R.id.toolbar));
       
       initialize();
       
       /*license.setOnClickListener(
           new OnClickListener()
           {
               @Override
               public void onClick(View view)
               {
                   showLicense();
               }
           });*/
   }

   // Initialize
   private void initialize()
   {
       app_name = findViewById(R.id.app_name);
       app_version = findViewById(R.id.app_version);
       copyright = findViewById(R.id.copyright);
       license = findViewById(R.id.license);
       setAppInfo();
       setCopyright();
   }
   
   // Setting app name
   private void setAppInfo()
   {
       // Getting texts with the default app string + app info
       String name = app_name.getText().toString();
       String version = app_version.getText().toString();
       String appVersion = null;
       
       
       // Getting the app version
       try
       {
           PackageInfo pi = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
           appVersion = pi.versionName + " (" + pi.versionCode + ")"; 
       }
       catch (PackageManager.NameNotFoundException e)
       {}

       // Setting app name and version into text views
       app_name.setText(name + " " + getText(R.string.app_name));
       app_version.setText((CharSequence) version + " " + appVersion);
   }
    
   // Adding copyright
   private void setCopyright()
   {
       // Get actual year from datenormalizer and created year from integers xml 
       int actualYear = DateNormalizer.getYear();
       int createdYear =  Integer.valueOf((String) getText( R.integer.creation_year));
       String finalYear = null;
       String CR= null;
       
       // Year to show on about screen
       if (actualYear == createdYear)
       {
           finalYear = String.valueOf(createdYear);
       }
       else
       {
           finalYear = createdYear + "-" + actualYear;
       }
       
       CR = getText(R.string.copyright) + " " + finalYear + " " + getText(R.string.owner);
       
       // Setting the copyright into textview
       copyright.setText((CharSequence) CR);
   }
   
   
   // Show license method
   /*private void showLicense()
   {
       setContentView(R.layout.app_license);
       getSupportActionBar().hide();
   }*/
}
