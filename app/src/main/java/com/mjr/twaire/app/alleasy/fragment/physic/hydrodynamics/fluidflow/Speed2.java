package com.mjr.twaire.app.alleasy.fragment.physic.hydrodynamics.fluidflow;

import com.mjr.twaire.app.alleasy.fragment.physic.PhysicCalculations;
import com.mjr.twaire.app.alleasy.model.Data;

public class Speed2 extends PhysicCalculations {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("V = ", "m³"));
        getDatas().add(new Data("Q = ", "m³/s"));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + getClass().getName();
    }
}
