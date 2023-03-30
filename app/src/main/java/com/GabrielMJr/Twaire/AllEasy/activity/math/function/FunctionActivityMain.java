package com.GabrielMJr.Twaire.AllEasy.activity.math.function;

import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;

public class FunctionActivityMain extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeActivity();
	}
	
	private void initializeActivity() {
		setContentView(R.id.card_main);
	}
}
