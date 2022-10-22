package com.GabrielMJr.Twaire.AllEasy.physic.kinematic;

import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.LinearLayout;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;

// MRU
// Displacament
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Displacement1;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Displacement2;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Displacement3;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Initial_Displacement;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Final_Displacement;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Displacement_Law;

// Speed
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Speed1;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Speed2;

// Time
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Time1;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Time2;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Time3;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Initial_Time;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.mru.MRU_Final_Time;

// MUV
// Acceleration
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.muv.MUV_Acceleration1;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.muv.MUV_Acceleration2;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.muv.MUV_Acceleration3;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.muv.MUV_Acceleration4;

public class Kinematic_ActivityMain extends MyActivity
{

    // MRU
    // Displacement
    private static LinearLayout mru_fVDisplacement;
    private static LinearLayout mru_sVDisplacement;
    private static LinearLayout mru_tVDiaplacement;
    private static LinearLayout mru_initial_displacement;
    private static LinearLayout mru_final_displacement;
    private static LinearLayout mru_displacement_law;

    // Speed
    private static LinearLayout mru_speed_law1;
    private static LinearLayout mru_speed_law2;

    // Time
    private static LinearLayout mru_time1;
    private static LinearLayout mru_time2;
    private static LinearLayout mru_time3;
    private static LinearLayout mru_initial_time;
    private static LinearLayout mru_final_time;

    // MUV
    // Acceleration
    private static LinearLayout muv_acceleration1;
    private static LinearLayout muv_acceleration2;
    private static LinearLayout muv_acceleration3;
    private static LinearLayout muv_acceleration4;

    private void initialize()
    {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        // MRU
        // Displacement
        this.mru_fVDisplacement = findViewById(R.id.mru_vDisplacement1);
        this.mru_sVDisplacement = findViewById(R.id.mru_vDisplacement2);
        this.mru_tVDiaplacement = findViewById(R.id.mru_vDisplacement3);
        this.mru_initial_displacement = findViewById(R.id.mru_initial_displacement);
        this.mru_final_displacement = findViewById(R.id.mru_final_displacement);
        this.mru_displacement_law = findViewById(R.id.mru_displacement_law);

        // Speed
        this.mru_speed_law1 = findViewById(R.id.mru_speed_law1);
        this.mru_speed_law2 = findViewById(R.id.mru_speed_law2);

        // Time
        this.mru_time1 = findViewById(R.id.mru_time1);
        this.mru_time2 = findViewById(R.id.mru_time2);
        this.mru_time3 = findViewById(R.id.mru_time3);
        this.mru_initial_time = findViewById(R.id.mru_initial_time);
        this.mru_final_time = findViewById(R.id.mru_final_time);

        // MUV
        // Acceleration
        this.muv_acceleration1 = findViewById(R.id.muv_acceleration1);
        this.muv_acceleration2 = findViewById(R.id.muv_acceleration2);
        this.muv_acceleration3 = findViewById(R.id.muv_acceleration3);
        this.muv_acceleration4 = findViewById(R.id.muv_acceleration4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_main);
        this.initialize();

        /* MRU */
        // Displacement
        this.mru_fVDisplacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement1.class));
                }
            });

        this.mru_sVDisplacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement2.class));
                }
            });

        this.mru_tVDiaplacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement3.class));
                }
            });

        this.mru_initial_displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Initial_Displacement.class));
                }
            });

        this.mru_final_displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Final_Displacement.class));
                }
            });

        this.mru_displacement_law.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement_Law.class));
                }
            });

        // Speed
        this.mru_speed_law1.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Speed1.class));
                }
            });

        this.mru_speed_law2.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Speed2.class));
                }
            });

        // Time
        this.mru_time1.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Time1.class));
                }
            });

        this.mru_time2.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Time2.class));
                }
            });

        this.mru_time3.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Time3.class));
                }
            });

        this.mru_initial_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Initial_Time.class));
                }
            });

        this.mru_final_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MRU_Final_Time.class));
                }
            });



        /*MUV*/
        // Acceleration
        this.muv_acceleration1.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MUV_Acceleration1.class));
                }
            });

        this.muv_acceleration2.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MUV_Acceleration2.class));
                }
            });

        this.muv_acceleration3.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MUV_Acceleration3.class));
                }
            });

        this.muv_acceleration4.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    startActivity(new Intent(getApplicationContext(), MUV_Acceleration4.class));
                }
            });
    }
}
