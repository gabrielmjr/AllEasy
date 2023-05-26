package com.mjr.twaire.app.alleasy;

import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;
import com.mjr.twaire.app.alleasy.fragment.HomeFragment;

public class MainActivity extends BaseActivity {
    @Override
    protected void initializeActivity() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void getViews() {
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    }
    
    @Override
    protected void initializeAttributes() {
        super.initializeAttributes();
            getSupportFragmentManager().beginTransaction()
            .replace(R.id.view_container, new HomeFragment(), HomeFragment.getFragmentTag())
            .commitNow();
    }
}
