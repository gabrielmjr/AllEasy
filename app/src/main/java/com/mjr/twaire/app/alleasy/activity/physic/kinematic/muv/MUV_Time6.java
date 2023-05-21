package com.mjr.twaire.app.alleasy.activity.physic.kinematic.muv;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.adapter.PhysicCalculationsTemplateAdapter;
import com.mjr.twaire.app.alleasy.model.Data;
import java.util.ArrayList;

public class MUV_Time6 extends PhysicCalculationsBaseActivity {
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
		setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
	}

    @Override
    protected void initializeAttributes() {
        datas = new ArrayList<>();
        adapter = new PhysicCalculationsTemplateAdapter(getApplicationContext(), datas);
        super.initializeAttributes();
    }

    @Override
    protected void setTemplateAttributes() {
        datas.add(new Data("ti = ", "s"));
        datas.add(new Data("vi = ", "m/s"));
        datas.add(new Data("v = ", "m/s"));
        datas.add(new Data("a = ", "m/s²"))
        getDataContainer().setAdapter(adapter);
    }
}
