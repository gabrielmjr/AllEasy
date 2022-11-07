package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.muv;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.gabrielMJr.twaire.physic.MUV;
import com.gabrielMJr.twaire.physic.Physic;
import com.gabrielMJr.twaire.tools.Tools;
import android.widget.Button;

public class MUV_Acceleration3 extends MyActivity
{

    // Attributes
    private static EditText initial_speed;
    private static EditText final_speed;
    private static EditText delta_time;
    private static TextView acceleration;
    private static TextView res;
    private static Button clear;

    private static int verify_initialSpeed;
    private static int verify_finalSpeed;
    private static int verify_deltaTime;
    private static double initialSpeed;
    private static double finalSpeed;
    private static double deltaTime;
    private static Tools tools;
    private static MUV muv;
    private static Physic physic;

    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        initial_speed = findViewById(R.id.initial_speed);
        final_speed =  findViewById(R.id.final_speed);
        delta_time = findViewById(R.id.delta_time);
        acceleration = findViewById(R.id.acceleration);
        res = findViewById(R.id.res);
        clear = findViewById(R.id.clear);

        tools = new Tools();
        muv = new MUV();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_muv_acceleration3);
        
        initialize();
        
        acceleration.setOnClickListener(
            new OnClickListener() {
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


                    if (tools.isNull(final_speed.getText().toString()))
                    {
                        final_speed.setError(getText(R.string.null_field));
                        verify_finalSpeed = 0;

                    }
                    else if (tools.isDot(final_speed.getText().toString()))
                    {
                        final_speed.setError(getText(R.string.dot_value));
                        verify_finalSpeed = 0;

                    }
                    else
                    {
                        finalSpeed = Double.valueOf(final_speed.getText().toString());
                        verify_finalSpeed = 1;
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


                    if (verify_initialSpeed == 1 
                        &&
                        verify_finalSpeed == 1
                        &&
                        verify_deltaTime == 1)
                    {

                        res.setText(muv.tAcceleration(initialSpeed, finalSpeed, deltaTime, physic.GET_STEP));

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
                    final_speed.setText(null);
                    delta_time.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
}
