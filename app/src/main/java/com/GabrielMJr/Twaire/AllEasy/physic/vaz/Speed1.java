package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.gabrielMJr.twaire.physic.FluidFlow;
import com.gabrielMJr.twaire.tools.Tools;
import android.support.v7.widget.Toolbar;

public class Speed1 extends MyActivity {

    // Atributos
    private static EditText vaz;
    private static EditText ar;
    private static TextView vel;
    private static TextView res;
    
    private static int verifyVaz;
    private static int verifyAr;
    private static Double vazao;
    private static Double area;
    private static FluidFlow FF;
    private static Tools Tools;
    
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.vaz = findViewById(R.id.vaz);
        this.ar = findViewById(R.id.ar);
        this.vel = findViewById(R.id.vel);
        this.res = findViewById(R.id.res);
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
                        verifyVaz = 0;
                    } else if (Tools.isDot(vaz.getText().toString())) {
                        vaz.setError(getText(R.string.dot_value));
                        verifyVaz = 0;
                    } else {
                        vazao = Double.valueOf(vaz.getText().toString());
                        verifyVaz = 1;
                    }


                    if (Tools.isNull(ar.getText().toString())) {
                        ar.setError(getText(R.string.null_field));
                        verifyAr = 0;
                    } else if (Tools.isDot(ar.getText().toString())) {
                        ar.setError(getText(R.string.dot_value));
                        verifyAr = 0;
                    } else {
                        area = Double.valueOf(ar.getText().toString());
                        verifyAr = 1;
                    }

                    
                    if (verifyVaz == 1 && verifyAr == 1) {
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
                                    + FF.fSpeed(vazao, area)
                                    + getText(R.string.speedmps));
                    } else {
                        return;
                    }
                }
            });
    }
}
