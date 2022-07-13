
package com.GabrielMJr.Twaire.AllEasy.Math;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer.MOpEngeneer;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.tools.Tools;

public class Arranjos extends Activity
	{

		// Atrubutes
		private static EditText n;
		private static EditText p;
		private static TextView a;
		private static TextView result;
		private static MOpEngeneer MOpEngeneer;
		private static Tools Tools;
		private static int verifyN;
		private static int verifyP;
		private static Long vn;
		private static Long vp;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.arranjos);

				this.n = (EditText) findViewById(R.id.n);
				this.p = (EditText) findViewById(R.id.p);
				this.a = (TextView) findViewById(R.id.a);
				this.result = (TextView) findViewById(R.id.result);
				this.MOpEngeneer = new MOpEngeneer();
				this.Tools = new Tools();


				this.a.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{

									if (Tools.isNull(Arranjos.n.getText().toString()))
										{
											Toast.makeText(Arranjos.this, "Não é possível determinar com <n> nulo!", Toast.LENGTH_SHORT).show();
											Arranjos.verifyN = 0; // Retorna 0 se nulo
										}
									else
										{
											Arranjos.vn = Long.valueOf(n.getText().toString());
											Arranjos.verifyN = 1; // Retorna 1 se não nulo
										}

									if (Tools.isNull(Arranjos.p.getText().toString()))
										{
											Toast.makeText(Arranjos.this, "Não é possível determinar com <p> nulo!", Toast.LENGTH_SHORT).show();
											Arranjos.verifyP = 0;
										}
									else
										{
											Arranjos.vp = Long.valueOf(Arranjos.p.getText().toString());
											Arranjos.verifyP = 1;
										}

										
									if (Arranjos.verifyN == 1 && Arranjos.verifyP == 1)
										{


											if (Arranjos.vn < Arranjos.vp)
												{
													Toast.makeText(Arranjos.this, "Não é possível com <n> menor que <p>.", Toast.LENGTH_SHORT).show();
												}
											else
												{
													// Mandar n e p para OpEngeneer e pegar a String[] result
													MOpEngeneer.setNP(Arranjos.vn, Arranjos.vp);

													if (MOpEngeneer.getArrResult()[ 0 ] < 0)
														{
															Toast.makeText(Arranjos.this, "Valores muito elevados.", Toast.LENGTH_SHORT).show();
														}
													else
														{
															result.setText((CharSequence) "=" + String.valueOf(MOpEngeneer.getArrResult()[ 0 ]));
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
