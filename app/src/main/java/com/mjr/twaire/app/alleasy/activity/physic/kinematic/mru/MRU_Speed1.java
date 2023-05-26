package com.mjr.twaire.app.alleasy.activity.physic.kinematic.urm;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class MRU_Speed1 extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("∆S = ", "m"));
        getDatas().add(new Data("∆t = ", "s"));
    }
}
