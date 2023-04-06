package com.gabrielmjr.alleasy.activity.math.combinatorial_analysis;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;
import com.gabrielmjr.alleasy.adapter.SubTitlesAdapter;
import com.gabrielmjr.alleasy.adapter.SubTitlesAdapter.OnSubtitleClickListener;
import com.gabrielmjr.alleasy.model.Activity;
import java.util.ArrayList;
import java.util.List;

public class CombinatorialAnalysisActivityMain extends BaseActivity implements OnSubtitleClickListener,
Runnable {
    private Toolbar toolbar;
    private RecyclerView subTitleRecycler;
    private SubTitlesAdapter subtitlesAdapter;
    
    private List<Activity> subTitles;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeActivity();
        getViews();
        Handler handler = new Handler();
        handler.postDelayed(this, 300);
	}
	
	private void initializeActivity () {
		setContentView(R.layout.activity_subtitle);
	}
    
    @Override
    public void run() {
        initializeAttributes();
        buildRecyclerView();
    }
    
    private void getViews() {
        toolbar = findViewById(R.id.toolbar);
        subTitleRecycler = findViewById(R.id.subtitle_recycler_view);
    }
    
    private void initializeAttributes() {
        setToolBar(toolbar);
        subTitles = new ArrayList<>();
        subtitlesAdapter = new SubTitlesAdapter(getApplicationContext(), subTitles, this);
    }
    
    private void buildRecyclerView() {
        subTitles.add(new Activity(getText(R.string.arranjments), Arranjos.class));
        subTitles.add(new Activity(getText(R.string.combinatorial_analysis), Combination.class));
        subTitles.add(new Activity(getText(R.string.factorial), Fatorial.class));
        subTitleRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subTitleRecycler.setAdapter(subtitlesAdapter);
        subtitlesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSubTitleClick(int position) {
        startActivity(new Intent(getApplicationContext(), subTitles.get(position).getClassId()));
    }
}
