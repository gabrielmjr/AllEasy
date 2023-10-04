package com.mjr.app.alleasy.activity.math.function;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mjr.app.alleasy.activity.BaseActivity;
import com.mjr.app.alleasy.core.adapter.SubtitlesAdapter;
import com.mjr.app.alleasy.core.model.Subtitle;
import com.mjr.app.alleasy.R;

import java.util.ArrayList;
import java.util.List;

public class FunctionActivityMain extends BaseActivity implements SubtitlesAdapter.OnSubtitleClickListener {
    private RecyclerView subTitleRecycler;
    private SubtitlesAdapter subtitlesAdapter;
    private List<Subtitle> subTitles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
    }

    @Override
    protected void initializeActivity () {
       // setContentView(R.layout.activity_subtitles);
    }

    @Override
    protected void getViews() {
        setToolBar((Toolbar)findViewById(R.id.toolbar));
        //subTitleRecycler = findViewById(R.id.subtitles_recycler_view);
    }

    @Override 
    protected void initializeAttributes() {
        subTitles = new ArrayList<>();
        subtitlesAdapter = new SubtitlesAdapter(getApplicationContext(), subTitles, this);
        buildRecyclerView();
    }

    private void buildRecyclerView() {
       // subTitles.add(new Subtitle(getText(R.string.second_degree_function), FSG.class));
        subTitleRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subTitleRecycler.setAdapter(subtitlesAdapter);
    }

    @Override
    public void onSubtitleClick(int position) {
      // startActivity(new Intent(getApplicationContext(), subTitles.get(position).getClassId()));
    }
}
