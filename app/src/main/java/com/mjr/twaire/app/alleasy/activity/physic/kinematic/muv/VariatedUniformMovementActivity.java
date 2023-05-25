package com.mjr.twaire.app.alleasy.activity.physic.kinematic.muv;

import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.SubtitleBaseActivity;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class VariatedUniformMovementActivity extends SubtitleBaseActivity {
    @Override
    protected void initializeSubtitles() {
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_acceleration1), MUV_Acceleration1.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_acceleration2), MUV_Acceleration2.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_acceleration3), MUV_Acceleration3.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_acceleration4), MUV_Acceleration4.class));
      /*  getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_displacement1), MUV_Displacement1.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_displacement2), MUV_Displacement2.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_displacement3), MUV_Acceleration3.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_displacement4), MUV_Acceleration4.class));*/
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_speed1), MUV_Speed1.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_speed2), MUV_Speed2.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_speed3), MUV_Speed3.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_speed4), MUV_Speed4.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_time1), MUV_Time1.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_time2), MUV_Time2.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_time3), MUV_Time3.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_time4), MUV_Time4.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_time5), MUV_Time5.class));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_muv_time6), MUV_Time6.class));
    }
}