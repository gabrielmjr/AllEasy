package com.mjr.twaire.app.alleasy.activity.physic.vaz;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class FlowRate2 extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("A = ", "m²"));
        getDatas().add(new Data("v = ", "m/s"));
    }
}