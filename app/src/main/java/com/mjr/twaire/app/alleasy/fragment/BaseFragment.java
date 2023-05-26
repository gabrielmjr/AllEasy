package com.mjr.twaire.app.alleasy;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import com.mjr.twaire.app.alleasy.adapter.SubtitlesAdapter;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public abstract class BaseFragment extends Fragment implements SubtitlesAdapter.OnSubtitleClickListener {
    private View viewContainer;
    
    @Override
    @MainThread
    public void onViewCreated(View viewContainer, Bundle savedInstanceState) {
        super.onViewCreated(viewContainer, savedInstanceState);
        this.viewContainer = viewContainer;
        getViews();
        initializeAttributes();
    }
    
    protected abstract void getViews();
    
    protected abstract void initializeAttributes();
    
    protected void replaceFragment(Subtitle subtitle) {
        getActivity().getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.view_container, subtitle.getClassId(), subtitle.getTag())
            .commit();
    }
    
    protected View getViewContainer() {
        return viewContainer;
    }
}