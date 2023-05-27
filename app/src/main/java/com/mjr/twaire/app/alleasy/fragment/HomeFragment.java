package com.mjr.twaire.app.alleasy.fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.fragment.physic.hydrodynamics.HydrodynamicsFragment;
import com.mjr.twaire.app.alleasy.fragment.physic.kinematics.KinematicsFragment;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class HomeFragment extends SubtitlesFragment {
    @Override
    protected void initializeSubtitles() {
       /* optionsItems.add(new Subtitle(getText(R.string.combinatorial_analysis), .class));*/
        getSubtitles().add(new Subtitle(getText(R.string.hydrodynamics), new HydrodynamicsFragment()));
        getSubtitles().add(new Subtitle(getText(R.string.kinematics), new KinematicsFragment()));
        getSubtitlesContainer().setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 3));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + "/" + getClass().getName();
    }
}
