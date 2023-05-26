package com.mjr.twaire.app.alleasy.fragment.physic.kinematics.urm;

import com.mjr.twaire.app.alleasy.fragment.physic.PhysicCalculations;
import com.mjr.twaire.app.alleasy.model.Data;

public class URMTime4 extends PhysicCalculations {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("∆t = ", "s"));
        getDatas().add(new Data("t = ", "s"));
    }
    
    @Override
    public String getFragmentTag() {
        return getClass().getPackage().getName() + getClass().getName();
    }
}
