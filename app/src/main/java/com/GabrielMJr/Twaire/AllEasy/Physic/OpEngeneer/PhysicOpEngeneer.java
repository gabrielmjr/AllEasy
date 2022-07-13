package com.GabrielMJr.Twaire.AllEasy.Physic.OpEngeneer;

public interface PhysicOpEngeneer
	{
		public abstract void setTV(Double t, Double V);
		public abstract void setAV(Double A, Double v);
		public abstract void setRV(Double r, Double v);
		public abstract Double getVres();
		public abstract Double[] getVRes3();
		public abstract void setQv(Double Q, Double v, int c);
		public abstract Double getAreaVRes();
		public abstract Double[] getRaioRes();
		public abstract void setQA(Double Q, Double A);
		public abstract Double getVelocidadeRes();
		public abstract void setVQ(Double V, Double Q);
		public abstract Double getTempoRes();
		public abstract void setTQ(Double t, Double Q);
		public abstract Double getVolumeRes();
	}
