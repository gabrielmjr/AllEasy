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
import android.widget.Button;

public class MUV_Acceleration1 extends MyActivity
{

    // Attributes
    private EditText delta_speed;
    private EditText delta_time;
    private TextView acceleration;
    private TextView res;
    private Button clear;

    private Boolean verify_deltaSpeed;
    private Boolean verify_deltaTime;
    private double deltaSpeed;
    private double deltaTime;
    private Tools tools;
    private MUV muv;
    
    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        delta_speed = findViewById(R.id.delta_speed);
        delta_time =  findViewById(R.id.delta_time);
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
        setContentView(R.layout.kinematic_muv_acceleration1);

        initialize();

        acceleration.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {

                    if (tools.isNull(delta_speed.getText().toString()))
                    {
                        delta_speed.setError(getText(R.string.null_field));
                        verify_deltaSpeed = false;

                    }
                    else if (tools.isDot(delta_speed.getText().toString()))
                    {
                        delta_speed.setError(getText(R.string.dot_value));
                        verify_deltaSpeed = false;

                    }
                    else
                    {
                        deltaSpeed = Double.valueOf(delta_speed.getText().toString());
                        verify_deltaSpeed = true;
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


                    if (verify_deltaSpeed && verify_deltaTime)
                    {

                        res.setText(getText(R.string.accelerationp)
                                    + " "
                                    + delta_speed.getText().toString()
                                    + getText(R.string.dm)
                                    + " - "
                                    +delta_time.getText().toString()
                                    + getText(R.string.dm)

                                    + "\n"
                                    + getText(R.string.accelerationp)
                                    + " "
                                    + muv.fAcceleration(deltaSpeed, deltaTime)
                                    + getText(R.string.dm));

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
                    delta_time.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }

}
