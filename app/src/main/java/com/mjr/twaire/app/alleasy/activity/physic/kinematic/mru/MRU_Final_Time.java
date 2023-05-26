package com.mjr.twaire.app.alleasy.activity.physic.kinematic.urm;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class MRU_Final_Time extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("ti = ", "s"));
        getDatas().add(new Data("∆t = ", "s"));
    }
}
