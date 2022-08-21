
package com.GabrielMJr.Twaire.AllEasy.Math;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.GabrielMJr.Twaire.Math.Arranjo;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.tools.StringAnalyst;

public class Arranjos extends Activity
	{

		// Atrubutes
		private static EditText n;
		private static EditText p;
		private static TextView a;
		private static TextView result;
		private static Arranjo Arranjo;
		private static StringAnalyst StringAnalyst;
		private static int verifyN;
		private static int verifyP;
		private static int vn;
		private static int vp;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.arranjos);

				this.n = findViewById(R.id.n);
				this.p = findViewById(R.id.p);
				this.a = findViewById(R.id.a);
				this.result = findViewById(R.id.result);
				this.Arranjo = new Arranjo();
				this.StringAnalyst = new StringAnalyst();


				this.a.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{

									if (StringAnalyst.isNull(Arranjos.n.getText().toString()))
										{
											Toast.makeText(Arranjos.this, R.string.n_null_math, Toast.LENGTH_SHORT).show();
											Arranjos.verifyN = 0; // Retorna 0 se nulo
										}
									else
										{
											Arranjos.vn = Integer.valueOf(n.getText().toString());
											Arranjos.verifyN = 1; // Retorna 1 se não nulo
										}

									if (StringAnalyst.isNull(Arranjos.p.getText().toString()))
										{
											Toast.makeText(Arranjos.this, R.string.p_null_math, Toast.LENGTH_SHORT).show();
											Arranjos.verifyP = 0;
										}
									else
										{
											Arranjos.vp = Integer.valueOf(Arranjos.p.getText().toString());
											Arranjos.verifyP = 1;
										}

										
									if (Arranjos.verifyN == 1 && Arranjos.verifyP == 1)
										{


											if (Arranjos.vn < Arranjos.vp)
												{
													Toast.makeText(Arranjos.this, R.string.p_big_than_n, Toast.LENGTH_SHORT).show();
												}
											else
												{
													// Mandar n e p para OpEngeneer e pegar a String[] result
													Long res = Arranjo.valueOf(Arranjos.vn, Arranjos.vp);

													if (res < 0)
														{
															Toast.makeText(Arranjos.this, R.string.big_values, Toast.LENGTH_SHORT).show();
														}
													else
														{
															result.setText((CharSequence) "=" + String.valueOf(res));
														}
												}
										}
									else
										{
											return;
										}	
								}
						}); 
			}
	}
