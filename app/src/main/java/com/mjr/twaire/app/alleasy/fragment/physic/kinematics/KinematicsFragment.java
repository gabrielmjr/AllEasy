package com.mjr.twaire.app.alleasy.fragment.physic.kinematics;

import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.fragment.SubtitlesFragment;
import com.mjr.twaire.app.alleasy.fragment.physic.kinematics.urm.UniformRectilinearMovementFragment;
import com.mjr.twaire.app.alleasy.fragment.physic.kinematics.vum.VariatedUniformMovementFragment;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class KinematicsFragment extends SubtitlesFragment {
    @Override
    protected void initializeSubtitles() {
        getSubtitles().add(new Subtitle(getText(R.string.uniform_rectilinear_movement), new UniformRectilinearMovementFragment()));
        getSubtitles().add(new Subtitle(getText(R.string.variated_uniform_movement), new VariatedUniformMovementFragment()));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + getClass().getName();
    }
}
