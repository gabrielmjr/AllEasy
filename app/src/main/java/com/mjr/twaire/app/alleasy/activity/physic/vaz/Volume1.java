package com.mjr.twaire.app.alleasy.activity.physic.vaz;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.adapter.PhysicCalculationsTemplateAdapter;
import com.mjr.twaire.app.alleasy.model.Data;
import java.util.ArrayList;

public class Volume1 extends PhysicCalculationsBaseActivity {
    private ArrayList<Data> datas;
    private PhysicCalculationsTemplateAdapter adapter;

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
        super.getViews();
        setToolBar((Toolbar) findViewById(R.id.toolbar));
    }

    @Override
    protected void initializeAttributes() {
        datas = new ArrayList<>();
        adapter = new PhysicCalculationsTemplateAdapter(getApplicationContext(), datas);
        super.initializeAttributes();
    }
    
    @Override
    protected void setTemplateAttributes() {
        datas.add(new Data("∆t = ", "s"));
        datas.add(new Data("Q = ", "m³/s"));
        getDataContainer().setAdapter(adapter);
    }
}
