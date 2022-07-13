package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.os.Bundle;
import android.app.Activity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.AllEasy.tools.Tools;
import android.widget.Toast;
import com.GabrielMJr.Twaire.AllEasy.Physic.OpEngeneer.FOpEngeneer;
import com.GabrielMJr.Twaire.AllEasy.tools.Constantes;

public class Vaz3 extends Activity
{
	
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
	private static FOpEngeneer FP;
	private static Constantes CT;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vaz3);
		
		this.ra = findViewById(R.id.ra);
		this.vel = findViewById(R.id.vel);
		this.vaz = findViewById(R.id.vaz);
		this.res = findViewById(R.id.res);
		this.Tools = new Tools();
		this.FP = new FOpEngeneer();
		this.CT = new Constantes();
		
		this.vaz.setOnClickListener(
		  new OnClickListener() {
				public void onClick(View view) {
					
					if (Tools.isNull(Vaz3.ra.getText().toString())) {
						Toast.makeText(Vaz3.this, "Não é possível calcular com <raio> nulo!", Toast.LENGTH_SHORT).show();
						Vaz3.verifyRaio = 0;
					} else {
						Vaz3.raio = Double.valueOf(Vaz3.ra.getText().toString());
						Vaz3.verifyRaio = 1;
					}
					 
					if (Tools.isNull(Vaz3.vel.getText().toString())) {
						Toast.makeText(Vaz3.this, "Não é possível com <velocidade> nula!", Toast.LENGTH_SHORT).show();
						Vaz3.verifyVelocity = 0;
					} else {
						Vaz3.velocidade = Double.valueOf(Vaz3.vel.getText().toString());
						Vaz3.verifyVelocity = 1;
					}
					
					if (Vaz3.verifyRaio == 1 && Vaz3.verifyVelocity == 1) {
						
						// Mandar valores para Classe de Física
						FP.setRV(Vaz3.raio, Vaz3.velocidade);
						
						// Colocar valores e resultado em ordem na tela
						Vaz3.res.setText((CharSequence) "Q = "
						                  + String.valueOf(CT.getPi(3))
															+ " × ("
															+ Vaz3.ra.getText().toString()
															+ ")²"
															+ " × "
															+ Vaz3.vel.getText().toString());
															
					  Vaz3.res.setText((CharSequence) Vaz3.res.getText().toString()
						                  + "\n"
															+ "Q = "
															+ CT.getPi(3)
															+ " × "
															+ FP.getVRes3()[0]
															+ "m²"
															+ " × "
															+ Vaz3.velocidade
															+ "m/s");
															
						Vaz3.res.setText((CharSequence) Vaz3.res.getText().toString()
						                  + "\n"
						                  + FP.getVRes3()[1]
															+ "m²"
															+ " × "
															+ Vaz3.velocidade
															+ "m/s");
															
						Vaz3.res.setText((CharSequence) Vaz3.res.getText().toString()
						                  + "\n" 
					                    + FP.getVRes3()[2]
															+ "m³/s");
						
					} else {
						return;
					}
				}
			});
	}
}
