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

public class Speed1 extends MyActivity {

    // Atributos
    private EditText vaz;
    private EditText ar;
    private TextView vel;
    private TextView res;
    private Button clear;
    
    private Boolean verifyVaz;
    private Boolean verifyAr;
    private Double vazao;
    private Double area;
    private FluidFlow FF;
    private Tools Tools;
    
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.vaz = findViewById(R.id.vaz);
        this.ar = findViewById(R.id.ar);
        this.vel = findViewById(R.id.vel);
        this.res = findViewById(R.id.res);
        this.clear = findViewById(R.id.clear);
        this.FF = new FluidFlow();
        this.Tools = new Tools();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluid_flow_speed1);
        this.initialize();
        
        this.vel.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

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


                    if (Tools.isNull(ar.getText().toString())) {
                        ar.setError(getText(R.string.null_field));
                        verifyAr = false;
                    } else if (Tools.isDot(ar.getText().toString())) {
                        ar.setError(getText(R.string.dot_value));
                        verifyAr = false;
                    } else {
                        area = Double.valueOf(ar.getText().toString());
                        verifyAr = true;
                    }

                    
                    if (verifyVaz && verifyAr) {
                        res.setText(getText(R.string.speedp)
                                    + " "
                                    + "("
                                    + vazao
                                    + getText(R.string.vmc)
                                    + ") "
                                    + getText(R.string.division)
                                    + " ("
                                    + area
                                    + getText(R.string.amq)
                                    + ")");
                                    
                        res.setText((CharSequence) res.getText().toString()
                                    + "\n"
                                    + getText(R.string.speedp)
                                    + " "
                                    + FF.speed1(vazao, area)
                                    + getText(R.string.speedmps));
                                    
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
                    ar.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
    }
}
