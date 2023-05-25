package com.mjr.twaire.app.alleasy.activity.physic.kinematic.muv;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class MUV_Acceleration4 extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("vi = ", "m/s"));
        getDatas().add(new Data("v = ", "m/s"));
        getDatas().add(new Data("ti =", "s"));
        getDatas().add(new Data("t = ", "s"));
    }
}