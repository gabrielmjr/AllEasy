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

public class Volume1 extends MyActivity {

    // Atributos
    private EditText tempo;
    private EditText vaz;
    private TextView vol;
    private TextView res;
    private Toolbar toolbar;
    private Button clear;
    
    private Boolean verifyTime;
    private Boolean verifyVaz;
    private Double vazao;
    private Double time;
    private FluidFlow FF;
    private Tools Tools;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.tempo = findViewById(R.id.time);
        this.vaz = findViewById(R.id.vaz);
        this.vol = findViewById(R.id.vol);
        this.res = findViewById(R.id.res);
        this.toolbar = findViewById(R.id.toolbar);
        this.clear = findViewById(R.id.clear);
        this.FF = new FluidFlow();
        this.Tools = new Tools();
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluid_flow_volume1);
        this.initialize();
        
        this.vol.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    if (Tools.isNull(tempo.getText().toString())) {
                        tempo.setError(getText(R.string.null_field));
                        verifyTime = false;
                    } else if (Tools.isDot(tempo.getText().toString())) {
                        tempo.setError(getText(R.string.dot_value));
                        verifyTime = false;
                    } else {
                        time = Double.valueOf(tempo.getText().toString());
                        verifyTime = true;
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

                    
                    if (verifyTime && verifyVaz) {                    
                        res.setText(getText(R.string.volumep)
                                    + " "
                                    + time
                                    + getText(R.string.second)
                                    + " "
                                    + getText(R.string.multiplication)
                                    + " ("
                                    + vazao
                                    + getText(R.string.speedmcps)
                                    + ")");

                        res.setText((CharSequence) res.getText().toString()
                                    + "\n"
                                    + getText(R.string.volumep)
                                    + " "
                                    + FF.volume(time, vazao)
                                    + getText(R.string.vmc));
                                    
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
                    tempo.setText(null);
                    vaz.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
}
