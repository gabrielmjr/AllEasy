package com.mjr.app.alleasy.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mjr.app.alleasy.R;
import com.mjr.app.alleasy.model.Subtitle;

public abstract class BaseFragment extends Fragment {
    protected View viewContainer;

    @MainThread
    @Override
    public void onViewCreated(@NonNull View viewContainer, Bundle savedInstanceState) {
        super.onViewCreated(viewContainer, savedInstanceState);
        this.viewContainer = viewContainer;
        getViews();
        initializeAttributes();
    }

    protected abstract void getViews();

    protected abstract void initializeAttributes();

    protected void replaceFragment(@NonNull Subtitle subtitle) {
        requireActivity().getSupportFragmentManager()
        .beginTransaction()
        .addToBackStack(subtitle.getFragment().getTag())
        .replace(R.id.view_container, subtitle.getFragment(), subtitle.getFragment().getTag())
        .commit();
    }
}
