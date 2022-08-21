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
import com.GabrielMJr.Twaire.Math.SDF;
import com.GabrielMJr.Twaire.tools.StringAnalyst;

public class FSG extends Activity
	{
		//Atrubutos
		private Button calculate;
		private EditText a;
		private EditText b;
		private EditText c;
		private String ax;
		private String bx;
		private String cx;
		private TextView result;
		private SDF SDF;
		private int av;
		private int bv;
		private int cv;
		private StringAnalyst StringAnalyst;
		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.fsg);
				this.a = findViewById(R.id.a);
				this.b = findViewById(R.id.b);
				this.c = findViewById(R.id.c);
				this.calculate = findViewById(R.id.calculate);
				this.result = findViewById(R.id.result);
				this.SDF = new SDF();
				this.StringAnalyst = new StringAnalyst();

				// Onclick do botão "determinar"
				this.calculate.setOnClickListener(
					new OnClickListener() {
							public void onClick(View view)
								{

									// Armazenar valores de a, b e c em suas variavéis+"x"
									ax = a.getText().toString();
									bx = b.getText().toString();
									cx = c.getText().toString();

									// Verificar se valor de <a> é nulo ou não
									if (StringAnalyst.isNull(ax))
										{
											Toast.makeText(FSG.this, R.string.a_null_fsg, Toast.LENGTH_SHORT).show();
											av = 0;
										}
									else
										{ try
												{
													int a = Integer.valueOf(ax);
													av = 1;
												}
											catch (Exception e)
												{
													Toast.makeText(FSG.this, R.string.a_incorrect_fsg, Toast.LENGTH_SHORT).show();
													av = 0;
												}
										}

									// Verificar se valor de <b> é ou não nulo
									if (StringAnalyst.isNull(bx))
										{
											Toast.makeText(FSG.this, R.string.b_null_fsg, Toast.LENGTH_SHORT).show();
											bv = 0;
										}
									else
										{ try
												{
													int b = Integer.valueOf(bx);
													bv = 1;
												}
											catch (Exception e)
												{
													Toast.makeText(FSG.this, R.string.b_incorrect_fsg, Toast.LENGTH_SHORT).show();
                                                    bv = 0;
												}
										}

									// Verificar se valor de <c> é ou não nulo
									if (StringAnalyst.isNull(cx))
										{
											Toast.makeText(FSG.this, R.string.c_null_fsg, Toast.LENGTH_SHORT).show();
											cv = 0;
										}
									else
										{ try
												{
													int c = Integer.valueOf(cx);
												cv = 1;
												}
											catch ( Exception e)
												{
													Toast.makeText(FSG.this, R.string.c_incorrect_fsg, Toast.LENGTH_SHORT).show();				
													cv = 0;
												}
										}

									// Se os valores forem inseridos correctamente, prossiga normalmente
									if ((av == 1) && (bv == 1) && (cv == 1))
										{

										    SDF.setABC(Long.valueOf(ax), Long.valueOf(bx), Long.valueOf(cx));
											result.setText((CharSequence) SDF.getStepDelta()[0]
                                                                         + "\n" + SDF.getStepDelta()[1]
                                                                         + "\n" + SDF.getStepDelta()[2]
                                                                         + "\n" + SDF.getStepDelta()[3]
																		 + "\n" + SDF.getStepDelta()[4]
																		 + "\n\nx1 = "
																		 + SDF.getX1()
																		 + "     x2 = " 
																		 + SDF.getX2()
																		 + "\n\nDf = "
																		 + SDF.getDominio()
																		 + "     D'f = "
																		 + SDF.getContraDominio()
																		 + "\n\nXv = "
																		 + SDF.getXv()
																		 + "     Yv = "
																		 + SDF.getYv()
																		 + "\n\n"
                                                                         + "Ordenada na origem = "
																		 + SDF.getOrdenadaNaOrigem()
																		 + "\nEquação do eixo de simetria = "
																		 + SDF.getEES()
																		 + "\n\nConcavidade virada para"
																		 + SDF.getConcavidade());

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
