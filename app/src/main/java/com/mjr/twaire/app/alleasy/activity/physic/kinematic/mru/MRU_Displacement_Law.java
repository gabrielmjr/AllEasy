package com.mjr.twaire.app.alleasy.activity.physic.kinematic.urm;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class MRU_Displacement_Law extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("Si = ", "m"));
        getDatas().add(new Data("v = ", "m/s"));
        getDatas().add(new Data("∆t = ", "s"));
    }
}
