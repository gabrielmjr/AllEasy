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

public class MUV_Speed3 extends MyActivity
{
    
    // Attributes
    private EditText final_speed;
    private EditText delta_time;
    private EditText acceleration;
    private TextView speed;
    private TextView res;
    private Button clear;

    private Boolean verify_finalSpeed;;
    private Boolean verify_deltaTime;
    private Boolean verify_acceleration;
    private double finalSpeed;
    private double deltaTime;
    private double accelerationV;
    private Tools tools;
    private MUV muv;
    private Physic physic;
    
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
                
                if (verify_finalSpeed && verify_deltaTime && verify_acceleration)
                {
                    res.setText(muv.speed3(finalSpeed, deltaTime, accelerationV, physic.GET_STEP));
                    
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
