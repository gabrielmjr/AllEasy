package com.mjr.twaire.app.alleasy.model;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Subtitle {
    private CharSequence label;
    private Fragment activity;
    private String tag;

    public Subtitle(@NonNull CharSequence label, @NonNull Fragment activity, @NonNull String tag) {
        this.label = label;
        this.activity = activity;
        this.tag = tag;
    }

    public Subtitle(@NonNull CharSequence label, @NonNull Fragment activity) {
        this.label = label;
        this.activity = activity;
    }

    public void setLabel(@NonNull CharSequence label) {
        this.label = label;
    }

    @NonNull
    public CharSequence getLabel() {
        return label;
    }

    public void setClassId(@NonNull Fragment activity) {
        this.activity = activity;
    }

    @NonNull
    public Fragment getClassId() {
        return activity;
    }

    @Nullable
    public String getTag() {
        return this.tag;
    }

    public void setTag(@NonNull String tag) {
        this.tag = tag;
    }
}
