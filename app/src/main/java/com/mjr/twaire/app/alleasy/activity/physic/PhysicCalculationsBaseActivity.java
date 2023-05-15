package com.mjr.twaire.app.alleasy.activity.physic;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
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
    protected void getViews() {
        dataContainer = findViewById(R.id.data_container);
    }
    
    @Override
    protected void initializeAttributes() {
        dataContainer.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        setTemplateAttributes();
    }
    
    protected abstract void setTemplateAttributes();
    
    protected RecyclerView getDataContainer() {
        return dataContainer;
    }
}
