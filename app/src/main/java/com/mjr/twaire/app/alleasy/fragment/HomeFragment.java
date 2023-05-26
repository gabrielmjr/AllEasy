package com.mjr.twaire.app.alleasy.fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.fragment.physic.kinematic.KinematicMainFragment;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class HomeFragment extends SubtitlesFragment {
    private static final String TAG = ".fragment.home";
    
    @Override
    protected void initializeSubtitles() {
       /* optionsItems.add(new Subtitle(getText(R.string.combinatorial_analysis), .class));
        optionsItems.add(new Subtitle(getText(R.string.kinematics), FluidFlow_ActivityMain.class));*/
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow), new KinematicMainFragment(), KinematicMainFragment.getFragmentTag()));
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow), new KinematicMainFragment(), KinematicMainFragment.getFragmentTag()));
        getSubtitlesContainer().setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 3));
    }
    
    public static String getFragmentTag() {
        return TAG;
    }
}