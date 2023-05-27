package com.mjr.twaire.app.alleasy.fragment.physic.hydrodynamics.fluidflow;

import com.mjr.twaire.app.alleasy.fragment.physic.PhysicCalculations;
import com.mjr.twaire.app.alleasy.model.Data;

public class FlowRate3 extends PhysicCalculations {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("r = ", "m"));
        getDatas().add(new Data("v = ", "m/s"));
        getDatas().add(new Data("π = ", "3.14"));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + getClass().getName();
    }
}
