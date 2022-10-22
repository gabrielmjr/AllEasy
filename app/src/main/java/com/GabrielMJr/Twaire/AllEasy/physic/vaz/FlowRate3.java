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

public class FlowRate3 extends MyActivity {

	// Atrubutos
	private static EditText ra;
	private static EditText vel;
	private static TextView vaz;
	private static TextView res;
    
	private static Tools Tools;
	private static Double velocidade;
	private static Double raio;
	private static int verifyRaio;
	private static int verifyVelocity;
	private static FluidFlow FF;
    private static Physic physic;
    
    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));
        
        this.ra = findViewById(R.id.ra);
        this.vel = findViewById(R.id.vel);
        this.vaz = findViewById(R.id.vaz);
        this.res = findViewById(R.id.res);
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
                        verifyRaio = 0;
                    } else if (Tools.isDot(ra.getText().toString())) {
                        ra.setError(getText(R.string.dot_value));
                        verifyRaio = 0;
                    } else {
                        raio = Double.valueOf(ra.getText().toString());
                        verifyRaio = 1;
                    }

                    
                    if (Tools.isNull(vel.getText().toString())) {
                        vel.setError(getText(R.string.null_field));
                        verifyVelocity = 0;
                    } else if (Tools.isDot(vel.getText().toString())) {
                        vel.setError(getText(R.string.dot_value));
                        verifyVelocity = 0;
                    } else {
                        velocidade = Double.valueOf(vel.getText().toString());
                        verifyVelocity = 1;
                    }


                    if (verifyRaio == 1 && verifyVelocity == 1) {
                        res.setText((CharSequence) FF.tFluidFlow(raio, velocidade, physic.GET_STEP));
                    } else {
                        return;
                    }
				}
			});
	}
}
