package com.GabrielMJr.Twaire.AllEasy.Physic.Vaz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Vaz1;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Vaz2;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Vaz3;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.T1;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Volume1;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Velocidade1;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Area1;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Raio1;
import com.GabrielMJr.Twaire.AllEasy.R;

public class Vaz extends Activity
	{

		private static RadioButton vaz1;
		private static RadioButton vaz2;
		private static RadioButton vaz3;
		private static RadioButton t1;
		private static RadioButton V1;
		private static RadioButton vel1;
		private static RadioButton area1;
		private static RadioButton raio1;
		private static Button pross;
		private static Intent Vaz1C;
		private static Intent Vaz2C;
		private static Intent Vaz3C;
		private static Intent Time1C;
		private static Intent Volume1C;
		private static Intent Velocidade1C;
		private static Intent Area1C;
		private static Intent Raio1C;
		
	  @Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.main_vaz);

				this.vaz1 = findViewById(R.id.v1);
				this.vaz2 = findViewById(R.id.v2);
				this.vaz3 = findViewById(R.id.v3);
				this.t1 = findViewById(R.id.t1);
				this.V1 = findViewById(R.id.V1);
				this.vel1 = findViewById(R.id.vel1);
				this.area1 = findViewById(R.id.area);
				this.raio1 = findViewById(R.id.raio1);
				this.pross = findViewById(R.id.pross);
				
				this.Vaz1C = new Intent(Vaz.this, Vaz1.class);
				this.Vaz2C = new Intent(Vaz.this, Vaz2.class);
				this.Vaz3C = new Intent(Vaz.this, Vaz3.class);
				this.Time1C = new Intent(Vaz.this, T1.class);
				this.Volume1C = new Intent(Vaz.this, Volume1.class);
				this.Velocidade1C = new Intent(Vaz.this, Velocidade1.class);
				this.Area1C = new Intent(Vaz.this, Area1.class);
				this.Raio1C = new Intent(Vaz.this, Raio1.class);
				
				/* Caso o botão "Prosseguir" for clicado,
				verifique qual das opções e inicie a activity
				de acordo
				*/
				this.pross.setOnClickListener (
				  new OnClickListener() {
						public void onClick(View view) {
							if (Vaz.vaz1.isChecked()) {
								startActivity(Vaz.Vaz1C);
							} else if (Vaz.vaz2.isChecked()) {
								startActivity(Vaz.Vaz2C);
							} else if (Vaz.vaz3.isChecked()) {
								startActivity(Vaz.Vaz3C);
							} else if(Vaz.t1.isChecked()){
								startActivity(Vaz.Time1C);
							} else if(Vaz.V1.isChecked()) {
								startActivity(Vaz.Volume1C);
							} else if(Vaz.vel1.isChecked()) {
								startActivity(Vaz.Velocidade1C);
							} else if (Vaz.area1.isChecked()) {
								startActivity(Vaz.Area1C);
							} else if (Vaz.raio1.isChecked()) {
								startActivity(Vaz.Raio1C);
							} else {
								Toast.makeText(Vaz.this, "Escolha uma fórmula para continuar", Toast.LENGTH_SHORT).show();
							}
						}
					});

			}
	}
