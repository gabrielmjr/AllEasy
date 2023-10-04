package com.mjr.app.alleasy.physical;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mjr.app.alleasy.core.BaseFragment;
import com.mjr.app.alleasy.physical.adapters.PhysicCalculationsTemplateAdapter;
import com.mjr.app.alleasy.physical.moldels.Data;
import com.mjr.twaire.code.physic.Calculations;

import java.util.ArrayList;

@SuppressLint("ViewConstructor")
public abstract class AbstractPhysicalCalculation extends BaseFragment {
    protected ArrayList<Data> datas;
    public Calculations calculation;
    protected com.mjr.app.alleasy.core.R rFromCore;

    private View root;
    protected RecyclerView dataContainer;
    protected TextView formula;
    protected TextView resolution;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.template_physic_calculation, container, false);
    }

    @Override
    protected void getViews() {
        dataContainer = viewContainer.findViewById(R.id.data_container);
        formula = viewContainer.findViewById(R.id.formula);
        resolution = viewContainer.findViewById(R.id.resolution);
    }

    @Override
    protected void initializeAttributes() {
        datas = new ArrayList<>();
        dataContainer.setAdapter(new PhysicCalculationsTemplateAdapter(requireContext().getApplicationContext(), datas));
        dataContainer.setLayoutManager(new LinearLayoutManager(requireContext().getApplicationContext()));
        setTemplateAttributes();
        onCalculateClickListener();
    }

    @SuppressLint("NotifyDataSetChanged")
    protected abstract void setTemplateAttributes();

    protected abstract void onCalculateClickListener();

    public void setCalculation(Calculations calculation) {
        this.calculation = calculation;
    }

    public void setFormula(@NonNull String formula) {
        this.formula.setText(formula);
    }

    public void setResolution(@NonNull String resolution) {
        this.resolution.setText(resolution);
    }
}
