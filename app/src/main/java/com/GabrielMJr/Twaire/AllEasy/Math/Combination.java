package com.GabrielMJr.Twaire.AllEasy.Math;

import android.os.Bundle;
import android.app.Activity;

// Importando funcionalidades
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import com.GabrielMJr.Twaire.AllEasy.Math.OpEngeneer.ArrJ;
import com.GabrielMJr.Twaire.AllEasy.R;

public class Combination extends Activity {

  // Atributes
  private EditText n;
  private EditText p;
  private TextView c;
  private TextView result;
  private ArrJ ArrJ;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.combination);

    this.n = (EditText) findViewById(R.id.n);
    this.p = (EditText) findViewById(R.id.p);
    this.c = (TextView) findViewById(R.id.c);
    this.result = (TextView) findViewById(R.id.result);
    this.ArrJ = new ArrJ();

    this.c.setOnClickListener(
        new OnClickListener() {
          public void onClick(View view) {

            long nn = Long.valueOf(n.getText().toString());
            long pp = Long.valueOf(p.getText().toString());

            ArrJ.setNP(nn, nn);
            long nres = ArrJ.getResult();

            ArrJ.setNP((nn - pp), (nn - pp));
            long nmpres = ArrJ.getResult();

            ArrJ.setNP(pp, pp);
            long pres = ArrJ.getResult();
            long resf = nres / (nmpres * pres);
            
            result.setText(
                (CharSequence) "n! = "
                    + String.valueOf(nres)
                    + "\np! = "
                    + String.valueOf(pres)
                    + "\n(n-p)! = "
                    + String.valueOf(nmpres)
                    + "\nResultado = "
                    + String.valueOf(resf));
          }
        });
  }
}
