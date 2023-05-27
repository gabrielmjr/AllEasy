package com.mjr.twaire.app.alleasy.fragment.physic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.BaseFragment;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.adapter.PhysicCalculationsTemplateAdapter;
import com.mjr.twaire.app.alleasy.model.Data;
import java.util.ArrayList;

public abstract class PhysicCalculations extends BaseFragment {
    private ArrayList<Data> datas;
    private PhysicCalculationsTemplateAdapter adapter;
    private RecyclerView dataContainer;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.template_physic_calculation, container, false);
    }
        
    @Override
    protected void getViews() {
        dataContainer = getViewContainer().findViewById(R.id.data_container);
    }

    @Override
    protected void initializeAttributes() {
        datas = new ArrayList<>();
        adapter = new PhysicCalculationsTemplateAdapter(getActivity().getApplicationContext(), datas);
        dataContainer.setAdapter(adapter);
        dataContainer.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        setTemplateAttributes();
    }
    
    protected abstract void setTemplateAttributes();
    
    protected ArrayList<Data> getDatas() {
        return datas;
    }
    
    protected PhysicCalculationsTemplateAdapter getAdapter() {
        return adapter;
    }
}