package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.FluidFlow;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.widget.Toolbar;

public class Volume1 extends AppCompatActivity {

    // Atributos
    private static EditText tempo;
    private static EditText vaz;
    private static TextView vol;
    private static TextView res;
    private static Toolbar toolbar;
    
    private static int verifyTime;
    private static int verifyVaz;
    private static Double vazao;
    private static Double time;
    private static FluidFlow FF;
    private static Tools Tools;
    
    private void initialize() {
        this.tempo = findViewById(R.id.time);
        this.vaz = findViewById(R.id.vaz);
        this.vol = findViewById(R.id.vol);
        this.res = findViewById(R.id.res);
        this.toolbar = findViewById(R.id.toolbar);
        this.FF = new FluidFlow();
        this.Tools = new Tools();
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluid_flow_volume1);
        this.initialize();
        setSupportActionBar(toolbar);

        this.vol.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    if (Volume1.Tools.isNull(tempo.getText().toString())) {
                        tempo.setError(getText(R.string.null_field));
                        verifyTime = 0;
                    } else if (Tools.isDot(tempo.getText().toString())) {
                        tempo.setError(getText(R.string.dot_value));
                        verifyTime = 0;
                    } else {
                        time = Double.valueOf(tempo.getText().toString());
                        verifyTime = 1;
                    }


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

                    
                    if (verifyTime == 1 && verifyVaz == 1) {                    
                        res.setText(getText(R.string.volumep)
                                    + " "
                                    + Tools.normalize(Tools.expNormalizer(time))
                                    + getText(R.string.second)
                                    + " "
                                    + getText(R.string.multiplication)
                                    + " ("
                                    + Tools.normalize(Tools.expNormalizer(vazao))
                                    + getText(R.string.speedmcps)
                                    + ")");

                        res.setText((CharSequence) res.getText().toString()
                                    + "\n"
                                    + getText(R.string.volumep)
                                    + " "
                                    + FF.volume(time, vazao)
                                    + getText(R.string.vmc));
                    } else {
                        return;
                    }
                }			
            });
    }
}
