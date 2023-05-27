package com.mjr.twaire.app.alleasy.fragment.physic.hydrodynamics.fluidflow;

import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.fragment.SubtitlesFragment;
import com.mjr.twaire.app.alleasy.model.Subtitle;

public class FluidFlowFragment extends SubtitlesFragment {
    @Override
    protected void initializeSubtitles() {
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow_area), new Area1()));
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow_flow_rate1), new FlowRate1()));
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow_flow_rate2), new FlowRate2()));
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow_flow_rate3), new  FlowRate3()));
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow_ray), new Ray1()));
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow_velocity1), new Speed1()));
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow_velocity2), new Speed2()));
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow_time), new Time1()));
        getSubtitles().add(new Subtitle(getText(R.string.fluid_flow_volume), new Volume1()));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + getClass().getName();
    }
}
