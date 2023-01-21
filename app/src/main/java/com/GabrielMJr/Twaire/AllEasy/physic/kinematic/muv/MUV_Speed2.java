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

public class MUV_Speed2 extends MyActivity
{
    
    // Attributes
    private EditText initial_time;
    private EditText final_time;
    private EditText acceleration;
    private TextView speed;
    private TextView res;
    private Button clear;

    private Boolean verify_initialTime;
    private Boolean verify_finalTime;
    private Boolean verify_acceleration;
    private double initialTime;
    private double finalTime;
    private double accelerationV;
    private Tools tools;
    private MUV muv;
    private Physic physic;
    
    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        initial_time = findViewById(R.id.initial_time);
        final_time = findViewById(R.id.final_time);
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
        setContentView(R.layout.kinematic_muv_speed2);
        initialize();
        
        
        speed.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {

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


                    if (verify_initialTime && verify_finalTime && verify_acceleration)
                    {

                        res.setText(muv.speed2(initialTime, finalTime, accelerationV, physic.GET_STEP));
                        
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
                    final_time.setText(null);
                    acceleration.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
}
