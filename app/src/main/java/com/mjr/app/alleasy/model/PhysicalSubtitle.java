package com.mjr.app.alleasy.model;

import com.mjr.app.alleasy.R;
import com.mjr.app.alleasy.activity.AbstractPhysicalCalculation;
import com.mjr.app.alleasy.fragment.BaseFragment;

import androidx.annotation.NonNull;

public class PhysicalSubtitle extends Subtitle {

    public  PhysicalSubtitle(@NonNull BaseFragment fragment) {
        String formula = ((AbstractPhysicalCalculation)fragment).calculation.getFormula();
        label = context.getText(R.string.calculate_using) + " " + formula;
        this.fragment = fragment;
    }

    public PhysicalSubtitle(CharSequence label, BaseFragment fragment) {
        this.label = label;
        this.fragment = fragment;
    }
}