package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.app.MyActivity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.FluidFlow;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class FlowRate2 extends MyActivity {

	// Atributos
	private EditText vel;
	private TextView vaz;
	private EditText ar;
	private TextView res;
    private Button clear;
    
	private Tools Tools;
	private Boolean verifyVelocity;
	private Boolean verifyArea;
	private Double velocidade;
	private Double area;
	private FluidFlow FF;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.vel = findViewById(R.id.vel);
        this.vaz = findViewById(R.id.vaz);
        this.ar = findViewById(R.id.ar);
        this.res = findViewById(R.id.res);
        this.clear = findViewById(R.id.clear);
        this.Tools = new Tools();
		this.FF = new FluidFlow();
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fluid_flow_flow_rate2);
		this.initialize();
        
		this.vaz.setOnClickListener(
            new OnClickListener() {
				public void onClick(View view) {

                    if (Tools.isNull(ar.getText().toString())) {
                        ar.setText(getText(R.string.null_field));
                        verifyArea = false;
                    } else if (Tools.isDot(ar.getText().toString())) {
                        ar.setError(getText(R.string.dot_value));
                        verifyArea = false;
                    } else {
                        area = Double.valueOf(ar.getText().toString());
                        verifyArea = true;
                    }


                    if (Tools.isNull(vel.getText().toString())) {
                        vel.setError(getText(R.string.null_field));
                        verifyVelocity = false;
                    } else if (Tools.isDot(vel.getText().toString())) {
                        vel.setError(getText(R.string.dot_value));
                        verifyVelocity = false;
                    } else {
                        velocidade = Double.valueOf(vel.getText().toString());
                        verifyVelocity = true;
                    }

                    
                    if (verifyVelocity && verifyArea) {
                        res.setText(getText(R.string.flowRatep)
                                    + " "
                                    + area
                                    + getText(R.string.amq)
                                    + " "
                                    + getText(R.string.multiplication)
                                    + " "
                                    + velocidade
                                    + getText(R.string.speedmps));

                        res.setText((CharSequence) res.getText().toString()
                                    + "\n"
                                    + getText(R.string.flowRatep)
                                    + " "
                                    + FF.sFluidFlow(area, velocidade)
                                    + getText(R.string.speedmcps));

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
                    vel.setText(null);
                    ar.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
	}
}
