package com.GabrielMJr.Twaire.AllEasy.Math;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.GabrielMJr.Twaire.Math.Arranjo;
import com.GabrielMJr.Twaire.tools.StringAnalyst;
import com.GabrielMJr.Twaire.AllEasy.R;

public class Combination extends Activity {

  // Atributes
  private static EditText n;
  private static EditText p;
  private static TextView c;
  private static String[] res = new String[4];
  private static TextView result;
  private static StringAnalyst StringAnalyst;
  private static Arranjo Arranjo;
  private static int verifyN;
  private static int verifyP;
  private static int verifyNfat;
  private static int verifyPfat;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.combination);

    // Atributos
    this.n = findViewById(R.id.n);
    this.p = findViewById(R.id.p);
    this.c = findViewById(R.id.c);
    this.result = findViewById(R.id.result);
    this.StringAnalyst = new StringAnalyst();
    this.Arranjo = new Arranjo();

    this.c.setOnClickListener(
      new OnClickListener() {
        public void onClick(View view) {

          if (StringAnalyst.isNull(n.getText().toString())) {
            Toast.makeText(Combination.this, R.string.p_big_than_n, Toast.LENGTH_SHORT).show();
            Combination.verifyN = 0;
          } else {
            Combination.verifyN = 1;
          }

          if (StringAnalyst.isNull(p.getText().toString())) {
            Toast.makeText(Combination.this, R.string.n_null_math, Toast.LENGTH_SHORT).show();
            Combination.verifyP = 0;
          } else {
            Combination.verifyP = 1;
          }

          if (Combination.verifyN == 1 && Combination.verifyP == 1) {

            // Valores de n e p do .xml
            Integer nn = Integer.valueOf(n.getText().toString());
            Integer pp = Integer.valueOf(p.getText().toString());

            if (nn < pp) {
              Toast.makeText(Combination.this, R.string.p_big_than_n, Toast.LENGTH_SHORT).show();
            } else {

              // Mandar n para OpEngeneer.Math e pegar a String result
              Long res = Arranjo.valueOf(nn, nn);
              String nfat = String.valueOf(res);

              // Mandar n-p para OpEngeneer.Math e pegar a String result
              res = Arranjo.valueOf((nn - pp), (nn - pp));
              String nmpfat = String.valueOf(res);

              // Mandar p para OpEngeneer.Math e pegar a String result
              res = Arranjo.valueOf(pp, pp);
              String pfat = String.valueOf(res);

              // Resultado final de Combinação
              String resfat = String.valueOf(Double.valueOf(nfat) / (Double.valueOf(nmpfat) * Double.valueOf(pfat)));

              // Mandar todos os resultados para uma String[] result
              Combination.setRes(nfat, pfat, nmpfat, resfat);

              if (Long.valueOf(nfat) <= 0) {
                Toast.makeText(Combination.this, R.string.n_big, Toast.LENGTH_SHORT).show();
                Combination.verifyNfat = 0;
              } else {
                Combination.verifyNfat = 1;
              }

              if (Long.valueOf(pfat) <= 0) {
                Toast.makeText(Combination.this, R.string.p_big,  Toast.LENGTH_SHORT).show();
                Combination.verifyPfat = 0;
              } else {
                Combination.verifyPfat = 1;
              }

              if (Combination.verifyNfat == 1 && Combination.verifyPfat == 1) {  
                Combination.setRes(nfat, pfat, nmpfat, resfat);    
                result.setText(
                  (CharSequence) "n! = "
                  + String.valueOf(Combination.getRes()[0])
                  + "\np! = "
                  + String.valueOf(Combination.getRes()[1])
                  + "\n(n-p)! = "
                  + String.valueOf(Combination.getRes()[2])
                  + "\nResultado = "
                  + String.valueOf(Combination.getRes()[3]));

              } else {
                Combination.setRes("", "", "", "");
              }
            }
            // Mandar resultados para o .xml

          } else {
            return;
          }
        }
      });
  }


  // Setters e getters
  private static void setRes(String nfat, String pfat, String nmpfat, String resfat) {
    Combination.res[0] = nfat;
    Combination.res[1] = pfat;
    Combination.res[2] = nmpfat;
    Combination.res[3] = resfat;
  }

  private static String[] getRes() {
    return res;
  }
}
