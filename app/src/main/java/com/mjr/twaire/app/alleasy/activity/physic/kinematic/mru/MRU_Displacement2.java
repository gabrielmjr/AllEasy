package com.mjr.twaire.app.alleasy.activity.physic.kinematic.urm;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class MRU_Displacement2 extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("∆t = ", "s"));
        getDatas().add(new Data("v = ", "m/s"));
    }
}
