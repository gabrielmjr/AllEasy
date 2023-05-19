package com.mjr.twaire.app.alleasy.activity.physic.vaz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;
import com.mjr.twaire.app.alleasy.activity.physic.kinematic.mru.UniformRectilinearMovementActivity;
import com.mjr.twaire.app.alleasy.activity.physic.kinematic.muv.VariatedUniformMovementActivity;
import com.mjr.twaire.app.alleasy.adapter.SubtitlesAdapter;
import com.mjr.twaire.app.alleasy.adapter.SubtitlesAdapter.OnSubtitleClickListener;
import com.mjr.twaire.app.alleasy.model.Subtitle;
import java.util.ArrayList;
import java.util.List;

public class FluidFlow_ActivityMain extends BaseActivity implements OnSubtitleClickListener {
    private RecyclerView subtitlesRecycler;
    private SubtitlesAdapter subtitlesAdapter;
    private List<Subtitle> subtitles;
    
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
        subtitlesRecycler = findViewById(R.id.subtitles_recycler_view);
    }

    @Override
    protected void initializeAttributes() {
        subtitles = new ArrayList<>();
        subtitlesAdapter = new SubtitlesAdapter(getApplicationContext(), subtitles, this);
        buildRecyclerView();
    }

    private void buildRecyclerView() {
        subtitles.add(new Subtitle(getText(R.string.fluid_flow_area), Area1.class));
        subtitles.add(new Subtitle(getText(R.string.fluid_flow_flow_rate1), FlowRate1.class));
        subtitles.add(new Subtitle(getText(R.string.fluid_flow_flow_rate2), FlowRate2.class));
        subtitles.add(new Subtitle(getText(R.string.fluid_flow_flow_rate3), FlowRate3.class));
        subtitles.add(new Subtitle(getText(R.string.fluid_flow_ray), Ray1.class));
        subtitles.add(new Subtitle(getText(R.string.fluid_flow_velocity1), Speed1.class));
        subtitles.add(new Subtitle(getText(R.string.fluid_flow_velocity2), Speed2.class));
        subtitles.add(new Subtitle(getText(R.string.fluid_flow_time), Time1.class));
        subtitles.add(new Subtitle(getText(R.string.fluid_flow_volume), Volume1.class));
        subtitlesRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subtitlesRecycler.setAdapter(subtitlesAdapter);
    }

    @Override
    public void onSubTitleClick(int position) {
        startActivity(new Intent(getApplicationContext(), subtitles.get(position).getClassId()));
    }
}
