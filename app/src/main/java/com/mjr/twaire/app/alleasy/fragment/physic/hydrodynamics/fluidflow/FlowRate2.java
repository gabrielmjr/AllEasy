package com.mjr.twaire.app.alleasy.fragment.physic.hydrodynamics.fluidflow;

import com.mjr.twaire.app.alleasy.fragment.physic.PhysicCalculations;
import com.mjr.twaire.app.alleasy.model.Data;

public class FlowRate2 extends PhysicCalculations {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("A = ", "m²"));
        getDatas().add(new Data("v = ", "m/s"));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + getClass().getName();
    }
}
