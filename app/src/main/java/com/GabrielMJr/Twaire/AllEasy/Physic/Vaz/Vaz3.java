package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.os.Bundle;
import android.app.Activity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.tools.StringAnalyst;
import android.widget.Toast;
import com.GabrielMJr.Twaire.Physic.FluidFlow;
//import com.GabrielMJr.Twaire.AllEasy.StringAnalyst.Constantes;

public class Vaz3 extends Activity {

	// Atrubutos
	private static EditText ra;
	private static EditText vel;
	private static TextView vaz;
	private static TextView res;
	private static StringAnalyst StringAnalyst;
	private static Double velocidade;
	private static Double raio;
	private static int verifyRaio;
	private static int verifyVelocity;
	private static FluidFlow FF;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vaz3);

		this.ra = findViewById(R.id.ra);
		this.vel = findViewById(R.id.vel);
		this.vaz = findViewById(R.id.vaz);
		this.res = findViewById(R.id.res);
		this.StringAnalyst = new StringAnalyst();
		this.FF = new FluidFlow();

		this.vaz.setOnClickListener(
            new OnClickListener() {
				public void onClick(View view) {

                    try {
                        if (StringAnalyst.isNull(ra.getText().toString())) {
                            Toast.makeText(Vaz3.this, R.string.raio_null, Toast.LENGTH_SHORT).show();
                            verifyRaio = 0;
                        } else {
                            raio = Double.valueOf(ra.getText().toString());
                            verifyRaio = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(Vaz3.this, R.string.insert_raio_well, Toast.LENGTH_SHORT).show();
                        verifyRaio = 0;
                    }

                    try {
                        if (StringAnalyst.isNull(vel.getText().toString())) {
                            Toast.makeText(Vaz3.this, R.string.vel_null, Toast.LENGTH_SHORT).show();
                            verifyVelocity = 0;
                        } else {
                            velocidade = Double.valueOf(vel.getText().toString());
                            verifyVelocity = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(Vaz3.this, R.string.insert_velocity_well, Toast.LENGTH_SHORT).show();
                        verifyVelocity = 0;
                    }
                    
                    if (verifyRaio == 1 && verifyVelocity == 1) {
                        res.setText((CharSequence) FF.tfluidFlow(raio, velocidade));
                    } else {
                        return;
                    }
				}
			});
	}
}
