package com.GabrielMJr.Twaire.AllEasy.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;
import android.os.Build;


// Extends app compat activity and and set the back button on toolbar
public class BaseActivity extends AppCompatActivity {
	private Toolbar setNavigationOnToolbar(Toolbar toolbar) {
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		toolbar.setNavigationOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					onBackPressed();
				}
			});
		return toolbar;
	}

	protected Toolbar setToolBar(Toolbar toolbar) {
		return setNavigationOnToolbar(toolbar);
	}


	// Checker of sdk int
	protected boolean isCompatible() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
			return false;
		} else {
			return true;
		}
	}


}
