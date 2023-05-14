package com.mjr.twaire.app.alleasy.activity.physic.kinematic.muv;

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

public class VariatedUniformMovementActivity extends BaseActivity implements Runnable,
OnSubtitleClickListener {
    private RecyclerView subTitlesRecycler;
    private SubTitlesAdapter subTitlesAdapter;
    private List<Activity> subTitles;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    protected void initializeActivity() {
        setContentView(R.layout.activity_subtitles);
    }

    @Override
    protected void getViews() {
        setToolBar((Toolbar)findViewById(R.id.toolbar));
        subTitlesRecycler = findViewById(R.id.subtitles_recycler_view);
    }
    
    @Override
    protected void initializeAttributes() {
        subTitles = new ArrayList<>();
        subTitlesAdapter = new SubTitlesAdapter(getApplicationContext(), subTitles, this);
        buildRecyclerView();
    }

    private void buildRecyclerView() {
        subTitles.add(new Activity(getText(R.string.kinematic_mru_displacement1), MUV_Acceleration1.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_displacement2), MUV_Acceleration2.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_displacement3), MUV_Acceleration3.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_displacement_law), MUV_Acceleration4.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_initial_displacement), MUV_Speed1.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_final_displacement), MUV_Speed2.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_speed1), MUV_Speed3.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_speed2), MUV_Speed4.class));
        /*subTitles.add(new Activity(getText(R.string.kinematic_mru_time1), MUV_Time1.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_time2), MUV_Time2.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_time3), MUV_Time3.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_initial_time), MUV_Time4.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_final_time), MUV_Time5.class));
        subTitles.add(new Activity(getText(R.string.kinematic_mru_final_time), MUV_Time6.class));*/
        subTitlesRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subTitlesRecycler.setAdapter(subTitlesAdapter);
    }

    @Override
    public void onSubTitleClick(int position) {
        startActivity(new Intent(getApplicationContext(), subTitles.get(position).getClassId()));
    }
}
