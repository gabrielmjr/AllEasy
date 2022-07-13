package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import com.GabrielMJr.Twaire.AllEasy.tools.Tools;
import com.GabrielMJr.Twaire.AllEasy.Physic.OpEngeneer.FOpEngeneer;
import android.app.Activity;
import android.os.Bundle;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class Volume1 extends Activity
	{

		// Atributos
		private static EditText tempo;
		private static EditText vaz;
		private static TextView vol;
		private static TextView res;
		private static int verifyTime;
		private static int verifyVaz;
		private static Double vazao;
		private static Double time;
		private static FOpEngeneer FP;
		private static Tools Tools;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.volume1);

				this.tempo = findViewById(R.id.time);
				this.vaz = findViewById(R.id.vaz);
				this.vol = findViewById(R.id.vol);
				this.res = findViewById(R.id.res);
				this.FP = new FOpEngeneer();
				this.Tools = new Tools();

				this.vol.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{
									if (Volume1.Tools.isNull(Volume1.tempo.getText().toString()))
										{
											Toast.makeText(Volume1.this, "Não é possível calcular com <Tempo> nulo!", Toast.LENGTH_SHORT).show();
											Volume1.verifyTime = 0;
										}
									else
										{
											Volume1.time = Double.valueOf(Volume1.tempo.getText().toString());
											Volume1.verifyTime = 1;
										}

									if (Volume1.Tools.isNull(vaz.getText().toString()))
										{
											Toast.makeText(Volume1.this, "Não é possível com <Vazão> nulo!", Toast.LENGTH_SHORT).show();
											Volume1.verifyVaz = 0;
										}
									else
										{
											Volume1.vazao = Double.valueOf(vaz.getText().toString());
											Volume1.verifyVaz = 1;
										}

									if (Volume1.verifyTime == 1 && Volume1.verifyVaz == 1)
										{
											Volume1.FP.setTQ(time, vazao);
											Volume1.res.setText((CharSequence) "V = "
																					+ String.valueOf(time)
																					+ "{s}" 
																					+ " × "
																					+ vazao
																					+ "m³/{s}");

											Volume1.res.setText((CharSequence) Volume1.res.getText().toString()
																					+ "\n"
																					+ "V = "
																					+ FP.getVolumeRes()
																					+ "m³");

										}
									else
										{
											return;
										}

								}			
						});
			}
	}
