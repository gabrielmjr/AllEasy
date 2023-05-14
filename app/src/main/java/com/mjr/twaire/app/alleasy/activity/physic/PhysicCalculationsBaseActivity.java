package com.mjr.twaire.app.alleasy.activity.physic;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;
import com.mjr.twaire.app.alleasy.adapter.PhysicCalculationsTemplateAdapter;

public abstract class PhysicCalculationsBaseActivity extends BaseActivity {
    private RecyclerView dataContainer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    protected void initializeAttributes() {
        dataContainer = findViewById(R.id.data_container);
        setTemplateAttributes();
    }
    
    protected void setTemplateAttributes() {
        
    }
    
}
