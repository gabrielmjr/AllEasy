package com.GabrielMJr.Twaire.AllEasy.physic.kinematic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.LinearLayout;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Displacement1;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Displacement2;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Displacement3;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Initial_Displacement;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Final_Displacement;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Displacement_Law;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Speed1;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Speed2;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Time1;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Time2;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Time3;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Initial_Time;
import com.GabrielMJr.Twaire.AllEasy.physic.kinematic.MRU_Final_Time;

public class Kinematic_ActivityMain extends AppCompatActivity {

    private static LinearLayout fVDisplacement;
    private static LinearLayout sVDisplacement;
    private static LinearLayout tVDiaplacement;
    private static LinearLayout initial_displacement;
    private static LinearLayout final_displacement;
    private static LinearLayout displacement_law;
    private static LinearLayout speed_law1;
    private static LinearLayout speed_law2;
    private static LinearLayout time1;
    private static LinearLayout time2;
    private static LinearLayout time3;
    private static LinearLayout initial_time;
    private static LinearLayout final_time;

    private static Toolbar toolbar;

    private void initialize () {
        this.fVDisplacement = findViewById(R.id.fVDisplacement);
        this.sVDisplacement = findViewById(R.id.sVDisplacement);
        this.tVDiaplacement = findViewById(R.id.tVDisplacement);
        this.initial_displacement = findViewById(R.id.initial_displacement);
        this.final_displacement = findViewById(R.id.final_displacement);
        this.displacement_law = findViewById(R.id.displacement_law);
        this.speed_law1 = findViewById(R.id.speed_law1);
        this.speed_law2 = findViewById(R.id.speed_law2);
        this.time1 = findViewById(R.id.time1);
        this.time2 = findViewById(R.id.time2);
        this.time3 = findViewById(R.id.time3);
        this.initial_time = findViewById(R.id.initial_time);
        this.final_time = findViewById(R.id.final_time);
        this.toolbar = findViewById(R.id.toolbar);
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinematic_main);
        this.initialize();
        setSupportActionBar(toolbar);

        this.fVDisplacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement1.class));
                }
            });

        this.sVDisplacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement2.class));
                }
            });

        this.tVDiaplacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement3.class));
                }
            });

        this.initial_displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Initial_Displacement.class));
                }
            });

        this.final_displacement.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Final_Displacement.class));
                }
            });

        this.displacement_law.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Displacement_Law.class));
                }
            });

        this.speed_law1.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Speed1.class));
                }
            });

        this.speed_law2.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Speed2.class));
                }
            });

        this.time1.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Time1.class));
                }
            });

        this.time2.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Time2.class));
                }
            });

        this.time3.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Time3.class));
                }
            });

        this.initial_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Initial_Time.class));
                }
            });

        this.final_time.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick (View view) {
                    startActivity(new Intent(getApplicationContext(), MRU_Final_Time.class));
                }
            });
    }

}
