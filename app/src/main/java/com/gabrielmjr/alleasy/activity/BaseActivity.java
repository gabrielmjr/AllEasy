package com.gabrielmjr.alleasy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;
import android.os.Build;

public class BaseActivity extends AppCompatActivity {
    private void onNavigationClickListener (View view) {}
    
	private Toolbar setNavigationOnToolbar(Toolbar toolbar) {
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		toolbar.setNavigationOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					onNavigationClickListener(view);
				}
			});
		return toolbar;
	}

	protected Toolbar setToolBar(Toolbar toolbar) {
		return setNavigationOnToolbar(toolbar);
	}
}
