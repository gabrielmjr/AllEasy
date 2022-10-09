package com.GabrielMJr.Twaire.AllEasy.physic.vaz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import com.gabrielMJr.twaire.tools.Tools;
import com.gabrielMJr.twaire.physic.FluidFlow;
import android.support.v7.widget.Toolbar;

public class FlowRate2 extends AppCompatActivity {

	// Atributos
	private static EditText vel;
	private static TextView vaz;
	private static EditText ar;
	private static TextView res;
    private static Toolbar toolbar;
    
	private static Tools Tools;
	private static int verifyVelocity;
	private static int verifyArea;
	private static Double velocidade;
	private static Double area;
	private static FluidFlow FF;
    
    private void initialize() {
        this.vel = findViewById(R.id.vel);
        this.vaz = findViewById(R.id.vaz);
        this.ar = findViewById(R.id.ar);
        this.res = findViewById(R.id.res);
        this.toolbar = findViewById(R.id.toolbar);
        this.Tools = new Tools();
		this.FF = new FluidFlow();
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fluid_flow_flow_rate2);
		this.initialize();
        setSupportActionBar(toolbar);

		this.vaz.setOnClickListener(
            new OnClickListener() {
				public void onClick(View view) {

                    if (Tools.isNull(ar.getText().toString())) {
                        ar.setText(getText(R.string.null_field));
                        verifyArea = 0;
                    } else if (Tools.isDot(ar.getText().toString())) {
                        ar.setError(getText(R.string.dot_value));
                        verifyArea = 0;
                    } else {
                        area = Double.valueOf(ar.getText().toString());
                        verifyArea = 1;
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

                    
                    if (verifyVelocity == 1 && verifyArea == 1) {
                        res.setText(getText(R.string.flowRatep)
                                    + " "
                                    + Tools.normalize(Tools.expNormalizer(area))
                                    + getText(R.string.amq)
                                    + " "
                                    + getText(R.string.multiplication)
                                    + " "
                                    + Tools.normalize(Tools.expNormalizer(velocidade))
                                    + getText(R.string.speedmps));

                        res.setText((CharSequence) res.getText().toString()
                                    + "\n"
                                    + getText(R.string.flowRatep)
                                    + " "
                                    + FF.sFluidFlow(area, velocidade)
                                    + getText(R.string.speedmcps));

                    } else {
                        return;
                    }
                }
			});
	}
}
