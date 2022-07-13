package com.GabrielMJr.Twaire.AllEasy.Physic.OpEngeneer;

import com.GabrielMJr.Twaire.AllEasy.Physic.OpEngeneer.PhysicOpEngeneer;
import com.GabrielMJr.Twaire.AllEasy.tools.Constantes;
import java.lang.Math;

public class FOpEngeneer implements PhysicOpEngeneer
	{
		// Atributos da Fisíca
		private static Double tempo;  //Tempo
		private static Double volume; //Volume
		private static Double[] resVaz3 = new Double[3]; // Resultado de vazão na terceira fórmula
		private static Double Area; // Área
		private static Double velocidade; // Velocidade
		private static Double raio; // Raío
		private static Double[] resRaio = new Double[3];
		private static Double Qvaz; // Vazão
		private static Double Pi; // Pi 


		// Cálculo de Vazão na primeira fórmula
		private static void genVaz1()
			{
			  FOpEngeneer.Qvaz = (FOpEngeneer.volume / FOpEngeneer.tempo);
			}

		// Cálculo de Vazão na segunda fórmula
		private static void genVaz2()
			{
				FOpEngeneer.Qvaz = (FOpEngeneer.Area * FOpEngeneer.velocidade);
			}

		// Cálculo de Vazão na terceira fórmula
		private static void genVaz3()
			{
				// Guardar resultado de cada passo em uma lista
				Double a = Math.pow(FOpEngeneer.raio, 2);
				Double b = FOpEngeneer.Pi * a;
				Double c = b * velocidade;
				FOpEngeneer.setVRes3(a, b, c);
			}

		// Cálculo de Área da vazão
		private static void genAreaV()
			{
				FOpEngeneer.Area = FOpEngeneer.Qvaz / FOpEngeneer.velocidade;
			}

		// Cálculo de Raio da vazão
		private static void genRaioV()
			{
				FOpEngeneer.Pi = new Constantes().getPi(3);
				Double a = (FOpEngeneer.Pi * FOpEngeneer.velocidade);
				Double b = (FOpEngeneer.Qvaz / a);
				Double c = Math.sqrt(b);
				FOpEngeneer.setRaioRes(a, b, c);
			}

		// Cálculo de Velocidade da vazão
		private static void genVelocidadeV()
			{
				FOpEngeneer.velocidade = FOpEngeneer.Qvaz / FOpEngeneer.Area;
			}

		// Cálculo de Tempo da vazão
		private static void genTempoV()
			{
				FOpEngeneer.tempo = FOpEngeneer.volume / FOpEngeneer.Qvaz;
			}

		// Cálculo de Volume da vazão
		private static void genVolumeV()
			{
				FOpEngeneer.volume = FOpEngeneer.tempo * FOpEngeneer.Qvaz;
			}

		// Setters e Getters
		@Override
		public void setTV(Double t, Double V)
			{
				this.tempo = t;
				this.volume = V;

				this.genVaz1(); // Cálcular vazão assim que os dados forem inseridos
			}

		@Override
		public Double getVres()
			{
				return this.Qvaz;
			}

		@Override
		public void setAV(Double A, Double v)
			{
				this.Area = A;
				this.velocidade = v;

				this.genVaz2();
			}

		@Override
		public void setRV(Double r, Double v)
			{
				this.Pi = new Constantes().getPi(3); // Gerando Pi das constantes
				this.raio = r;
				this.velocidade = v;

				this.genVaz3();
			}

		private static void setVRes3(Double a, Double b, Double c)
			{
        FOpEngeneer.resVaz3[ 0 ] = a;
				FOpEngeneer.resVaz3[ 1 ] = b;
				FOpEngeneer.resVaz3[ 2 ] = c;
			}

		@Override
		public Double[] getVRes3()
			{
				return this.resVaz3;
			}

		@Override
		public void setQv(Double Q, Double v, int c)
			{
				FOpEngeneer.Qvaz = Q;
				FOpEngeneer.velocidade = v;

				switch (c)
					{
						case 1:
							FOpEngeneer.genAreaV();
							break;

						case 2:
							FOpEngeneer.genRaioV();
							break;

						default:
							return;
					}
			}

		@Override
		public Double getAreaVRes()
			{
				return FOpEngeneer.Area;
			}

	  private static void setRaioRes(Double a, Double b, Double c)
			{
				FOpEngeneer.resRaio[ 0 ] = a;
				FOpEngeneer.resRaio[ 1 ] = b;
				FOpEngeneer.resRaio[ 2 ] = c;
			}

		@Override
		public Double[] getRaioRes()
			{
				return FOpEngeneer.resRaio;
			}

		@Override
		public void setQA(Double Q, Double A)
			{
				FOpEngeneer.Qvaz = Q;
				FOpEngeneer.Area = A;

				FOpEngeneer.genVelocidadeV();
			}

		@Override
		public Double getVelocidadeRes()
			{
				return FOpEngeneer.velocidade;
			}

		@Override
		public void setVQ(Double V, Double Q)
			{
				FOpEngeneer.volume = V;
				FOpEngeneer.Qvaz = Q;

				FOpEngeneer.genTempoV();
			}

		@Override
		public Double getTempoRes()
			{
				return FOpEngeneer.tempo;
			}

		@Override
		public void setTQ(Double t, Double Q)
			{
				FOpEngeneer.tempo = t;
				FOpEngeneer.Qvaz = Q;

				FOpEngeneer.genVolumeV();
			}

		@Override
		public Double getVolumeRes()
			{
				return FOpEngeneer.volume;
			}
	}
