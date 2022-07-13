package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.os.Bundle;
import android.app.Activity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.AllEasy.Physic.OpEngeneer.FOpEngeneer;
import com.GabrielMJr.Twaire.AllEasy.tools.Tools;

public class Velocidade1 extends Activity
	{

		// Atributos
		private static EditText vaz;
		private static EditText ar;
		private static int verifyVaz;
		private static int verifyAr;
		private static Double vazao;
		private static Double area;
		private static TextView vel;
		private static TextView res;
		private static FOpEngeneer FP;
		private static Tools Tools;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.velocidade1);

				this.vaz = findViewById(R.id.vaz);
				this.ar = findViewById(R.id.ar);
				this.vel = findViewById(R.id.vel);
				this.res = findViewById(R.id.res);
				this.FP = new FOpEngeneer();
				this.Tools = new Tools();

				this.vel.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{
									if (Tools.isNull(Velocidade1.vaz.getText().toString()))
										{
											Toast.makeText(Velocidade1.this, "Não é possível calcular com <Vazão> nulo!", Toast.LENGTH_SHORT).show();
											Velocidade1.verifyVaz = 0;
										}
									else
										{
											Velocidade1.vazao = Double.valueOf(Velocidade1.vaz.getText().toString());
											Velocidade1.verifyVaz = 1;
										}

									if (Tools.isNull(Velocidade1.ar.getText().toString()))
										{
											Toast.makeText(Velocidade1.this, "Não é possível calcular com <Área> nula!", Toast.LENGTH_SHORT).show();
											Velocidade1.verifyAr = 0;
										}
									else
										{
											Velocidade1.area = Double.valueOf(Velocidade1.ar.getText().toString());
											Velocidade1.verifyAr = 1;
										}

									if (Velocidade1.verifyVaz == 1 && Velocidade1.verifyAr == 1)
										{
											Velocidade1.FP.setQA(Velocidade1.vazao, Velocidade1.area);
											Velocidade1.res.setText((CharSequence) "v = ("
																							+ String.valueOf(vazao)
																							+ "m³/s) / ("
																							+ Velocidade1.area
																							+ "m²)");
											Velocidade1.res.setText((CharSequence) Velocidade1.res.getText().toString()
																							+ "\n"
																							+ "v = "
																							+ FP.getVelocidadeRes()
																							+ "m/s");

										}
									else
										{
											return;
										}
								}
						});
			}
	}
