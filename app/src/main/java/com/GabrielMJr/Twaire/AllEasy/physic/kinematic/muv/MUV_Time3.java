package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.muv;

import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.support.v7.widget.Toolbar;

public class MUV_Time3 extends MyActivity 
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physic_calculations);
        getViews();
    }


	private void getViews()
	{
		setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
	}

}
