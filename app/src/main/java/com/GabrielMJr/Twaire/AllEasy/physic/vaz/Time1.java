package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.gabrielMJr.twaire.physic.hydrodynamics.fluidflow.FluidFlow;
import com.gabrielMJr.twaire.tools.Tools;

public class Time1 extends MyActivity {
    
    // Atrubutos
    private EditText vol;
    private EditText vaz;
    private TextView tempo;
    private TextView res;
    private Button clear;
    
    private Boolean verifyVol;
    private Boolean verifyVaz;
    private Double volume;
    private Double vazao;
    private FluidFlow FF;
    private Tools Tools;
    
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
                        verifyVol = false;
                    } else if (Tools.isDot(vol.getText().toString())) {
                        vol.setError(getText(R.string.dot_value));
                        verifyVol = false;
                    } else {
                        volume = Double.valueOf(vol.getText().toString());
                        verifyVol = true;
                    }


                    if (Tools.isNull(vaz.getText().toString())) {
                        vaz.setError(getText(R.string.null_field));
                        verifyVaz = false;
                    } else if (Tools.isDot(vaz.getText().toString())) {
                        vaz.setError(getText(R.string.dot_value));
                        verifyVaz = false;
                    } else {
                        vazao = Double.valueOf(vaz.getText().toString());
                        verifyVaz = true;
                    }


                    if (verifyVaz && verifyVol) {
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

