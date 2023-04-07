package com.gabrielmjr.alleasy.activity.physic.kinematic.mru;

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

public class UniformRectilinearMovementActivity extends BaseActivity implements Runnable,
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
        setToolBar(toolbar);
        subTitlesAdapter = new SubTitlesAdapter(getApplicationContext(), subTitles, this);
    }
    
    private void buildRecyclerView() {
        subTitles.add(new Activity(getText(R.string.kinematic_mru_displacement1), MRU_Displacement1.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_displacement2), MRU_Displacement2.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_displacement3), MRU_Displacement3.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_displacement_law), MRU_Displacement_Law.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_initial_displacement), MRU_Initial_Displacement.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_final_displacement), MRU_Final_Displacement.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_speed1), MRU_Speed1.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_speed2), MRU_Speed2.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_time1), MRU_Time1.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_time2), MRU_Time2.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_time3), MRU_Time3.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_initial_time), MRU_Initial_Time.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_final_time), MRU_Final_Time.class));
        subTitlesRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subTitlesRecycler.setAdapter(subTitlesAdapter);
    }

    @Override
    public void onSubTitleClick(int position) {
        startActivity(new Intent(getApplicationContext(), subTitles.get(position).getClassId()));
    }
}
