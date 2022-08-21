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

public class T1 extends Activity {

    // Atrubutos
    private static EditText vol;
    private static EditText vaz;
    private static TextView tempo;
    private static TextView res;
    private static int verifyVol;
    private static int verifyVaz;
    private static Double volume;
    private static Double vazao;
    private static FluidFlow FF;
    private static StringAnalyst StringAnalyst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t1);

        this.vol = findViewById(R.id.vol);
        this.vaz = findViewById(R.id.vaz);
        this.tempo = findViewById(R.id.tempo);
        this.res = findViewById(R.id.res);
        this.StringAnalyst = new StringAnalyst();
        this.FF = new FluidFlow();

        this.tempo.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    try {
                        if (StringAnalyst.isNull(vol.getText().toString())) {
                            Toast.makeText(T1.this, R.string.vol_null, Toast.LENGTH_SHORT).show();
                            verifyVol = 0;
                        } else {
                            volume = Double.valueOf(vol.getText().toString());
                            verifyVol = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(T1.this, R.string.insert_volume_well, Toast.LENGTH_SHORT).show();
                        verifyVol = 0;
                    }

                    try {
                        if (StringAnalyst.isNull(vaz.getText().toString())) {
                            Toast.makeText(T1.this, R.string.vaz_null, Toast.LENGTH_SHORT).show();
                            verifyVaz = 0;
                        } else {
                            vazao = Double.valueOf(vaz.getText().toString());
                            verifyVaz = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(T1.this, R.string.insert_vaz_well, Toast.LENGTH_SHORT).show();
                        verifyVaz = 0;

                        if (verifyVaz == 1 && verifyVol == 1) {
                            res.setText((CharSequence) "∆t = "
                                        + String.valueOf(volume)
                                        + "m³ / ("
                                        + vazao
                                        + "m³/s)");

                            res.setText((CharSequence) res.getText().toString()
                                        + "\n∆t ="
                                        + FF.tempo(volume, vazao)
                                        + "s");
                        } else { 
                            return;
                        }
                    }
                }
            });

    }
}

