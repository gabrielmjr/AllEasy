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
import com.gabrielMJr.twaire.physic.Physic;
import android.widget.Button;

public class FlowRate3 extends MyActivity {

	// Atrubutos
	private EditText ra;
	private EditText vel;
	private TextView vaz;
	private TextView res;
    private Button clear;
    
	private Tools Tools;
	private Double velocidade;
	private Double raio;
	private Boolean verifyRaio;
	private Boolean verifyVelocity;
	private FluidFlow FF;
    private Physic physic;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.ra = findViewById(R.id.ra);
        this.vel = findViewById(R.id.vel);
        this.vaz = findViewById(R.id.vaz);
        this.res = findViewById(R.id.res);
        this.clear = findViewById(R.id.clear);
        this.Tools = new Tools();
		this.FF = new FluidFlow();
        this.physic = new Physic();
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fluid_flow_flow_rate3);
		this.initialize();
        
		this.vaz.setOnClickListener(
            new OnClickListener() {
				public void onClick(View view) {

                    if (Tools.isNull(ra.getText().toString())) {
                        ra.setError(getText(R.string.null_field));
                        verifyRaio = false;
                    } else if (Tools.isDot(ra.getText().toString())) {
                        ra.setError(getText(R.string.dot_value));
                        verifyRaio = false;
                    } else {
                        raio = Double.valueOf(ra.getText().toString());
                        verifyRaio = true;
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


                    if (verifyRaio && verifyVelocity) {
                        res.setText((CharSequence) FF.tFluidFlow(raio, velocidade, physic.GET_STEP));
                        
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
                    ra.setText(null);
                    vel.setText(null);
                    res.setText(null);
                    
                    return;
                }
            });
	}
}
