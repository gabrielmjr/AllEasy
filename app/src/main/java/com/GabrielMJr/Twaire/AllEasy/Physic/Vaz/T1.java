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
import com.GabrielMJr.Twaire.AllEasy.Physic.OpEngeneer.FOpEngeneer;

public class T1 extends Activity
	{

		// Atrubutos
		private static EditText vol;
		private static EditText vaz;
		private static TextView tempo;
		private static TextView res;
		private static int verifyVol;
		private static int verifyVaz;
		private static Double volume;
		private static Double vazao;
		private static FOpEngeneer FP;
		private static Tools Tools;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.t1);

				this.vol = findViewById(R.id.vol);
				this.vaz = findViewById(R.id.vaz);
				this.tempo = findViewById(R.id.tempo);
				this.res = findViewById(R.id.res);
				this.Tools = new Tools();
				this.FP = new FOpEngeneer();

				this.tempo.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{
									if (T1.Tools.isNull(vol.getText().toString()))
										{
											Toast.makeText(T1.this, "Não é possível calcular com <Volume> nulo!", Toast.LENGTH_SHORT).show();
											T1.verifyVol = 0;
										}
									else
										{
											T1.volume = Double.valueOf(vol.getText().toString());
											T1.verifyVol = 1;
										}

									if (T1.Tools.isNull(T1.vaz.getText().toString()))
										{
											Toast.makeText(T1.this, "Não é possível calcular com <Vazão> nulo!", Toast.LENGTH_SHORT).show();
											T1.verifyVaz = 0;
										}
									else
										{
											T1.vazao = Double.valueOf(T1.vaz.getText().toString());
											T1.verifyVaz = 1;
										}

									if (T1.verifyVaz == 1 && T1.verifyVol == 1)
										{
											FP.setVQ(volume, vazao);
											T1.res.setText((CharSequence) "∆t = "
																		 + String.valueOf(volume)
																		 + "m³ / ("
																		 + vazao
																		 + "m³/s)");

											T1.res.setText((CharSequence) T1.res.getText().toString()
																		 + "\n"
																		 + "∆t = "
																		 + FP.getTempoRes()
																		 + "s");

										}
									else
										{
											return;
										}
								}
						});

			}
	}

