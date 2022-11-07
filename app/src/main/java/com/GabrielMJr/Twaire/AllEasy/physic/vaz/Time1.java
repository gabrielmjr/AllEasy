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
import android.widget.Button;

public class Time1 extends MyActivity {
    
    // Atrubutos
    private static EditText vol;
    private static EditText vaz;
    private static TextView tempo;
    private static TextView res;
    private static Button clear;
    
    private static int verifyVol;
    private static int verifyVaz;
    private static Double volume;
    private static Double vazao;
    private static FluidFlow FF;
    private static Tools Tools;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.vol = findViewById(R.id.vol);
        this.vaz = findViewById(R.id.vaz);
        this.tempo = findViewById(R.id.tempo);
        this.res = findViewById(R.id.res);
        this.clear = findViewById(R.id.clear);
        this.Tools = new Tools();
        this.FF = new FluidFlow();
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluid_flow_time1);
        this.initialize();
        
        this.tempo.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {
                    
                    if (Tools.isNull(vol.getText().toString())) {
                        vol.setError(getText(R.string.null_field));
                        verifyVol = 0;
                    } else if (Tools.isDot(vol.getText().toString())) {
                        vol.setError(getText(R.string.dot_value));
                        verifyVol = 0;
                    } else {
                        volume = Double.valueOf(vol.getText().toString());
                        verifyVol = 1;
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


                    if (verifyVaz == 1 && verifyVol == 1) {
                        res.setText(getText(R.string.dtp)
                                    + String.valueOf(volume)
                                    + getText(R.string.vmc)
                                    + " "
                                    + getText(R.string.division)
                                    + " ("
                                    + vazao
                                    + getText(R.string.speedmcps)
                                    + ")");

                        res.setText((CharSequence) res.getText().toString()
                                    + "\n"
                                    + getText(R.string.dtp)
                                    + " "
                                    + FF.time(volume, vazao)
                                    + getText(R.string.second));
                                    
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
                    vol.setText(null);
                    vaz.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });

    }
}

