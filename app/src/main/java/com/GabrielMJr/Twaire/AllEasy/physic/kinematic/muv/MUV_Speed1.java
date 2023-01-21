package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.muv;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.gabrielMJr.twaire.physic.kinematics.muv.MUV;
import com.gabrielMJr.twaire.tools.Tools;

public class MUV_Speed1 extends MyActivity
{
    
    // Attributes
    private EditText delta_time;
    private EditText acceleration;
    private TextView speed;
    private TextView res;
    private Button clear;

    private Boolean verify_deltaTime;
    private Boolean verify_acceleration;
    private double deltaTime;
    private double accelerationV;
    private Tools tools;
    private MUV muv;
    
    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        delta_time = findViewById(R.id.delta_time);
        acceleration =  findViewById(R.id.acceleration);
        speed = findViewById(R.id.speed);
        res = findViewById(R.id.res);
        clear = findViewById(R.id.clear);

        tools = new Tools();
        muv = new MUV();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_muv_speed1);
        initialize();
        
        speed.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {

                    if (tools.isNull(delta_time.getText().toString()))
                    {
                        delta_time.setError(getText(R.string.null_field));
                        verify_deltaTime = false;

                    }
                    else if (tools.isDot(delta_time.getText().toString()))
                    {
                        delta_time.setError(getText(R.string.dot_value));
                        verify_deltaTime = false;

                    }
                    else
                    {
                        deltaTime = Double.valueOf(delta_time.getText().toString());
                        verify_deltaTime = true;
                    }


                    if (tools.isNull(acceleration.getText().toString()))
                    {
                        acceleration.setError(getText(R.string.null_field));
                        verify_acceleration = false;

                    }
                    else if (tools.isDot(acceleration.getText().toString()))
                    {
                        acceleration.setError(getText(R.string.dot_value));
                        verify_acceleration = false;

                    }
                    else
                    {
                        accelerationV = Double.valueOf(acceleration.getText().toString());
                        verify_acceleration = true;
                    }


                    if (verify_deltaTime && verify_acceleration)
                    {

                        res.setText(getText(R.string.dvp)
                                    + " "
                                    + delta_time.getText().toString()
                                    + getText(R.string.dm)
                                    + " "
                                    + getText(R.string.multiplication)
                                    + " "
                                    + delta_time.getText().toString()
                                    + getText(R.string.dm)

                                    + "\n"
                                    + getText(R.string.dvp)
                                    + " "
                                    + muv.speed1(deltaTime, accelerationV)
                                    + getText(R.string.speedmps));

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
                    delta_time.setText(null);
                    acceleration.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
    
}
