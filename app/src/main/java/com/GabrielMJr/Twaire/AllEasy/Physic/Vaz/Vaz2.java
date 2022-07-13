package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.os.Bundle;
import android.app.Activity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.AllEasy.tools.Tools;
import com.GabrielMJr.Twaire.AllEasy.Physic.OpEngeneer.FOpEngeneer;


public class Vaz2 extends Activity
{
	
	// Atributos
	private static EditText vel;
	private static TextView vaz;
	private static EditText ar;
	private static TextView res;
	private static Tools Tools;
	private static int verifyVelocity;
	private static int verifyArea;
	private static Double velocidade;
	private static Double area;
	private static FOpEngeneer FP;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vaz2);
		
		this.vel = findViewById(R.id.vel);
		this.vaz = findViewById(R.id.vaz);
		this.ar = findViewById(R.id.ar);
		this.res = findViewById(R.id.res);
		this.Tools = new Tools();
		this.FP = new FOpEngeneer();
		
		
		this.vaz.setOnClickListener(
		  new OnClickListener() {
				public void onClick(View view) {
					
					if (Tools.isNull(Vaz2.vel.getText().toString())) {
						Toast.makeText(Vaz2.this, "Não é possível calcular com <Velocidade> nula!", Toast.LENGTH_SHORT).show();
						Vaz2.verifyVelocity = 0;
					} else {
						Vaz2.velocidade = Double.valueOf(Vaz2.vel.getText().toString());
						Vaz2.verifyVelocity = 1;
					}
					
					if (Tools.isNull(Vaz2.ar.getText().toString())) {
						Toast.makeText(Vaz2.this, "Não é possível calcular com <Área> nula!", Toast.LENGTH_SHORT).show();
						Vaz2.verifyArea = 0;
					} else {
						Vaz2.area = Double.valueOf(Vaz2.ar.getText().toString());
						Vaz2.verifyArea = 1;
					}
					
					if (Vaz2.verifyVelocity == 1 && Vaz2.verifyArea == 1) {
						
						FP.setAV(Vaz2.area, Vaz2.velocidade);
						
						Vaz2.res.setText((CharSequence) "Q = "
						             + Vaz2.ar.getText().toString()
												 + "m²"
												 + " × "
												 + Vaz2.vel.getText().toString()
												 + "m/s");
												 
					 Vaz2.res.setText((CharSequence) Vaz2.res.getText().toString()
					                   + "\n"
														 + "Q = "
														 + FP.getVres()
														 + "m³/s");
						
					} else {
						return;
					}
				}
			});
	}
}
