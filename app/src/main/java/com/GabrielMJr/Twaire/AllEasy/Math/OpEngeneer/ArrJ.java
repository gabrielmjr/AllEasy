package com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer;

import com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer.Arranjo;

public class ArrJ implements Arranjo{

  //Atributos do mini motor
  private long n;
  private long p;
  private long result;
  
  // Gerando Arranjos
  private void genResult() {
    long res = 1;
    long k = this.getN();

    for (long i = this.getP(); i > 0; i--) {
      res = res * k;
      k--;
    }
    this.setResult(res);
  }
  
  //Getters and Setters
  @Override
  public void setNP(long n, long p) {
    this.n = n;
    this.p = p;
    this.genResult();
  }  
  
  private long getN() {
    return this.n;
  }
  
  private long getP() {
    return this.p;
  }
  
  @Override
  public Long getResult() {
    return this.result;
   }
  
  private void setResult(long res) {
    this.result = res;
  } 
}
