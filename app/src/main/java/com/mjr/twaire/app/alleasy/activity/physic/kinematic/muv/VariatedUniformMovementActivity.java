package com.mjr.twaire.app.alleasy.activity.physic.kinematic.muv;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

public class VariatedUniformMovementActivity extends BaseActivity implements Runnable,
OnSubtitleClickListener {
    private RecyclerView subTitlesRecycler;
    private SubtitlesAdapter subTitlesAdapter;
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
        subTitlesRecycler = findViewById(R.id.subtitles_recycler_view);
    }
    
    @Override
    protected void initializeAttributes() {
        subtitles = new ArrayList<>();
        subTitlesAdapter = new SubtitlesAdapter(getApplicationContext(), subtitles, this);
        buildRecyclerView();
    }

    private void buildRecyclerView() {
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_acceleration1), MUV_Acceleration1.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_acceleration2), MUV_Acceleration2.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_acceleration3), MUV_Acceleration3.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_acceleration4), MUV_Acceleration4.class));
      /*  subtitles.add(new Subtitle(getText(R.string.kinematic_muv_displacement1), MUV_Displacement1.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_displacement2), MUV_Displacement2.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_displacement3), MUV_Acceleration3.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_displacement4), MUV_Acceleration4.class));*/
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_speed1), MUV_Speed1.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_speed2), MUV_Speed2.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_speed3), MUV_Speed3.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_speed4), MUV_Speed4.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_time1), MUV_Time1.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_time2), MUV_Time2.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_time3), MUV_Time3.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_time4), MUV_Time4.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_time5), MUV_Time5.class));
        subtitles.add(new Subtitle(getText(R.string.kinematic_muv_time6), MUV_Time6.class));
        subTitlesRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subTitlesRecycler.setAdapter(subTitlesAdapter);
    }

    @Override
    public void onSubTitleClick(int position) {
        startActivity(new Intent(getApplicationContext(), subtitles.get(position).getClassId()));
    }
}
