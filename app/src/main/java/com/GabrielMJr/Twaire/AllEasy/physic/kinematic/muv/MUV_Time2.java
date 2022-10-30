package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.muv;

import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.support.v7.widget.Toolbar;

public class MUV_Time2 extends MyActivity {


    private void initialize()
    {
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_muv_time2);
        initialize();
    }

}
