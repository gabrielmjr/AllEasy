package com.GabrielMJr.Twaire.AllEasy.physic.kinematic;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.MRU;

public class MRU_Displacement_Law extends MyActivity {

    private static EditText initial_displacement;
    private static EditText speed;
    private static EditText delta_time;
    private static TextView displacement;
    private static TextView res;
    
    private static int verifyInitialDisplacement;
    private static int verifySpeed;
    private static int verifyDeltaTime;
    private static double initialDisplacement;
    private static double speedValue;
    private static double deltaTime;
    private static Tools tools;
    private static MRU mru;

    private void initialize () {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.initial_displacement = findViewById(R.id.initial_displacement);
        this.speed = findViewById(R.id.speed);
        this.delta_time = findViewById(R.id.delta_time);
        this.displacement = findViewById(R.id.displacement);
        this.res = findViewById(R.id.res);
        
        this.tools = new Tools();
        this.mru = new MRU();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_mru_displacement_law);
        initialize();
        
        displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {

                    if (tools.isNull(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.null_field));
                        verifyInitialDisplacement = 0;

                    }
                    else if (tools.isDot(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.dot_value));
                        verifyInitialDisplacement = 0;

                    }
                    else {
                        initialDisplacement = Double.valueOf(initial_displacement.getText().toString());
                        verifyInitialDisplacement = 1;
                    }

                    if (tools.isNull(speed.getText().toString())) {
                        speed.setError(getText(R.string.null_field));
                        verifySpeed = 0;

                    }
                    else if (tools.isDot(speed.getText().toString())) {
                        speed.setError(getText(R.string.dot_value));
                        verifySpeed = 0;

                    }
                    else {
                        speedValue = Double.valueOf(speed.getText().toString());
                        verifySpeed = 1;
                    }

                    if (tools.isNull(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.null_field));
                        verifyDeltaTime = 0;

                    }
                    else if (tools.isDot(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.dot_value));
                        verifyDeltaTime = 0;

                    }
                    else {
                        deltaTime = Double.valueOf(delta_time.getText().toString());
                        verifyDeltaTime = 1;
                    }

                    if (verifyInitialDisplacement == 1
                        &&
                        verifySpeed == 1
                        &&
                        verifyDeltaTime == 1) {
                        res.setText(mru.spaceLaw(initialDisplacement, speedValue, deltaTime, mru.getStep));

                    }
                    else {
                        return;
                    }                                                                                                 
                }
            });
    }

}
