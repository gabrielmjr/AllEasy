package com.mjr.twaire.app.alleasy.activity.physic.vaz;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class Speed2 extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("Q = ", "m³/s"));
        getDatas().add(new Data("r = ", "m"));
        getDatas().add(new Data("π = ", "3.14"));
    }
}