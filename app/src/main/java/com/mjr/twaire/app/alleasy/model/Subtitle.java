package com.mjr.twaire.app.alleasy.model;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.mjr.twaire.app.alleasy.BaseFragment;

public class Subtitle {
    private CharSequence label;
    private BaseFragment fragment;
    private String tag;

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
}
