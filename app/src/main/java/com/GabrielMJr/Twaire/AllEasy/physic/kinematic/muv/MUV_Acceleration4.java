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
import com.gabrielMJr.twaire.physic.Physic;
import com.gabrielMJr.twaire.physic.kinematics.muv.MUV;
import com.gabrielMJr.twaire.tools.Tools;

public class MUV_Acceleration4 extends MyActivity
{

    // Attributes
    private EditText initial_speed;
    private EditText final_speed;
    private EditText initial_time;
    private EditText final_time;
    private TextView acceleration;
    private TextView res;
    private Button clear;

    private Boolean verify_initialSpeed;
    private Boolean verify_finalSpeed;
    private Boolean verify_initialTime;
    private Boolean verify_finalTime;
    private double initialSpeed;
    private double finalSpeed;
    private double initialTime;
    private double finalTime;
    private Tools tools;
    private MUV muv;
    private Physic physic;

    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        initial_speed = findViewById(R.id.initial_speed);
        final_speed =  findViewById(R.id.final_speed);
        initial_time = findViewById(R.id.initial_time);
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
        setContentView(R.layout.kinematic_muv_acceleration4);
        initialize();
        
        acceleration.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {

                    if (tools.isNull(initial_speed.getText().toString()))
                    {
                        initial_speed.setError(getText(R.string.null_field));
                        verify_initialSpeed = false;

                    }
                    else if (tools.isDot(initial_speed.getText().toString()))
                    {
                        initial_speed.setError(getText(R.string.dot_value));
                        verify_initialSpeed = false;

                    }
                    else
                    {
                        initialSpeed = Double.valueOf(initial_speed.getText().toString());
                        verify_initialSpeed = true;
                    }


                    if (tools.isNull(final_speed.getText().toString()))
                    {
                        final_speed.setError(getText(R.string.null_field));
                        verify_finalSpeed = false;

                    }
                    else if (tools.isDot(final_speed.getText().toString()))
                    {
                        final_speed.setError(getText(R.string.dot_value));
                        verify_finalSpeed = false;

                    }
                    else
                    {
                        finalSpeed = Double.valueOf(final_speed.getText().toString());
                        verify_finalSpeed = true;
                    }

                    if (tools.isNull(initial_time.getText().toString()))
                    {
                        initial_time.setError(getText(R.string.null_field));
                        verify_initialTime = false;

                    }
                    else if (tools.isDot(initial_time.getText().toString()))
                    {
                        initial_time.setError(getText(R.string.dot_value));
                        verify_initialTime = false;

                    }
                    else
                    {
                        initialTime = Double.valueOf(initial_time.getText().toString());
                        verify_initialTime = true;
                    }

                    if (tools.isNull(final_time.getText().toString()))
                    {
                        final_time.setError(getText(R.string.null_field));
                        verify_finalTime = false;

                    }
                    else if (tools.isDot(final_time.getText().toString()))
                    {
                        final_time.setError(getText(R.string.dot_value));
                        verify_finalTime = false;

                    }
                    else
                    {
                        finalTime = Double.valueOf(final_time.getText().toString());
                        verify_finalTime = true;
                    }

                    if (verify_initialSpeed
                        &&
                        verify_finalSpeed
                        &&
                        verify_initialTime
                        &&
                        verify_finalTime)
                    {

                        res.setText(muv.acceleration4(initialSpeed, finalSpeed, initialTime, finalTime, physic.GET_STEP));
                        
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
                    initial_time.setText(null);
                    initial_speed.setText(null);
                    final_speed.setText(null);
                    final_time.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
    
}
