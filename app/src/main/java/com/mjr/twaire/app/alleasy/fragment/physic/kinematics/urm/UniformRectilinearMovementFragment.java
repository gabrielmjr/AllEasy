package com.mjr.twaire.app.alleasy.fragment.physic.kinematics.urm;

import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.fragment.SubtitlesFragment;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class UniformRectilinearMovementFragment extends SubtitlesFragment {
    @Override
    protected void initializeSubtitles() {
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_displacement1), new URMDisplacement1()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_displacement2), new URMDisplacement2()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_displacement3), new URMDisplacement3()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_displacement4), new URMDisplacement4()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_displacement5), new URMDisplacement5()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_displacement6), new URMDisplacement6()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_speed1), new URMSpeed1()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_speed2), new URMSpeed2()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_time1), new URMTime1()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_time2), new URMTime2()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_time3), new URMTime3()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_time4), new URMTime4()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematic_urm_time5), new URMTime5()));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + getClass().getName();
    }
}
