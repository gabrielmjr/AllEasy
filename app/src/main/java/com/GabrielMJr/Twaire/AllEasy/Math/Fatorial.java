package com.GabrielMJr.Twaire.AllEasy.Math;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import com.GabrielMJr.Twaire.Math.Arranjo;
import com.GabrielMJr.Twaire.tools.StringAnalyst;
import com.GabrielMJr.Twaire.AllEasy.R;

public class Fatorial extends Activity {

    // Atributes
    private static EditText n;
    private static TextView fat;
    private static TextView result;
    private static StringAnalyst StringAnalyst;
    private static Arranjo Arranjo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fatorial);

        this.n = findViewById(R.id.n);
        this.fat = findViewById(R.id.fat);
        this.result = findViewById(R.id.result);
        this.StringAnalyst = new StringAnalyst();
        this.Arranjo = new Arranjo();

        this.fat.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    // Verifica se n é nulo
                    if (StringAnalyst.isNull(n.getText().toString())) {
                        Toast.makeText(Fatorial.this, R.string.n_null_math, Toast.LENGTH_SHORT).show();
                    } else {
                        // Verifica se o limite de n do .xml é maior que 20 ou não
                        //Se for maior, não vai calcular, pois o resultado estará incorrecto
                        if (Integer.valueOf(n.getText().toString()) > 20) {
                            Toast.makeText(Fatorial.this, R.string.big_values, Toast.LENGTH_SHORT).show();
                        } else {

                            // Senão, calcule normalmente
                            // Mandar n e p para OpEngeneer.Math
                           Long res = Arranjo.valueOf(
                                Integer.valueOf(n.getText().toString()), Integer.valueOf(n.getText().toString()));

                            // Pegar a String[] result
                            result.setText((CharSequence) "=" + String.valueOf(res));
                        }
                    }
                }
    });
    }
   }
