package com.mjr.twaire.app.alleasy.fragment.physic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.BaseFragment;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.adapter.PhysicCalculationsTemplateAdapter;
import com.mjr.twaire.app.alleasy.model.Data;
import com.mjr.twaire.code.physic.Calculations;
import java.util.ArrayList;

public abstract class PhysicCalculations extends BaseFragment {
    private ArrayList<Data> datas;
    private PhysicCalculationsTemplateAdapter adapter;
    private RecyclerView dataContainer;
    private TextView formula;
    
    private Calculations calculation;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.template_physic_calculation, container, false);
    }
        
    @Override
    protected void getViews() {
        dataContainer = getViewContainer().findViewById(R.id.data_container);
        formula = getViewContainer().findViewById(R.id.formula);
    }

    @Override
    protected void initializeAttributes() {
        datas = new ArrayList<>();
        adapter = new PhysicCalculationsTemplateAdapter(getActivity().getApplicationContext(), datas);
        dataContainer.setAdapter(adapter);
        dataContainer.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        setTemplateAttributes();
        setFormula();
    }
    
    protected abstract void setTemplateAttributes();
    
    protected void setFormula() {
        formula.setText(calculation.getFormula());
    }
    
    protected ArrayList<Data> getDatas() {
        return datas;
    }
    
    protected void setFormula(String formula) {
        this.formula.setText(formula);
    }
    
    protected String getFormula() {
        return formula.getText().toString();
    }
    
    protected PhysicCalculationsTemplateAdapter getAdapter() {
        return adapter;
    }
    
    public void setCalculation(Calculations calculation) {
        this.calculation = calculation;
    }
    
    public Calculations getCalculation() {
        return calculation;
    }
}