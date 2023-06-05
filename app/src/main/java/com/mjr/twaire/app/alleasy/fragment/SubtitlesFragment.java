package com.mjr.twaire.app.alleasy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.BaseFragment;
import com.mjr.twaire.app.alleasy.adapter.SubtitlesAdapter;
import com.mjr.twaire.app.alleasy.model.Subtitle;
import java.util.ArrayList;

public abstract class SubtitlesFragment extends BaseFragment implements SubtitlesAdapter.OnSubtitleClickListener {
    private RecyclerView recyclerView;
    private SubtitlesAdapter adapter;
    private ArrayList<Subtitle> optionsItems;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subtitles, container, false);
    }
    
    @Override
    protected void getViews() {
        recyclerView = getViewContainer().findViewById(R.id.subtitles_recycler_view);
    }

    @Override
    protected void initializeAttributes() {
        optionsItems = new ArrayList<>();
        adapter = new SubtitlesAdapter(getActivity().getApplicationContext(), optionsItems, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        initializeSubtitles();
    }

    protected abstract void initializeSubtitles();
    
    protected RecyclerView getSubtitlesContainer() {
        return recyclerView;
    }
    
    protected SubtitlesAdapter getAdapter() {
        return adapter;
    }
    
    protected ArrayList<Subtitle> getSubtitles() {
        return optionsItems;
    }
    
    @Override
    public void onSubtitleClick(int position) {
        replaceFragment(optionsItems.get(position));
    }
}