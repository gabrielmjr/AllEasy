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

public class MUV_Acceleration1 extends MyActivity
{

    // Attributes
    private static EditText delta_speed;
    private static EditText delta_time;
    private static TextView acceleration;
    private static TextView res;

    private static int verify_deltaSpeed;
    private static int verify_deltaTime;
    private static double deltaSpeed;
    private static double deltaTime;
    private static Tools tools;
    private static MUV muv;

    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        delta_speed = findViewById(R.id.delta_speed);
        delta_time =  findViewById(R.id.delta_time);
        acceleration = findViewById(R.id.acceleration);
        res = findViewById(R.id.res);

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


                    if (verify_deltaSpeed == 1 && verify_deltaTime == 1)
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

                    }
                    else
                    {
                        return;
                    }
                }
            });
    }

}
