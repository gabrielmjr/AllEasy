package com.GabrielMJr.Twaire.AllEasy.activity.physic.kinematic.muv;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;

public class MUV_Time1 extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
    }


	private void getViews() {
		setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
	}
}