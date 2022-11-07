package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.muv;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.gabrielMJr.twaire.physic.MUV;
import com.gabrielMJr.twaire.physic.Physic;
import com.gabrielMJr.twaire.tools.Tools;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class MUV_Speed4 extends MyActivity
{
    
    // Attributes
    private static EditText initial_speed;
    private static EditText delta_time;
    private static EditText acceleration;
    private static TextView speed;
    private static TextView res;
    private static Button clear;

    private static int verify_initialSpeed;;
    private static int verify_deltaTime;
    private static int verify_acceleration;
    private static double initialSpeed;
    private static double deltaTime;
    private static double accelerationV;
    private static Tools tools;
    private static MUV muv;
    private static Physic physic;
    
    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        initial_speed = findViewById(R.id.initial_speed);
        delta_time = findViewById(R.id.delta_time);
        acceleration =  findViewById(R.id.acceleration);
        speed = findViewById(R.id.speed);
        res = findViewById(R.id.res);
        clear = findViewById(R.id.clear);

        tools = new Tools();
        muv = new MUV();
        physic = new Physic();
    }
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_muv_speed4);
        initialize();
        
        speed.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (tools.isNull(initial_speed.getText().toString()))
                {
                    initial_speed.setError(getText(R.string.null_field));
                    verify_initialSpeed = 0;

                }
                else if (tools.isDot(initial_speed.getText().toString()))
                {
                    initial_speed.setError(getText(R.string.dot_value));
                    verify_initialSpeed = 0;

                }
                else
                {
                    initialSpeed = Double.valueOf(initial_speed.getText().toString());
                    verify_initialSpeed = 1;
                }
                
                if (tools.isNull(delta_time.getText().toString()))
                {
                    delta_time.setError(getText(R.string.null_field));
                    verify_deltaTime = 0;

                }
                else if (tools.isDot(delta_time.getText().toString()))
                {
                    delta_time.setError(getText(R.string.dot_value));
                    verify_deltaTime = 0;

                }
                else
                {
                    deltaTime = Double.valueOf(delta_time.getText().toString());
                    verify_deltaTime = 1;
                }
                
                if (tools.isNull(acceleration.getText().toString()))
                {
                    acceleration.setError(getText(R.string.null_field));
                    verify_acceleration = 0;

                }
                else if (tools.isDot(acceleration.getText().toString()))
                {
                    acceleration.setError(getText(R.string.dot_value));
                    verify_acceleration = 0;

                }
                else
                {
                    accelerationV = Double.valueOf(acceleration.getText().toString());
                    verify_acceleration = 1;
                }
                
                if (verify_initialSpeed == 1 && verify_deltaTime == 1 && verify_acceleration == 1)
                {
                    res.setText(muv.finalSpeed(initialSpeed, deltaTime, accelerationV, physic.GET_STEP));
                    
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
                    initial_speed.setText(null);
                    delta_time.setText(null);
                    acceleration.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
}
