package com.gabrielmjr.alleasy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;
import android.os.Build;
import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity {
    private void onNavigationClickListener (View view) {}
    
	private Toolbar setNavigationOnToolbar(Toolbar toolbar) {
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
        return toolbar;
	}
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
    
    

	protected Toolbar setToolBar(Toolbar toolbar) {
		return setNavigationOnToolbar(toolbar);
	}
}
