package com.gabrielmjr.alleasy.activity.physic.kinematic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.UniformRectilinearMovementActivity;
import com.gabrielmjr.alleasy.activity.physic.kinematic.muv.VariatedUniformMovementActivity;
import com.gabrielmjr.alleasy.adapter.SubTitlesAdapter;
import com.gabrielmjr.alleasy.adapter.SubTitlesAdapter.OnSubtitleClickListener;
import com.gabrielmjr.alleasy.model.Activity;
import java.util.ArrayList;
import java.util.List;

public class KinematicActivityMain extends BaseActivity implements Runnable,
OnSubtitleClickListener {
    private Toolbar toolbar;
    private RecyclerView subTitlesRecycler;
    private SubTitlesAdapter subTitlesAdapter;
    private List<Activity> subTitles;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeActivity();
        getViews();
        Handler handler = new Handler();
        handler.postDelayed(this, 150);
    }
    
    private void initializeActivity() {
        setContentView(R.layout.activity_subtitles);
    }
    
    private void getViews() {
        toolbar = findViewById(R.id.toolbar);
        subTitlesRecycler = findViewById(R.id.subtitles_recycler_view);
    }
    
    @Override
    public void run() {
        initializeAttributes();
        buildRecyclerView();
    }
    
    private void initializeAttributes() {
        subTitles = new ArrayList<>();
        subTitlesAdapter = new SubTitlesAdapter(getApplicationContext(), subTitles, this);
        setToolBar(toolbar);
    }
    
    private void buildRecyclerView() {
        subTitles.add(new Activity(getText(R.string.uniform_rectilinear_movement), UniformRectilinearMovementActivity.class));
        subTitles.add(new Activity(getText(R.string.variated_uniform_movement), VariatedUniformMovementActivity.class));
        subTitlesRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subTitlesRecycler.setAdapter(subTitlesAdapter);
    }
    
    @Override
    public void onSubTitleClick(int position) {
        startActivity(new Intent(getApplicationContext(), subTitles.get(position).getClassId()));
    }
}
