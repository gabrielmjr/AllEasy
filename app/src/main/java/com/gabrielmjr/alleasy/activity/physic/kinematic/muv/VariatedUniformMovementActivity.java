package com.gabrielmjr.alleasy.activity.physic.kinematic.muv;

import android.os.Bundle;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;

public class VariatedUniformMovementActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeActivity();
    }
    
    private void initializeActivity() {
        setContentView(R.layout.activity_subtitles);
    }
}
