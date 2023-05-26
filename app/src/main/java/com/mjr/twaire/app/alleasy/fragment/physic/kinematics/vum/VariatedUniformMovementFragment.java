package com.mjr.twaire.app.alleasy.fragment.physic.kinematics.vum;

import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.fragment.SubtitlesFragment;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class VariatedUniformMovementFragment extends SubtitlesFragment {
    @Override
    protected void initializeSubtitles() {
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_acceleration1), new VUMAcceleration1()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_acceleration2), new VUMAcceleration2()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_acceleration3), new VUMAcceleration3()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_acceleration4), new VUMAcceleration4()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_speed1), new VUMSpeed1()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_speed2), new VUMSpeed2()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_speed3), new VUMSpeed3()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_speed4), new VUMSpeed4()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_time1), new VUMTime1()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_time2), new VUMTime2()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_time3), new VUMTime3()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_time4), new VUMTime4()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_time5), new VUMTime5()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_vum_time6), new VUMTime6()));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + getClass().getName();
    }
}
