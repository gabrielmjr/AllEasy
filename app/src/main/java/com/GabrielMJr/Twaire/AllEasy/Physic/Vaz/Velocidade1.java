package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.os.Bundle;
import android.app.Activity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.Physic.FluidFlow;
import com.GabrielMJr.Twaire.tools.StringAnalyst;

public class Velocidade1 extends Activity {

    // Atributos
    private static EditText vaz;
    private static EditText ar;
    private static int verifyVaz;
    private static int verifyAr;
    private static Double vazao;
    private static Double area;
    private static TextView vel;
    private static TextView res;
    private static FluidFlow FF;
    private static StringAnalyst StringAnalyst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.velocidade1);

        this.vaz = findViewById(R.id.vaz);
        this.ar = findViewById(R.id.ar);
        this.vel = findViewById(R.id.vel);
        this.res = findViewById(R.id.res);
        this.FF = new FluidFlow();
        this.StringAnalyst = new StringAnalyst();

        this.vel.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    try {
                        if (StringAnalyst.isNull(vaz.getText().toString())) {
                            Toast.makeText(Velocidade1.this, R.string.vaz_null, Toast.LENGTH_SHORT).show();
                            verifyVaz = 0;
                        } else {
                            vazao = Double.valueOf(vaz.getText().toString());
                            verifyVaz = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(Velocidade1.this, R.string.insert_vaz_well, Toast.LENGTH_SHORT).show();
                        verifyVaz = 0;
                    }

                    try {
                        if (StringAnalyst.isNull(ar.getText().toString())) {
                            Toast.makeText(Velocidade1.this, R.string.area_null, Toast.LENGTH_SHORT).show();
                            verifyAr = 0;
                        } else {
                            area = Double.valueOf(ar.getText().toString());
                            verifyAr = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(Velocidade1.this, R.string.insert_area_well, Toast.LENGTH_SHORT).show();
                        verifyAr = 0;
                    }
                    
                    if (verifyVaz == 1 && verifyAr == 1) {
                        res.setText((CharSequence) "v = ("
                                                + String.valueOf(vazao)
                                                + "m³/s) / ("
                                                + area
                                                + "m²)");
                        res.setText((CharSequence) res.getText().toString()
                                                + "\nQ = "
                                                + FF.fvelocidade(vazao, area)
                                                + "m/s");
                    } else {
                        return;
                    }
                }
            });
    }
}
