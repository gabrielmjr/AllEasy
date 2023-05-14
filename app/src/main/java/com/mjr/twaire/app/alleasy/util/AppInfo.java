package com.mjr.twaire.app.alleasy.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.Context;

public class AppInfo extends AppCompatActivity
{
    // The methods of this class returns the appInfo
    
    // Attributes
    //Package info
    private PackageInfo pi;
    
    private Context context;
    
    // Constructor
    public AppInfo(Context context)
    {
        this.context = context;
        // Package info
        try
        {
            pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        catch (PackageManager.NameNotFoundException e)
        {}
    }
    
    // Get app version
    public String getAppVersion()
    {
        return pi.versionName; 
    }
    
    // Get app version code
    public int getVersionCode()
    {
        return pi.versionCode;
    }
}
