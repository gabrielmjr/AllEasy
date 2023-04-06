package com.gabrielmjr.alleasy.activity.physic.kinematic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Displacement1;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Initial_Displacement;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Time2;
import com.gabrielmjr.alleasy.activity.physic.kinematic.muv.MUV_Acceleration2;
import com.gabrielmjr.alleasy.activity.physic.kinematic.muv.MUV_Speed1;
import com.gabrielmjr.alleasy.activity.physic.kinematic.muv.MUV_Speed3;
import com.gabrielmjr.alleasy.activity.physic.kinematic.muv.MUV_Speed4;
import com.gabrielmjr.alleasy.activity.BaseActivity;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Displacement2;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Displacement3;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Displacement_Law;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Final_Displacement;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Final_Time;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Initial_Time;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Speed1;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Speed2;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Time1;
import com.gabrielmjr.alleasy.activity.physic.kinematic.mru.MRU_Time3;
import com.gabrielmjr.alleasy.activity.physic.kinematic.muv.MUV_Acceleration1;
import com.gabrielmjr.alleasy.activity.physic.kinematic.muv.MUV_Acceleration3;
import com.gabrielmjr.alleasy.activity.physic.kinematic.muv.MUV_Acceleration4;
import com.gabrielmjr.alleasy.activity.physic.kinematic.muv.MUV_Speed2;

public class KinematicActivityMain extends BaseActivity {

    // MRU
    // Displacement
    private LinearLayout mru_fVDisplacement;
    private LinearLayout mru_sVDisplacement;
    private LinearLayout mru_tVDiaplacement;
    private LinearLayout mru_initial_displacement;
    private LinearLayout mru_final_displacement;
    private LinearLayout mru_displacement_law;

    // Speed
    private LinearLayout mru_speed_law1;
    private LinearLayout mru_speed_law2;

    // Time
    private LinearLayout mru_time1;
    private LinearLayout mru_time2;
    private LinearLayout mru_time3;
    private LinearLayout mru_initial_time;
    private LinearLayout mru_final_time;

    // MUV
    // Acceleration
    private LinearLayout muv_acceleration1;
    private LinearLayout muv_acceleration2;
    private LinearLayout muv_acceleration3;
    private LinearLayout muv_acceleration4;

    // Speed
    private LinearLayout muv_speed1;
    private LinearLayout muv_speed2;
    private LinearLayout muv_speed3;
    private LinearLayout muv_speed4;

    private void initialize() {
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

        // Speed
        this.muv_speed1 = findViewById(R.id.muv_speed1);
        this.muv_speed2 = findViewById(R.id.muv_speed2);
        this.muv_speed3 = findViewById(R.id.muv_speed3);
        this.muv_speed4 = findViewById(R.id.muv_speed4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_main);
        this.initialize();

        /* MRU */
        // Displacement
        this.mru_fVDisplacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement1.class));
                }
            });

        this.mru_sVDisplacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement2.class));
                }
            });

        this.mru_tVDiaplacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement3.class));
                }
            });

        this.mru_initial_displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Initial_Displacement.class));
                }
            });

        this.mru_final_displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Final_Displacement.class));
                }
            });

        this.mru_displacement_law.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement_Law.class));
                }
            });

        // Speed
        this.mru_speed_law1.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Speed1.class));
                }
            });

        this.mru_speed_law2.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Speed2.class));
                }
            });

        // Time
        this.mru_time1.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Time1.class));
                }
            });

        this.mru_time2.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Time2.class));
                }
            });

        this.mru_time3.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Time3.class));
                }
            });

        this.mru_initial_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Initial_Time.class));
                }
            });

        this.mru_final_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Final_Time.class));
                }
            });



        /*MUV*/
        // Acceleration
        this.muv_acceleration1.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MUV_Acceleration1.class));
                }
            });

        this.muv_acceleration2.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MUV_Acceleration2.class));
                }
            });

        this.muv_acceleration3.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MUV_Acceleration3.class));
                }
            });

        this.muv_acceleration4.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MUV_Acceleration4.class));
                }
            });

        // Speed
        this.muv_speed1.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MUV_Speed1.class));
                }
            });

        this.muv_speed2.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MUV_Speed2.class));
                }
            });

        this.muv_speed3.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MUV_Speed3.class));
                }
            });

        this.muv_speed4.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MUV_Speed4.class));
                }
            });
    }
}
