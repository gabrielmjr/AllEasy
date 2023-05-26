package com.mjr.twaire.app.alleasy.activity.physic.kinematic.urm;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.physic.PhysicCalculationsBaseActivity;
import com.mjr.twaire.app.alleasy.adapter.PhysicCalculationsTemplateAdapter;
import com.mjr.twaire.app.alleasy.model.Data;
import java.util.ArrayList;

public class MRU_Final_Displacement extends PhysicCalculationsBaseActivity {
    @Override
    protected void setTemplateAttributes() {
        getDatas().add(new Data("Si = ", "m"));
        getDatas().add(new Data("∆S = ", "m"));
    }
}
