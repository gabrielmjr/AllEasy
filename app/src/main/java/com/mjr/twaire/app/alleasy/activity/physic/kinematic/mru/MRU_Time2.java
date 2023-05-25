package com.mjr.twaire.app.alleasy.activity.physic.kinematic.mru;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class MRU_Time2 extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("∆S = ", "m"));
        getDatas().add(new Data("∆v = ", "m/s"));
    }
}