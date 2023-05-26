package com.mjr.twaire.app.alleasy;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import com.mjr.twaire.app.alleasy.adapter.MainAdapter.OnOptionsClickListener;

public abstract class BaseFragment extends Fragment implements OnOptionsClickListener {
    private View viewContainer;
    
    @Override
    public void onOptionsClick(int position) {}
    
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
    
    protected View getViewContainer() {
        return viewContainer;
    }
}
