package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.FluidFlow;
import android.support.v7.widget.Toolbar;

public class Ray1 extends AppCompatActivity {

    // Atrubutos
    private static EditText vaz;
    private static EditText vel;
    private static TextView raio;
    private static TextView res;
    private static Toolbar toolbar;
    
    private static int verifyVaz;
    private static int verifyVelocity;
    private static Double vazao;
    private static Double velocidade;
    private static Tools Tools;
    private static FluidFlow FF;

    private void initialize() {
        this.vaz = findViewById(R.id.vaz);
        this.vel = findViewById(R.id.vel);
        this.raio = findViewById(R.id.raio);
        this.res = findViewById(R.id.res);
        this.toolbar = findViewById(R.id.toolbar);
        this.Tools = new Tools();
        this.FF = new FluidFlow();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluid_flow_ray1);
        this.initialize();
        setSupportActionBar(toolbar);
        
        this.raio.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    if (Tools.isNull(vaz.getText().toString())) {
                        vaz.setError(getText(R.string.null_field));
                        verifyVaz = 0;
                    } else if (Tools.isDot(vaz.getText().toString())) {
                        vaz.setError(getText(R.string.dot_value));
                        verifyVaz = 0;
                    } else {
                        vazao = Double.valueOf(vaz.getText().toString());
                        verifyVaz = 1;
                    }


                    if (Tools.isNull(vel.getText().toString())) {
                        vel.setError(getText(R.string.null_field));
                        verifyVelocity = 0;
                    } else if (Tools.isDot(vel.getText().toString())) {
                        vel.setError(getText(R.string.dot_value));
                        verifyVelocity = 0;
                    } else {
                        velocidade = Double.valueOf(vel.getText().toString());
                        verifyVelocity = 1;
                    }


                    if (verifyVaz == 1 && verifyVelocity == 1) {
                        res.setText(FF.ray(vazao, velocidade, FF.getStep));
                    } else {
                        return;
                    }
                }
            });
    }
}
