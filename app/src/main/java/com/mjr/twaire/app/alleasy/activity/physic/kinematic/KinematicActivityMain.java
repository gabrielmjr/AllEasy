package com.mjr.twaire.app.alleasy.activity.physic.kinematic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;
import com.mjr.twaire.app.alleasy.activity.physic.kinematic.mru.UniformRectilinearMovementActivity;
import com.mjr.twaire.app.alleasy.activity.physic.kinematic.muv.VariatedUniformMovementActivity;
import com.mjr.twaire.app.alleasy.adapter.SubTitlesAdapter;
import com.mjr.twaire.app.alleasy.adapter.SubTitlesAdapter.OnSubtitleClickListener;
import com.mjr.twaire.app.alleasy.model.Activity;
import java.util.ArrayList;
import java.util.List;

public class KinematicActivityMain extends BaseActivity implements OnSubtitleClickListener {
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
