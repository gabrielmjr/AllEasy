package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.os.Bundle;
import android.app.Activity;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.Physic.OpEngeneer.FOpEngeneer;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.AllEasy.tools.Tools;

public class Area1 extends Activity
	{

		// Atrubutos
		private static EditText vaz;
		private static EditText vel;
		private static TextView area;
		private static TextView res;
		private static int verifyVaz;
		private static int verifyVel;
		private static FOpEngeneer FP;
		private static Double vazao;
		private static Double velocidade;
		private static Tools Tools;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.a1);

				this.vel = findViewById(R.id.vel);
				this.vaz = findViewById(R.id.vaz);
				this.area = findViewById(R.id.area);
				this.res = findViewById(R.id.res);
				this.FP = new FOpEngeneer();
				this.Tools = new Tools();

				this.area.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{
									if (Tools.isNull(Area1.vaz.getText().toString()))
										{
											Toast.makeText(Area1.this, "Não é possível calcular com <Vazão> nulo!", Toast.LENGTH_SHORT).show();
											Area1.verifyVaz = 0;
										}
									else
										{
											Area1.vazao = Double.valueOf(Area1.vaz.getText().toString());
											Area1.verifyVaz = 1;
										}

									if (Tools.isNull(Area1.vel.getText().toString()))
										{
											Toast.makeText(Area1.this, "Não é possível calcular com <Velocidade> nula!", Toast.LENGTH_SHORT).show();
											Area1.verifyVel = 0;
										}
									else
										{
											Area1.velocidade = Double.valueOf(Area1.vel.getText().toString());
											Area1.verifyVel = 1;
										}

									if (Area1.verifyVaz == 1 && Area1.verifyVel == 1)
										{

											Area1.FP.setQv(vazao, velocidade, 1);
											Area1.res.setText((CharSequence) "A = ("
											                   + String.valueOf(Area1.vazao)
																				 + "m³/s)"
																				 + "/("
																				 + Area1.velocidade
																				 + "m/s)");
																				 
										 Area1.res.setText((CharSequence) Area1.res.getText().toString()
										                    + "\n"
																				+ "A = "
																				+ Area1.FP.getAreaVRes()
																				+ "m²");

										}
									else
										{
											return;
										}
								}
						});
			}
	}
