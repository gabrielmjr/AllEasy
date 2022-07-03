package com.GabrielMJr.Twaire.AllEasy.Math;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer.MathE;

public class FSG extends Activity
	{
		//Atrubutos
		private static Button calculate;
		private static EditText a;
		private static EditText b;
		private static EditText c;
		private static String ax;
		private static String bx;
		private static String cx;
		private static TextView result;
		private static MathE MathE;
		private static int av;
		private static int bv;
		private static int cv;
		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.fsg);
				this.a = (EditText) findViewById(R.id.a);
				this.b = (EditText) findViewById(R.id.b);
				this.c = (EditText) findViewById(R.id.c);
				this.calculate = (Button) findViewById(R.id.calculate);
				this.result = (TextView)  findViewById(R.id.result);
				this.MathE = new MathE();

				// Onclick do botão "determinar"
				this.calculate.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{

									// Armazenar valores de a, b e c em suas variavéis+"x"
									FSG.ax = a.getText().toString();
									FSG.bx = b.getText().toString();
									FSG.cx = c.getText().toString();

									// Verificar se valor de <a> é nulo ou não
									if (MathE.isNull(FSG.ax))
										{
											Toast.makeText(FSG.this, "Não é possível com <a> nulo! Insira o valor de <a> correctamente.", Toast.LENGTH_SHORT).show();
											FSG.av = 0;
										}
									else
										{ try
												{
													int a = Integer.valueOf(FSG.ax);
													FSG.av = 1;
												}
											catch (Exception e)
												{
													Toast.makeText(FSG.this, "Insira o valor de <a> correctamente.", Toast.LENGTH_SHORT).show();
													FSG.av = 0;
												}
										}

									// Verificar se valor de <b> é ou não nulo
									if (MathE.isNull(FSG.bx))
										{
											Toast.makeText(FSG.this, "Não é possível com <b> nulo! Insira o valor de <a> correctamente.", Toast.LENGTH_SHORT).show();
											FSG.bv = 0;
										}
									else
										{ try
												{
													int b = Integer.valueOf(FSG.bx);
													FSG.bv = 1;
												}
											catch (Exception e)
												{
													Toast.makeText(FSG.this, "Insira o valor de <b> correctamente.", Toast.LENGTH_SHORT).show();
												}
										}

									// Verificar se valor de <c> é ou não nulo
									if (MathE.isNull(FSG.cx))
										{
											Toast.makeText(FSG.this, "Não é possível com <c> nulo! Insira o valor de <c> correctamente.", Toast.LENGTH_SHORT).show();
											FSG.cv = 0;
										}
									else
										{ try
												{
													int c = Integer.valueOf(FSG.cx);
													FSG.cv = 1;
												}
											catch ( Exception e)
												{
													Toast.makeText(FSG.this, "Insira o valor de <c> correctamente.", Toast.LENGTH_SHORT).show();				
													FSG.cv = 0;
												}
										}

									// Se os valores forem inseridos correctamente, prossiga normalmente
									if ((FSG.av == 1) && (FSG.bv == 1) && (FSG.cv == 1))
										{

											MathE.setABC(Double.valueOf(FSG.ax), Long.valueOf(FSG.bx), Long.valueOf(FSG.cx));
											result.setText((CharSequence) "∆ = "
																		 + MathE.getFSGInfo()[ 3 ]
																		 + "\nx1 = "
																		 + MathE.getFSGInfo()[ 4 ]
																		 + "     x2 = " 
																		 + MathE.getFSGInfo()[ 5 ]
																		 + "\nDf = "
																		 + MathE.getFSGInfo()[ 6 ]
																		 + "     D'f = "
																		 + MathE.getFSGInfo()[ 7 ]
																		 + "\nXv = "
																		 + MathE.getFSGInfo()[ 8 ]
																		 + "     Yv = "
																		 + MathE.getFSGInfo()[ 9 ]
																		 + "\nOrdenada na origem = "
																		 + MathE.getFSGInfo()[ 10 ]
																		 + "\nEquação do eixo de simetria = "
																		 + MathE.getFSGInfo()[ 11 ]
																		 + "\nConcavidade virada para"
																		 + MathE.getFSGInfo()[ 12 ]);

											// Senão, retorna um vazio
										}
									else
										{
											return;
										}
								}
						});
			}
	}
