package com.mjr.twaire.app.alleasy.activity.physic.kinematic.mru;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;
import com.mjr.twaire.app.alleasy.adapter.SubtitlesAdapter;
import com.mjr.twaire.app.alleasy.adapter.SubtitlesAdapter.OnSubtitleClickListener;
import com.mjr.twaire.app.alleasy.model.Subtitle;
import java.util.ArrayList;
import java.util.List;

public class UniformRectilinearMovementActivity extends BaseActivity implements OnSubtitleClickListener {
    private Toolbar toolbar;
    private RecyclerView subTitlesRecycler;
    private SubtitlesAdapter subTitlesAdapter;
    private List<Subtitle> subTitles;
    
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
        toolbar = findViewById(R.id.toolbar);
        subTitlesRecycler = findViewById(R.id.subtitles_recycler_view);
    }
    
    @Override
    protected void initializeAttributes() {
        subTitles = new ArrayList<>();
        setToolBar(toolbar);
        subTitlesAdapter = new SubtitlesAdapter(getApplicationContext(), subTitles, this);
        buildRecyclerView();
    }
    
    private void buildRecyclerView() {
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_displacement1), MRU_Displacement1.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_displacement2), MRU_Displacement2.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_displacement3), MRU_Displacement3.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_displacement_law), MRU_Displacement_Law.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_initial_displacement), MRU_Initial_Displacement.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_final_displacement), MRU_Final_Displacement.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_speed1), MRU_Speed1.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_speed2), MRU_Speed2.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_time1), MRU_Time1.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_time2), MRU_Time2.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_time3), MRU_Time3.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_initial_time), MRU_Initial_Time.class));
        subTitles.add(new Subtitle(getText(R.string.kinematic_mru_final_time), MRU_Final_Time.class));
        subTitlesRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subTitlesRecycler.setAdapter(subTitlesAdapter);
    }

    @Override
    public void onSubTitleClick(int position) {
        startActivity(new Intent(getApplicationContext(), subTitles.get(position).getClassId()));
    }
}
