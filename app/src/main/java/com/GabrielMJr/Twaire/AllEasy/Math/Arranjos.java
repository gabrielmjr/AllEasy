
package com.GabrielMJr.Twaire.AllEasy.Math;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer.MathE;
import com.GabrielMJr.Twaire.AllEasy.R;

public class Arranjos extends Activity
	{

		// Atrubutes
		private static EditText n;
		private static EditText p;
		private static TextView a;
		private static TextView result;
		private static MathE MathE;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.arranjos);

				this.n = (EditText) findViewById(R.id.n);
				this.p = (EditText) findViewById(R.id.p);
				this.a = (TextView) findViewById(R.id.a);
				this.result = (TextView) findViewById(R.id.result);
				this.MathE = new MathE();


				this.a.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{
									try
										{
											if (Integer.valueOf(n.getText().toString()) < Integer.valueOf(p.getText().toString()))
												{
													Toast.makeText(Arranjos.this, "Não é possível com <n> menor que <p>.", Toast.LENGTH_SHORT).show();
												}
											else
												{
													// Mandar n e p para OpEngeneer e pegar a String[] result
													MathE.setNP(Long.valueOf(n.getText().toString()), Long.valueOf(p.getText().toString()));
													
													if (MathE.getArrResult()[ 0 ] < 0) {
														Toast.makeText(Arranjos.this, "Valores muito elevados.", Toast.LENGTH_SHORT).show();
													} else {
													result.setText((CharSequence) "=" + String.valueOf(MathE.getArrResult()[ 0 ]));
													}
												}


										}
									catch (Exception e)
										{
											switch (n.getText().toString().replaceAll("\\s", ""))
												{
													case "":
														Toast.makeText(Arranjos.this, "Não é possível com <n> nulo.", Toast.LENGTH_SHORT).show();
														break;

													default:
														break;
												}

											switch (p.getText().toString().replaceAll("\\s", ""))
												{
													case "":
														Toast.makeText(Arranjos.this, "Não é possível com <p> nulo.", Toast.LENGTH_SHORT).show();
														break;

													default:
														return;
												}
										}
								}
						});

			}
	}
