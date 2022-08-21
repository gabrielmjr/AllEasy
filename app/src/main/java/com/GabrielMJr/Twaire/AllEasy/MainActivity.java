package com.GabrielMJr.Twaire.AllEasy;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.Math.Arranjos;
import com.GabrielMJr.Twaire.AllEasy.Math.Combination;
import com.GabrielMJr.Twaire.AllEasy.Math.Fatorial;
import com.GabrielMJr.Twaire.AllEasy.Math.FSG;
import com.GabrielMJr.Twaire.AllEasy.Physic.Vaz.Vaz;

public class MainActivity extends Activity {

    // Atributes
	private static TextView Arrj;
	private static TextView Comb;
    private static TextView Fat;
	private static TextView Fsg;
	private static TextView Vz;

	private static Intent ArranjosC;
	private static Intent CombinationC;
    private static Intent FatorialC;
	private static Intent FSGC;
	private static Intent VazC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		this.Arrj = findViewById(R.id.arrj);
		this.Comb = findViewById(R.id.comb);
		this.Fat = findViewById(R.id.fat);
		this.Fsg = findViewById(R.id.fsg);
		this.Vz = findViewById(R.id.vaz);

		this.ArranjosC = new Intent(MainActivity.this, Arranjos.class);
		this.CombinationC = new Intent(MainActivity.this, Combination.class);
		this.FatorialC = new Intent(MainActivity.this, Fatorial.class);
		this.FSGC = new Intent(MainActivity.this, FSG.class);
		this.VazC = new Intent(MainActivity.this, Vaz.class);

		// Abrir aba de "Arranjos" caso o botão Arrj for clicado
        this.Arrj.setOnClickListener(
			new OnClickListener() {
				public void onClick(View view) {
					startActivity(ArranjosC);
				}
			});

		// Abrir aba de "Combinação" caso o botão Comb for clicado
        this.Comb.setOnClickListener(
			new OnClickListener() {
				public void onClick(View view) {
					startActivity(CombinationC);
				}
			});

		// Abrir aba de "Fatorial" caso o botão Fat for clicado
        this.Fat.setOnClickListener(
			new OnClickListener() {
				public void onClick(View view) {
					startActivity(FatorialC);
				}
			});

		// Abrir aba de "Função de segundo grau" caso o botão Fsg for clicado
        this.Fsg.setOnClickListener(
			new OnClickListener() {
				public void onClick(View view) {
					startActivity(FSGC);
				}
			});

		// Abrir aba de "Vazão" caso  botão VZ for clicado;
		this.Vz.setOnClickListener(
            new OnClickListener(){
				public void onClick(View view) {
					startActivity(VazC);
				}
			});
	}
}
