package com.mjr.twaire.app.alleasy.activity;

import android.content.Intent;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.adapter.SubtitlesAdapter;
import com.mjr.twaire.app.alleasy.adapter.SubtitlesAdapter.OnSubtitleClickListener;
import com.mjr.twaire.app.alleasy.model.Subtitle;
import java.util.ArrayList;

public abstract class SubtitleBaseActivity extends BaseActivity implements OnSubtitleClickListener {
    private RecyclerView subtitlesRecycler;
    private SubtitlesAdapter subtitlesAdapter;
    private ArrayList<Subtitle> subtitles;
    
    @Override
    protected void initializeActivity() {
        setContentView(R.layout.activity_subtitles);
    }
    
    @Override
    protected void getViews() {
        setToolBar((Toolbar)findViewById(R.id.toolbar));
        subtitlesRecycler = findViewById(R.id.subtitles_recycler_view);
    }
 
    @Override
    protected void initializeAttributes() {
        subtitles = new ArrayList<>();
        subtitlesAdapter = new SubtitlesAdapter(getApplicationContext(), subtitles, this);
        subtitlesRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subtitlesRecycler.setAdapter(subtitlesAdapter);
        initializeSubtitles();
    }
    
    protected abstract void initializeSubtitles();
    
    @Override
    public void onSubTitleClick(int position) {
    }
    
    protected ArrayList<Subtitle> getSubtitles() {
        return subtitles;
    }
}