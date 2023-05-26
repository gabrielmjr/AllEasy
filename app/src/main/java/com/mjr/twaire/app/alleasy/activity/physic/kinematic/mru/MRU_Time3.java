package com.mjr.twaire.app.alleasy.activity.physic.kinematic.urm;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class MRU_Time3 extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("Si = ", "s"));
        getDatas().add(new Data("S = ", "s"));
        getDatas().add(new Data("∆v = ú", "m/s"));
    }
}
