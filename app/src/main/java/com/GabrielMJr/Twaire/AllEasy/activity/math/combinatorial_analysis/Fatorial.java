package com.GabrielMJr.Twaire.AllEasy.activity.math.combinatorial_analysis;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;
import com.GabrielMJr.Twaire.Math.Arranjo;
import com.gabrielMJr.twaire.tools.Tools;

public class Fatorial extends BaseActivity {

    // Atributes
    private EditText n;
    private TextView fat;
    private TextView result;
    private Button clear;

    private Tools Tools;
    private Arranjo Arranjo;

    private void initialize() {
        setToolBar((Toolbar) findViewById(R.id.toolbar));

        this.n = findViewById(R.id.n);
        this.fat = findViewById(R.id.fat);
        this.result = findViewById(R.id.result);
        this.clear = findViewById(R.id.clear);
        this.Tools = new Tools();
        this.Arranjo = new Arranjo();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fatorial);

        this.initialize();

        this.fat.setOnClickListener(
            new OnClickListener() {
                public void onClick(View view) {

                    // Verifica se n é nulo
                    if (Tools.isNull(n.getText().toString())) {
                        n.setError(getText(R.string.null_field));
                    } else {

                        // Verifica se o limite de n do .xml é maior que 20 ou não
                        //Se for maior, não vai calcular, pois o resultado estará incorrecto

                        if (Integer.valueOf(n.getText().toString()) > 20) {
                            n.setError(getText(R.string.big_value));

                        } else {

                            // Senão, calcule normalmente
                            // Mandar n e p para OpEngeneer.Math
                            Long res = Arranjo.valueOf(
                                Integer.valueOf(n.getText().toString()), Integer.valueOf(n.getText().toString()));

                            // Pegar a String[] result
                            result.setText("=" + String.valueOf(res));
                        }
                    }

                    return;
                }
            });

        this.clear.setOnClickListener(
            new OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    n.setText(null);
                    result.setText(null);

                    return;
                }
            });
    }
}
