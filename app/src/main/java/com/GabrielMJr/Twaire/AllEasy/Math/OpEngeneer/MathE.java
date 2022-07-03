package com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer;

import com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer.OpEngeneer;
import java.lang.Math;

public class MathE implements OpEngeneer
	{

		//Atributos do mini motor matematico
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
						Long k = MathE.getN();

						for (Long i = MathE.getP(); i > 0; i--)
							{
								res = res * k;
								k--;
							}
						MathE.setArrResult(Long.valueOf(res), Long.valueOf(1));
					}
				catch (Exception e)
					{
						MathE.setArrResult(Long.valueOf(0), Long.valueOf(-1));
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

				MathE.setAx(a);
				MathE.setB(b);
				MathE.setC(c);
				MathE.genFSG();
				MathE.genGraphInfo();
				MathE.fsgResult[ 0 ] = String.valueOf(MathE.getA());
				MathE.fsgResult[ 1 ] = String.valueOf(MathE.getB());
				MathE.fsgResult[ 2 ] = String.valueOf(MathE.getC());
			}

		/*
		 Calcular FSG
		 */
		private static void genFSG()
			{
				// Calcular Delta = [3]
				Double delta;
				delta = Double.valueOf((Math.pow(MathE.getB(), 2) - 4 * MathE.getA() * MathE.getC()));

				// Calcular x1 =[4] ou [5]
				Double x1;
				x1 = Double.valueOf((-MathE.getB() + Math.sqrt(delta)) / (2 * MathE.getA()));

				// Calcular x2 = [5] ou [4]
				Double x2;
				x2 = Double.valueOf((-MathE.getB() - Math.sqrt(delta)) / (2 * MathE.getA()));

				// Mandar delta, x1 e x2 para String[] result
				MathE.fsgResult[ 3 ] = String.valueOf(delta);

				// x1 será o menor valor entre x1 e x2
				if (x1 > x2)
					{
						MathE.fsgResult[ 5 ] = String.valueOf(x1);
						MathE.fsgResult[ 4 ] = String.valueOf(x2);	
					}
				else
					{
						MathE.fsgResult[ 4 ] = String.valueOf(x1);
						MathE.fsgResult[ 5 ] = String.valueOf(x2);
					}
			}


		// Fazer estudo do gráfico
		private static void genGraphInfo()
			{
				/* 
				 XV = [8]
				 xv = (x1 + x2) /2
				 */
				MathE.fsgResult[ 8 ] = String.valueOf((Double.valueOf(MathE.fsgResult[ 4 ])
																							+ Double.valueOf(MathE.fsgResult[ 5 ])) 
																							/ 2);

				/* YV = [9]
				 yv = (-∆)/( 4 * a)
				 */	 
				MathE.fsgResult[ 9 ] = String.valueOf((-Double.valueOf(MathE.fsgResult[ 3 ]))
																							/ (Double.valueOf(MathE.getA())
																							* 4));
				// Dominio, sempre R, [6]
				MathE.fsgResult[ 6 ] = "R";

				// Contradominio
				MathE.genCDF();

				/*Ordenada na origem = [10]
				 y = c
				 */
				MathE.fsgResult[ 10 ] = String.valueOf(MathE.getC());

				//Equação do eixo de simetria = a, [11]
				MathE.fsgResult[ 11 ] = String.valueOf(MathE.getA());
			}

		// Gerador de contra dominio e concavidade
		private static void genCDF()
			{
				Double a = Double.valueOf(MathE.getA());
				Double delta = Double.valueOf(MathE.fsgResult[ 3 ]);
				Double yv = Double.valueOf(MathE.fsgResult[ 9 ]);

				// Determinar concavidade e D'f
				if (a > 0 && delta > 0)
					{
						MathE.fsgResult[ 7 ] = "]" + yv + "; +∞[";
						MathE.fsgResult[ 12 ] = " cima e duas raizes reais distintas.";
					}
				else if (a > 0 && delta == 0)
					{
						MathE.fsgResult[ 7 ] = "]" + yv + "; +∞[";
						MathE.fsgResult[ 12 ] = " cima e uma raiz dupla, ou seja, x1 = x2.";
					}
				else if (a > 0 && delta < 0)
					{
						MathE.fsgResult[ 7 ] = "]" + yv + "; +∞[";
						MathE.fsgResult[ 12 ] = " cima e sem raizes reais.";
					}
				else if (a < 0 && delta > 0)
					{
						MathE.fsgResult[ 7 ] = "]-∞; " + yv + "[";
						MathE.fsgResult[ 12 ] = " baixo e duas raizes reais distintas.";
					}
				else if (a < 0 && delta == 0)
					{
						MathE.fsgResult[ 7 ] = "]-∞; " + yv + "[";
						MathE.fsgResult[ 12 ] = " baixo e uma raiz dupla, ou seja, x1 = x2.";
					}
				else if (a < 0 && delta < 0)
					{
						MathE.fsgResult[ 7 ] = "]-∞; " + yv + "[";
						MathE.fsgResult[ 12 ] = " baixo e sem raizes reais.";
					}
			}







		/* Método que retorna se o valor é nulo ou não
		 if null, return true
		 else, return false
		 */
		@Override
		public Boolean isNull(String val)
			{
				String v = String.valueOf(val);
				switch (v)
					{
						case "":
							return true;

						default:
							return false;
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
				MathE.setIt(MathE.init);
				r = Math.pow(MathE.getA(), -MathE.getIt());
				MathE.expresult[ 0 ] = r;
				MathE.setIt(MathE.getIt() / 2);
				r = Math.pow(MathE.getA(), -MathE.getIt());
				MathE.expresult[ 1 ] = r;
				MathE.setIt(MathE.getIt() / 2);
				r = Math.pow(MathE.getA(), -MathE.getIt());
				MathE.expresult[ 2 ] = r;
				MathE.setIt(MathE.getIt() - 1);
				r = Math.pow(MathE.getA(), -MathE.getIt());
				MathE.expresult[ 3 ] = r;

				// Para x = 0
				MathE.setIt(MathE.getIt() - 1);
				r = Math.pow(MathE.getA(), -MathE.getIt());
				MathE.expresult[ 4 ] = r;

				// Para a parte positiva de x
				MathE.setIt(MathE.fst - 1);
				r = Math.pow(MathE.getA(), MathE.getIt());
				MathE.expresult[ 5 ] = r;
				MathE.setIt(MathE.getIt() * 2);
				r = Math.pow(MathE.getA(), MathE.getIt());
				MathE.expresult[ 6 ] = r;
				MathE.setIt(MathE.getIt() * 2);
				r = Math.pow(MathE.getA(), MathE.getIt());
				MathE.expresult[ 7 ] = r;
				MathE.setIt(MathE.getIt() * 2);
				r = Math.pow(MathE.getA(), MathE.getIt());
				MathE.expresult[ 8 ] = r;
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
				MathE.arrResult[ 0 ] = res;
				MathE.arrResult[ 1 ] = isDone;
			}

		@Override
		public Long[] getArrResult()
			{
				return MathE.arrResult;
			}

		//Retornar toda a informação do gráfico em uma String[]
		@Override
		public String[] getFSGInfo()
			{
				return MathE.fsgResult;
			}

		@Override
		public Double[] getEXPResult()
			{
				return MathE.expresult;
			}

		private static void setC(Long c)
			{
				MathE.c = c;
			}

		private static Long getC()
			{
				return MathE.c;
			}

		private static void setB(Long b)
			{
				MathE.b = b;
			}

		private static Long getB()
			{
				return MathE.b;
			}

		@Override
		public void setA(Double a)
			{
				MathE.a = a;
				this.genFxp();
			}

		@Override
		public void setA(int a)
			{
				// Mandar a
			  MathE.a = Double.valueOf(a);
			}

		private static void setAx(Double a)
			{
				MathE.a = a;
			}

		private static Double getA()
			{
				return MathE.a;
			}

		private static void setP(Long p)
			{
				MathE.p = p;
			}

		private static Long getP()
			{
				return MathE.p;
			}

		private static void setN(long n)
			{
				MathE.n = n;
			}

		private static long getN()
			{
				return MathE.n;
			}

		private static void setIt(int it)
			{
				MathE.it = it;
			}

		private static int getIt()
			{
				return MathE.it;
			}
	}
