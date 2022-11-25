package com.GabrielMJr.Twaire.AllEasy.app;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.api.Constants;
import com.GabrielMJr.Twaire.AllEasy.api.ResponseIF;
import com.GabrielMJr.Twaire.AllEasy.api.UpdateChecker;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.GabrielMJr.Twaire.AllEasy.databaseManager.DateNormalizer;
import com.GabrielMJr.Twaire.AllEasy.util.AppInfo;
import java.util.HashMap;

public class About extends MyActivity implements ResponseIF
{

    // Attributes
    private TextView app_name;
    private TextView app_version;
    private TextView updater_status;
    private TextView copyright;

    private Button license;
    private Button update_checker;

    private UpdateChecker updateChecker;

    private AppInfo appInfo;
    private int versionCode;

    // About the app activity
    @Override
    protected void onCreate(Bundle savedInstanceStatus)
    {
        super.onCreate(savedInstanceStatus);
        setContentView(R.layout.about);
        setToolBar((Toolbar)findViewById(R.id.toolbar));

        initialize();

        // Check for updates
        update_checker.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    // Start checking from updates
                    updateChecker.checkUpdate();
                }
            });

        license.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Toast.makeText(getApplicationContext(), getString(R.string.illselicense), Toast.LENGTH_LONG).show();
                }
            });
    }

    // Initialize
    private void initialize()
    {
        app_name = findViewById(R.id.app_name);
        app_version = findViewById(R.id.app_version);
        update_checker = findViewById(R.id.check_update);
        updater_status = findViewById(R.id.updater_status);
        copyright = findViewById(R.id.copyright);
        license = findViewById(R.id.license);
        appInfo = new AppInfo(getApplicationContext());
        updateChecker = new UpdateChecker(getApplicationContext(), this);
        setAppInfo();
        setCopyright();
    }

    // If the request returns successful response
    @Override
    public void onResponse(HashMap api_info)
    {
        // Response code of connection
        versionCode = (Integer)api_info.get(Constants.TAG);

        // Update available
        if (versionCode > appInfo.getVersionCode())
        {
            updater_status.setBackground(getDrawable(R.drawable.ic_edge_button_blue));
            updater_status.setText(R.string.update_available);
        }

        // Already updated
        else if (versionCode == appInfo.getVersionCode())
        {
            updater_status.setBackground(getDrawable(R.drawable.ic_edge_button_green));
            updater_status.setText(R.string.updated);
        }
    }

    // If the api returns bad response
    @Override
    public void onErrorResponse()
    {
        // Unable to verify
        updater_status.setBackground(getDrawable(R.drawable.ic_edge_button_red));
        updater_status.setText(R.string.unable_to_check_update);
    }
    
    // Problems with json
    @Override
    public void onJSONError()
    {
        
    }

    // Show license method
    /*private void showLicense()
     {
     setContentView(R.layout.app_license);
     getSupportActionBar().hide();
     }*/



    // Getters and setters
    // Setting app name
    private void setAppInfo()
    {
        // Getting texts with the default app string + app info
        String name = app_name.getText().toString();
        String version = app_version.getText().toString();
        String appVersion = appInfo.getAppVersion() + " ("
            + appInfo.getVersionCode()
            + ")";

        // Setting app name and version into text views
        app_name.setText(name + " " + getText(R.string.app_name));
        app_version.setText((CharSequence) version + " " + appVersion);
    }

    // Adding copyright
    private void setCopyright()
    {
        // Get actual year from datenormalizer and created year from integers xml 
        int actualYear = DateNormalizer.getYear();
        int createdYear =  Integer.valueOf((String) getText(R.integer.creation_year));
        String finalYear = null;
        String CR = null;

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
}
