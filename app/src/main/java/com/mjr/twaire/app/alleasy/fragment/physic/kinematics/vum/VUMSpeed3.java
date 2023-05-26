package com.mjr.twaire.app.alleasy.fragment.physic.kinematics.vum;

import com.mjr.twaire.app.alleasy.fragment.physic.PhysicCalculations;
import com.mjr.twaire.app.alleasy.model.Data;

public class VUMSpeed3 extends PhysicCalculations {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("v = ", "m/s"));
        getDatas().add(new Data("a = ", "m/s2"));
        getDatas().add(new Data("∆t = ", "s"));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + getClass().getName();
    }
}
