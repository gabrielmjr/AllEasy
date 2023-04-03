package com.GabrielMJr.Twaire.AllEasy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;
import android.os.Build;

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
}
