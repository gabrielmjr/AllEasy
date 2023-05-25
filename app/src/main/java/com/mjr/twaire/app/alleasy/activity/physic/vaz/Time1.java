package com.mjr.twaire.app.alleasy.activity.physic.vaz;

import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.model.Data;

public class Time1 extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("V = ", "m³"));
        getDatas().add(new Data("Q = ", "m³/s"));
    }
}