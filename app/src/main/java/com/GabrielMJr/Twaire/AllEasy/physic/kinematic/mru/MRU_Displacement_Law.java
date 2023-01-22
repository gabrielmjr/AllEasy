package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.gabrielMJr.twaire.physic.Physic;
import com.gabrielMJr.twaire.physic.kinematics.mru.MRU;
import com.gabrielMJr.twaire.tools.Tools;

public class MRU_Displacement_Law extends MyActivity {

    private EditText initial_displacement;
    private EditText speed;
    private EditText delta_time;
    private TextView displacement;
    private TextView res;
    private Button clear;
    
    private Boolean verifyInitialDisplacement;
    private Boolean verifySpeed;
    private Boolean verifyDeltaTime;
    private double initialDisplacement;
    private double speedValue;
    private double deltaTime;
    private Tools tools;
    private MRU mru;
    private Physic physic;

    private void initialize () {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.initial_displacement = findViewById(R.id.initial_displacement);
        this.speed = findViewById(R.id.speed);
        this.delta_time = findViewById(R.id.delta_time);
        this.displacement = findViewById(R.id.displacement);
        this.res = findViewById(R.id.res);
        this.clear = findViewById(R.id.clear);
        
        this.tools = new Tools();
        this.mru = new MRU();
        this.physic = new Physic();
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
                        verifyInitialDisplacement = false;

                    }
                    else if (tools.isDot(initial_displacement.getText().toString())) {
                        initial_displacement.setError(getText(R.string.dot_value));
                        verifyInitialDisplacement = false;

                    }
                    else {
                        initialDisplacement = Double.valueOf(initial_displacement.getText().toString());
                        verifyInitialDisplacement = true;
                    }

                    if (tools.isNull(speed.getText().toString())) {
                        speed.setError(getText(R.string.null_field));
                        verifySpeed = false;

                    }
                    else if (tools.isDot(speed.getText().toString())) {
                        speed.setError(getText(R.string.dot_value));
                        verifySpeed = false;

                    }
                    else {
                        speedValue = Double.valueOf(speed.getText().toString());
                        verifySpeed = true;
                    }

                    if (tools.isNull(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.null_field));
                        verifyDeltaTime = false;

                    }
                    else if (tools.isDot(delta_time.getText().toString())) {
                        delta_time.setError(getText(R.string.dot_value));
                        verifyDeltaTime = false;

                    }
                    else {
                        deltaTime = Double.valueOf(delta_time.getText().toString());
                        verifyDeltaTime = true;
                    }

                    if (verifyInitialDisplacement
                        &&
                        verifySpeed
                        &&
                        verifyDeltaTime) {
                        res.setText(mru.displacement6(initialDisplacement, speedValue, deltaTime, physic.GET_STEP));

                        return;
                    }
                    else
                    {
                        return;
                    }
                }
            });
            
        this.clear.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    initial_displacement.setText(null);
                    speed.setText(null);
                    delta_time.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }

}
