package com.GabrielMJr.Twaire.AllEasy.Math;

import android.os.Bundle;
import android.app.Activity;

// Importando funcionalidades
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

// Classes do pacote
import com.GabrielMJr.Twaire.AllEasy.Math.Fatorial;
import com.GabrielMJr.Twaire.AllEasy.Math.Arranjos;
import com.GabrielMJr.Twaire.AllEasy.Math.Combination;

import com.GabrielMJr.Twaire.AllEasy.R;

public class MainMath extends Activity {

  private Button fat;
  private Button arrj;
  private Button comb;
  private Intent Fatorial;
  private Intent Arranjos;
  private Intent Combination;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_math);

    this.fat = (Button) findViewById(R.id.fat);
    this.arrj = (Button) findViewById(R.id.arrj);
    this.comb = (Button) findViewById(R.id.comb);

    this.Fatorial = new Intent(MainMath.this, Fatorial.class);
    this.Arranjos = new Intent(MainMath.this, Arranjos.class);
    this.Combination = new Intent(MainMath.this, Combination.class);

    this.fat.setOnClickListener(
        new OnClickListener() {
          public void onClick(View view) {
            startActivity(Fatorial);
          }
        });

    this.arrj.setOnClickListener(
        new OnClickListener() {
          public void onClick(View view) {
            startActivity(Arranjos);
          }
        });

    this.comb.setOnClickListener(
        new OnClickListener() {
          public void onClick(View view) {
            startActivity(Combination);
          }
        });
  }
}
