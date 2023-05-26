package com.mjr.twaire.app.alleasy.fragment.physic.kinematic;

import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.physic.kinematic.muv.VariatedUniformMovementActivity;
import com.mjr.twaire.app.alleasy.activity.physic.kinematic.urm.UniformRectilinearMovementActivity;
import com.mjr.twaire.app.alleasy.fragment.SubtitlesFragment;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class KinematicMainFragment extends SubtitlesFragment {
    public static final String TAG = ".fragment.physic.kinematic.KinematicMainFragment";
    
    @Override
    protected void initializeSubtitles() {
        //getSubtitles().add(new Subtitle(getText(R.string.uniform_rectilinear_movement), new UniformRectilinearMovementActivity(), UniformRectilinearMovementActivity.getFragmentTag()));
        getSubtitles().add(new Subtitle(getText(R.string.variated_uniform_movement), new VariatedUniformMovementActivity(), VariatedUniformMovementActivity.getFragmentTag()));
    }
    
    public static String getFragmentTag() {
        return TAG;
    }
}
