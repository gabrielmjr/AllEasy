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
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.Physic;
import android.widget.Button;

public class MUV_Acceleration2 extends MyActivity
{

    // Attributes
    private static EditText delta_speed;
    private static EditText initial_time;
    private static EditText final_time;
    private static TextView acceleration;
    private static TextView res;
    private static Button clear;

    private static int verify_deltaSpeed;
    private static int verify_initialTime;
    private static int verify_finalTime;
    private static double deltaSpeed;
    private static double initialTime;
    private static double finalTime;
    private static Tools tools;
    private static MUV muv;
    private static Physic physic;

    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        delta_speed = findViewById(R.id.delta_speed);
        initial_time =  findViewById(R.id.initial_time);
        final_time = findViewById(R.id.final_time);
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
        setContentView(R.layout.kinematic_muv_acceleration2);
        initialize();


        acceleration.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {

                    if (tools.isNull(delta_speed.getText().toString()))
                    {
                        delta_speed.setError(getText(R.string.null_field));
                        verify_deltaSpeed = 0;

                    }
                    else if (tools.isDot(delta_speed.getText().toString()))
                    {
                        delta_speed.setError(getText(R.string.dot_value));
                        verify_deltaSpeed = 0;

                    }
                    else
                    {
                        deltaSpeed = Double.valueOf(delta_speed.getText().toString());
                        verify_deltaSpeed = 1;
                    }


                    if (tools.isNull(initial_time.getText().toString()))
                    {
                        initial_time.setError(getText(R.string.null_field));
                        verify_initialTime = 0;

                    }
                    else if (tools.isDot(initial_time.getText().toString()))
                    {
                        initial_time.setError(getText(R.string.dot_value));
                        verify_initialTime = 0;

                    }
                    else
                    {
                        initialTime = Double.valueOf(initial_time.getText().toString());
                        verify_initialTime = 1;
                    }

                    if (tools.isNull(final_time.getText().toString()))
                    {
                        final_time.setError(getText(R.string.null_field));
                        verify_finalTime = 0;

                    }
                    else if (tools.isDot(final_time.getText().toString()))
                    {
                        final_time.setError(getText(R.string.dot_value));
                        verify_finalTime = 0;

                    }
                    else
                    {
                        finalTime = Double.valueOf(final_time.getText().toString());
                        verify_finalTime = 1;
                    }


                    if (verify_deltaSpeed == 1 
                        &&
                        verify_initialTime == 1
                        &&
                        verify_finalTime == 1)
                    {

                        res.setText(muv.sAcceleration(deltaSpeed, initialTime, finalTime, physic.GET_STEP));
                        
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
                    delta_speed.setText(null);
                    initial_time.setText(null);
                    final_time.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }

}
