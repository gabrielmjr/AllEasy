package com.gabrielmjr.alleasy.activity.physic.vaz;

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

public class FluidFlow_ActivityMain extends BaseActivity implements Runnable,
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
        subTitles.add(new Activity(getText(R.string.fluid_flow_area), Area1.class));
        subTitles.add(new Activity(getText(R.string.fluid_flow_flow_rate1), FlowRate1.class));
        subTitles.add(new Activity(getText(R.string.fluid_flow_flow_rate2), FlowRate2.class));
        subTitles.add(new Activity(getText(R.string.fluid_flow_flow_rate3), FlowRate3.class));
        subTitles.add(new Activity(getText(R.string.fluid_flow_ray), Ray1.class));
        subTitles.add(new Activity(getText(R.string.fluid_flow_velocity1), Speed1.class));
        subTitles.add(new Activity(getText(R.string.fluid_flow_velocity2), Speed2.class));
        subTitles.add(new Activity(getText(R.string.fluid_flow_time), Time1.class));
        subTitles.add(new Activity(getText(R.string.fluid_flow_volume), Volume1.class));
        subTitlesRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subTitlesRecycler.setAdapter(subTitlesAdapter);
    }

    @Override
    public void onSubTitleClick(int position) {
        startActivity(new Intent(getApplicationContext(), subTitles.get(position).getClassId()));
    }
}
