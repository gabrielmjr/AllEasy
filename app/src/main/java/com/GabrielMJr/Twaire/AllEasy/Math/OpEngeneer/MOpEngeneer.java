package com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer;

import com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer.MathOpEngeneer;
import java.lang.Math;


/*
Classe de Operações Matemáticas
*/
public class MOpEngeneer implements MathOpEngeneer
	{

		//Atributos
		private static Long n;
		private static Long p;
		private static Double a;
		private static Long b;
		private static Long c;
		private static final int init = 8;
		private static final int fst = 2;
		private static int it;
		private static Long[] arrResult = new Long[2];
		private static String[] fsgResult = new String[ 13 ];
		private static Double[] expresult = new Double[ 9 ];



		/*
		 Calculadora de arranjos,
		 combination
		 e fatorial
		 */
		private static void genResult()
			{
				try
					{
						Long res = Long.valueOf(1);
						Long k = MOpEngeneer.getN();

						for (Long i = MOpEngeneer.getP(); i > 0; i--)
							{
								res = res * k;
								k--;
							}
						MOpEngeneer.setArrResult(Long.valueOf(res), Long.valueOf(1));
					}
				catch (Exception e)
					{
						MOpEngeneer.setArrResult(Long.valueOf(0), Long.valueOf(-1));
					}
			}





		/*
		 Calculadora de FSG (Função de segundo grau)
		 */
		// Definindo a,b e c de outra clase
		@Override
		public void setABC(Double a, Long b, Long c) 
			{
				/*
				 a = [0]
				 b = [1]
				 c = [2]
				 */

				MOpEngeneer.setAx(a);
				MOpEngeneer.setB(b);
				MOpEngeneer.setC(c);
				MOpEngeneer.genFSG();
				MOpEngeneer.genGraphInfo();
				MOpEngeneer.fsgResult[ 0 ] = String.valueOf(MOpEngeneer.getA());
				MOpEngeneer.fsgResult[ 1 ] = String.valueOf(MOpEngeneer.getB());
				MOpEngeneer.fsgResult[ 2 ] = String.valueOf(MOpEngeneer.getC());
			}

		/*
		 Calcular FSG
		 */
		private static void genFSG()
			{
				// Calcular Delta = [3]
				Double delta;
				delta = Double.valueOf((Math.pow(MOpEngeneer.getB(), 2) - 4 * MOpEngeneer.getA() * MOpEngeneer.getC()));

				// Calcular x1 =[4] ou [5]
				Double x1;
				x1 = Double.valueOf((-MOpEngeneer.getB() + Math.sqrt(delta)) / (2 * MOpEngeneer.getA()));

				// Calcular x2 = [5] ou [4]
				Double x2;
				x2 = Double.valueOf((-MOpEngeneer.getB() - Math.sqrt(delta)) / (2 * MOpEngeneer.getA()));

				// Mandar delta, x1 e x2 para String[] result
				MOpEngeneer.fsgResult[ 3 ] = String.valueOf(delta);

				// x1 será o menor valor entre x1 e x2
				if (x1 > x2)
					{
						MOpEngeneer.fsgResult[ 5 ] = String.valueOf(x1);
						MOpEngeneer.fsgResult[ 4 ] = String.valueOf(x2);	
					}
				else
					{
						MOpEngeneer.fsgResult[ 4 ] = String.valueOf(x1);
						MOpEngeneer.fsgResult[ 5 ] = String.valueOf(x2);
					}
			}


		// Fazer estudo do gráfico
		private static void genGraphInfo()
			{
				/* 
				 XV = [8]
				 xv = (x1 + x2) /2
				 */
				MOpEngeneer.fsgResult[ 8 ] = String.valueOf((Double.valueOf(MOpEngeneer.fsgResult[ 4 ])
																									 + Double.valueOf(MOpEngeneer.fsgResult[ 5 ])) 
																									 / 2);

				/* YV = [9]
				 yv = (-∆)/( 4 * a)
				 */	 
				MOpEngeneer.fsgResult[ 9 ] = String.valueOf((-Double.valueOf(MOpEngeneer.fsgResult[ 3 ]))
																									 / (Double.valueOf(MOpEngeneer.getA())
																									 * 4));
				// Dominio, sempre R, [6]
				MOpEngeneer.fsgResult[ 6 ] = "R";

				// Contradominio
				MOpEngeneer.genCDF();

				/*Ordenada na origem = [10]
				 y = c
				 */
				MOpEngeneer.fsgResult[ 10 ] = String.valueOf(MOpEngeneer.getC());

				//Equação do eixo de simetria = a, [11]
				MOpEngeneer.fsgResult[ 11 ] = String.valueOf(MOpEngeneer.getA());
			}

		// Gerador de contra dominio e concavidade
		private static void genCDF()
			{
				Double a = Double.valueOf(MOpEngeneer.getA());
				Double delta = Double.valueOf(MOpEngeneer.fsgResult[ 3 ]);
				Double yv = Double.valueOf(MOpEngeneer.fsgResult[ 9 ]);

				// Determinar concavidade e D'f
				if (a > 0 && delta > 0)
					{
						MOpEngeneer.fsgResult[ 7 ] = "]" + yv + "; +∞[";
						MOpEngeneer.fsgResult[ 12 ] = " cima e duas raizes reais distintas.";
					}
				else if (a > 0 && delta == 0)
					{
						MOpEngeneer.fsgResult[ 7 ] = "]" + yv + "; +∞[";
						MOpEngeneer.fsgResult[ 12 ] = " cima e uma raiz dupla, ou seja, x1 = x2.";
					}
				else if (a > 0 && delta < 0)
					{
						MOpEngeneer.fsgResult[ 7 ] = "]" + yv + "; +∞[";
						MOpEngeneer.fsgResult[ 12 ] = " cima e sem raizes reais.";
					}
				else if (a < 0 && delta > 0)
					{
						MOpEngeneer.fsgResult[ 7 ] = "]-∞; " + yv + "[";
						MOpEngeneer.fsgResult[ 12 ] = " baixo e duas raizes reais distintas.";
					}
				else if (a < 0 && delta == 0)
					{
						MOpEngeneer.fsgResult[ 7 ] = "]-∞; " + yv + "[";
						MOpEngeneer.fsgResult[ 12 ] = " baixo e uma raiz dupla, ou seja, x1 = x2.";
					}
				else if (a < 0 && delta < 0)
					{
						MOpEngeneer.fsgResult[ 7 ] = "]-∞; " + yv + "[";
						MOpEngeneer.fsgResult[ 12 ] = " baixo e sem raizes reais.";
					}
			}


			
		/*
		 Calculadora de função exponencial
		 */

		//
		private static void genFxp()
			{
				Double r;	

				// Para a parte negativa de x
				MOpEngeneer.setIt(MOpEngeneer.init);
				r = Math.pow(MOpEngeneer.getA(), -MOpEngeneer.getIt());
				MOpEngeneer.expresult[ 0 ] = r;
				MOpEngeneer.setIt(MOpEngeneer.getIt() / 2);
				r = Math.pow(MOpEngeneer.getA(), -MOpEngeneer.getIt());
				MOpEngeneer.expresult[ 1 ] = r;
				MOpEngeneer.setIt(MOpEngeneer.getIt() / 2);
				r = Math.pow(MOpEngeneer.getA(), -MOpEngeneer.getIt());
				MOpEngeneer.expresult[ 2 ] = r;
				MOpEngeneer.setIt(MOpEngeneer.getIt() - 1);
				r = Math.pow(MOpEngeneer.getA(), -MOpEngeneer.getIt());
				MOpEngeneer.expresult[ 3 ] = r;

				// Para x = 0
				MOpEngeneer.setIt(MOpEngeneer.getIt() - 1);
				r = Math.pow(MOpEngeneer.getA(), -MOpEngeneer.getIt());
				MOpEngeneer.expresult[ 4 ] = r;

				// Para a parte positiva de x
				MOpEngeneer.setIt(MOpEngeneer.fst - 1);
				r = Math.pow(MOpEngeneer.getA(), MOpEngeneer.getIt());
				MOpEngeneer.expresult[ 5 ] = r;
				MOpEngeneer.setIt(MOpEngeneer.getIt() * 2);
				r = Math.pow(MOpEngeneer.getA(), MOpEngeneer.getIt());
				MOpEngeneer.expresult[ 6 ] = r;
				MOpEngeneer.setIt(MOpEngeneer.getIt() * 2);
				r = Math.pow(MOpEngeneer.getA(), MOpEngeneer.getIt());
				MOpEngeneer.expresult[ 7 ] = r;
				MOpEngeneer.setIt(MOpEngeneer.getIt() * 2);
				r = Math.pow(MOpEngeneer.getA(), MOpEngeneer.getIt());
				MOpEngeneer.expresult[ 8 ] = r;
			}

		//Getters and Setters
		@Override
		public void setNP(Long n, Long p)
			{
				this.setN(n);
				this.setP(p);
				this.genResult();
			}  

		private static void setArrResult(Long res, Long isDone)
			{
				MOpEngeneer.arrResult[ 0 ] = res;
				MOpEngeneer.arrResult[ 1 ] = isDone;
			}

		@Override
		public Long[] getArrResult()
			{
				return MOpEngeneer.arrResult;
			}

		//Retornar toda a informação do gráfico em uma String[]
		@Override
		public String[] getFSGInfo()
			{
				return MOpEngeneer.fsgResult;
			}

		@Override
		public Double[] getEXPResult()
			{
				return MOpEngeneer.expresult;
			}

		private static void setC(Long c)
			{
				MOpEngeneer.c = c;
			}

		private static Long getC()
			{
				return MOpEngeneer.c;
			}

		private static void setB(Long b)
			{
				MOpEngeneer.b = b;
			}

		private static Long getB()
			{
				return MOpEngeneer.b;
			}

		@Override
		public void setA(Double a)
			{
				MOpEngeneer.a = a;
				this.genFxp();
			}

		@Override
		public void setA(int a)
			{
				// Mandar a
			  MOpEngeneer.a = Double.valueOf(a);
			}

		private static void setAx(Double a)
			{
				MOpEngeneer.a = a;
			}

		private static Double getA()
			{
				return MOpEngeneer.a;
			}

		private static void setP(Long p)
			{
				MOpEngeneer.p = p;
			}

		private static Long getP()
			{
				return MOpEngeneer.p;
			}

		private static void setN(long n)
			{
				MOpEngeneer.n = n;
			}

		private static long getN()
			{
				return MOpEngeneer.n;
			}

		private static void setIt(int it)
			{
				MOpEngeneer.it = it;
			}

		private static int getIt()
			{
				return MOpEngeneer.it;
			}

	}
	
	
