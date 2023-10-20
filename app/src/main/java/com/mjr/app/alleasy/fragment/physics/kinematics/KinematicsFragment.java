package com.mjr.app.alleasy.fragment.physics.kinematics;

import com.mjr.app.alleasy.R;
import com.mjr.app.alleasy.fragment.SubtitlesFragment;
import com.mjr.app.alleasy.fragment.physics.kinematics.urm.UniformRectilinearMovementFragment;
import com.mjr.app.alleasy.fragment.physics.kinematics.vum.VariatedUniformMovementFragment;
import com.mjr.app.alleasy.model.Subtitle;

public class KinematicsFragment extends SubtitlesFragment {
    @Override
    protected void initializeSubtitles() {
        getSubtitles().add(new Subtitle(getText(R.string.uniform_rectilinear_movement), new UniformRectilinearMovementFragment()));
        getSubtitles().add(new Subtitle(getText(R.string.variated_uniform_movement), new VariatedUniformMovementFragment()));
    }
}
