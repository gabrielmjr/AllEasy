package com.mjr.twaire.app.alleasy.activity.physic.vaz;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class Volume1 extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("∆t = ", "s"));
        getDatas().add(new Data("Q = ", "m³/s"));
    }
}