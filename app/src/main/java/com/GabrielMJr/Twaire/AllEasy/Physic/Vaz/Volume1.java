package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import com.GabrielMJr.Twaire.tools.StringAnalyst;
import com.GabrielMJr.Twaire.Physic.FluidFlow;
import android.app.Activity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class Volume1 extends Activity {

    // Atributos
    private static EditText tempo;
    private static EditText vaz;
    private static TextView vol;
    private static TextView res;
    private static int verifyTime;
    private static int verifyVaz;
    private static Double vazao;
    private static Double time;
    private static FluidFlow FF;
    private static StringAnalyst StringAnalyst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume1);

        this.tempo = findViewById(R.id.time);
        this.vaz = findViewById(R.id.vaz);
        this.vol = findViewById(R.id.vol);
        this.res = findViewById(R.id.res);
        this.FF = new FluidFlow();
        this.StringAnalyst = new StringAnalyst();

        this.vol.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    try {
                        if (Volume1.StringAnalyst.isNull(tempo.getText().toString())) {
                            Toast.makeText(Volume1.this, R.string.time_null, Toast.LENGTH_SHORT).show();
                            verifyTime = 0;
                        } else {
                            time = Double.valueOf(tempo.getText().toString());
                            verifyTime = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(Volume1.this, R.string.insert_time_well, Toast.LENGTH_SHORT).show();
                        verifyTime = 0;
                    }


                    try {
                        if (StringAnalyst.isNull(vaz.getText().toString())) {
                            Toast.makeText(Volume1.this, R.string.vaz_null, Toast.LENGTH_SHORT).show();
                            verifyVaz = 0;
                        } else {
                            vazao = Double.valueOf(vaz.getText().toString());
                            verifyVaz = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(Volume1.this, R.string.insert_vaz_well, Toast.LENGTH_SHORT).show();
                        verifyVaz = 0;
                    }

                    if (verifyTime == 1 && verifyVaz == 1) {                    
                        res.setText((CharSequence) "V = "
                                            + String.valueOf(time)
                                            + "s × "
                                            + vazao
                                            + "m³/s");

                        res.setText((CharSequence) res.getText().toString()
                                            + "\nV = "
                                            + FF.volume(time, vazao)
                                            + "m³");
                    } else {
                        return;
                    }
                }			
            });
    }
}
