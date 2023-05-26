package com.mjr.twaire.app.alleasy.fragment.physic.kinematics.vum;

import com.mjr.twaire.app.alleasy.fragment.physic.PhysicCalculations;
import com.mjr.twaire.app.alleasy.model.Data;

public class VUMTime2 extends PhysicCalculations {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("vi = ", "m/s"));
        getDatas().add(new Data("v = ", "m/s"));
        getDatas().add(new Data("a = ", "m/s²"));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + getClass().getName();
    }
}
