package com.mjr.twaire.app.alleasy.activity.physic.kinematic.urm;

import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.SubtitleBaseActivity;
import com.mjr.twaire.app.alleasy.fragment.SubtitlesFragment;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class UniformRectilinearMovementActivity extends SubtitlesFragment {
    private static final String TAG = ".fragment.physic.kinematic.urm.UniformRectilinearMovementActivity";
    
    @Override
    protected void initializeSubtitles() {
        /*getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_displacement1), MRU_Displacement1.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_displacement2), MRU_Displacement2.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_displacement3), MRU_Displacement3.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_displacement_law), MRU_Displacement_Law.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_initial_displacement), MRU_Initial_Displacement.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_final_displacement), MRU_Final_Displacement.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_speed1), MRU_Speed1.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_speed2), MRU_Speed2.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_time1), MRU_Time1.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_time2), MRU_Time2.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_time3), MRU_Time3.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_initial_time), MRU_Initial_Time.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_final_time), MRU_Final_Time.class));*/
    }
    
    public static String getFragmentTag() {
        return TAG;
    }
}
