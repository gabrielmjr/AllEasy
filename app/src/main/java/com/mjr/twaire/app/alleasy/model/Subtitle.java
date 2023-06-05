package com.mjr.twaire.app.alleasy.model;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.mjr.twaire.app.alleasy.BaseFragment;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.fragment.physic.PhysicCalculations;

public class Subtitle {
    private static Context context;
    private CharSequence label;
    private BaseFragment fragment;
    private String tag;

    public Subtitle(@NonNull BaseFragment fragment) {
        String formula = ((PhysicCalculations)fragment).getCalculation().getFormula();
        label = context.getText(R.string.calculate_using) + "\n" + formula;
        this.fragment = fragment;
        this.tag = fragment.getFragmentTag();
    }
    
    public Subtitle(@NonNull CharSequence label, @NonNull BaseFragment fragment) {
        this.label = label;
        this.fragment = fragment;
        this.tag = fragment.getFragmentTag();
    }

    public void setLabel(@NonNull CharSequence label) {
        this.label = label;
    }

    @NonNull
    public CharSequence getLabel() {
        return label;
    }

    public void setClassId(@NonNull BaseFragment fragment) {
        this.fragment = fragment;
    }

    @NonNull
    public Fragment getClassId() {
        return fragment;
    }

    @NonNull
    public String getTag() {
        return this.tag;
    }

    public void setTag(@NonNull String tag) {
        this.tag = tag;
    }
    
    @Nullable
    public static Context getContext() {
        return context;
    }
    
    public static void setContext(@Nullable Context c) {
        context = c;
    }
}
