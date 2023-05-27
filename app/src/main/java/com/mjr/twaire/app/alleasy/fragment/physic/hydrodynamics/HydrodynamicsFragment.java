package com.mjr.twaire.app.alleasy.fragment.physic.hydrodynamics;

import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.fragment.SubtitlesFragment;
import com.mjr.twaire.app.alleasy.fragment.physic.hydrodynamics.fluidflow.FluidFlowFragment;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class HydrodynamicsFragment extends SubtitlesFragment {
    @Override
    protected void initializeSubtitles() {
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow), new FluidFlowFragment()));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + getClass().getName();
    }
}
