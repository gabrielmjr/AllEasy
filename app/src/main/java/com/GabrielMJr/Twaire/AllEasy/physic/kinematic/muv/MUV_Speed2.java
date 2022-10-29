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

public class MUV_Speed2 extends MyActivity
{
    
    // Attributes
    private static EditText initial_time;
    private static EditText final_time;
    private static EditText acceleration;
    private static TextView speed;
    private static TextView res;

    private static int verify_initialTime;
    private static int verify_finalTime;
    private static int verify_acceleration;
    private static double initialTime;
    private static double finalTime;
    private static double accelerationV;
    private static Tools tools;
    private static MUV muv;
    private static Physic physic;
    
    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        initial_time = findViewById(R.id.initial_time);
        final_time = findViewById(R.id.final_time);
        acceleration =  findViewById(R.id.acceleration);
        speed = findViewById(R.id.speed);
        res = findViewById(R.id.res);

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


                    if (verify_initialTime == 1 && verify_finalTime == 1 && verify_acceleration == 1)
                    {

                        res.setText(muv.sVSpeed(initialTime, finalTime, accelerationV, physic.GET_STEP));
                    }
                    else
                    {
                        return;
                    }
                }
            });
    }
}
