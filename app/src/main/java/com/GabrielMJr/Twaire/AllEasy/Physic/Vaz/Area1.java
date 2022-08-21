package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.os.Bundle;
import android.app.Activity;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.Physic.FluidFlow;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.tools.StringAnalyst;

public class Area1 extends Activity {

    // Atrubutos
    private static EditText vaz;
    private static EditText vel;
    private static TextView area;
    private static TextView res;
    private static int verifyVaz;
    private static int verifyVel;
    private static FluidFlow FF;
    private static Double vazao;
    private static Double velocidade;
    private static StringAnalyst StringAnalyst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1);

        this.vel = findViewById(R.id.vel);
        this.vaz = findViewById(R.id.vaz);
        this.area = findViewById(R.id.area);
        this.res = findViewById(R.id.res);
        this.FF = new FluidFlow();
        this.StringAnalyst = new StringAnalyst();

        this.area.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    try {
                        if (StringAnalyst.isNull(vaz.getText().toString())) {
                            Toast.makeText(Area1.this, R.string.vaz_null, Toast.LENGTH_SHORT).show();
                            verifyVaz = 0;
                        } else {
                            vazao = Double.valueOf(vaz.getText().toString());
                            verifyVaz = 1;
                        }
                    } catch (Exception error) {
                        Toast.makeText(Area1.this, R.string.insert_vaz_well, Toast.LENGTH_SHORT).show();
                        verifyVaz = 0;
                    }

                    try {           
                        if (StringAnalyst.isNull(vel.getText().toString())) {
                            Toast.makeText(Area1.this, R.string.vel_null, Toast.LENGTH_SHORT).show();
                            verifyVel = 0;
                        } else {
                            velocidade = Double.valueOf(vel.getText().toString());
                            verifyVel = 1;
                        }
                    } catch (Exception error) {
                        Toast.makeText(Area1.this, R.string.insert_velocity_well, Toast.LENGTH_SHORT).show();
                        verifyVel = 0;
                    }

                    if (verifyVaz == 1 && verifyVel == 1) {
                        res.setText((CharSequence) "A = "
                                    + String.valueOf(vazao)
                                    + "m³/s × "
                                    + velocidade
                                    + "m/s");

                        res.setText((CharSequence) res.getText().toString()
                                    + "\nA = "
                                    + FF.area(vazao, velocidade)
                                    + "m²");
                    } else {
                        return;
                    }
                }
            });
    }
}
