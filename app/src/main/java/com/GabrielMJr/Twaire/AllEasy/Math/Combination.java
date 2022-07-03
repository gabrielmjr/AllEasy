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

public class Combination extends Activity
	{

		// Atributes
		private static EditText n;
		private static EditText p;
		private static TextView c;
		private static String[] res = new String[4];
		private static TextView result;
		private static MathE MathE;



		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.combination);

				// Atributos
				this.n = (EditText) findViewById(R.id.n);
				this.p = (EditText) findViewById(R.id.p);
				this.c = (TextView) findViewById(R.id.c);
				this.result = (TextView) findViewById(R.id.result);
				this.MathE = new MathE();

				this.c.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{

									try
										{
											// Valores de n e p do .xml
											Long nn = Long.valueOf(n.getText().toString());
											Long pp = Long.valueOf(p.getText().toString());

											if (nn < pp)
												{
													Toast.makeText(Combination.this, "Não é possível com <n> menor aie <p>.", Toast.LENGTH_SHORT).show();
												}
											else
												{

													// Mandar n para OpEngeneer.Math e pegar a String result
													MathE.setNP(nn, nn);
													String nfat = String.valueOf(MathE.getArrResult()[ 0 ]);

													// Mandar n-p para OpEngeneer.Math e pegar a String result
													MathE.setNP((nn - pp), (nn - pp));
													String nmpfat = String.valueOf(MathE.getArrResult()[ 0 ]);

													// Mandar p para OpEngeneer.Math e pegar a String result
													MathE.setNP(pp, pp);
													String pfat = String.valueOf(MathE.getArrResult()[ 0 ]);

													// Resultado final de Combinação
													String resfat = String.valueOf(Double.valueOf(nfat) / (Double.valueOf(nmpfat) * Double.valueOf(pfat)));

													// Mandar todos os resultados para uma String[] result
													Combination.setRes(nfat, pfat, nmpfat, resfat);

													// Mandar resultados para o .xml
													result.setText(
														(CharSequence) "n! = "
														+ String.valueOf(Combination.getRes()[ 0 ])
														+ "\np! = "
														+ String.valueOf(Combination.getRes()[ 1 ])
														+ "\n(n-p)! = "
														+ String.valueOf(Combination.getRes()[ 2 ])
														+ "\nResultado = "
														+ String.valueOf(Combination.getRes()[ 3 ]));
												}
										}
									catch (Exception e)
										{
											switch (n.getText().toString().replaceAll("\\s", ""))
												{
													case "":
														Toast.makeText(Combination.this, "Não é possível com <n> nulo.", Toast.LENGTH_SHORT).show();
														break;

													default:
														break;
												}

											switch (p.getText().toString().replaceAll("\\s", ""))
												{
													case "":
														Toast.makeText(Combination.this, "Não é possívsl com <p> nulo.", Toast.LENGTH_SHORT).show();

													default:
														return;
												}
										}
								}
						});
			}

		// Setters e getters
		private static void setRes(String nfat, String pfat, String nmpfat, String resfat)
			{
				Combination.res[ 0 ] = nfat;
				Combination.res[ 1 ] = pfat;
				Combination.res[ 2 ] = nmpfat;
				Combination.res[ 3 ] = resfat;
			}

		private static String[] getRes()
			{
				return res;
			}
	}
