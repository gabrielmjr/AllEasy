package com.GabrielMJr.Twaire.AllEasy.Math;

import android.os.Bundle;
import android.app.Activity;
import android.widget.RadioButton;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.AllEasy.Math.SC.F1;
import com.GabrielMJr.Twaire.AllEasy.R;

public class FExp extends Activity{
	// Atributos
	private static Intent F1;

	private static RadioButton f1;
	private static Button cnt;
	@Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fexp);

		this.F1 = new Intent(FExp.this, F1.class);

		this.f1 = (RadioButton) findViewById(R.id.f1);
		this.cnt = (Button) findViewById(R.id.cnt);

		this.cnt.setOnClickListener(
		  new OnClickListener(){
				public void onClick (View view){
					if ( f1.isChecked() ) {
						startActivity(F1);
					}
				}
			});
	}
}
		
