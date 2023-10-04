package com.mjr.app.alleasy.physical.moldels;

import com.mjr.app.alleasy.core.BaseFragment;
import com.mjr.app.alleasy.core.model.Subtitle;
import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation;

import static com.mjr.app.alleasy.core.R.string.calculate_using;

import androidx.annotation.NonNull;

public class PhysicalSubtitle extends Subtitle {

    public  PhysicalSubtitle(@NonNull BaseFragment fragment) {
        String formula = ((AbstractPhysicalCalculation)fragment).calculation.getFormula();
        label = context.getText(calculate_using) + " " + formula;
        this.fragment = fragment;
    }

    public PhysicalSubtitle(CharSequence label, BaseFragment fragment) {
        this.label = label;
        this.fragment = fragment;
    }
}