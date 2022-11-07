package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.gabrielMJr.twaire.physic.FluidFlow;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.gabrielMJr.twaire.tools.Tools;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class Area1 extends MyActivity {

    // Atrubutos
    private static EditText vaz;
    private static EditText vel;
    private static TextView area;
    private static TextView res;
    private static Button clear;
    
    private static int verifyVaz;
    private static int verifyVel;
    private static FluidFlow FF;
    private static Double vazao;
    private static Double velocidade;
    private static Tools Tools;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.vel = findViewById(R.id.vel);
        this.vaz = findViewById(R.id.vaz);
        this.area = findViewById(R.id.area);
        this.res = findViewById(R.id.res);
        this.clear = findViewById(R.id.clear);
        this.FF = new FluidFlow();
        this.Tools = new Tools();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluid_flow_area1);
        this.initialize();
        
        this.area.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

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

                    
                    if (Tools.isNull(vel.getText().toString())) {
                        vel.setError(getText(R.string.null_field));
                        verifyVel = 0;
                    } else if (Tools.isDot(vel.getText().toString())) {
                        vel.setError(getText(R.string.dot_value));
                    } else {
                        velocidade = Double.valueOf(vel.getText().toString());
                        verifyVel = 1;
                    }


                    if (verifyVaz == 1 && verifyVel == 1) {
                        res.setText(getText(R.string.areap)
                                    + " ("
                                    + Tools.normalize(Tools.expNormalizer(vazao))
                                    + getText(R.string.speedmcps)
                                    + ") "
                                    + getText(R.string.division)
                                    + " ("
                                    + Tools.normalize(Tools.expNormalizer(velocidade))
                                    + getText(R.string.speedmps)
                                    + ")");
                                    
                        res.setText((CharSequence) res.getText().toString()
                                    + "\n"
                                    + getText(R.string.areap)
                                    + " "
                                    + FF.area(vazao, velocidade)
                                    + getText(R.string.amq));
                                    
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
                        vel.setText(null);
                        res.setText(null);
                        
                        return;
                    }
                });
    }
}
