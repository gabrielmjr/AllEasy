package com.mjr.twaire.app.alleasy.activity.physic.kinematic.mru;

import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.SubtitleBaseActivity;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class UniformRectilinearMovementActivity extends SubtitleBaseActivity {
    @Override
    protected void initializeSubtitles() {
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_displacement1), MRU_Displacement1.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_displacement2), MRU_Displacement2.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_displacement3), MRU_Displacement3.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_displacement_law), MRU_Displacement_Law.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_initial_displacement), MRU_Initial_Displacement.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_final_displacement), MRU_Final_Displacement.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_speed1), MRU_Speed1.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_speed2), MRU_Speed2.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_time1), MRU_Time1.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_time2), MRU_Time2.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_time3), MRU_Time3.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_initial_time), MRU_Initial_Time.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_mru_final_time), MRU_Final_Time.class));
    }
}