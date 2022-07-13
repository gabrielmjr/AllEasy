package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import com.GabrielMJr.Twaire.AllEasy.Physic.OpEngeneer.FOpEngeneer;
import com.GabrielMJr.Twaire.AllEasy.R;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.AllEasy.tools.Tools;
import android.widget.Toast;

public class Vaz1 extends Activity
	{

		private static FOpEngeneer FE;
		private static EditText vol;
		private static EditText dt;
		private static TextView vaz;
		private static Double volume;
		private static Double time;
		private static Tools Tools;
		private static int verifyVolume;
		private static int verifyTime;
		private static TextView res;

		@Override
		public void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.vaz1);

				this.vol = findViewById(R.id.vol);
				this.dt = findViewById(R.id.dt);
				this.vaz = findViewById(R.id.vaz);
				this.res = findViewById(R.id.res);
				this.FE = new FOpEngeneer();
				this.Tools = new Tools();
						
				this.vaz.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{				
									
									if (Tools.isNull(Vaz1.vol.getText().toString()))
										{
											Toast.makeText(Vaz1.this, "Não é possível calcular com <Volume> nulo!", Toast.LENGTH_SHORT).show();
											Vaz1.verifyVolume = 0; // Retorna 0 se true
										}
									else
										{
											Vaz1.volume = Double.valueOf(Vaz1.vol.getText().toString());
											Vaz1.verifyVolume = 1; // Retorna 1 se false
										}

									if (Tools.isNull(Vaz1.dt.getText().toString()))
										{
											Toast.makeText(Vaz1.this, "Não é possível calcar com <Tempo> nulo!", Toast.LENGTH_SHORT).show();
											Vaz1.verifyTime = 0;
										}
									else
										{
											Vaz1.time = Double.valueOf(dt.getText().toString());
											Vaz1.verifyTime = 1;
										}


									// Se os valores VerifyVolume e time == 1, efetuar operação
									if (Vaz1.verifyVolume == 1 && Vaz1.verifyTime == 1)
										{
											FE.setTV(Vaz1.time, Vaz1.volume);
											Vaz1.res.setText((CharSequence) "Q = "
																			 + String.valueOf(Vaz1.volume) 
																			 + "m³"
																			 + "/"
																			 + Vaz1.time
																			 + "s");
																			 
										 Vaz1.res.setText((CharSequence) Vaz1.res.getText().toString()
										                  + "\n"
																			+ "Q = "
																			+ FE.getVres()
																			+ "m³/s");
										}
									else
										{
											return;
										}
								}
						});
			}
	}
