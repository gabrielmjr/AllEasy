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

public class MUV_Speed1 extends MyActivity
{
    
    // Attributes
    private static EditText delta_time;
    private static EditText acceleration;
    private static TextView speed;
    private static TextView res;

    private static int verify_deltaTime;
    private static int verify_acceleration;
    private static double deltaTime;
    private static double accelerationV;
    private static Tools tools;
    private static MUV muv;
    
    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        delta_time = findViewById(R.id.delta_time);
        acceleration =  findViewById(R.id.acceleration);
        speed = findViewById(R.id.speed);
        res = findViewById(R.id.res);

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


                    if (verify_deltaTime == 1 && verify_acceleration == 1)
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
                                    + muv.fVSpeed(deltaTime, accelerationV)
                                    + getText(R.string.speedmps));

                    }
                    else
                    {
                        return;
                    }
                }
            });
    }
    
}
