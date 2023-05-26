package com.mjr.twaire.app.alleasy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.BaseFragment;
import com.mjr.twaire.app.alleasy.adapter.MainAdapter;
import com.mjr.twaire.app.alleasy.model.Subtitle;
import java.util.ArrayList;

public abstract class SubtitlesFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    private ArrayList<Subtitle> optionsItems;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    
    @Override
    protected void getViews() {
        recyclerView = getViewContainer().findViewById(R.id.main_recycler_view);
    }

    @Override
    protected void initializeAttributes() {
        optionsItems = new ArrayList<>();
        mainAdapter = new MainAdapter(getActivity().getApplicationContext(), optionsItems, this);
        recyclerView.setAdapter(mainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        initializeSubtitles();
    }

    protected abstract void initializeSubtitles();
    
    protected RecyclerView getSubtitlesContainer() {
        return recyclerView;
    }
    
    protected MainAdapter getMainAdapter() {
        return mainAdapter;
    }
    
    protected ArrayList<Subtitle> getSubtitles() {
        return optionsItems;
    }
    
    @Override
    public void onOptionsClick(int position) {
        replaceFragment(optionsItems.get(position));
    }
}