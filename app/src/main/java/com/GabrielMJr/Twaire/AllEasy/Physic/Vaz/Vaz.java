package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Vaz1;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Vaz2;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Vaz3;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.T1;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Volume1;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Velocidade1;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Area1;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Raio1;
import com.GabrielMJr.Twaire.AllEasy.R;

public class Vaz extends Activity {

    private static LinearLayout vaz1;
    private static LinearLayout vaz2;
    private static LinearLayout vaz3;
    private static LinearLayout t1;
    private static LinearLayout V1;
    private static LinearLayout vel1;
    private static LinearLayout area1;
    private static LinearLayout raio1;
    private static Intent Vaz1C;
    private static Intent Vaz2C;
    private static Intent Vaz3C;
    private static Intent Time1C;
    private static Intent Volume1C;
    private static Intent Velocidade1C;
    private static Intent Area1C;
    private static Intent Raio1C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_vaz);

        this.vaz1 = findViewById(R.id.v1);
        this.vaz2 = findViewById(R.id.v2);
        this.vaz3 = findViewById(R.id.v3);
        this.t1 = findViewById(R.id.t1);
        this.V1 = findViewById(R.id.V1);
        this.vel1 = findViewById(R.id.vel1);
        this.area1 = findViewById(R.id.area);
        this.raio1 = findViewById(R.id.raio1); 

        this.Vaz1C = new Intent(Vaz.this, Vaz1.class);
        this.Vaz2C = new Intent(Vaz.this, Vaz2.class);
        this.Vaz3C = new Intent(Vaz.this, Vaz3.class);
        this.Time1C = new Intent(Vaz.this, T1.class);
        this.Volume1C = new Intent(Vaz.this, Volume1.class);
        this.Velocidade1C = new Intent(Vaz.this, Velocidade1.class);
        this.Area1C = new Intent(Vaz.this, Area1.class);
        this.Raio1C = new Intent(Vaz.this, Raio1.class);

        this.vaz1.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    startActivity(Vaz.Vaz1C);
                }});

        this.vaz2.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(Vaz.Vaz2C);
                }
            });

        this.vaz3.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(Vaz.Vaz2C);
                }
            });

        this.vaz3.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(Vaz.Vaz3C);
                }
            });

        this.t1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(Vaz.Time1C);
                }
            });

        this.V1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(Vaz.Volume1C);
                }
            });

        this.vel1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(Vaz.Velocidade1C);
                }
            });

        this.area1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(Vaz. Area1C);
                }
            });

        this.raio1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(Vaz.Raio1C);
                }
            });
    }
}
