package com.GabrielMJr.Twaire.AllEasy.Math.SC;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer.MathE;
import com.GabrielMJr.Twaire.AllEasy.R;

public class F1 extends Activity
	{
		// Atributos
		private static EditText a;
		private static Button det;
		private static TextView result;
		private static MathE MathE;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.f1);
				this.a = findViewById(R.id.a);
				this.det = findViewById(R.id.det);
				this.result = findViewById(R.id.result);
				this.MathE = new MathE();

				det.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{
									try
										{											
											Double ax = Double.valueOf(F1.a.getText().toString());
											if (ax < 0)
												{
													Toast.makeText(F1.this, "Não é possível com <a> menor que 0.", Toast.LENGTH_SHORT).show();
												}
											else if (ax == 1)
												{
													Toast.makeText(F1.this, "Não é possível com <a> = 1.", Toast.LENGTH_SHORT).show();
												}
											else if (ax > 1)
												{									
													MathE.setA(Double.valueOf(a.getText().toString()));
													result.setText((CharSequence)
																				 "x      y"
																				 + "\n-8     "
																				 + MathE.getEXPResult()[ 0 ]
																				 + "\n-4     "
																				 + MathE.getEXPResult()[ 1 ]
																				 + "\n-2     "
																				 + MathE.getEXPResult()[ 2 ]
																				 + "\n-1     "
																				 + MathE.getEXPResult()[ 3 ]
																				 + "\n0      "
																				 + MathE.getEXPResult()[ 4 ]
																				 + "\n1      "
																				 + MathE.getEXPResult()[ 5 ]
																				 + "\n2      "
																				 + MathE.getEXPResult()[ 6 ]
																				 + "\n4      "
																				 + MathE.getEXPResult()[ 7 ]
																				 + "\n8      "
																				 + MathE.getEXPResult()[ 8 ]);
												}
										}
									catch (Exception e)
										{
											Toast.makeText(F1.this, "Insira o valor correctamente!", Toast.LENGTH_SHORT).show();
										}
								}
						});
			}
	}
