package com.GabrielMJr.Twaire.AllEasy.app;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;

public class About extends MyActivity
{
    
    // Attributes
    private static TextView app_name;
    private static TextView app_version;
    private static Button license;
    
   // About the app activity
   @Override
   protected void onCreate(Bundle savedInstabceStatus)
   {
       super.onCreate(savedInstabceStatus);
       setContentView(R.layout.about);
       setToolBar((Toolbar)findViewById(R.id.toolbar));
       
       initialize();
   }

   // Initialize
   private void initialize()
   {
       app_name = findViewById(R.id.app_name);
       app_version = findViewById(R.id.app_version);
       license = findViewById(R.id.license);
   }
   
   // Setting app name
 /*  private void setAppInfo()
   {
       // Getting texts with the default app string + app info
       String name = app_name.getText().toString();
       String version = app_version.getText().toString();
       
       // Getting the app version
       try
       {
           PackageInfo pi = getApplicationContext().getPackageManager().getPackageInfo(getApplicationCont
       }
       catch (PackageManager.NameNotFoundException e)
       {});

       app_name.setText(name + getText(R.string.app_name));
       app_version.setText(version + 
   }
    */
}
