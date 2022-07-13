package com.GabrielMJr.Twaire.AllEasy.tools;

import java.lang.Math;

public class Constantes implements ConstantManager
	{

		// Atrubutos
		private static Double Pi;

		// Normalizador de Pi
		private static void genPi(int i)
			{
				
				// Condições antes de determinar
				if (i < 0)
					{
						Constantes.setPi(0.0);
					}
				/*else if (i == 3)
					{
						Constantes.setPi(0.0);
					}*/
				else if (i > 18)
					{
						Constantes.setPi(-1.0);
					}
				else
					{
						String[] pi = new String[18];
						for (int k = i; k >= 0; k--)
							{
								pi = String.valueOf(Math.PI).replaceAll("\\s", "").split("");  // Transformar valor de Pi em uma lista
							}
						String j = "";
						for (int k = i; k >= 0; k--)
							{
								j = String.valueOf(pi[ k ]) + j; // Colocando a lista em ordem
							}
							Constantes.setPi(Double.valueOf(j)); // Armazenando Pi de forma finalizada
				 	 	 /* Nota: Método que devolve valor de Pi
						 	* usando índice
							*/
					}
			}


		// Getters e Setters
		@Override
		public Double getPi(int i)
			{
				Constantes.genPi(i);
				return Constantes.Pi;
			}

		private static void setPi(Double pi)
			{
				Constantes.Pi = pi;
			}

	}
