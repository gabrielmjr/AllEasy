package com.GabrielMJr.Twaire.AllEasy.Math;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer.MOpEngeneer;
import com.GabrielMJr.Twaire.AllEasy.R;

public class Fatorial extends Activity {

  // Atributes
  private static EditText n;
  private static TextView fat;
  private static TextView result;
  private static MOpEngeneer MOpEngeneer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fatorial);

    this.n = (EditText) findViewById(R.id.n);
    this.fat = (TextView) findViewById(R.id.fat);
    this.result = (TextView) findViewById(R.id.result);
    this.MOpEngeneer = new MOpEngeneer();

    this.fat.setOnClickListener(
        new OnClickListener() {
          public void onClick(View view) {

            try {
							// Verifica se o limite de n do .xml é maior que 20 ou não
							//Se for maior, não vai calcular, pois o resultado estará incorrecto
              if (Integer.valueOf(n.getText().toString()) > 20) {
                Toast.makeText(Fatorial.this, "Número muito elevado!", Toast.LENGTH_SHORT).show();
              } else {
								
								// Senão, calcule normalmente
								// Mandar n e p para OpEngeneer.Math
                MOpEngeneer.setNP(
                    Long.valueOf(n.getText().toString()), Long.valueOf(n.getText().toString()));
										
								// Pegar a String[] result
                result.setText((CharSequence) "=" + String.valueOf(MOpEngeneer.getArrResult()[0]));
              }

            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
  }
}
