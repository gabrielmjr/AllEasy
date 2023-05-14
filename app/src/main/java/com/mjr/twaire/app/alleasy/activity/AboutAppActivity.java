package com.mjr.twaire.app.alleasy.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.api.ResponseIF;
import com.mjr.twaire.app.alleasy.api.UpdateChecker;
import com.mjr.twaire.app.alleasy.util.AppInfo;
import com.mjr.twaire.app.alleasy.util.Constants;
import com.mjr.twaire.app.alleasy.util.DateNormalizer;
import java.util.HashMap;

public class AboutAppActivity extends BaseActivity implements Runnable,
ResponseIF, OnClickListener {
    private TextView appName;
    private TextView appVersion;
    private TextView updaterStatus;
    private TextView copyright;
    private TextView appDownloadName;
    private Button license;
    private Button updateCheckerButton;
    private ConstraintLayout downloadButton;

    private UpdateChecker updateChecker;
    private UpdateChecker.DownloadApp downloadApp;

    private AppInfo appInfo;
    private int versionCode;

    @Override
    protected void onCreate(Bundle savedInstanceStatus) {
        super.onCreate(savedInstanceStatus);
    }

    @Override
    protected void initializeActivity() {
        setContentView(R.layout.about);
    }

    @Override 
    protected void getViews() {
        appName = findViewById(R.id.app_name);
        appVersion = findViewById(R.id.app_version);
        updateCheckerButton = findViewById(R.id.check_update);
        updaterStatus = findViewById(R.id.updater_status);
        copyright = findViewById(R.id.copyright);
        license = findViewById(R.id.license);
        downloadButton = findViewById(R.id.download_button);
        appDownloadName = findViewById(R.id.app_download_name);
    }

    @Override
    protected void initializeAttributes() {
        appInfo = new AppInfo(getApplicationContext());
        updateChecker = new UpdateChecker(getApplicationContext(), this);
        downloadApp = updateChecker.getDownloadApp();
        setToolBar((Toolbar)findViewById(R.id.toolbar));
        setAppInfo();
        setCopyright();
        setListeners();
    }

    @Override
    protected void setListeners() {
        updateCheckerButton.setOnClickListener(this);
        downloadButton.setOnClickListener(this);
        license.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.check_update:
                updateChecker.checkUpdate();
                break;
            case R.id.download_button:
                downloadApp();
                break;
            case R.id.license:
                showLicense();
                break;
        }
    }

    private void downloadApp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getPackageManager().checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, getPackageName()) == PackageManager.PERMISSION_GRANTED)
                downloadApp.start();
            else
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, Constants.WRITE_EXTERNAL_SD);
        } else
            downloadApp.start();
    }

    private void showLicense() {
        Toast.makeText(getApplicationContext(), getString(R.string.illselicense), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(HashMap api_info) {
        versionCode = (Integer)api_info.get(Constants.TAG);
        if (versionCode > appInfo.getVersionCode()) {
            updaterStatus.setBackgroundResource(R.drawable.ic_edge_button_blue);
            updaterStatus.setText(R.string.update_available);
            downloadButton.setVisibility(View.VISIBLE);
            appDownloadName.setText(updateChecker.getReleaseName());
        } else if (versionCode == appInfo.getVersionCode()) {
            updaterStatus.setBackgroundResource(R.drawable.ic_edge_button_green);
            updaterStatus.setText(R.string.updated);
            downloadButton.setVisibility(View.GONE);
        }
    }

    @Override
    public void onErrorResponse() {
        updaterStatus.setBackgroundResource(R.drawable.ic_edge_button_red);
        updaterStatus.setText(R.string.unable_to_check_update);
        downloadButton.setVisibility(View.GONE);
    }

    @Override
    public void onJSONError() {}

    private void setAppInfo() {
        appName.setText(appName.getText().toString() + " " + getText(R.string.app_name));
        this.appVersion.setText(appVersion.getText().toString() + " " + appInfo.getAppVersion()
                                + " (" + appInfo.getVersionCode() + ")");
    }

    private void setCopyright() {
        int actualYear = DateNormalizer.getYear();
        int createdYear = Integer.valueOf(getText(R.integer.creation_year).toString());
        String finalYear;
        String copyright;
        if (actualYear == createdYear)
            finalYear = String.valueOf(createdYear);
        else
            finalYear = createdYear + "-" + actualYear;
        copyright = getText(R.string.copyright) + " " + finalYear + " " + getText(R.string.owner);
        this.copyright.setText(copyright);
    }
}
