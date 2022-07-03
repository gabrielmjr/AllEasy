package com.GabrielMJr.Twaire.AllEasy;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.Math.Arranjos;
import com.GabrielMJr.Twaire.AllEasy.Math.Combination;
import com.GabrielMJr.Twaire.AllEasy.Math.Fatorial;
import com.GabrielMJr.Twaire.AllEasy.Math.FSG;
import com.GabrielMJr.Twaire.AllEasy.Math.FExp;

public class MainActivity extends Activity {

  // Atributes
	private static Button Arrj;
	private static Button Comb;
  private static Button Fat;
	private static Button Fsg;
	private static Button Fexp;
	
	private static Intent ArranjosC;
	private static Intent CombinationC;
  private static Intent FatorialC;
	private static Intent FSGC;
	private static Intent FExpC;

  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
		
		this.Arrj = (Button) findViewById(R.id.arrj);
		this.Comb = (Button) findViewById(R.id.comb);
		this.Fat = (Button) findViewById(R.id.fat);
		this.Fsg = (Button) findViewById(R.id.fsg);
		this.Fexp = (Button) findViewById(R.id.fexp);
		
		this.ArranjosC = new Intent(MainActivity.this, Arranjos.class);
		this.CombinationC = new Intent(MainActivity.this, Combination.class);
		this.FatorialC = new Intent(MainActivity.this, Fatorial.class);
		this.FSGC = new Intent(MainActivity.this, FSG.class);
		this.FExpC = new Intent(MainActivity.this, FExp.class);
		
		// Abrir aba de "Arranjos" caso o botão Arrj for clicado
    this.Arrj.setOnClickListener(
			new OnClickListener() {
				public void onClick (View view) {
					startActivity(ArranjosC);
				}
			});
 
		// Abrir aba de "Combinação" caso o botão Comb for clicado
    this.Comb.setOnClickListener(
			new OnClickListener() {
				public void onClick (View view) {
					startActivity(CombinationC);
				}
			});
			
		// Abrir aba de "Fatorial" caso o botão Fat for clicado
    this.Fat.setOnClickListener(
			new OnClickListener() {
				public void onClick (View view) {
					startActivity(FatorialC);
				}
			});
			
		// Abrir aba de "Função de segundo grau" caso o botão Fsg for clicado
    this.Fsg.setOnClickListener(
			new OnClickListener() {
				public void onClick (View view) {
					startActivity(FSGC);
				}
			});
			
		// Abrir aba de "Função exponencial" caso o botão Fexp for clicado
		this.Fexp.setOnClickListener(
		  new OnClickListener(){
				public void onClick(View view) {
					startActivity(FExpC);
				}
			});
	}
}
