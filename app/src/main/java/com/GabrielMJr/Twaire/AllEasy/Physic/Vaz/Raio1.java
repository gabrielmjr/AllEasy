package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.os.Bundle;
import android.app.Activity;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.AllEasy.tools.Tools;
import com.GabrielMJr.Twaire.AllEasy.tools.Constantes;
import com.GabrielMJr.Twaire.AllEasy.Physic.OpEngeneer.FOpEngeneer;


public class Raio1 extends Activity
	{

		// Atrubutos
		private static EditText vaz;
		private static EditText vel;
		private static TextView raio;
		private static TextView res;
		private static int verifyVaz;
		private static int verifyVelocity;
		private static Double vazao;
		private static Double velocidade;
		private static Constantes CT;
		private static Tools Tools;
		private static FOpEngeneer FP;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.raio1);

				this.vaz = findViewById(R.id.vaz);
				this.vel = findViewById(R.id.vel);
				this.raio = findViewById(R.id.raio);
				this.res = findViewById(R.id.res);
				this.CT = new Constantes();
				this.Tools = new Tools();
				this.FP = new FOpEngeneer();

				this.raio.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{

									if (Tools.isNull(Raio1.vaz.getText().toString()))
										{
											Toast.makeText(Raio1.this, "Não é possível com <Vazão> nulo!", Toast.LENGTH_SHORT).show();
											Raio1.verifyVaz = 0;
										}
									else
										{
											Raio1.vazao = Double.valueOf(Raio1.vaz.getText().toString());
											Raio1.verifyVaz = 1;
										}

									if (Tools.isNull(Raio1.vel.getText().toString()))
										{
											Toast.makeText(Raio1.this, "Não é possível calcular com <Velocidade> nula!", Toast.LENGTH_SHORT).show();
											Raio1.verifyVelocity = 0;
										}
									else
										{
											Raio1.velocidade = Double.valueOf(Raio1.vel.getText().toString());
											Raio1.verifyVelocity = 1;
										}

									if (Raio1.verifyVaz == 1 && Raio1.verifyVelocity == 1)
										{
											FP.setQv(Raio1.vazao, Raio1.velocidade, 2);
											Raio1.res.setText((CharSequence) "r = "
																				+ "√[("
																				+ Raio1.vazao
																				+ "m³/s) / ("
																				+ CT.getPi(3)
																				+ " × "
																				+ Raio1.velocidade
																				+ "m/s"
																				+ ")]");

											Raio1.res.setText((CharSequence) Raio1.res.getText().toString()
																				+ "\n"
																				+ "r = "
																				+ "√[("
																				+ Raio1.vazao
																				+ "m³/s) / ("
																				+ FP.getRaioRes()[ 0 ]
																				+ "m/s)]");

											Raio1.res.setText((CharSequence) Raio1.res.getText().toString()
																				+ "\n"
																				+ "r ="
																				+ "√("
																				+ FP.getRaioRes()[ 1 ]
																				+ "m²");

											Raio1.res.setText((CharSequence) Raio1.res.getText().toString()
																				+ "\n"
																				+ "r = "
																				+ FP.getRaioRes()[ 2 ]
																				+ "m");

										}
									else
										{
											return;
										}
								}
						});
			}
	}
