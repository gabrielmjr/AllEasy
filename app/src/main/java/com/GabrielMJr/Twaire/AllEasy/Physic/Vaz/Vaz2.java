package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.os.Bundle;
import android.app.Activity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.tools.StringAnalyst;
import com.GabrielMJr.Twaire.Physic.FluidFlow;


public class Vaz2 extends Activity {

	// Atributos
	private static EditText vel;
	private static TextView vaz;
	private static EditText ar;
	private static TextView res;
	private static StringAnalyst StringAnalyst;
	private static int verifyVelocity;
	private static int verifyArea;
	private static Double velocidade;
	private static Double area;
	private static FluidFlow FF;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vaz2);

		this.vel = findViewById(R.id.vel);
		this.vaz = findViewById(R.id.vaz);
		this.ar = findViewById(R.id.ar);
		this.res = findViewById(R.id.res);
		this.StringAnalyst = new StringAnalyst();
		this.FF = new FluidFlow();


		this.vaz.setOnClickListener(
            new OnClickListener() {
				public void onClick(View view) {

                    try {
                        if (StringAnalyst.isNull(ar.getText().toString())) {
                            Toast.makeText(Vaz2.this, R.string.area_null, Toast.LENGTH_SHORT).show();
                            verifyArea = 0;
                        } else {
                            area = Double.valueOf(ar.getText().toString());
                            verifyArea = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(Vaz2.this, R.string.insert_area_well, Toast.LENGTH_SHORT).show();
                        verifyArea = 0;
                    }


                    try {
                        if (StringAnalyst.isNull(vel.getText().toString())) {
                            Toast.makeText(Vaz2.this, R.string.vel_null, Toast.LENGTH_SHORT).show();
                            verifyVelocity = 0;
                        } else {
                            velocidade = Double.valueOf(vel.getText().toString());
                            verifyVelocity = 1;
                        }

                    } catch (Exception error) {
                        Toast.makeText(Vaz2.this, R.string.insert_velocity_well, Toast.LENGTH_SHORT).show();
                        verifyVelocity = 0;
                    }

                    if (verifyVelocity == 1 && verifyArea == 1) {
                        res.setText((CharSequence) "Q = "
                                         + ar.getText().toString()
                                         + "m²"
                                         + " × "
                                         + vel.getText().toString()
                                         + "m/s");

                        res.setText((CharSequence) res.getText().toString()
                                         + "\nQ = "
                                         + FF.sfluidFlow(area, velocidade)
                                         + "m³/s");

                    } else {
                        return;
                    }
                }
			});
	}
}
