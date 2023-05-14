package com.mjr.twaire.app.alleasy.activity.math.combinatorial_analysis;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;
import com.mjr.twaire.app.alleasy.adapter.SubTitlesAdapter;
import com.mjr.twaire.app.alleasy.adapter.SubTitlesAdapter.OnSubtitleClickListener;
import com.mjr.twaire.app.alleasy.model.Activity;
import java.util.ArrayList;
import java.util.List;

public class CombinatorialAnalysisActivityMain extends BaseActivity implements OnSubtitleClickListener {
    private Toolbar toolbar;
    private RecyclerView subTitleRecycler;
    private SubTitlesAdapter subtitlesAdapter;
    private List<Activity> subTitles;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
    protected void initializeActivity () {
		setContentView(R.layout.activity_subtitles);
	}
    
    @Override
    protected void getViews() {
        toolbar = findViewById(R.id.toolbar);
        subTitleRecycler = findViewById(R.id.subtitles_recycler_view);
    }
   
    @Override
    protected void initializeAttributes() {
        setToolBar(toolbar);
        subTitles = new ArrayList<>();
        subtitlesAdapter = new SubTitlesAdapter(getApplicationContext(), subTitles, this);
        buildRecyclerView();
    }
    
    private void buildRecyclerView() {
        subTitles.add(new Activity(getText(R.string.arranjments), Arranjos.class));
        subTitles.add(new Activity(getText(R.string.combinatorial_analysis), Combination.class));
        subTitles.add(new Activity(getText(R.string.factorial), Fatorial.class));
        subTitleRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subTitleRecycler.setAdapter(subtitlesAdapter);
    }

    @Override
    public void onSubTitleClick(int position) {
        startActivity(new Intent(getApplicationContext(), subTitles.get(position).getClassId()));
    }
}
