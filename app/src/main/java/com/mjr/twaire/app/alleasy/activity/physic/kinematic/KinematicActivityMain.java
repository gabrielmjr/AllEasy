package com.mjr.twaire.app.alleasy.activity.physic.kinematic;

import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.SubtitleBaseActivity;
import com.mjr.twaire.app.alleasy.activity.physic.kinematic.mru.UniformRectilinearMovementActivity;
import com.mjr.twaire.app.alleasy.activity.physic.kinematic.muv.VariatedUniformMovementActivity;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class KinematicActivityMain extends SubtitleBaseActivity {
    @Override
    protected void initializeSubtitles() {
        getSubtitles().add(new Subtitle(getText(R.string.uniform_rectilinear_movement), UniformRectilinearMovementActivity.class));
        getSubtitles().add(new Subtitle(getText(R.string.variated_uniform_movement), VariatedUniformMovementActivity.class));
    }
}