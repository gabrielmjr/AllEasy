package com.gabrielmjr.alleasy.activity.physic.vaz;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;

public class Time1 extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initializeAttributes() {
        setContentView(R.layout.activity_physic_calculations);
    }
    
    @Override
    protected void getViews() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
    }

    @Override
    protected void initializeActivity() {
    }
}

