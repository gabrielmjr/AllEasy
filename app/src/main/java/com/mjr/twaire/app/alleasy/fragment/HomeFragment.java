package com.mjr.twaire.app.alleasy.fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.physic.kinematic.KinematicActivityMain;
import com.mjr.twaire.app.alleasy.adapter.MainAdapter;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class HomeFragment extends SubtitlesFragment implements MainAdapter.OnOptionsClickListener {
    private static final String TAG = ".fragment.home";
    
    @Override
    protected void initializeSubtitles() {
       /* optionsItems.add(new Subtitle(getText(R.string.combinatorial_analysis), .class));
        optionsItems.add(new Subtitle(getText(R.string.kinematics), FluidFlow_ActivityMain.class));*/
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow), new KinematicActivityMain(), KinematicActivityMain.getFragmentTag()));
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow), new KinematicActivityMain(), KinematicActivityMain.getFragmentTag()));
        getSubtitlesContainer().setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 3));
    }
    
    public static String getFragmentTag() {
        return TAG;
    }
}