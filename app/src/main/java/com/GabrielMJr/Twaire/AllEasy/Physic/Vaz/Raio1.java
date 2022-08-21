package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.os.Bundle;
import android.app.Activity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.tools.StringAnalyst;
import com.GabrielMJr.Twaire.Physic.FluidFlow;


public class Raio1 extends Activity {

    // Atrubutos
    private static EditText vaz;
    private static EditText vel;
    private static TextView raio;
    private static TextView res;
    private static int verifyVaz;
    private static int verifyVelocity;
    private static Double vazao;
    private static Double velocidade;
    private static StringAnalyst StringAnalyst;
    private static FluidFlow FF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.raio1);

        this.vaz = findViewById(R.id.vaz);
        this.vel = findViewById(R.id.vel);
        this.raio = findViewById(R.id.raio);
        this.res = findViewById(R.id.res);
        //this.CT = new Constantes();
        this.StringAnalyst = new StringAnalyst();
        this.FF = new FluidFlow();

        this.raio.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    try {
                        if (StringAnalyst.isNull(vaz.getText().toString())) {
                            Toast.makeText(Raio1.this, R.string.vaz_null, Toast.LENGTH_SHORT).show();
                            verifyVaz = 0;
                        } else {
                            vazao = Double.valueOf(vaz.getText().toString());
                            verifyVaz = 1;
                        }
                        
                    } catch (Exception error) {
                        Toast.makeText(Raio1.this, R.string.insert_vaz_well, Toast.LENGTH_SHORT).show();
                        verifyVaz = 0;
                    }

                    try {
                        if (StringAnalyst.isNull(vel.getText().toString())) {
                            Toast.makeText(Raio1.this, R.string.vel_null, Toast.LENGTH_SHORT).show();
                            verifyVelocity = 0;
                        } else {
                            velocidade = Double.valueOf(vel.getText().toString());
                            verifyVelocity = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(Raio1.this, R.string.insert_velocity_well, Toast.LENGTH_SHORT).show();
                        verifyVelocity = 0;
                    }

                    if (verifyVaz == 1 && verifyVelocity == 1) {
                        res.setText(FF.raio(vazao, velocidade));
                    } else {
                        return;
                    }
                }
            });
    }
}
