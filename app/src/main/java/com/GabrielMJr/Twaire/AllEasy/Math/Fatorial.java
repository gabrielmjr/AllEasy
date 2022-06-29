package com.GabrielMJr.Twaire.AllEasy.Math;

import android.os.Bundle;
import android.app.Activity;

// Importando funcionalidades
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

import com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer.ArrJ;
import com.GabrielMJr.Twaire.AllEasy.R;

public class Fatorial extends Activity {

  // Atributes
  private EditText n;
  private TextView fat;
  private TextView result;
  private ArrJ ArrJ;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fatorial);

    this.n = (EditText) findViewById(R.id.n);
    this.fat = (TextView) findViewById(R.id.fat);
    this.result = (TextView) findViewById(R.id.result);
    this.ArrJ = new ArrJ();

    this.fat.setOnClickListener(
        new OnClickListener() {
          public void onClick(View view) {

            try {
              if (Integer.valueOf(n.getText().toString()) > 20) {
                Toast.makeText(Fatorial.this, "Número muito elevado!", Toast.LENGTH_SHORT).show();
              } else {
                ArrJ.setNP(
                    Long.valueOf(n.getText().toString()), Long.valueOf(n.getText().toString()));
                result.setText((CharSequence) "=" + String.valueOf(ArrJ.getResult()));
              }

            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
  }
}
