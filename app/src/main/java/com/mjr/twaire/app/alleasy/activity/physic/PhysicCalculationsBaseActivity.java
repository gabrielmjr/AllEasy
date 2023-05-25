package com.mjr.twaire.app.alleasy.activity.physic;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;
import com.mjr.twaire.app.alleasy.adapter.PhysicCalculationsTemplateAdapter;
import com.mjr.twaire.app.alleasy.model.Data;
import java.util.ArrayList;

public abstract class PhysicCalculationsBaseActivity extends BaseActivity {
    private ArrayList<Data> datas;
    private PhysicCalculationsTemplateAdapter adapter;
    private RecyclerView dataContainer;
    
    @Override
    protected void initializeActivity() {
        setContentView(R.layout.template_physic_calculation);
    }
    
    @Override
    protected void getViews() {
        dataContainer = findViewById(R.id.data_container);
        setToolBar((Toolbar) findViewById(R.id.toolbar));
    }
    
    @Override
    protected void initializeAttributes() {
        datas = new ArrayList<>();
        adapter = new PhysicCalculationsTemplateAdapter(getApplicationContext(), datas);
        dataContainer.setAdapter(adapter);
        dataContainer.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        setTemplateAttributes();
    }
    
    protected abstract void setTemplateAttributes();
    
    protected ArrayList<Data> getDatas() {
        return datas;
    }
    
    protected PhysicCalculationsTemplateAdapter getAdapter() {
        return adapter;
    }
    
    protected RecyclerView getDataContainer() {
        return dataContainer;
    }
}