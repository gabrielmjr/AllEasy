package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.FluidFlow;
import android.support.v7.widget.Toolbar;
import com.gabrielMJr.twaire.physic.Physic;
import android.widget.Button;

public class Ray1 extends MyActivity {

    // Atrubutos
    private static EditText vaz;
    private static EditText vel;
    private static TextView raio;
    private static TextView res;
    private static Button clear;
    
    private static int verifyVaz;
    private static int verifyVelocity;
    private static Double vazao;
    private static Double velocidade;
    private static Tools Tools;
    private static FluidFlow FF;
    private static Physic physic;

    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.vaz = findViewById(R.id.vaz);
        this.vel = findViewById(R.id.vel);
        this.raio = findViewById(R.id.raio);
        this.res = findViewById(R.id.res);
        this.clear = findViewById(R.id.clear);
        this.Tools = new Tools();
        this.FF = new FluidFlow();
        this.physic = new Physic();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluid_flow_ray1);
        this.initialize();
        
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
                        res.setText(FF.ray(vazao, velocidade, physic.GET_STEP));
                        
                        return;
                    } else {
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
                    vaz.setText(null);
                    vel.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
}
