package com.GabrielMJr.Twaire.AllEasy;

import android.os.Bundle;
import android.app.Activity;

// Importado funcionadidades
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

// Classes do pacote
import com.GabrielMJr.Twaire.AllEasy.Math.MainMath;

import com.GabrielMJr.Twaire.AllEasy.R;

public class MainActivity extends Activity {

  // Atributes
  private Button chMath;
  private Intent Math;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.chMath = (Button) findViewById(R.id.chMath);
    this.Math = new Intent(MainActivity.this, MainMath.class);

    this.chMath.setOnClickListener(
        new OnClickListener() {
          public void onClick(View view) {
            startActivity(Math);
          }
        });
  }
}
