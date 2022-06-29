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

public class Arranjos extends Activity {

  // Atrubutes
  private EditText n;
  private EditText p;
  private TextView a;
  private TextView result;
  private ArrJ ArrJ;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.arranjos);
    
    this.n = (EditText) findViewById(R.id.n);
    this.p = (EditText) findViewById(R.id.p);
    this.a = (TextView) findViewById(R.id.a);
    this.result = (TextView) findViewById(R.id.result);
    this.ArrJ = new ArrJ();
    
    this.a.setOnClickListener(
      new OnClickListener() {
        public void onClick(View view) {
          try{
            
            ArrJ.setNP(Long.valueOf(n.getText().toString()), Long.valueOf(p.getText().toString()));
            result.setText((CharSequence) "=" + String.valueOf(ArrJ.getResult()));
            
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
        
  }
}
