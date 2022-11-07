package com.GabrielMJr.Twaire.AllEasy.physic.kinematic.muv;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.gabrielMJr.twaire.physic.MUV;
import com.gabrielMJr.twaire.physic.Physic;
import com.gabrielMJr.twaire.tools.Tools;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

public class MUV_Speed3 extends MyActivity
{
    
    // Attributes
    private static EditText final_speed;
    private static EditText delta_time;
    private static EditText acceleration;
    private static TextView speed;
    private static TextView res;
    private static Button clear;

    private static int verify_finalSpeed;;
    private static int verify_deltaTime;
    private static int verify_acceleration;
    private static double finalSpeed;
    private static double deltaTime;
    private static double accelerationV;
    private static Tools tools;
    private static MUV muv;
    private static Physic physic;
    
    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        final_speed = findViewById(R.id.final_speed);
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
        setContentView(R.layout.kinematic_muv_speed3);
        initialize();
        
        speed.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
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
                
                if (verify_finalSpeed == 1 && verify_deltaTime == 1 && verify_acceleration == 1)
                {
                    res.setText(muv.initialSpeed(finalSpeed, deltaTime, accelerationV, physic.GET_STEP));
                    
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
                    final_speed.setText(null);
                    acceleration.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
    
}
