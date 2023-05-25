package com.mjr.twaire.app.alleasy.activity.physic.kinematic.muv;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;

public class MUV_Acceleration4 extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initializeActivity() {
        setContentView(R.layout.template_physic_calculation);
	}

	@Override
    protected void getViews() {
		setToolBar((Toolbar) findViewById(R.id.toolbar));
	}

    @Override
    protected void initializeAttributes() {
    }
}
