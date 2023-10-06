package com.mjr.app.alleasy.physics.fragments.kinematics;

import com.mjr.app.alleasy.physics.R;
import com.mjr.app.alleasy.physics.fragments.kinematics.urm.UniformRectilinearMovementFragment;
import com.mjr.app.alleasy.physics.fragments.kinematics.vum.VariatedUniformMovementFragment;
import com.mjr.app.alleasy.core.SubtitlesFragment;
import com.mjr.app.alleasy.core.model.Subtitle;

public class KinematicsFragment extends SubtitlesFragment {
    @Override
    protected void initializeSubtitles() {
        getSubtitles().add(new Subtitle(getText(R.string.uniform_rectilinear_movement), new UniformRectilinearMovementFragment()));
        getSubtitles().add(new Subtitle(getText(R.string.variated_uniform_movement), new VariatedUniformMovementFragment()));
    }
}
