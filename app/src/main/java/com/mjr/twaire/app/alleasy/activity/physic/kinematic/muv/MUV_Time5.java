package com.mjr.twaire.app.alleasy.activity.physic.kinematic.muv;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class MUV_Time5 extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("ti = ", "s"));
        getDatas().add(new Data("∆v = ", "m/s"));
        getDatas().add(new Data("a = ", "m/s²"));
    }
}