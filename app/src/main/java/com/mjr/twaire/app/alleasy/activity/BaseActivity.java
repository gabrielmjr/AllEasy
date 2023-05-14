package com.mjr.twaire.app.alleasy.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public abstract class BaseActivity extends AppCompatActivity implements Runnable {
    protected Handler handler;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeThisAttributes();
        initializeActivity();
        getHandler().postDelayed(this, 150);
    }
    
    private void initializeThisAttributes() {
        handler = new Handler(getMainLooper());
    }
    
    protected abstract void initializeActivity();
    
    protected abstract void getViews();
    
    protected abstract void initializeAttributes();
    
    @Override
    public void run() {
        getViews();
        initializeAttributes();
        setListeners();
    }
    
	private Toolbar setNavigationOnToolbar(Toolbar toolbar) {
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
        return toolbar;
	}
    
    protected void setListeners() {
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
    
	protected Toolbar setToolBar(Toolbar toolbar) {
		return setNavigationOnToolbar(toolbar);
	}
    
    protected Handler getHandler() {
        return handler;
    }
}
